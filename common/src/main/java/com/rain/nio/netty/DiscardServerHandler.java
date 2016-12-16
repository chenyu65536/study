package com.rain.nio.netty;


import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.Charset;

/**
 * Created by rain on 2016/12/15.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

        //接收
        ByteBuf in = (ByteBuf) msg;

        System.out.println("000:" + in.toString(io.netty.util.CharsetUtil.UTF_8));
        //发送
        ctx.writeAndFlush("这是服务端".getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        final ByteBuf buff = ctx.alloc().buffer(12); // (2)
        buff.writeBytes("你好，客户端，我是服务器啊".getBytes(Charset.forName("UTF-8")));

        ctx.writeAndFlush(buff);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelReadComplete();
        ctx.disconnect();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.disconnect();
        ctx.close();
    }
}
