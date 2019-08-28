package com.mowen.lamda.expression;

import com.mowen.common.domain.User;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/28 10:14
 * @since:
 */
public class StreamOperation {
    private List<Integer> list;

    private List<User> userList;

    private Map<String, String> map;

    public StreamOperation(){
        initData();
    }

    private void initData(){
        list = Arrays.asList(1, 2, 4, 8, 16, 32, 64);
        userList = new ArrayList<>();
        User user = new User(1, "莫问_1");
        userList.add(user);
        user = new User(2, "莫问_2");
        userList.add(user);
        user = new User(3, "莫问_3");
        userList.add(user);
        user = new User(4, "莫问_4");
        userList.add(user);
        user = new User(5, "莫问_5");
        userList.add(user);
        userList.add(user);//增加一个重复的数据

        map = new HashMap<>();
        map.put("1", "莫问_1");
        map.put("2", "莫问_2");
        map.put("3", "莫问_3");
        map.put("4", "莫问_4");
        map.put("5", "莫问_5");
    }

    //foreach示例
    public void testForeach(){
       list.forEach(x -> System.out.println(x));
       userList.forEach(user -> System.out.println("list=" + user.getUserId() + "-" + user.getName()));
       map.forEach((K, V) -> System.out.println("map=" + K + "-" + V));
    }

    //limit示例
    public void testLimit(){
        //前两条记录
        List<Integer> collect = list.stream().limit(2).collect(Collectors.toList());
        System.out.println(collect.size());
        System.out.println(collect);
    }

    //stream skip示例
    public void testSkip(){
        //跳过前三条数据
        List<Integer> collect = list.stream().skip(3).collect(Collectors.toList());
        System.out.println(collect);
    }

    //stream distinct示例
    public void  testDistinct(){
        List<User> collect = userList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    //stream filter示例
    public void testFilter(){
        List<Integer> collect = list.stream().filter(x -> x > 10).collect(Collectors.toList());
        System.out.println("lists = " + collect);

        List<User> collect1 = userList.stream().filter(user -> user.getUserId() > 3).collect(Collectors.toList());
        System.out.println(collect1);
    }

    //合并另外一个stream
    public void testFlatMap(){
        //这儿的示例的场景不是很适合，如果将一个二维数组变成一位数组， 子集合的合并比较好，但绝对在这个地方显得分怪异
        List<Integer> collect = list.stream().flatMap(p -> userList.stream().map(user -> user.getUserId())).collect(Collectors.toList());
        System.out.println(collect);
    }

    //map示例，一种形式转换成另外一种形式
    public void testMap(){
        List<String> collect = userList.stream().map(user -> user.getName() + "-" + user.getUserId()).collect(Collectors.toList());
        System.out.println(collect);


        List<String> stringList = list.stream().map(p -> 3 * p + "").collect(Collectors.toList());
        System.out.println(stringList);
    }

    //reduce示例, 进行集合的合并操作，这儿做的累计计算，如果接触过hadoop的map/reduce框架，发觉就是这样的原理
    public void testReduce(){
        Integer reduce = list.stream().reduce(0, (acc, a) -> acc + a, (a, b) -> a + b);
        System.out.println(reduce);

        Optional<Integer> integer = list.stream().reduce((a, b) -> a + b);
        System.out.println(integer.get());

        Integer reduce1 = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce1);
    }

    public void testList2Map(){
        ConcurrentMap<Integer, String> collect = userList.stream().collect(Collectors.toConcurrentMap(User::getUserId, User::getName, (K, V) -> K));
        System.out.println(collect);

        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getUserId, a -> a, (a, b) -> a));
        System.out.println(userMap);
        //第三个，未解决冲突，报错，注意， 通常我们用上面这种方法写
        /*Map<Integer, User> integerUserMap = userList.stream().collect(Collectors.toMap(User::getUserId, a -> a));
        System.out.println(integerUserMap);*/
    }

    //max示例
    public void testMax(){
        Integer max = list.stream().max(Comparator.comparingInt(a -> a)).get();
        System.out.println(max);


        User user = userList.stream().max(Comparator.comparingInt(User::getUserId)).get();
        System.out.println(user.getUserId());
    }

    public void testMin(){
        Integer integer = list.stream().max((a, b) -> b - a).get();
        System.out.println(integer);

        int userId = userList.stream().min(Comparator.comparingInt(User::getUserId)).get().getUserId();
        System.out.println(userId);
    }

    public void testCount(){
        long count = list.stream().count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        StreamOperation streamOperation = new StreamOperation();
        //1. 测试foreach操作
        System.out.println("测试foreach操作");
        streamOperation.testForeach();

        //2.测试limit
        System.out.println("测试limit");
        streamOperation.testLimit();

        //3. 测试skip
        System.out.println("测试skip");
        streamOperation.testSkip();

        //4. 测试distinct
        System.out.println("测试distinct");
        streamOperation.testDistinct();

        //5. 测试filter
        System.out.println("测试filter");
        streamOperation.testFilter();

        //6. 测试flatMap
        System.out.println("测试flatMap");
        streamOperation.testFlatMap();

        //7. 测试map
        System.out.println("测试map");
        streamOperation.testMap();

        //8. 测试reduce
        System.out.println("测试reduce");
        streamOperation.testReduce();

        //9. 测试list转Map
        System.out.println("测试list转Map");
        streamOperation.testList2Map();

        //10.测试最大值
        System.out.println("测试max");
        streamOperation.testMax();

        //11. 测试最小值
        System.out.println("测试最小值");
        streamOperation.testMin();

        //12. 测试count
        System.out.println("测试count");
        streamOperation.testCount();
    }
}
