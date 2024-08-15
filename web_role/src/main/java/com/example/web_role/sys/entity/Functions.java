package com.example.web_role.sys.entity;

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
@TableName("functions")
public class Functions implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer functionNumber;

    private Integer functiongroupNumber;

    private String functiongroupName;

    private String functionName;

    private String functioinAttribution;

    public Integer getFunctionNumber() {
        return functionNumber;
    }

    public void setFunctionNumber(Integer functionNumber) {
        this.functionNumber = functionNumber;
    }

    public Integer getFunctiongroupNumber() {
        return functiongroupNumber;
    }

    public void setFunctiongroupNumber(Integer functiongroupNumber) {
        this.functiongroupNumber = functiongroupNumber;
    }

    public String getFunctiongroupName() {
        return functiongroupName;
    }

    public void setFunctiongroupName(String functiongroupName) {
        this.functiongroupName = functiongroupName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctioinAttribution() {
        return functioinAttribution;
    }

    public void setFunctioinAttribution(String functioinAttribution) {
        this.functioinAttribution = functioinAttribution;
    }

    @Override
    public String toString() {
        return "Functions{" +
            "functionNumber = " + functionNumber +
            ", functiongroupNumber = " + functiongroupNumber +
            ", functiongroupName = " + functiongroupName +
            ", functionName = " + functionName +
            ", functioinAttribution = " + functioinAttribution +
        "}";
    }
}
