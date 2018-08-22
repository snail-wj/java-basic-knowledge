package com.example.annotation;

/**
 * @author WJ
 * @date 2018/8/22
 *
 * 注解，总而言之一句话，就是说就是一个打标签的一个过程，其实注解的作用，看你是想给他什么样的功能.
 * 记住一句话:注解是一个标签:https://blog.csdn.net/briblue/article/details/73824058
 */
@TestAnnotation(id = 0)
public class Test {

    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if(hasAnnotation){
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
    }
}
