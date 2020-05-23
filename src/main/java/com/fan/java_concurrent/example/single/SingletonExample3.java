package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.NotRecommend;
import com.fan.java_concurrent.annotations.ThreadSafe;

/**
 * 懒汉单例模式
 * 单例实例在第一使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造方法
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    // 使用synchronized关键字修饰
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
