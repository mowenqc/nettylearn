package com.mowen.nettylearn.stickSplitPackage.delimiter.handler;

import com.mowen.nettylearn.handler.MessageHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.delimiter.handler
 * author: mowen
 * create_time: 2019/5/30 13:37
 * project_name : mowen_parent
 */
public class DelimiterClientHandler extends MessageHandler {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        String text = "这两天气温不知怎么了，变得清凉起来%%清晨起床，我没有在朦胧意识中摇摇晃晃去洗澡洗头，晚上也不需要开着老旧的空调，听着它呜咽般呻吟着工作，相对于前几天炎热烦躁，我睡得很好，精神好了许多%%都说睡觉是对身体最好的爱护，那么，这两天是真切的爱了自己，以至于，早上出门上班时，我感觉自己浑身都是力量%%";
        ctx.writeAndFlush(Unpooled.copiedBuffer(text.getBytes()));
    }
}
