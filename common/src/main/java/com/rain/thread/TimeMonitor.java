package com.rain.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rain on 2016/12/1.
 */
public class TimeMonitor extends Thread {
    private static List<TimeMonitorSubscriber> subscribers = new ArrayList<>();

    private TimeMonitor() {
        this.start();
    }

    public static TimeMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void register(TimeMonitorSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unRegister(TimeMonitorSubscriber subscriber) {
        subscribers.remove(subscriber);
    }


    @Override
    public synchronized void run() {
        while (true) {
            for (TimeMonitorSubscriber subscriber : subscribers) {
                if (subscriber.isTimeOut()) {
                    subscriber.notifyTimeOut();
                    unRegister(subscriber);
                }
            }
        }
    }


    private static class SingletonHolder {
        private static final TimeMonitor INSTANCE = new TimeMonitor();
    }

}
