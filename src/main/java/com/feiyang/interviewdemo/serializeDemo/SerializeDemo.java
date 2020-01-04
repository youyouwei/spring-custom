package com.feiyang.interviewdemo.serializeDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:55 2019/11/11
 */
@Slf4j
public class SerializeDemo {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        object2Json();

    }

    /**
     * java object 转 json 如果只是数据转换 不需要实现serialize 来明确表明对象类
     * fastjson 对象转json 会排除空的null 的字段
     */
    public static void object2Json() throws JsonProcessingException {
        Cup cup = new Cup();
        cup.setMaker("china");
        String json = JSON.toJSONString(cup);
        System.out.println(json);
        log.info("json:{}", json);
        json = OBJECT_MAPPER.writeValueAsString(cup);
        System.out.println(json);
        log.info("");
        System.out.println(JSON.toJSONString(cup, SerializerFeature.WriteMapNullValue));

        demo(null, null);

    }

    /**
     *
     * @param name
     * @param address
     */
    public static void demo(  String name,  String address) {
        System.out.println(name + address);
    }



}
