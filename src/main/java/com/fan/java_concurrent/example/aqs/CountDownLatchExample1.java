package com.fan.java_concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchExample1 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadCount = i;
            exec.execute(() -> {
                try {
                    test(threadCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

            });
        }

        countDownLatch.await();
        log.info("finished");
        exec.shutdown();
  }

    private static void test(int threadCount) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadCount);
        Thread.sleep(100);
    }
}
