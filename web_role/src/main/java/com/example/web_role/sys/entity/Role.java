package com.example.web_role.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@TableName("role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_number", type = IdType.AUTO)
    private Integer roleNumber;

    private String roleName;

    private String roleKind;


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

    public String getRoleKind() {
        return roleKind;
    }

    public void setRoleKind(String roleKind) {
        this.roleKind = roleKind;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleNumber = " + roleNumber +
            ", roleName = " + roleName +
            ", roleKind = " + roleKind +
        "}";
    }
}
