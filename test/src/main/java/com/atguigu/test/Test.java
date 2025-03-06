package com.atguigu.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 上午8:11
 * @注释
 */
public class Test {
    public static int a = 10;
    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }

    }


    public static void test(Object o) {
        System.out.println("test");
    }
    public  void test1() {
        System.out.println("test");
        test2();
        this.test2();
        new Test().test2();
    }
    public  void test2() {
        System.out.println("test2");
    }

}
class A{
    public static int a;
}
class B {
    public int b = 20;
}



class ThreadDemo extends Thread  {
    @Override
    public void run() {
        System.out.println("ThreadDemo run...");
    }
}