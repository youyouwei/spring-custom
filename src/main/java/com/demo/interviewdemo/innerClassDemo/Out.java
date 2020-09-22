package com.demo.interviewdemo.innerClassDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-07-04 20:13
 **/
public class Out {
    private static int a;
    private int b;

    /**
     * 静态内部类
     */
    public static class Inner {
        public void print() {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Out.Inner inner = new Out.Inner();
        inner.print();
    }

    /**
     * 成员内部类 中不能定义静态成员类
     */
    public class InnerNew {
        public void print() {
            System.out.println(a);
            System.out.println(b);
        }
    }

    /**
     * 局部内部类（定义在方法中的类）
     * @param c
     */
    public void test(final int c) {
        final int d = 1;
        class inner {
            public void print() {
                System.out.println(c);
            }

        }
    }

    abstract static class Bird {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public abstract int fly();

    }

    /**
     * 内部类要想直接使用内部类，需要把定义程静态内部类
     */
    static class Test {
        public void test(Bird bird) {
            System.out.println(bird.getName() + "能够飞" + bird.fly() + "米");
        }

        public static void anonymity(String[] args) {
            Test test = new Test();
            test.test(new Bird(){
                @Override
                public int fly() {
                    return 10000;
                }

                @Override
                public String getName() {
                    return "大雁";
                }
            });

        }
    }




}
