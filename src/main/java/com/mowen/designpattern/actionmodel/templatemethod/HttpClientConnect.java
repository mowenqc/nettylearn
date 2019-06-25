package com.mowen.designpattern.actionmodel.templatemethod;

import java.net.URL;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 13:56
 * @since: v1.0
 */
public class HttpClientConnect extends NetConnection {

    @Override
    protected String request(URL url) {
        //发起httpClient Request
        // 获取 response
        //转化成字符串
        return null;
    }
}
