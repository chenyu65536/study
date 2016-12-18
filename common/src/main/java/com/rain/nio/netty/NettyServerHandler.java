package com.rain.nio.netty;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by rain on 2016/12/15.
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Person person =  new Person();
        person.setAge(25);
        person.setName("服务器");
        ctx.writeAndFlush(person);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("服务器："+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.disconnect();
        ctx.close();
    }
}
