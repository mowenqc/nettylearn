package com.mowen.nettylearn.stickSplitPackage.hessian2;

import com.mowen.nettylearn.NettyClient;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.child.BaseChildHandler;
import com.mowen.nettylearn.stickSplitPackage.hessian2.handler.Hassian2ClientMessageHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.hessian2
 * author: mowen
 * create_time: 2019/5/31 9:21
 * project_name : mowen_parent
 */
public class Hessian2TestClient extends NettyClient {

    public Hessian2TestClient() {
        super(new BaseChildHandler(null, CodecFactory.createStringDecoder(), new Hassian2ClientMessageHandler()));
    }

    public static void main(String[] args) {
        new Hessian2TestClient().connect();
    }
}
