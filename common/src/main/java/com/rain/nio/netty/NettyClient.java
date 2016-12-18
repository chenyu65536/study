package com.rain.nio.netty;

import com.rain.nio.netty.msgpack.MsgpackDecoder;
import com.rain.nio.netty.msgpack.MsgpackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created by chenyu on 2016/12/16.
 */

public class NettyClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    //解决 半包黏包问题
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536, 0, 2, 0, 2))
                            .addLast(new LengthFieldPrepender(2))
                            .addLast(new MsgpackEncoder())
                            .addLast(new MsgpackDecoder())
                            .addLast(new NettyServerHandler());
                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
