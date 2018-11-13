package com.example.tool;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

/**
 * @author wangjing06 <wangjing06@kuaishou.com>
 * Created on 2018-11-13
 */
public class ToolDemo {

    /**
     * joda DateTime尝试使用
     */
    @Test
    public void test1(){
        String date1 = "2018-11-13";
        String date2 = "2018/11/13";
        long time = DateTime.parse(date1, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate().getTime();
        long time2 = DateTime.parse(date2, DateTimeFormat.forPattern("yyyy/MM/dd")).toDate().getTime();
        System.out.println(time);
        System.out.println(time2);
    }
}
