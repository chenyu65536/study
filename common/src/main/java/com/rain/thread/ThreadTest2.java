package com.rain.thread;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.WeakHashMap;

/**
 * Created by rain on 2016/11/30.
 */
public class ThreadTest2 {



    public static void execute() {
        Thread thread = new Thread();
        thread.start();


    }

    public static void main(String[] args) {
        execute();
    }

}
