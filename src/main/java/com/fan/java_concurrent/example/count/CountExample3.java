package com.fan.java_concurrent.example.count;

import com.fan.java_concurrent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 修饰代码块：大括号括起来的代码，作用于调用对象
 * 修饰方法：整个方法，作用域调用对象
 * 修饰静态方法：整个静态方法，作用于所有对象
 * 修饰类：括号括起来的部分，作用域所有对象
 */
@Slf4j
@ThreadSafe
public class CountExample3 {

    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public  static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count{}", count);
    }

    public static synchronized void add() {
        count++;
    }
}
