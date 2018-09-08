package com.example.proxy.dynamic_state;

/**
 * @author WJ
 * @date 2018/8/22
 * 茅台
 */
public class MaotaiWine implements SellWine {

    @Override
    public void sell() {
        System.out.println("我卖的是茅台酒");
    }

    @Override
    public void speak() {
        System.out.println("我喜欢喝茅台");
    }
}
