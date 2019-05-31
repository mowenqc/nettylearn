package com.mowen.nettylearn.stickSplitPackage.hessian2;

import com.mowen.nettylearn.NettyServer;
import com.mowen.nettylearn.common.CodecFactory;
import com.mowen.nettylearn.handler.MessageHandler;
import com.mowen.nettylearn.handler.child.BaseChildHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.hessian2
 * author: mowen
 * create_time: 2019/5/31 9:15
 * project_name : mowen_parent
 */
public class Hessian2TestServer extends NettyServer {

    public Hessian2TestServer() {
        super(new BaseChildHandler(CodecFactory.createHessian2Decoder(),null, new MessageHandler()));
    }

    public static void main(String[] args) {
        new Hessian2TestServer().connect();
    }
}
