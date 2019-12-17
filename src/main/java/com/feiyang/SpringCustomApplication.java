package com.feiyang;


public class SpringCustomApplication {

    public static void main(String[] args) {

        if (args != null && args.length > 0) {

            System.out.println(args[0]);

            String name = System.getProperty("Name");
            System.out.println(name);



        }

    }

}
