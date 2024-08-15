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
@TableName("company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_number", type = IdType.AUTO)
    private Integer companyNumber;

    private String companyName;

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

    @Override
    public String toString() {
        return "Company{" +
            "companyNumber = " + companyNumber +
            ", companyName = " + companyName +
        "}";
    }
}
