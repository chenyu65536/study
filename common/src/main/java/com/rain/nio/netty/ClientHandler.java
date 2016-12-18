package com.rain.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by chenyu on 2016/12/16.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {


    /**
     *  tcp 三次握手成功后建立连接，发送资源，客户端先发送
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Person person =  new Person();
        person.setAge(18);
        person.setName("客户端");
        ctx.writeAndFlush(person);
    }

    /**
     * 接收成功后
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("客户端："+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.disconnect();
        ctx.close();
    }
}
