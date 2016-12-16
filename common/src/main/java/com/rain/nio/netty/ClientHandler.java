package com.rain.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * Created by chenyu on 2016/12/16.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final ByteBuf buff = ctx.alloc().buffer(12); // (2)
        buff.writeBytes("你好，服务器，我是客户端啊".getBytes(Charset.forName("UTF-8")));
        ctx.writeAndFlush(buff);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(buf.toString(Charset.forName("UTF-8")));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.disconnect();
        ctx.close();
    }
}
