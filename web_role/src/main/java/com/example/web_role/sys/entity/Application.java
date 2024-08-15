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
@TableName("application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "application_number", type = IdType.AUTO)
    private Integer applicationNumber;

    private Integer applicationgroupNumber;

    private String applicationgroupName;

    private String applicationName;

    private String applicationAttribution;

    private String applicationState;

    private String authorityExplaination;

    public Integer getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Integer applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

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

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationAttribution() {
        return applicationAttribution;
    }

    public void setApplicationAttribution(String applicationAttribution) {
        this.applicationAttribution = applicationAttribution;
    }

    public String getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public String getAuthorityExplaination() {
        return authorityExplaination;
    }

    public void setAuthorityExplaination(String authorityExplaination) {
        this.authorityExplaination = authorityExplaination;
    }

    @Override
    public String toString() {
        return "Application{" +
            "applicationNumber = " + applicationNumber +
            ", applicationgroupNumber = " + applicationgroupNumber +
            ", applicationgroupName = " + applicationgroupName +
            ", applicationName = " + applicationName +
            ", applicationAttribution = " + applicationAttribution +
            ", applicationState = " + applicationState +
            ", authorityExplaination = " + authorityExplaination +
        "}";
    }
}
