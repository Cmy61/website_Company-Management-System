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
@TableName("belong_1")
public class Belong1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userNumber;

    private String userName;

    private Integer roleNumber;

    private String roleName;

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(Integer roleNumber) {
        this.roleNumber = roleNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Belong1{" +
            "userNumber = " + userNumber +
            ", userName = " + userName +
            ", roleNumber = " + roleNumber +
            ", roleName = " + roleName +
        "}";
    }
}
