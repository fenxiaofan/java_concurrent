package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.Recommend;
import com.fan.java_concurrent.annotations.ThreadSafe;

/**
 * 使用枚举来实现单例模式
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // 构造方法是由JVM保证只被调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
