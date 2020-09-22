package com.demo.interviewdemo.annotationAndReflect.fruitDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-22 11:49
 **/
public class Apple {
    @FruitName("红富士")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.BLUE)
    private String appleColor;

    @FruitProvider(id = 1,name = "陕西红富士集团",address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvide;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvide() {
        return appleProvide;
    }

    public void setAppleProvide(String appleProvide) {
        this.appleProvide = appleProvide;
    }
}
