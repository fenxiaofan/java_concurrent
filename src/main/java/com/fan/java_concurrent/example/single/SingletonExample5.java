package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.ThreadSafe;

/**
 * 懒汉单例模式 -> 双重同步锁
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造方法
    private SingletonExample5() {

    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存

    // 添加volatile关键字，来禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    // 使用双重锁检查机制
    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
