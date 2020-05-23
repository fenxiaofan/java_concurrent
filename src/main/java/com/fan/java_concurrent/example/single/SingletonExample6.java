package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.ThreadSafe;

/**
 * 饿汉模式 -> 使用静态域
 * 单例模式在类装载时创建
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有构造方法
    private SingletonExample6() {

    }

    // 单例对象
    private static SingletonExample6 instance = null;

    /**
     * 要注意静态变量和静态代码块的先后顺序，代码先后顺序不同，执行的结果不同
     */
    static {
        instance = new SingletonExample6();
    }

    // 静态方法，获取实例
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
