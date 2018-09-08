package com.example.proxy;

import com.example.proxy.dynamic_state.*;
import com.example.proxy.static_state.Cinema;
import com.example.proxy.static_state.Movie;
import com.example.proxy.static_state.RealMovie;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author WJ
 * @date 2018/8/22
 * <p>
 * <p>
 * 参考url(超级好理解):
 * https://blog.csdn.net/briblue/article/details/73928350
 */
public class ProxyTest {

    /**
     * 静态代理对象测试
     */
    @Test
    public void testStaticProxy() {
        RealMovie realMovie = new RealMovie();
        Movie movie = new Cinema(realMovie);
        movie.play();
    }

    /**
     * 动态代理对象测试
     *
     * loader 自然是类加载器
     * interfaces 代码要用来代理的接口
     * h 一个 InvocationHandler 对象
     *
     * public static Object newProxyInstance(ClassLoader loader,
     *                                           Class<?>[] interfaces,
     *                                           InvocationHandler h)
     *
     * 动态代理设计到了非常重要的类Proxy，我们通过Proxy的静态方法newProxyInstance会动态创建代理
     * 其中参数是以下的三个参数:
     * loader 自然是类加载器
     * interfaces 代码要用来代理的接口
     * h 一个 InvocationHandler 对象
     *InvocationHandler是一个接口，官方文档解释说，每一个代理的示例都与之关联的InvocationHandler实现类，如果
     * 代理方法被调用，那么代理便会通知和转发给内部的InvocationHandler实现类，由它决定处理
     *
     * public interface InvocationHandler {
     *
     *     public Object invoke(Object proxy, Method method, Object[] args)
     *         throws Throwable;
     * }
     * InvocationHandler 内部只是一个 invoke() 方法，正是这个方法决定了怎么样处理代理传递过来的方法调用。
     * proxy 代理对象
     * method 代理对象调用的方法
     * args 调用的方法中的参数
     *
     * 其实这个invoke只是一个方法调用的位置，此时没有真的开始调用方法，当Proxy.newProxyInstance出一个动态代理的时候
     * 这个时候动态代理代指的即使newProxyInstance的代理对象(第一个参数)，然后调用代理方法的时候，此时调用了动态代理的
     * InvocationHandler.invoke()方法,当执行到method.invoke(wineBrand, args);，这个时候才是真的执行代理对象
     * (真实对象)的方法，然后继续执行，知道invoke方法结束，这个和那个看电影的静态方法一直，只是不需要在手动的创建一个静态
     * 的代理类了，我们此时执行动态的代理类即可.代理只需要管真实的用户调用的方法，而不需要代理invoke()方法前后调用了什么
     *
     * 代理的主要功能在于:
     * 不修改代理对象的源码上，进行功能的增强
     * 这在AOP面向切面编程中经常见
     *
     */
    @Test
    public void testDynamicProxy1() {
        MaotaiWine maotai = new MaotaiWine();
        InvocationHandler seller1 = new Guitai(maotai);
        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(), MaotaiWine.class.getInterfaces(), seller1);
        dynamicProxy.sell();
        dynamicProxy.speak();
    }

    @Test
    public void testDynamicProxy2(){
        MaotaiWine maotai = new MaotaiWine();
        WuliangyeWine wuliangye = new WuliangyeWine();

        Guitai sellerA = new Guitai(maotai);
        Guitai selllerB = new Guitai(wuliangye);

        SellWine maotaiDynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(), MaotaiWine.class.getInterfaces(), sellerA);
        SellWine wuliangyeDynamicProxy = (SellWine) Proxy.newProxyInstance(WuliangyeWine.class.getClassLoader(), WuliangyeWine.class.getInterfaces(), selllerB);

        maotaiDynamicProxy.sell();
        wuliangyeDynamicProxy.sell();
    }

    @Test
    public void testDynamicProxy3(){
        ZhongHua zhongHua = new ZhongHua();
        Guitai sellerC = new Guitai(zhongHua);
        SellCigarette zhonghuaDynamicProxy = (SellCigarette) Proxy.newProxyInstance(ZhongHua.class.getClassLoader(), ZhongHua.class.getInterfaces(), sellerC);
        zhongHua.sell();
        zhonghuaDynamicProxy.sell();
    }
}
