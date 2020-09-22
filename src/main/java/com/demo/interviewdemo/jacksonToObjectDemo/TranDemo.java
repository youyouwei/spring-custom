package com.demo.interviewdemo.jacksonToObjectDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @description: 转换实例
 * @author: jhyang
 * @create: 2019-07-01 17:54
 **/
public class TranDemo {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        /*User user = new User("123", "tom");

        String json = "{\n" +
                "    \"id\":\"123\",\n" +
                "    \"name1\":\"tom\",\n" +
                "    \"address\":\"china\"\n" +
                "}";

        User newUser = objectMapper.readValue(json, User.class);


        System.out.println(newUser);

        String newJson = objectMapper.writeValueAsString(user);
        System.out.println(newJson);*/

        /*Screen screen = new Screen();
        screen.setName("屏幕");
        screen.setType("电脑");
        //对象直接toString()不会有引号
        System.out.println(screen);*/

        //jsonToObject();
        //objectToJson();
        jsonToObjectWithGenerics();


    }

    /**
     * 类型转json字符串
     */
    public static void objectToJson() throws JsonProcessingException {
        Screen screen = new Screen();
        screen.setName("屏幕");
        screen.setType("电脑");

        //如果对象为null 转换string 会等于 "null"，会导致获取的string结果不同于预期
        String json = screen == null ? null : objectMapper.writeValueAsString(screen);

        System.out.println(json);
    }

    /**
     * 字符串转类型
     */
    public static void jsonToObject() throws IOException {
        String json = "{\n" +
                "    \"name\":\"屏幕\",\n" +
                "    \"type\":\"电脑\"\n" +
                "}";

        //空对象转成"null"字符串，同时"null"也可以转成null对象，但是字符串为null或则""都会转换失败
        Screen screenNew = objectMapper.readValue("null", Screen.class);
        System.out.println(screenNew);
        //如果是json为null，转换会报错，一定要做非空判断
        Screen screen = (StringUtils.isEmpty(json) ? null : objectMapper.readValue(json, Screen.class));

        System.out.println(screen);
    }

    /**
     * json串转泛型类型对象
     */
    public static void jsonToObjectWithGenerics() throws IOException {

        Box<Integer> box = new Box<>();
        box.setName("瓶子");
        box.setT(1);
        String json = objectMapper.writeValueAsString(box);
        System.out.println(json);

        Box<Integer> boxNew = objectMapper.readValue(json, new TypeReference<Box<Integer>>() {});
        boxNew = objectMapper.readValue(json, Box.class);
        System.out.println(boxNew);

        Box<Screen> screenBox = new Box<>();
        screenBox.setName("屏幕");
        Screen screen = new Screen();
        screen.setType("电脑");
        screen.setName("屏幕");
        screenBox.setT(screen);
        json = objectMapper.writeValueAsString(screenBox);
        System.out.println(json);
        //泛型 只在编译时期检查语法，运行时期会进行类型擦除 同一转成Object
        Box<Integer> stringBox = objectMapper.readValue(json, Box.class);
        Integer integer = stringBox.getT();
        System.out.println(stringBox);



    }

}

@Data
class Screen {
    private String type;
    private String name;
}

@Data
class Box<T> {

    private String name;
    private T t;

}

