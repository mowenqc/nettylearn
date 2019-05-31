package com.mowen.nettylearn.stickSplitPackage.hessian2.handler;

import com.mowen.nettylearn.codec.hessian2.Hessian2Encoder;
import com.mowen.nettylearn.domain.ReMessage;
import com.mowen.nettylearn.handler.MessageHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.hessian2.handler
 * author: mowen
 * create_time: 2019/5/31 9:23
 * project_name : mowen_parent
 */
public class Hassian2ClientMessageHandler extends MessageHandler {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ReMessage reMessage = new ReMessage("test", "测试一个发送数据");
        ByteBuf buffer = Unpooled.buffer();
        byte[] bytes = Hessian2Encoder.encodeObject(reMessage);
        logger.info("发送的字节长度为：" + bytes.length);
        int length = bytes.length;
        buffer.writeInt(length);
        buffer.writeBytes(bytes);
        ctx.writeAndFlush(buffer);
    }
}
