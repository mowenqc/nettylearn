package com.mowen.nettylearn.stickSplitPackage.kryo;

import com.mowen.nettylearn.NettyClient;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.child.BaseChildHandler;
import com.mowen.nettylearn.stickSplitPackage.kryo.handler.KryoClientMessageHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.kryo
 * author: mowen
 * create_time: 2019/5/31 14:30
 * project_name : mowen_parent
 */
public class KryoTestClient extends NettyClient {

    public KryoTestClient() {
        super(new BaseChildHandler(null, CodecFactory.createStringDecoder(), new KryoClientMessageHandler()));
    }

    public static void main(String[] args) {
        new KryoTestClient().connect();
    }
}
