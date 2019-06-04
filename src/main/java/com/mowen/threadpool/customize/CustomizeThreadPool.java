package com.mowen.threadpool.customize;

import com.mowen.common.Constants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 8:57
 * project_name : mowen_parent
 */
public class CustomizeThreadPool extends CustomizeAbstractExecutorService {

    private Logger logger = Logger.getLogger(getClass());
    /**
     * 默认并发线程的大小， 如果传入了这个值， 就用修改的值
     */
    private int poolSize;

    private CustomizeThreadFactory threadFactory = new CustomizeThreadFactory();

    /**
     * 默认等待队列
     */
    private BlockingQueue<Runnable> waitQueue = new LinkedBlockingQueue<>();

    private Set<CustomizeJob> workTask = new HashSet<>();

    private AtomicInteger activeCount = new AtomicInteger(Constants.ZERO);
    private AtomicInteger threadNum = new AtomicInteger(Constants.ZERO);

    private boolean SHUTDOWN = false;

    //添加主锁，用于创建新的线程
    private Lock mainLock = new ReentrantLock();


    public CustomizeThreadPool() {
        this(Constants.TEN);
    }

    public CustomizeThreadPool(int poolSize) {
        this.poolSize = poolSize;
    }

    @Override
    protected void execute(RunnableFuture futureTask) {
        int activeNum = activeCount.getAndIncrement();
        logger.info("activeNum = " + activeNum);
        if (SHUTDOWN) {
            logger.info("线程已中断，不能执行新的线程");
            return;
        }
        if (activeNum <= poolSize) {
            CustomizeJob customizeJob = new CustomizeJob(futureTask);
            Thread thread = threadFactory.newThread(customizeJob);
            workTask.add(customizeJob);
            thread.start();
        } else {
            logger.info("addToQueue");
            waitQueue.offer(futureTask);
        }
    }

    @Override
    public void shutdown() {
        SHUTDOWN = true;
    }

    public class CustomizeJob implements Runnable {

        private Runnable job;

        public CustomizeJob(Runnable runnable) {
            this.job = runnable;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //如果等待线程为空and已经调用了shutdown()方法，那么本线程将被停止
                    if (SHUTDOWN && waitQueue.size() == 0) {
                        logger.info("终止线程");
                        if(job != null){
                            logger.error("removeJob");
                            waitQueue.remove(job);
                        }
                        break;
                    }
                    logger.info("执行等待任务:" + waitQueue.size());
                    if (job != null || (job = waitQueue.poll(2, TimeUnit.SECONDS)) != null) {
                        job.run();
                    }
                    if (SHUTDOWN && waitQueue.size() == 0) {
                        if(job != null){
                            logger.error("removeJob");
                            waitQueue.remove(job);
                        }
                        break;
                    }
                    job = null;
                    logger.info("执行任务完成~" + threadNum.getAndIncrement());
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
