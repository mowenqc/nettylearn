package com.mowen.nettylearn.stickSplitPackage.kryo.handler;

import com.mowen.nettylearn.codec.hessian2.Hessian2Encoder;
import com.mowen.nettylearn.codec.kryo.KryoEncoder;
import com.mowen.nettylearn.domain.ReMessage;
import com.mowen.nettylearn.handler.MessageHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.kryo.handler
 * author: mowen
 * create_time: 2019/5/31 14:31
 * project_name : mowen_parent
 */
public class KryoClientMessageHandler extends MessageHandler {
    private Logger logger = Logger.getLogger(getClass());
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ReMessage reMessage = new ReMessage("kryo", "测试一个发送数据kryo");
        ByteBuf buffer = Unpooled.buffer();
        byte[] bytes = KryoEncoder.encodeObject(reMessage);
        logger.info("发送的字节长度为：" + bytes.length);
        buffer.writeInt(bytes.length);
        buffer.writeBytes(bytes);
        ctx.writeAndFlush(buffer);
    }
}
