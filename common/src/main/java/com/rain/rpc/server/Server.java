package com.rain.rpc.server;

import java.io.IOException;

/**
 * Created by chenyu on 2016/12/14.
 */
public interface Server {
    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
