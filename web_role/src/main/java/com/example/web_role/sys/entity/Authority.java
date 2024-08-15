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
@TableName("authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "authority_number", type = IdType.AUTO)
    private Integer authorityNumber;

    private Integer functionNumber;

    private String functionName;

    private String authorityName;

    private String authorityAddress;

    private String authorityExplaination;

    public Integer getAuthorityNumber() {
        return authorityNumber;
    }

    public void setAuthorityNumber(Integer authorityNumber) {
        this.authorityNumber = authorityNumber;
    }

    public Integer getFunctionNumber() {
        return functionNumber;
    }

    public void setFunctionNumber(Integer functionNumber) {
        this.functionNumber = functionNumber;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityAddress() {
        return authorityAddress;
    }

    public void setAuthorityAddress(String authorityAddress) {
        this.authorityAddress = authorityAddress;
    }

    public String getAuthorityExplaination() {
        return authorityExplaination;
    }

    public void setAuthorityExplaination(String authorityExplaination) {
        this.authorityExplaination = authorityExplaination;
    }

    @Override
    public String toString() {
        return "Authority{" +
            "authorityNumber = " + authorityNumber +
            ", functionNumber = " + functionNumber +
            ", functionName = " + functionName +
            ", authorityName = " + authorityName +
            ", authorityAddress = " + authorityAddress +
            ", authorityExplaination = " + authorityExplaination +
        "}";
    }
}
