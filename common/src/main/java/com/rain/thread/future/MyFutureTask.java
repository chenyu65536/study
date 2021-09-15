package com.rain.thread.future;


import com.rain.thread.TimeMonitorSubscriber;
import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by rain on 2016/11/30.
 */
public class MyFutureTask<T> implements Runnable, TimeMonitorSubscriber {
    private T data;
    private long endTime;
    private Thread thread;
    private Callable callable;
    private boolean isDone = false;

    public MyFutureTask(Callable callable) {
        this.callable = callable;
        thread = new Thread(this);
        //  thread.setName("测试线程");  Thread.currentThread().getName()  查看当前线程，方便调试
    }

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public synchronized void run() {
        System.out.println("------thread  start-----");
        Thread.sleep(2000L);
        data = (T) callable.call();
        isDone = true;
        notifyAll();

    }

    public synchronized T get() throws InterruptedException {
        thread.start();
        if (!isDone) {
            wait();
        }
        System.out.println("------thread  end-----");
        return data;
    }

    public synchronized T get(TimeUnit unit, long time) throws InterruptedException {
        thread.start();
        endTime = System.currentTimeMillis() + unit.toMillis(time);
        this.register();
        if (!isDone) {
            wait();
        }
        System.out.println("------thread  end-----");
        unRegister();
        return data;
    }

    @Override
    public boolean isTimeOut() {
        return endTime < System.currentTimeMillis();
    }

    @Override
    public void notifyTimeOut() {
        thread.interrupted();
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        MyFutureTask<Person> task = new MyFutureTask<>(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return new Person("oo");
            }
        });
        System.out.println("------先做点其他事----");
        Person person = task.get(TimeUnit.MILLISECONDS, 1000);
        System.out.println("------所有task完成----" + person.getName());
    }

}
