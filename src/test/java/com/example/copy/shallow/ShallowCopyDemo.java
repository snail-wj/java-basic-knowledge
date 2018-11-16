package com.example.copy.shallow;

import org.junit.Test;

/**
 * @author wj
 * Created on 2018-11-16
 */
public class ShallowCopyDemo {

    @Test
    public void test1(){
        Person personSource = new Person();
        personSource.setId(1);
        personSource.setName("xiaoming");
        personSource.setAge(25);
        Person personTarget = new Person();

        CglibBeanCopierUtils.copyProperties(personSource, personTarget);
        System.out.println("personSource = personTarget => " + (personSource == personTarget));
        System.out.println("personSource:" + personSource + "," + "personTarget:" + personTarget);


    }
}
