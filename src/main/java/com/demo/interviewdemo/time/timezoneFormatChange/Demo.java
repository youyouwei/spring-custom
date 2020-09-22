package com.demo.interviewdemo.time.timezoneFormatChange;

import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:47 2020/8/14
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault().getId());

        System.out.println(formatZoneId(ZoneId.systemDefault().getId()));


    }

    public static String formatZoneId(String zoneId) {
        if(zoneId == null){
            return null;
        }
        StringBuilder formatZoneId = new StringBuilder();
        Optional<Map.Entry<String, String>> zoneInfo = DateZoneUtil.getZoneIdList().entrySet().stream()
                .filter(zone -> zoneId.equals(zone.getKey())).findAny();
        if (zoneInfo.isPresent()) {
            formatZoneId.append(zoneInfo.get().getValue());
        }
        return formatZoneId.toString();
    }

}
