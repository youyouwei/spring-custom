package com.demo.interviewdemo.jacksonToObjectDemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-14 18:19
 **/
public class JsonIgnoreDemo {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Name name = new Name(1, "tom", "jack");

        System.out.println(OBJECT_MAPPER.writeValueAsString(name));

        String json = "{\"id\":1,\"firstName\":\"tom\",\"lastName\":\"jack\"}";
        OBJECT_MAPPER.readValue(json, Name.class);





    }

}
