package com.example.proxy.static_state;

/**
 * @author WJ
 * @date 2018/8/22
 * Cinema是Proxy代理对象
 */
public class Cinema implements Movie {

    private RealMovie movie;

    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }

    @Override
    public void play() {
        advertise(true);
        movie.play();
        advertise(false);
    }

    private void advertise(boolean isStart) {
        String msg = isStart ? "电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！" : "电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！";
        System.out.println(msg);
    }
}
