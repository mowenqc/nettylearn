package com.mowen.nettylearn.handler.child;

import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.MessageHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * desc  : com.mowen.nettylearn.handler.child
 * author: mowen
 * create_time: 2019/5/30 8:34
 * project_name : mowen_parent
 * desc: 定义管道处理，是netty应用程序开发必须使用到的，这里只是做了简单的抽象，传入了三个参数
 * 编解码器与消息处理器，
 */
public class BaseChildHandler extends ChannelInitializer {
    private ChannelHandler encoder;
    private ChannelHandler decoder;
    private MessageHandler messageHandler;

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public BaseChildHandler(ChannelHandler encoder, ChannelHandler decoder, MessageHandler messageHandler){
        this.encoder = encoder;
        this.decoder = decoder;
        this.messageHandler = messageHandler;
    }

    @Override
    protected void initChannel(Channel ch) {
        /**
         * 将这三个事件处理器加入到管道中
         */
        ChannelPipeline pipeline = ch.pipeline();
        if(encoder != null){
            ChannelHandler handler = CodecFactory.createHandler(encoder);
            if(handler != null){
                pipeline.addLast("encode", handler);
            }
        }
        if(decoder != null){
            ChannelHandler handler = CodecFactory.createHandler(decoder);
            if( handler != null){
                pipeline.addLast("decoder", handler);
            }
        }
        if(messageHandler != null){
            pipeline.addLast("messageHandler", messageHandler);
        }
    }
}
