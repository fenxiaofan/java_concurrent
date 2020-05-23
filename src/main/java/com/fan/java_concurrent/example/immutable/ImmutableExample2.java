package com.fan.java_concurrent.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        // 会把传入的map拷贝的自己的类中，该类中的很多方法被重新定义无法操作，抛出异常
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//        map.put(1, 3);    此处会抛出异常
        log.info("{}", map.get(1));
    }
}
