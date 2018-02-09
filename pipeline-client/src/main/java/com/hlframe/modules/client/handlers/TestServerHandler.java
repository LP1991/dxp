/********************** 版权声明 *************************
 * 文件名: TestHandler.java
 * 包名: com.hlframe.modules.client.handlers
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/2/8
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.handlers;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class TestServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("exceptionCaught");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("channelActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("channelInactive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println("channelRead");
        System.out.println(("server receive:" + msg.toString()));
        if (msg.equals("client say: hello server")) {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap b = new Bootstrap();
                b.group(group).channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<Channel>() {
                            //增加多个的处理类到ChannelPipeline
                            @Override
                            protected void initChannel(Channel ch) throws Exception {
                                //序列化java对象
                                ch.pipeline().addLast(new ObjectEncoder());
                                //对象反序列化
                                ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(null)));
                                //添加处理适配器
                                ch.pipeline().addLast(new TestClientHandler());
                            }
                        });
                ChannelFuture f = b.connect("localhost", 8088).sync();
                f.channel().writeAndFlush("shide zhege jiushi woyao chuanshu de shuju ");
                f.channel().closeFuture().sync();
                System.out.println("FileUploadClient connect()结束");
            } finally {
                group.shutdownGracefully();
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        System.out.println("channelReadComplete");
    }
}
