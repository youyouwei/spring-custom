package com.feiyang.interviewdemo.jsonDemo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 19:03 2020/6/1
 */
public class JsonDemo {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static void main(String[] args) throws Exception {
        serialize();
    }

    /**
     * 序列化
     */
    public static void serialize() throws JsonProcessingException {
        //空bean不报错
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
        Person person = null;
        OBJECT_MAPPER.writeValueAsString(person);


    }

    /**
     * 反序列化
     */
    public static void deserialize() {

    }

    @Data
    static class Person{
        private String name;
        private Integer id;
    }


    public static void method() {


    }

}
