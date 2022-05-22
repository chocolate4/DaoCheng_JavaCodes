package com.daocheng.week03.work01And02.netty02;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 使用 Netty 实现后端 HTTP 访问
 */
public class NettyHttpServer02 {
    public static void main(String[] args) {
        int port = 8808; //绑定端口号

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(2); //mainReactor  (socket连接及状态维护)
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(16); //subReactor  (事件分发处理，去内核读数据)

        try{
            ServerBootstrap b = new ServerBootstrap(); //启动线程 开启socket
            b.option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.TCP_NODELAY,true)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childOption(ChannelOption.SO_REUSEADDR,true)
                    .childOption(ChannelOption.SO_RCVBUF,32*1024)
                    .childOption(ChannelOption.SO_SNDBUF,32*1024)
                    .childOption(EpollChannelOption.SO_REUSEPORT,true)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new HttpInitializer02()); //自定义handler
            Channel ch = b.bind(port).sync().channel(); //绑定端口，开启channel
            System.out.println("开启netty http服务器，监听地址和端口为 http://localhost:" + port + '/');
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
