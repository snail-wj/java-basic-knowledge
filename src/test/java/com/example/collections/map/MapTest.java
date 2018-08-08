package com.example.collections.map;

import org.junit.Test;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author WJ
 * @date 2018/8/8
 */
public class MapTest {

    /**
     * navigablemap的使用
     */
    @Test
    public void test1(){
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(11, "aa");
        map.put(22, "bb");
        map.put(55, "ee");
        map.put(44, "dd");
        map.put(33, "cc");
        System.out.println("原始的map");
        System.out.println(map);
        System.out.println("键大于33，不包含33");
        SortedMap<Integer, String> integerStringSortedMap = map.tailMap(33, false);
        System.out.println(integerStringSortedMap);
        System.out.println("map first key");
        System.out.println(map.firstKey());
        System.out.println("map last key");
        System.out.println(map.lastKey());
        System.out.println("map last entry");
        System.out.println(map.lastEntry());

    }
}
