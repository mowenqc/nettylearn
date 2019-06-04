package com.mowen.nettylearn.stickSplitPackage.linebase;

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
public class LineBaseTestServer extends NettyServer {

    public LineBaseTestServer(){
        super(new BaseChildHandler(CodecFactory.createLineBasedFrameDecoder(),CodecFactory.createStringDecoder(), new MessageHandler()));
    }

    public static void main(String[] args) {
        new LineBaseTestServer().connect();
    }

}
