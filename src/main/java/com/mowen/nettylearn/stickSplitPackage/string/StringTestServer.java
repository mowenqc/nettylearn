package com.mowen.nettylearn.stickSplitPackage.string;

import com.mowen.nettylearn.NettyServer;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.MessageHandler;
import com.mowen.nettylearn.handler.child.BaseChildHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage
 * author: mowen
 * create_time: 2019/5/30 9:28
 * project_name : mowen_parent
 */
public class StringTestServer extends NettyServer {

    public StringTestServer(){
        super(new BaseChildHandler(CodecFactory.createStringDecoder(),CodecFactory.createStringEncoder(), new MessageHandler()));
    }

    public static void main(String[] args) {
        new StringTestServer().connect();
    }

}
