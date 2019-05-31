package com.mowen.nettylearn.stickSplitPackage.delimiter;

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
public class DelimiterTestServer extends NettyServer {

    public DelimiterTestServer() {
        //定义%%为分隔符
        super(new BaseChildHandler(CodecFactory.createDelimiterDecoder("%%"),CodecFactory.createStringDecoder(), new MessageHandler()));
    }
    public static void main(String[] args) {
        new DelimiterTestServer().connect();
    }
}
