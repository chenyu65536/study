package com.rain.thread;

/**
 * Created by rain on 2016/12/1.
 */
public class TimeoutException extends RuntimeException {

    public TimeoutException() {
    }

    public TimeoutException(String message) {
        super(message);
    }
}
