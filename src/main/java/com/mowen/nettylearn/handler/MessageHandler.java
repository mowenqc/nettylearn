package com.mowen.nettylearn.handler;

import com.mowen.nettylearn.ContextManager;
import com.mowen.nettylearn.common.util.DateUtil;
import com.mowen.nettylearn.domain.ReMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import java.util.Date;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.nettylearn.handler
 * author: mowen
 * create_time: 2019/5/30 8:00
 * project_name : mowen_parent
 */
@Sharable
public class MessageHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = Logger.getLogger(getClass());
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asLongText();
        logger.info("激活连接：" + ctx.channel().id().asLongText());
        //将连接的上下文保存起来，以备后续使用这个连接
        ContextManager.addContext(channelId, ctx.channel());
        String date = DateUtil.dateToString(new Date(), DateUtil.DATETIME_FORMAT);
        ByteBuf byteBuf = Unpooled.copiedBuffer(date.getBytes());
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asLongText();
        logger.info("关闭连接处理：" + channelId);
        ContextManager.removeContext(channelId);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ByteBuf){
            ByteBuf byteBuf = (ByteBuf) msg;
            byte [] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            /**
             * 简单的打印出消息， 如果需要进一步处理，在此进行， msg就是从ctx的另一端发送过来的消息
             */
            logger.info("收到消息:" + new String(bytes));
        }else if(msg instanceof String){
            logger.info("收到消息String:" + msg);
        }
        else if(msg instanceof ReMessage){
            logger.info("reMessage = " + msg);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        String channelId = ctx.channel().id().asLongText();
        logger.info("数据读写完成：" + channelId);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        String socketString = ctx.channel().remoteAddress().toString();
        logger.info("userEventTriggered:" + socketString);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                logger.info("Client: " + socketString + " READER_IDLE 读超时");
                ctx.disconnect();
            } else if (event.state() == IdleState.WRITER_IDLE) {
                logger.info("Client: " + socketString + " WRITER_IDLE 写超时");
                ctx.disconnect();
            } else if (event.state() == IdleState.ALL_IDLE) {
                logger.info("Client: " + socketString + " ALL_IDLE 总超时");
                ctx.disconnect();
            }

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        String channelId = ctx.channel().id().asLongText();
        logger.error(channelId + "发生异常", cause);
    }
}
