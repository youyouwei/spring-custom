package com.demo.interviewdemo.collectionOperDemo.optimizeDemo;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 优化集合操作  算法
 * @Author: jiahuiyang
 * @Date: Created in 15:59 2020/9/27
 */
public class OptimizeCollectionDemo {

    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>();

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setName("ticket" + i);
            ticket.setType("movie");
            tickets.add(ticket);

            if (i != 99) {
                ids.add(i);
            }
        }


        // method 1
        long start = System.currentTimeMillis();

        tickets = tickets.stream().filter(u -> ids.contains(u.getId())).collect(Collectors.toList());

        System.out.println("consumer times: " + (System.currentTimeMillis() - start));
//        consumer times: 30403 10万数据级耗时30秒
        System.out.println("size: " + tickets.size());


        // method2
        start = System.currentTimeMillis();
        Map<Integer, Ticket> map = tickets.stream().collect(Collectors.toMap(Ticket::getId, ticket -> ticket));
        Set<Ticket> newTickets = new HashSet<>(100000);
        ids.forEach(x->{
            newTickets.add(map.get(x));
        });
        System.out.println("consumer times: " + (System.currentTimeMillis() - start));
//        consumer times: 50   10万数量级耗时50毫秒
        System.out.println("size: "+newTickets.size());

        // 总结：method 1 算法是先遍历tickets，然后对每个元素在ids中遍历查找，相当于for循环嵌套，所以时间复杂度是O(n^2)
        // method 2 算法是先遍历tickets并把每个元素转成Map，然后再遍历ids并查找map中的key，由于map查找key的时间复杂度是O(1)，所以总的时间复杂度是O(n)+O(n)=O(2n)相当于O(n)，但是中间会有Map转换，会消耗内存。

        // 所以如果存在循环遍历查找元素，可以考虑把List转成Map，这样提高查询性能。这就应了List适合遍历，Map适合查找。

    }




    @Data
    static class Ticket {
        private Integer id;
        private String name;

        private String type;

    }
}



