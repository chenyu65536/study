package com.rain.thread;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

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
        countDownLatch.countDown();
        countDownLatch.await();
    }

    public void method1() {
        Exchanger<Integer> exchanger = new Exchanger<>();
        try {
            exchanger.exchange(1);
            exchanger.exchange(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //高并发 cas 种子  性能会差
        Random random = new Random();
        random.nextInt();
        //每个线程维护一个种子  性能好
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        localRandom.nextInt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.currentThread().isInterrupted();
        Thread.currentThread().interrupt();

        try {
            wait(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t = new Thread();
        try {
            t.join(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.yield();//让出cpu、不释放锁、可能会重新抢到cpu
        LockSupport.park();
        LockSupport.unpark(t);
    }

    public void method2() {
        System.out.println("method2");
    }

    public void method3() {
        System.out.println("method3");
    }

/*
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        });

        new Thread();

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
        Condition condition = lock.newCondition();
        lock.lock();
        lock.unlock();


        AbstractQueuedSynchronizer queuedSynchronizer = null;
        queuedSynchronizer.tryAcquireNanos(10);

        ThreadPoolExecutor executor;
        executor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });


        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.addAndGet(1);
    }
*/
/*

    public static void main(String[] args) {
    */
/*    Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
*//*

        int[] nums = new int[]{4, 5, 6};
        int[][] goodPrices = new int[][]{{1, 2, 3}, {4, 3, 2}, {1, 5, 3}};
        //最小买，最大卖
        int amount = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] prices = goodPrices[i];
            int buyPrice = prices[0];
            int buyDay = 0;
            int sellPrice = prices[0];
            int sellDay = 0;
            for (int j = 1; j < prices.length; j++) {
                if (prices[j] >= sellPrice) {
                    //重置卖入价
                    sellPrice = prices[j];
                    sellDay = j;
                }

                if (prices[j] < sellPrice) {
                    //重置买入价 同时进行一次卖出
                    if (sellPrice > buyPrice && sellDay>buyDay) {
                        amount = amount + (sellPrice - buyPrice) * nums[i];
                    }
                    buyPrice = prices[j];
                    buyDay = j;
                }
            }
            if (sellDay > buyDay) {
                amount = amount + (sellPrice - buyPrice) * nums[i];
            }
        }
        System.out.printf(""+amount);
    }
*/


    //x^k=n,求x
    public static void main(String[] args) {
        double n = 15;
        int k = 3;//k次方
        double distance = 0.001;//允许的误差
        double res = sqrt3(n,k, distance);
        System.out.println(res);


        String a= "aa";

        System.out.printf(""+a.hashCode());
    }

    public static double sqrt3(double n, int m,double distance) {
        double k = n / m;
        double k2, k3;
        do {
            k2 = k * k;
            k3 = k2 * k;
            k = k - (k3 - n) / (m * k2);
        } while (Math.abs(k * k * k - n) > distance);
        return k;
    }
}
