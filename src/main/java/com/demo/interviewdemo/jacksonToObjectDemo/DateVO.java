package com.demo.interviewdemo.jacksonToObjectDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.Date;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:02 2019/10/8
 */
@Data
public class DateVO {

    public static void main(String[] args) throws IOException {
        /*DateVO dateVO = new DateVO();
        dateVO.setStart(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(dateVO));

        System.out.println(JSON.toJSONString(dateVO));

        String json = "{\"start\":1570695126050}";

        System.out.println(objectMapper.readValue(json, DateVO.class));

//        System.out.println(JSON.toJavaObject((JSONObject)JSON.toJSON(json) , DateVO.class));

        json = "{\"start\":\"10102019\"}";
        System.out.println(objectMapper.readValue(json, DateVO.class));

        //

        json = "{\"start\":\"2019-10-10\"}";
        System.out.println(objectMapper.readValue(json, DateVO.class));

        System.out.println(new Date());*/

        Integer integer = 1;
        Long lo = 1L;
        System.out.println(integer.equals( lo.intValue()));


    }

    @JsonFormat(pattern = "ddMMyyyy")
    private Date start;

}
