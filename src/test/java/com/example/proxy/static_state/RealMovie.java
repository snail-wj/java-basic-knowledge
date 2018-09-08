package com.example.proxy.static_state;

/**
 * @author WJ
 * @date 2018/8/22
 */
public class RealMovie implements Movie {
    @Override
    public void play() {
        System.out.println("您正在观看电影《肖申克的救赎》");
    }
}
