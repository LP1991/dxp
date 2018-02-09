/********************** 版权声明 *************************
 * 文件名: NettyClient.java
 * 包名: com.hlframe.modules.client.client
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/2/8
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.dxp.netty;

import com.hlframe.modules.dxp.handler.TestClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class NettyClient {
    public void connect(int port, String host) throws Exception {
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
            ChannelFuture f = b.connect(host, port).sync();

            f.channel().writeAndFlush("asdsadasd");
            f.channel().closeFuture().sync();
            System.out.println("FileUploadClient connect()结束");
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyClient client = new NettyClient();
        try {
            client.connect(8080,"localhost");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
