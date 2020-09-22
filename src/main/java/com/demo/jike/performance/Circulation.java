package com.demo.jike.performance;

import java.util.*;

/**
 * @Description: 循环处理
 *
 * @Author: jiahuiyang
 * @Date: Created in 15:41 2019/12/13
 */
public class Circulation {

    public static final Integer MAX_VALUE = 30000;

    /**
     * 循环嵌套
     */
    public static void circulationNest() {
        List<Consumer> consumers = new ArrayList<>();
        List<Consumer> consumers1 = new ArrayList<>();
        for (int i = 0; i < MAX_VALUE; i++) {
            consumers.add(new Consumer(i, "tom", i, new Date()));
            consumers1.add(new Consumer(i, "tom", i, new Date()));
        }

        //测试双for循环耗时
        long s1 = System.currentTimeMillis();
        int iTest = 0;
        for (Consumer consumer : consumers) {
            if (consumer.getName() != null) {
                for (Consumer consumer1 : consumers1) {
                    if (consumer.getId().equals(consumer1.getId())) {
                        iTest++;
                    }
                }
            }
        }
        long s2 = System.currentTimeMillis();
        System.out.println("双for循环查询时间为：" + (s2 - s1) + "(毫秒)，一共查询出" + iTest + "条数据 \n\n\n");


        //测试map查询耗时
        long s3 = System.currentTimeMillis();

        int mapTest = 0;
        //把需要循环查找的条件字段作为map的key值或则把条件转成key对象处理
        Map<Integer, Consumer> map = new HashMap<>();
        for (Consumer consumer : consumers) {
            map.put(consumer.getId(), consumer);
        }

        for (Consumer consumer : consumers1) {
            if (consumer.getName() != null) {
                //通过map 查询条件是否存在
                if (map.get(consumer.getId()) != null) {
                    mapTest++;
                }
            }
        }
        long s4 = System.currentTimeMillis();
        System.out.println("使用map结构查询时间为：" + (s4 - s3) + "(毫秒)，一共查询出" + mapTest + "条数据 \n\n\n");







    }

}


