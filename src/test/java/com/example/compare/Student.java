package com.example.compare;

import lombok.Data;

import static java.util.Objects.requireNonNull;

/**
 * @author WJ
 * @date 2018/8/14
 */
@Data
public class Student implements Comparable<Student> {
    private String name;
    private int gender; //0 women 1 man
    private int age;

    public Student(String name, int gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        requireNonNull(o);


        if(this.gender != o.getGender()){
            return o.getGender() - this.getGender();
        }

        return this.age - o.age;
    }
}
