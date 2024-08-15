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
@TableName("have_1")
public class Have1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleNumber;

    private Integer authorityNumber;

    private String roleName;

    private String authorityName;

    public Integer getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(Integer roleNumber) {
        this.roleNumber = roleNumber;
    }

    public Integer getAuthorityNumber() {
        return authorityNumber;
    }

    public void setAuthorityNumber(Integer authorityNumber) {
        this.authorityNumber = authorityNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String toString() {
        return "Have1{" +
            "roleNumber = " + roleNumber +
            ", authorityNumber = " + authorityNumber +
            ", roleName = " + roleName +
            ", authorityName = " + authorityName +
        "}";
    }
}
