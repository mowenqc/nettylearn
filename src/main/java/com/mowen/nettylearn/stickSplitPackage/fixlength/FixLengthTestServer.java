package com.mowen.nettylearn.stickSplitPackage.fixlength;

import com.mowen.nettylearn.NettyServer;
import com.mowen.nettylearn.common.CodecFactory;
import com.mowen.nettylearn.handler.MessageHandler;
import com.mowen.nettylearn.handler.child.BaseChildHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.delimiter
 * author: mowen
 * create_time: 2019/5/30 11:45
 * project_name : mowen_parent
 */
public class FixLengthTestServer extends NettyServer {

    public FixLengthTestServer() {
        super(new BaseChildHandler(CodecFactory.createFixLengthFrameDecode(12),CodecFactory.createStringDecoder(), new MessageHandler()));
    }

    public static void main(String[] args) {
        //fixlength在中文状态下尽量少用，不好控制长度，特别是中引文混合，很可能读出的数据就是乱码的
        new FixLengthTestServer().connect();
    }
}
