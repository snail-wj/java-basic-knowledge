package com.example.optional;

import lombok.val;
import org.junit.Test;

import java.util.Optional;

import static java.lang.System.*;

/**
 * Optional操作
 *
 * @author WJ
 * @date 2018/8/20
 */
public class OptionalDemo {

    /**
     * 基本方法:
     * of() 为非 null 的值创建一个 Optional 实例
     * isPresent() 如果值存在，返回 true，否则返回 false
     * get() 返回该对象，有可能返回 null
     */
    @Test
    public void testOptionalIsPresent() {
        val op1 = Optional.of("hello");
        out.println(op1.isPresent());
        out.println(op1.get());  //输出hello
        val op3 = Optional.ofNullable(null);
        out.println(op3.isPresent());
        val op2 = Optional.of(null); //抛出异常
    }

    /**
     * ifPresent() 如果实例非空，调用 Comsumer Lambda 表达式
     */
    @Test
    public void testOptionalzIsPresent2() {
        val op1 = Optional.of("Hello");
        op1.ifPresent(out::println);
    }

    /**
     * map() 如果实例非空，调用 Function Lambda 表达式
     */
    @Test
    public void testOptionalIsPresent3() {
        val op1 = Optional.of("Hello");
        val op2 = op1.map(s -> s.toUpperCase());
        op2.ifPresent(System.out::println);
    }

    /**
     * orElse(obj) 如果实例非空，返回该实例，否则返回 obj
     */
    @Test
    public void testOptionalIsPresent4() {
        val op1 = Optional.of("Hello");
        System.out.println(op1.orElse("World"));
        val op2 = Optional.ofNullable(null);
        System.out.println(op2.orElse("World"));
    }
}
