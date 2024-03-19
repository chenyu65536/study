package com.rain.exception;

import lombok.SneakyThrows;

import java.util.HashSet;

public class Test {

    @SneakyThrows
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }
}
