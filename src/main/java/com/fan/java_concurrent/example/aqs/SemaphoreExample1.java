package com.fan.java_concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExample1 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadCount = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();    // 获取一个许可
                    test(threadCount);
                    semaphore.release();    // 释放一个许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        exec.shutdown();
  }

    private static void test(int threadCount) throws InterruptedException {
        log.info("{}", threadCount);
        Thread.sleep(1000);
    }
}
