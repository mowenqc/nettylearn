package com.mowen.nettyapplication.rpc.data;

import java.io.Serializable;

/***
 * desc  : com.mowen.nettyapplication.rpc.data
 * author: mowen
 * create_time: 2019/6/2 15:24
 * project_name : mowen_parent
 */
public class RpcRequest implements Serializable {

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 主机名
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?> parameterTypes;

    /**
     * 参数值
     */
    private Object[] paraeters;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?> getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?> parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParaeters() {
        return paraeters;
    }

    public void setParaeters(Object[] paraeters) {
        this.paraeters = paraeters;
    }
}
