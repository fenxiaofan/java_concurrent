package com.fan.java_concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum  = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
  }

    private static void race(int threadCount) throws Exception {
        Thread.sleep(1000);
        log.info("{} id ready", threadCount);
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException | TimeoutException e) {
            log.warn("BrokenBarrierException", e);
        }

        log.info("{} continue", threadCount);
    }
}
