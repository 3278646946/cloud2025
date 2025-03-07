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
    public  int a = 10;

    public static void main(String[] args) {

       int[] arr =  new int[10];
        for (int i : foreachTest(arr)) {
            System.out.println(i);
        }
    }


    public static int[] foreachTest(int[] arr) {
        for (int i : arr) {
            arr[i] = i;
        }
        return arr;
    }

    public static void test(Object o) {
        System.out.println("test");
//        a =  (Integer) o;

    }
    public  void test1(Object o) {
        System.out.println("test1");
        a = (Integer) o;
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