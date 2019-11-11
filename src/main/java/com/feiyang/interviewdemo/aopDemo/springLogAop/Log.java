package com.feiyang.interviewdemo.aopDemo.springLogAop;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:10 2019/11/11
 */
@Data
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logId;
    private String type;
    private String title;
    private String remoteAddr;
    private String requestUri;
    private String method;
    private String params;
    private String exception;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operateDate;
    private String timeout;
    private String userId;

    public void setMapToParams(Map<String, String[]> paramMap) {
        if (paramMap == null) {
            return;
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : ((Map<String, String[]>) paramMap).entrySet()) {
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");

        }

    }



}
