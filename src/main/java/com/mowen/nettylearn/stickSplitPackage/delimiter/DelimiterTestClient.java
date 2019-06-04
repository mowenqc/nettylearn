package com.mowen.nettylearn.stickSplitPackage.delimiter;

import com.mowen.nettylearn.NettyClient;
import com.mowen.nettylearn.factory.CodecFactory;
import com.mowen.nettylearn.handler.child.BaseChildHandler;
import com.mowen.nettylearn.stickSplitPackage.delimiter.handler.DelimiterClientHandler;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.delimiter
 * author: mowen
 * create_time: 2019/5/30 11:45
 * project_name : mowen_parent
 */
public class DelimiterTestClient extends NettyClient {

    public DelimiterTestClient() {
        super(new BaseChildHandler(CodecFactory.createDelimiterDecoder("%%"),CodecFactory.createStringDecoder(), new DelimiterClientHandler()));
    }


    public static void main(String[] args) {
        new DelimiterTestClient().connect();
    }
}
