package com.mowen.nettylearn.stickSplitPackage.kryo;

import com.mowen.nettylearn.NettyServer;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.MessageHandler;
import com.mowen.nettylearn.handler.child.BaseChildHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.kryo
 * author: mowen
 * create_time: 2019/5/31 14:29
 * project_name : mowen_parent
 */
public class KryoTestServer extends NettyServer {

    public KryoTestServer() {
        super(new BaseChildHandler(CodecFactory.createKryoDecoder(),null, new MessageHandler()));
    }

    public static void main(String[] args) {
        new KryoTestServer().connect();
    }
}
