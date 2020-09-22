package com.demo.interviewdemo.optionalDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-03 16:32
 **/
public class OptionalDemo {
    public static void main(String[] args) {

        Worker worker = new Worker("tom", "111", 10);

        Optional<Worker> empty = Optional.empty();
        //逻辑反转
        Optional.ofNullable(new Object()).filter(u -> u instanceof String && u.equals("") ? false : true).orElse(true);





    }

    /**
     * stream 对map 进行过滤
     * @param map
     * @return
     */
    public static Map<String, Object> parseMapForFilter(Map<String, Object> map) {
        if (map == null) {
            return null;
        } else {
            map = map.entrySet().stream().filter(u -> u.getValue() != null).collect(Collectors.toMap(u -> u.getKey(), u -> u.getValue()));
        }
        return map;
    }

    public static Map<String, Object> ParseMapForFilterUpgrade(Map<String, Object> map) {
        return Optional.ofNullable(map).map(v -> {
            Map params = v.entrySet().stream().filter(u -> u.getValue() != null).collect(Collectors.toMap(u -> u.getKey(), u -> u.getValue()));
            return params;
        }).orElse(null);
    }

    public static Map<String, Object> parseMapForFilterUpgradeNew(Map<String, Object> map) {
        return Optional.ofNullable(map).flatMap(v -> {
            Map params = v.entrySet().stream().filter(u -> u.getValue() != null).collect(Collectors.toMap(u -> u.getKey(), u -> u.getValue()));
            return Optional.ofNullable(params);
        }).orElse(null);
    }

    public static boolean checkValueByOptional(Object object) {
        return (boolean) Optional.ofNullable(object).filter(e -> e instanceof String && e.equals("") ? false : true).orElse(null);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Worker {
        private String name;
        private String id;
        private Integer age;
    }


}
