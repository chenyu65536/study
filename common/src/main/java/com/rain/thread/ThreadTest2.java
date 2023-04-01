package com.rain.thread;


import com.rain.leetcode.bean.Node;
import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rain on 2016/11/30.
 */
public class ThreadTest2 {



    @SneakyThrows
    public static void test() {
        ThreadLocal threadLocal = new ThreadLocal();
      // threadLocal.set();

        ClassLoader.getSystemClassLoader().loadClass("aa");

        FutureTask<Node> future = new FutureTask<>(new Callable<Node>() {
            @Override
            public Node call() throws Exception {
                return null;
            }
        });
        future.get();
        ThreadTest2 tt = null;
        FutureTask future2 = new FutureTask(new Runnable() {
            @Override
            public void run() {

            }
        }, tt);
        future.get();


    }

    public static void main(String[] args) {
        //execute();
        Thread thread = new Thread();
        thread.suspend();
        thread.start();

        new Runnable(){

            @Override
            public void run() {

            }
        };
    }

}
