package com.rain.rpc;

import com.rain.study.common.test.rpc.api.HelloService;
import com.rain.study.common.test.rpc.client.RPCClient;
import com.rain.study.common.test.rpc.server.HelloServiceImpl;
import com.rain.study.common.test.rpc.server.Server;
import com.rain.study.common.test.rpc.server.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by chenyu on 2016/12/14.
 */
public class RPCTest {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = ServiceCenter.getInstance();
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
