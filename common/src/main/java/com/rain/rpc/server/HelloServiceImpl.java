package com.rain.rpc.server;


import com.rain.rpc.api.HelloService;

/**
 * Created by chenyu on 2016/12/14.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "rpc callback, 你好" + name;
    }

}
