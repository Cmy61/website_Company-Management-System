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
@TableName("applicationgroup")
public class Applicationgroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "applicationGroup_number", type = IdType.AUTO)
    private Integer applicationgroupNumber;

    private String applicationgroupName;

    public Integer getApplicationgroupNumber() {
        return applicationgroupNumber;
    }

    public void setApplicationgroupNumber(Integer applicationgroupNumber) {
        this.applicationgroupNumber = applicationgroupNumber;
    }

    public String getApplicationgroupName() {
        return applicationgroupName;
    }

    public void setApplicationgroupName(String applicationgroupName) {
        this.applicationgroupName = applicationgroupName;
    }

    @Override
    public String toString() {
        return "Applicationgroup{" +
            "applicationgroupNumber = " + applicationgroupNumber +
            ", applicationgroupName = " + applicationgroupName +
        "}";
    }
}
