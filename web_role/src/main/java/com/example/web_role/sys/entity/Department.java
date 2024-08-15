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
@TableName("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "department_number", type = IdType.AUTO)
    private Integer departmentNumber;

    private Integer companyNumber;

    private String companyName;

    private String departmentName;

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
            "departmentNumber = " + departmentNumber +
            ", companyNumber = " + companyNumber +
            ", companyName = " + companyName +
            ", departmentName = " + departmentName +
        "}";
    }
}
