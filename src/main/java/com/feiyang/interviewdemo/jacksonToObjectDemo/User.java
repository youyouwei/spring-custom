package com.feiyang.interviewdemo.jacksonToObjectDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-01 17:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  //可以忽略不存在的反序列化字段
public class User {
    @JsonIgnore   //表示该字段 在序列化和反序列化都忽略掉
    private String id;
    private String name;
}
