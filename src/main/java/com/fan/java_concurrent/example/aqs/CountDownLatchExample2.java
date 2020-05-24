package com.fan.java_concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample2 {

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
        // 指定休眠的时间，超过这个时间后，等待结束
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finished");
        // 调用的时候不会立马把线程池关闭掉，而是等待线程池内的任务执行完毕再关闭掉
        exec.shutdown();
  }

    private static void test(int threadCount) throws InterruptedException {
        Thread.sleep(1);
        log.info("{}", threadCount);
        Thread.sleep(1);
    }
}
