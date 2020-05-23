package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.NotThreadSafe;

/**
 * 懒汉单例模式
 * 单例实例在第一使用时进行创建
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造方法
    private SingletonExample1() {

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
