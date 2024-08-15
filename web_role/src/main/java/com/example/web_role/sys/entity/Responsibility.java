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
@TableName("responsibility")
public class Responsibility implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userNumber;

    private Integer positionNumber;

    private String userName;

    private String positionName;

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Responsibility{" +
            "userNumber = " + userNumber +
            ", positionNumber = " + positionNumber +
            ", userName = " + userName +
            ", positionName = " + positionName +
        "}";
    }
}
