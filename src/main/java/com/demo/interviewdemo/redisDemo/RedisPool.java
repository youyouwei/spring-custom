package com.demo.interviewdemo.redisDemo;

import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;

/**
 * @description: redis 连接池
 * 要使用JedisPool 和 JedisPoolConfig
 * @author: jhyang
 * @create: 2019-08-02 11:44
 **/
public class RedisPool {
    private static String ADDR = "127.0.0.1";
    private static Integer PORT = 6379;
    //private static String AUTH = "";

    private static Integer MAX_TOTAL = 1024;
    private static Integer MAX_IDEL = 200;
    private static Integer MAX_WAIT_MILLIS = 10000;
    private static Integer TIMEOUT = 10000;
    private static Boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;

    static{
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDEL);
            config.setMaxWaitMillis(MAX_WAIT_MILLIS);
            config.setTestOnBorrow(TEST_ON_BORROW);
            //AUTH走验证
            //jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis jedis = jedisPool.getResource();
                return jedis;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    public static void main(String[] args) {
        RedisPool.getJedis().set("name", "tom");
        System.out.println(RedisPool.getJedis().get("name"));

        RedisTemplate<Serializable, Object> redisTemplate;


    }
}
