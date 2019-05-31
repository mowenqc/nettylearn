package com.mowen.nettylearn;

import com.mowen.nettylearn.handler.child.BaseChildHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage
 * author: mowen
 * create_time: 2019/5/30 9:36
 * project_name : mowen_parent
 */
public class NettyClient {

    private int port = 8890;//默认端口

    private String server = "127.0.0.1"; //默认host

    private BaseChildHandler baseChildHandler;

    public NettyClient(BaseChildHandler baseChildHandler){
        this.baseChildHandler = baseChildHandler;
    }
    public void connect(){
        connect(server, port);
    }
    public void connect(String server, int port){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).
                handler(baseChildHandler);
            ChannelFuture channelFuture = bootstrap.connect(server, port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        }
        finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
