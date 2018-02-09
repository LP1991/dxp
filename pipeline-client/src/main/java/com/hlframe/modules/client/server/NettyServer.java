/********************** 版权声明 *************************
 * 文件名: NettyServer.java
 * 包名: com.hlframe.modules.client.server
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/2/8
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.server;

import com.hlframe.modules.client.handlers.TestServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class NettyServer {
    public void bind(int port) throws Exception {
        //NioEventLoopGroup是用来处理IO操作的多线程事件循环器
        //boss作为一个acceptor负责接收来自客户端的请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //worker用来处理已经被接收的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //启动NIO服务的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            //初始化NioServerSocketChannel
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel ch) throws Exception {
                    System.out.println("有客户端连接上来:"+ch.localAddress().toString());
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null))); // 最大长度
                    ch.pipeline().addLast(new TestServerHandler());
                }
            });
            //绑定端口,开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();
            System.out.println("file server 等待连接：");
            //等待服务器socket关闭
            f.channel().closeFuture().sync();
            System.out.println("file end");
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        try {
            server.bind(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
