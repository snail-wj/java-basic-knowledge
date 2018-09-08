package com.example.proxy.dynamic_state;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author WJ
 * @date 2018/8/22
 * <p>
 * 需要一个柜台来卖酒
 */
public class Guitai implements InvocationHandler {

    private Object wineBrand;

    public Guitai(Object wineBrand) {
        this.wineBrand = wineBrand;
    }

    /**
     * @param proxy  代理对象
     * @param method 代理对象调用的方法
     * @param args   调用的方法中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始 柜台是: " + this.getClass().getSimpleName());
        method.invoke(wineBrand, args);
        System.out.println("销售结束");
        return null;
    }
}
