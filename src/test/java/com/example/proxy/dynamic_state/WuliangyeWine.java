package com.example.proxy.dynamic_state;

/**
 * @author WJ
 * @date 2018/8/22
 */
public class WuliangyeWine implements SellWine {
    @Override
    public void sell() {
        System.out.println("我卖得是五粮液。");
    }

    @Override
    public void speak() {
        System.out.println("我喜欢喝五粮液");
    }
}
