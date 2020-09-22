package com.demo.interviewdemo.dataStructureAlgorithmDemo;

import lombok.Data;

import java.util.Stack;

/**
 * @description: 数据结构算法
 * @author: jhyang
 * @create: 2019-07-30 10:23
 **/
public class DataStructureDemo {
    public static void main(String[] args) {
        /*Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());

        System.out.println(stack.search(3));

        stack.pop();

        System.out.println(stack);

        List<Integer> list = new ArrayList<>();*/

        Stack stackNew = new Stack();

        Glass glass = new Glass();
        glass.setDes("玻璃");
        glass.setName("眼睛");

        stackNew.push(glass);
        stackNew.push(glass);
        stackNew.push(glass);

        stackNew.pop();

        Glass glassGet = (Glass) stackNew.peek();
        glassGet.setName("啤酒瓶");

        System.out.println(stackNew);
        System.out.println(glassGet);

    }
}
@Data
class Glass {
    private String name;
    private String des;
}
