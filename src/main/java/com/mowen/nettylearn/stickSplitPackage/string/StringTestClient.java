package com.mowen.nettylearn.stickSplitPackage.string;

import com.mowen.nettylearn.NettyClient;
import com.mowen.nettylearn.common.CodecFactory;
import com.mowen.nettylearn.handler.child.BaseChildHandler;
import com.mowen.nettylearn.stickSplitPackage.linebase.client.LineBaseClientMessageHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.linebase
 * author: mowen
 * create_time: 2019/5/30 9:36
 * project_name : mowen_parent
 */
public class StringTestClient extends NettyClient {

    public StringTestClient(){
        super(new BaseChildHandler(CodecFactory.createStringDecoder(),CodecFactory.createStringEncoder(), new LineBaseClientMessageHandler()));
    }

    public static void main(String[] args) {
        new StringTestClient().connect();
    }

}
