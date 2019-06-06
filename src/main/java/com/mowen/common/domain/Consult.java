package com.mowen.common.domain;

import java.io.Serializable;

/***
 * desc  : com.mowen.common.domain
 * author: mowen
 * create_time: 2019/6/6 8:27
 * project_name : mowen_parent
 */
public class Consult implements Serializable {


    /**
     * 客服id
     */
    private int consultId;

    /**
     * 客服姓名
     */
    private String consultName;


    /**
     * 客服编号
     */
    private String consultNo;

    public int getConsultId() {
        return consultId;
    }

    public void setConsultId(int consultId) {
        this.consultId = consultId;
    }

    public String getConsultName() {
        return consultName;
    }

    public void setConsultName(String consultName) {
        this.consultName = consultName;
    }

    public String getConsultNo() {
        return consultNo;
    }

    public void setConsultNo(String consultNo) {
        this.consultNo = consultNo;
    }

    @Override
    public String toString() {
        return "Consult{" +
            "consultId=" + consultId +
            ", consultName='" + consultName + '\'' +
            ", consultNo='" + consultNo + '\'' +
            '}';
    }
}
