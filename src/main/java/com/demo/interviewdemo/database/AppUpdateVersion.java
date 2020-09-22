package com.demo.interviewdemo.database;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-03 19:43
 **/
@Data
public class AppUpdateVersion {
    private Integer id;
    private String versionId;
    private String updateUrl;
    private String updateContent;
    private Date updateVersionDate;
    private String updateType;
    private Date createTime;
    private Date updateTime;

}
