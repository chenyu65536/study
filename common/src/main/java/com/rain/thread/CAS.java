package com.rain.thread;

import java.util.concurrent.atomic.LongAdder;

public class CAS {

    public void test(){
        LongAdder  longAdder = new LongAdder();
       longAdder.add(10);
        longAdder.longValue();
    }
}
