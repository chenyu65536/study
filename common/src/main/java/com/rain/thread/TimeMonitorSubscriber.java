package com.rain.thread;

/**
 * Created by rain on 2016/12/4.
 */
public interface TimeMonitorSubscriber {
    boolean isTimeOut();

    default void unRegister() {
        TimeMonitor.getInstance().unRegister(this);
    }

    default void register() {
        TimeMonitor.getInstance().register(this);
    }

    default void notifyTimeOut() {
        throw new TimeoutException("线程超时");
    }
}
