package com.rain.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class Test {

    public void method() {
        System.out.printf("111");
    }

    @SneakyThrows
    public static void main(String[] args) {
        Class<?> testClazz = Class.forName("com.rain.reflection.Test");
        Test test1 = (Test) testClazz.newInstance();

        Method method = testClazz.getMethod("method");
        method.invoke(test1);
    }

}
