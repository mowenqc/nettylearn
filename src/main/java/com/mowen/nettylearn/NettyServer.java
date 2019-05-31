package com.mowen.nettylearn;

import com.mowen.nettylearn.handler.child.BaseChildHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage
 * author: mowen
 * create_time: 2019/5/30 7:59
 * project_name : mowen_parent
 */
public class NettyServer {

    private Logger logger = Logger.getLogger(getClass());

    private int defaultPort = 8890;
    private String defaultHost = "127.0.0.1";
    private BaseChildHandler childHandler;

    public NettyServer(BaseChildHandler childHandler) {
        this.childHandler = childHandler;
    }

    public void connect() {
        connect(defaultHost, defaultPort);
    }

    public void connect(String host, int port) {
        //默认线程数
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.channel(NioServerSocketChannel.class).group(boss, work).option(
                ChannelOption.SO_BACKLOG, 1024).childHandler(childHandler);
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }


}
