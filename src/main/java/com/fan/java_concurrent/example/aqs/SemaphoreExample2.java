package com.fan.java_concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadCount = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);    // 获取三个许可
                    test(threadCount);
                    semaphore.release(3);    // 释放三个许可
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
