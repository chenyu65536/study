package com.rain.exception;

import lombok.SneakyThrows;

public class Test {

    @SneakyThrows
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }
}
