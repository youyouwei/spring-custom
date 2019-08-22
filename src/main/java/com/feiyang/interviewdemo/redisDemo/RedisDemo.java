package com.feiyang.interviewdemo.redisDemo;

import redis.clients.jedis.Jedis;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description: redis 客户端调用接口 jedis
 * 其中Jedis对应的方法都是redis中的命令
 * @author: jhyang
 * @create: 2019-08-01 18:09
 **/
public class RedisDemo {

    private Jedis jedis;

    public static void main(String[] args) {

        RedisDemo redisDemo = new RedisDemo();
        redisDemo.setJedis();
        redisDemo.jedis.set("name", "tom");
        String name = redisDemo.jedis.get("name");
        System.out.println(name);
    }

    public void setJedis() {
        jedis = new Jedis("127.0.0.1", 6379);
        //redis 有权限认证就加
        //jedis.auth("");
        System.out.println("连接成功！");
    }

    public void testString() {
        jedis.set("name", "chx");
        System.out.println("拼接前：" + jedis.get("name"));
        jedis.append("name", " is my name");
        System.out.println("拼接后：" + jedis.get("name"));
        jedis.del("name");
        System.out.println("删除后：" + jedis.get("name"));
        jedis.mset("name", "tom", "age", "20", "email", "tom@qq.com");
        jedis.incr("age");
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));
    }

    public void testMap() {
        Map<String, String> map = new Hashtable<>();
        map.put("name", "chx");
        map.put("age", "100");
        map.put("email", "chx@qq.com");
        jedis.hmset("user", map);
        List<String> list = jedis.hmget("user", "name", "age", "email");
        System.out.println(list);

        jedis.hdel("user", "age");
        System.out.println("age" + jedis.hmget("user", "age"));
        System.out.println("user的键中存放的值的个数：" + jedis.hlen("user"));
        System.out.println("是否存在key为user的记录：" + jedis.exists("user"));
        System.out.println("user对象中的所有key:" + jedis.hkeys("user"));
        System.out.println("user对象中的所有value:" + jedis.hvals("user"));

        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.del("user");
        System.out.println("删除后是否存在key为user的记录：" + jedis.exists("user"));

    }

    public void testList() {
        //先移除javaFramework中的所有内容
        jedis.del("javaFramework");

        jedis.lpush("javaFramework", "spring");
        jedis.lpush("javaFramework", "springMVC");
        jedis.lpush("javaFramework", "mybatis");

        System.out.println("长度：" + jedis.llen("javaFramework"));
        System.out.println("javaFramework:" + jedis.lrange("javaFramework", 0, -1));

        jedis.lrem("javaFramework", 0, "spring");
        System.out.println("删除后长度：" + jedis.llen("javaFramework"));
        System.out.println(jedis.lrange("javaFramework", 0, -1));
        jedis.del("javaFramework");

    }

    public void testSet() {
        jedis.sadd("user", "tom");
        jedis.sadd("user", "chen");
        jedis.sadd("user", "xiyu");
        jedis.sadd("user", "chx");
        jedis.sadd("user", "are");

        jedis.srem("user", "are");
        System.out.println("user中的value:" + jedis.smembers("user"));
        System.out.println("chx是否是user中的元素：" + jedis.sismember("user", "chx"));
        System.out.println("集合中的一个随机元素：" + jedis.srandmember("user"));
        System.out.println("user中元素的个数：" + jedis.scard("user"));
    }

    /**
     * 队列排序
     */
    public void test() {
        //先删除数据，再进行测试
        jedis.del("number");
        jedis.rpush("number", "4");
        jedis.rpush("number", "5");
        jedis.rpush("number", "3");

        jedis.lpush("number", "9");
        jedis.lpush("number", "1");
        jedis.lpush("number", "2");
        System.out.println(jedis.lrange("number", 0, jedis.llen("number")));
        System.out.println("排序：" + jedis.sort("number"));
        System.out.println(jedis.lrange("number", 0, -1));
        jedis.del("number");

    }


}
