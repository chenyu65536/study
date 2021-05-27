package com.rain.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/5/3 3:30 下午
 * AQS
 */
public class Test {

    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
      //  countDownLatch.await();
    }

    public void method1(){
        System.out.println("method1");

    }

    public void method2(){
        System.out.println("method2");
    }

    public void method3(){
        System.out.println("method3");
    }


    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method3();
            }
        });

        ReentrantLock lock = new ReentrantLock();
        lock.unlock();


        AbstractQueuedSynchronizer queuedSynchronizer = null;
    //    queuedSynchronizer.tryAcquireNanos();

        ThreadPoolExecutor executor;
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.addAndGet(1)
    }


}
