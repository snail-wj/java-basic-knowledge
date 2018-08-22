package com.example.proxy.dynamic_state;

/**
 * @author WJ
 * @date 2018/8/22
 */
public class ZhongHua implements SellCigarette {
    @Override
    public void sell() {
        System.out.println("我卖的是正宗的中华");
    }
}
