package com.rain.thread;


import com.rain.leetcode.bean.Node;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by rain on 2016/11/30.
 */
public class ThreadTest {
  /* private static ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

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

        Future<?> future =poolTaskExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });


        Future<Node> future2 =poolTaskExecutor.submit(new Callable<Node>() {
            @Override
            public Node call() throws Exception {
                return null;
            }
        });

    }

    private void execute() {
        synchronized (this) {
            j++;
            System.out.println("" + j);
        }
    }
    public static void main(String[] args) {
       // new ThreadTest().test();

    }*/

}
