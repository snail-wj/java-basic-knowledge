package com.example.http.okhttp;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author WJ
 * @date 2018/8/20
 * OKHttp使用规范
 */
public class OkHttpDemo {

    private final OkHttpClient client = new OkHttpClient();

    /**
     * Get的基本使用
     *
     * @throws IOException Request是OkHttp中访问的请求，Builder是辅助类。Response即OkHttp中的响应。
     */
    @Test
    public void testGet() throws IOException {
        //挑选了某一家dsp的url,进行测试
        String url = "http://net.rayjump.com/openapi/ads?http_req=2&sign=1f1c9a0fc38d80c59c96b079cb13a125&app_id=105136&unit_id=52670&client_ip=207.226.244.123&platform=1&os_version=4.4.2&android_id=&gaid=4769e19c-a5d8-4cd4-b594-503499ef74b4&language=EN&cc=US&useragent=Dalvik%2F2.1.0+%28Linux%3B+U%3B+Android+5.0.2%3B+Redmi+Note+2+MIUI%2FV9.5.4.0.LHMMIFA%29&ad_num=2";
        String response = run(url);
        System.out.println(response);
    }

    private String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {

            return response.body() != null ? response.body().string() : null;
        } else {
            throw new IOException("Unexpected code: " + response);
        }
    }


    /**
     * HTTP POST
     * @throws IOException
     * 使用Request的post方法来提交请求体RequestBody
     */
    @Test
    public void testPost() throws IOException {
        String url = "https://onlineapi.youappi.com/online";
        String json = "{\"user_info\":{\"ip\":\"217.118.83.220\",\"user_agent\":\"Dalvik/2.1.0 (Linux; U; Android 8.0.0; MI 6 MIUI/V9.5.8.0.OCAMIFA)\",\"user_id\":{\"gaid\":\"467676a4-5958-41a5-b395-464d0e563bff\"}},\"ad_units\":[{\"ad_unit_type\":\"image\",\"ad_properties\":{\"image_dimensions\":\" \"},\"ad_unit_id\":\"1.302.4.1\",\"ad_unit_num\":\"9\"}],\"request_origin\":\"server\",\"publisher_info\":{\"app_id\":\"com.xiaomi.discover\",\"publisher_token\":\"com.xiaomi.discover\"},\"access_token\":\"ebbc4772-00f5-42e0-bbc7-ffed0738a3bc\"}";
        System.out.println(post(url, json));

    }

    private String post(String url, String json) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {

            return response.body() != null ? response.body().string() : null;
        } else {
            throw new IOException("Unexpected code: " + response);
        }

    }

    /**
     * HTTPClient超时测试
     *
     * Connection Timeout：与远程服务器建立连接的时间
     * Socket Timeout: 建立连接之后，等待远程服务器返回数据的时间
     * Connection Request Timeout：从连接管理器/池获取一个连接的等待时间
     * ReadTimeout:建立连接后从服务器读取到可用资源所用的时间。
     *
     * Connection Timeout & Socket Timeout是最重要的，但是获取一个连接的超时设置(onnection Request Timeout)在高负载情况下也同样重要
     * 可以把ReadTimeout设置的长一点，ConnectTimeout可以相对比较短，这是源于我们的网络状况一般较为稳定，连接时很少出现问题，但是读取时因为数据下载时的网络波动，出状况的可能性更大一些。
     *
     * ConnectTimeout：如果连接超时，则抛出java.net.SocketException: connetct time out的异常
     * readTimeout：如果在预定时间内，读取不到内容，抛出Java.net.SocketException: read time out的异常
     */
    @Test
    public void testHttpOverTime() throws IOException {
        OkHttpClient clientTimeOut = client.newBuilder().connectTimeout(1, TimeUnit.MILLISECONDS).readTimeout(1, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder()
                .url("http://net.rayjump.com/openapi/ads?http_req=2&sign=1f1c9a0fc38d80c59c96b079cb13a125&app_id=105136&unit_id=52670&client_ip=207.226.244.123&platform=1&os_version=4.4.2&android_id=&gaid=4769e19c-a5d8-4cd4-b594-503499ef74b4&language=EN&cc=US&useragent=Dalvik%2F2.1.0+%28Linux%3B+U%3B+Android+5.0.2%3B+Redmi+Note+2+MIUI%2FV9.5.4.0.LHMMIFA%29&ad_num=2")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("response:" + response);

    }
}
