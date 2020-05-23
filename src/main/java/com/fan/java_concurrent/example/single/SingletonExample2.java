package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例模式在类装载时创建
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造方法
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态方法，获取实例
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
