package com.mowen.designpattern.actionmodel.templatemethod;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 11:40
 * @since: v1.0
 */
public class UrlConnection extends NetConnection {

    @Override
    protected String request(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = new byte[100];
            int lenth = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ( (lenth = inputStream.read(bytes)) > 0){
                byteArrayOutputStream.write(bytes, 0, lenth);
            }
            String result = new String(byteArrayOutputStream.toByteArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
