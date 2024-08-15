package com.example.web_role.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@TableName("project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_number", type = IdType.AUTO)
    private Integer projectNumber;

    private Integer companyNumber;

    private String companyName;

    private String projectName;

    private LocalTime projectStart;

    private LocalTime projectEnd;

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalTime getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(LocalTime projectStart) {
        this.projectStart = projectStart;
    }

    public LocalTime getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(LocalTime projectEnd) {
        this.projectEnd = projectEnd;
    }

    @Override
    public String toString() {
        return "Project{" +
            "projectNumber = " + projectNumber +
            ", companyNumber = " + companyNumber +
            ", companyName = " + companyName +
            ", projectName = " + projectName +
            ", projectStart = " + projectStart +
            ", projectEnd = " + projectEnd +
        "}";
    }
}
