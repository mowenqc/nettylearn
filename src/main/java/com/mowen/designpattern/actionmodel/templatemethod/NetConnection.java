package com.mowen.designpattern.actionmodel.templatemethod;

import java.net.URL;
import java.util.Map;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 11:33
 * @since: v1.0
 */
public abstract class NetConnection {

    public String connect(String url, Map<String, Object> params){
        //1. push params
        URL netUrl = null; //handlerParms(url, params);
        //2. 发起网络请求
        String result = request(netUrl);

        //3.handler result
        return result;
    }

    protected abstract String request(URL url);
}
