package com.mowen.reflect;

import java.util.Date;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/29 11:21
 * @since:
 */
public class BaseVo{

    private Date createTime;

    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
