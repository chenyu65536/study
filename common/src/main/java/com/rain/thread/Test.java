package com.rain.thread;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.*;
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

    @SneakyThrows
    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.await();
    }

    @SneakyThrows
    public void method1(){
        Exchanger<Integer> exchanger = new Exchanger<> ();
        exchanger.exchange(1);

        //高并发 cas 种子  性能会差
        Random random = new Random();
        random.nextInt();
        //每个线程维护一个种子  性能好
        ThreadLocalRandom localRandom =  ThreadLocalRandom.current();
        localRandom.nextInt();


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
        atomicInteger.addAndGet(1);
    }


}
