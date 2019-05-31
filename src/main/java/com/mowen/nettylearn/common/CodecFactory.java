package com.mowen.nettylearn.common;

import com.mowen.nettylearn.codec.hessian2.Hessian2Decoder;
import com.mowen.nettylearn.codec.hessian2.Hessian2Encoder;
import com.mowen.nettylearn.codec.kryo.KryoDecoder;
import com.mowen.nettylearn.codec.kryo.KryoEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.nio.charset.Charset;

/***
 * desc  : com.mowen.nettylearn.common
 * author: mowen
 * create_time: 2019/5/30 8:43
 * project_name : mowen_parent
 */
public class CodecFactory {

    public static LineBasedFrameDecoder createLineBasedFrameDecoder() {
        return new LineBasedFrameDecoder(1024);
    }

    /**
     * 构建行字符串解码器
     * @param length
     * @return
     */
    public static LineBasedFrameDecoder createLineBasedFrameDecoder(int length) {
        return new LineBasedFrameDecoder(length);
    }

    /**
     * 构建字符串解码器
     * @return
     */
    public static StringDecoder createStringDecoder(){
        return new StringDecoder(Charset.forName("utf-8"));
    }

    /**
     * 构建字符串编码器
     * @return
     */
    public static StringEncoder createStringEncoder(){
        return new StringEncoder(Charset.forName("utf-8"));
    }

    public static DelimiterBasedFrameDecoder createDelimiterDecoder(String split){
        ByteBuf byteBuf = Unpooled.copiedBuffer(split.getBytes());
        return new DelimiterBasedFrameDecoder(1024, byteBuf);
    }

    public static FixedLengthFrameDecoder createFixLengthFrameDecode(int length){
        return new FixedLengthFrameDecoder(length);
    }

    public static Hessian2Decoder createHessian2Decoder(){
        return new Hessian2Decoder();
    }

    public static Hessian2Encoder createHessian2Encoder(){
        return new Hessian2Encoder();
    }

    public static KryoDecoder createKryoDecoder(){
        return new KryoDecoder();
    }
    public static KryoEncoder createKryoEncoder(){
        return new KryoEncoder();
    }

    public static ChannelHandler createHandler(ChannelHandler channelHandler){
        if(channelHandler instanceof Hessian2Decoder){
            return createHessian2Decoder();
        }
        else if(channelHandler instanceof Hessian2Encoder){
            return createHessian2Encoder();
        }
        else if(channelHandler instanceof KryoDecoder){
            return createKryoDecoder();
        }
        else if(channelHandler instanceof KryoEncoder){
            return createKryoEncoder();
        }
        return null;
    }
}
