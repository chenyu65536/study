package com.rain.reflect;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
    private String kk = "1";



    public void method() {
        System.out.printf("111");
    }

    @SneakyThrows
    public static void main(String[] args) {
        Class<?> testClazz = Class.forName("com.rain.reflect.Test");
        Test test1 = (Test) testClazz.newInstance();

        //field
        Field[] publicFields = testClazz.getFields();
        Field[] allFields = testClazz.getDeclaredFields();
        String name = allFields[0].getName();
        String fieldValue = (String) allFields[0].get(test1);

        //method
        Method method = testClazz.getMethod("method");
        Parameter[] parameters = method.getParameters();
        parameters[0].getName();
        method.invoke(test1);

        //annotation
        Annotation[] annotations = method.getAnnotations();
        Class<BeanValid> annotationType = (Class<BeanValid>) annotations[0].annotationType();
        String value = ((BeanValid)annotations[0]).value();
    }
}
