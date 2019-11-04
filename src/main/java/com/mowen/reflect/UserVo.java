package com.mowen.reflect;

import com.mowen.annotation.FieldAnnotation;
import com.mowen.annotation.Niubility;

import java.io.Serializable;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/29 10:49
 * @since:
 */
@Niubility
public final class UserVo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Niubility
    private String name;

    @FieldAnnotation
    private String valueOfAssessment;

    private static final String origin = "中国";

    private UserVo(String name, String value){
        this.name = name;
        this.valueOfAssessment = value;
    }
    public UserVo(){

    }
    @Niubility
    public UserVo(String name){
        this.name = name;
    }

    @Niubility
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueOfAssessment() {
        return valueOfAssessment;
    }

    public void setValueOfAssessment(String valueOfAssessment) {
        this.valueOfAssessment = valueOfAssessment;
    }
}
