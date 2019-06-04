package com.mowen.nettylearn.stickSplitPackage.linebase;

import com.mowen.nettylearn.NettyClient;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.child.BaseChildHandler;
import com.mowen.nettylearn.stickSplitPackage.linebase.client.LineBaseClientMessageHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.linebase
 * author: mowen
 * create_time: 2019/5/30 9:36
 * project_name : mowen_parent
 */
public class LineBaseTestClient extends NettyClient {

    public LineBaseTestClient(){
        super(new BaseChildHandler(CodecFactory.createLineBasedFrameDecoder(),CodecFactory.createStringDecoder(), new LineBaseClientMessageHandler()));
    }

    public static void main(String[] args) {
        new LineBaseTestClient().connect();
    }

}
