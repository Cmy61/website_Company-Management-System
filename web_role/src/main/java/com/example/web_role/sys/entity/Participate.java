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
@TableName("participate")
public class Participate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userNumber;

    private Integer projectNumber;

    private String userName;

    private String projectName;

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Participate{" +
            "userNumber = " + userNumber +
            ", projectNumber = " + projectNumber +
            ", userName = " + userName +
            ", projectName = " + projectName +
        "}";
    }
}
