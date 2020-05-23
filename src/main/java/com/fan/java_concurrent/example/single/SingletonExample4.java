package com.fan.java_concurrent.example.single;

import com.fan.java_concurrent.annotations.NotThreadSafe;

/**
 * 懒汉单例模式 -> 双重同步锁
 */
@NotThreadSafe
public class SingletonExample4 {

    // 私有构造方法
    private SingletonExample4() {

    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存

    // JMN和cpu优化时，发生指令重排序，2和3顺序不确定先后
    private static SingletonExample4 instance = null;

    // 使用双重锁检查机制
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
