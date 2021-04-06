package com.rain.thread;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.locks.Lock;

/**
 * Created by rain on 2016/11/30.
 */
public class ThreadTest {
    private static ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

    public int j = 0;

    static {
        poolTaskExecutor.setQueueCapacity(1000);
        poolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        poolTaskExecutor.setMaxPoolSize(50);
        poolTaskExecutor.setKeepAliveSeconds(60);
        poolTaskExecutor.initialize();
    }

    public void test() {
        for (int i = 0; i < 1000; i++) {
            poolTaskExecutor.newThread(new Runnable() {
                @Override
                public void run() {
                    execute();
                }
            }).start();
        }
    }

    private void execute() {
        synchronized (this) {
            j++;
            System.out.println("" + j);
        }
    }

    public static void main(String[] args) {
        new ThreadTest().test();

    }

}
