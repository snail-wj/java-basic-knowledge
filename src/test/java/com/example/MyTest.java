package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WJ
 * @date 2018/8/23
 */
public class MyTest {

    // String类型测试
    @Test
    public void testString() {
        String s = "";
        test(s, 0);
    }

    // 这个理所当然不相等,只要对String这个对象做了相加操作，地址就变了，所以每一个栈帧中存的值都是一个一样的值
    private static void test(String s, Integer number) {
        if (number == 2) {
            return;
        }
        s = s + number;
        System.out.println(s + "," + s.hashCode());
        number++;
        test(s, number);
        System.out.println("after:" + s + "," + s.hashCode());
    }

    //String 类型数组测试
    @Test
    public void testStringArrray() {
        String[] s = {""};
        test1(s, 0);
    }

    // 这个理所应当的不会变，虽然String这个值在常量池，会变，但是由于我们这个地址指向的
    //的是一个数组，这个是一个对象，这个从一开始就不变的，String[0]的在堆内存的地址不会变
    //则内存地址不变，则里面存储的值只有一个，所以等到回溯出来的时候也只有一个
    private static void test1(String[] s, Integer number) {
        if (number == 2) {
            return;
        }
        s[0] = s[0] + number;
        System.out.println(s[0] + "," + s.hashCode());
        number++;
        test1(s, number);
        System.out.println("after:" + s[0] + "," + s.hashCode());
    }

    public static void main(String[] args) {
//        String s = "";
//        test(s, 0);

//        String[] s = {""};
//        test1(s, 0);

//        int[] s = {0};
//        test2(s, 0);

//        int s = 0;
//        test3(s, 0);

//        Integer s = 1000;
//        test4(s, 0);

//        Integer[] s = {0};
//        test5(s, 0);

        AtomicInteger s = new AtomicInteger(0);
        test6(s, 0);

    }

    //int数组测试
    @Test
    public void testIntArray() {
        int[] s = {0};
        test2(s, 0);
    }

    //同test1，是数组，则不会变
    private static void test2(int[] s, Integer number) {
        if (number == 2) {
            return;
        }
        s[0] = s[0] + number;
        System.out.println(s[0] + "," + s.hashCode());
        number++;
        test2(s, number);
        System.out.println("after:" + s[0] + "," + s.hashCode());
    }

    //int数字测试
    @Test
    public void testInt(){
        int s = 0;
        test3(s, 0);
    }

    //这个会变，这个每一次方法的调用，都是通过栈帧，这个值会变
    //而且int的数字是保存到栈上面的的，当方法调用，退出栈，则值也会消失
    private static void test3(int s, Integer number) {
        if (number == 2) {
            return;
        }
        s = s + number;
        System.out.println(s);
        number++;
        test3(s, number);
        System.out.println("after:" + s);
    }

    //Integer数字测试
    @Test
    public void testInteger(){
        Integer s = 1000;
        test4(s, 0);
    }


    //Integer a;则会有: a 与 a + 1的地址不一样，不过我们可以使用一个AutomicInteger这个对象
    private static void test4(Integer s, Integer number) {
        if (number == 2) {
            return;
        }
        System.out.println(s == (s + number));
        s = s + number;
        System.out.println(s + "," + s.hashCode());
        number++;
        test4(s, number);
        System.out.println("after:" + s + "," + s.hashCode());
    }

    /**
     * Integer数组测试
     */
    @Test
    public void testIntegerArray(){
        Integer[] s = {0};
        test5(s, 0);
    }

    //不会变，这个int型数组，则这个值没有改变
    private static void test5(Integer[] s, Integer number) {
        if (number == 2) {
            return;
        }
        s[0] = s[0] + number;
        System.out.println(s[0] + "," + s.hashCode());
        number++;
        test5(s, number);
        System.out.println("after:" + s[0] + "," + s.hashCode());
    }

    @Test
    public void testAtomicInteger(){
        AtomicInteger s = new AtomicInteger(0);
        test6(s, 0);
    }

    //使用AtomicInteger这个对象，加1，对象地址不会变
    private static void test6(AtomicInteger s, Integer number) {
        if (number == 2) {
            return;
        }
        s.addAndGet(1);
        System.out.println(s + "," + s.hashCode());
        number++;
        test6(s, number);
        System.out.println("after:" + s + "," + s.hashCode());
    }

//    @org.junit.Test
//    public void test1(){
//        Integer a = new Integer(1);
//        Integer b = new Integer(2);
//        b = a;
//        a = 3;
//        System.out.println(a + "," + a.hashCode());
//        System.out.println(b + "," + b.hashCode());
//    }

    @org.junit.Test
    public void test2() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b;
        b = a;
        a.add(3);
        System.out.println(a + "," + a.hashCode());
        System.out.println(b + "," + b.hashCode());
    }

    @org.junit.Test
    public void test3() {
        int[] a = {1, 2, 3};
        int[] b = a;
        a[0] = 0;
        System.out.println(a + "," + a.hashCode());
        System.out.println(b + "," + b.hashCode());

    }

    @Test
    public void test4() {
//        String s = new String("123456");
//        System.out.println(s + "," + s.hashCode());
//        s += "7";
//        System.out.println(s + "," + s.hashCode());
//        String s1 = "123456";
//        System.out.println(s + "," + s.hashCode());
//        System.out.println(s1 + "," + s1.hashCode());
//        s1+="7";
//        String s2 = "1234567";
//        System.out.println(s1 + "," + s1.hashCode());
//        System.out.println(s2 + "," + s2.hashCode());

//        Integer a = new Integer(1);
//        Integer b = 1;
//        System.out.println(a + "," + a.hashCode());
//        System.out.println(b + "," + b.hashCode());
//        a += 1;
//        System.out.println(a + "," + a.hashCode());

        ArrayList<Person> list = new ArrayList<>();
        ArrayList<Person> list2;
        System.out.println(list + "," + list.hashCode());
        list2 = list;
        System.out.println(list2 + "," + list.hashCode());
        list.add(new Person());
        System.out.println(list + "," + list.hashCode());
        list.add(new Person());
        System.out.println(list + "," + list.hashCode());
        System.out.println(list2 == list);
    }

    public class Person {
    }

}
