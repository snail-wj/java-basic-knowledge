package com.example.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author WJ
 * @date 2018/8/14
 */
public class CompareDemo {

    @Test
    public void testcompare1(){
        List<Student> studentList = Arrays.asList(new Student("zhoujielun", 1, 35), new Student("wanglihong", 1, 34), new Student("sunyanzi", 0, 18), new Student("xietingfeng", 1, 35));
        System.out.println("未排序:");
        System.out.println(studentList);
        System.out.println("排序后:");
        Collections.sort(studentList);
        System.out.println(studentList);
    }
}
