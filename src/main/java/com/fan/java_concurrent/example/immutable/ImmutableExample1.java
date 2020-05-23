package com.fan.java_concurrent.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        // final修饰的基本变量不能再次被赋值
//        a = 2;

        map.put(1,3);
        log.info("map key 1 value is {}", map.get(1));
    }
}
