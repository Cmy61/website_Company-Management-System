package com.example.web_role.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@TableName("functiongroup")
public class Functiongroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "functionGroup_number", type = IdType.AUTO)
    private Integer functiongroupNumber;

    private Integer applicationNumber;

    private String applicationName;

    private String functiongroupName;

    public Integer getFunctiongroupNumber() {
        return functiongroupNumber;
    }

    public void setFunctiongroupNumber(Integer functiongroupNumber) {
        this.functiongroupNumber = functiongroupNumber;
    }

    public Integer getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Integer applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getFunctiongroupName() {
        return functiongroupName;
    }

    public void setFunctiongroupName(String functiongroupName) {
        this.functiongroupName = functiongroupName;
    }

    @Override
    public String toString() {
        return "Functiongroup{" +
            "functiongroupNumber = " + functiongroupNumber +
            ", applicationNumber = " + applicationNumber +
            ", applicationName = " + applicationName +
            ", functiongroupName = " + functiongroupName +
        "}";
    }
}
