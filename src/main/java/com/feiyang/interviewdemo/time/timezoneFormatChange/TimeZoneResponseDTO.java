package com.feiyang.interviewdemo.time.timezoneFormatChange;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:Jayce
 * @Date :2020/4/1
 * @Time :10:53
 */
@Data
public class TimeZoneResponseDTO implements Serializable {

    private static final long   serialVersionUID = 1383422957003573430L;
    /**
     * 时区信息列表
     */
    private Map<String, String> zoneInfoList;

    /**
     * 默认服务器时区信息
     */
    private Map<String, String> defaultZoneInfo;

    /**
     * 默认服务器时间戳
     */
    private Long                defaultTimeStamp;
}
