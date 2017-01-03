package com.rain.nio.netty;

import org.msgpack.annotation.Message;

/**
 * Created by chenyu on 2016/12/16.
 */
@Message//这个加上，要不会无法encode decode，debug  逐步执行才报错。。
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
