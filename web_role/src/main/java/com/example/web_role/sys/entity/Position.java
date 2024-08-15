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
@TableName("position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "position_number", type = IdType.AUTO)
    private Integer positionNumber;

    private Integer posPositionNumber;

    private String posPositionName;

    private Integer departmentNumber;

    private String departmentName;

    private String positionName;

    private String positionState;

    private String positionPath;

    public Integer getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    public Integer getPosPositionNumber() {
        return posPositionNumber;
    }

    public void setPosPositionNumber(Integer posPositionNumber) {
        this.posPositionNumber = posPositionNumber;
    }

    public String getPosPositionName() {
        return posPositionName;
    }

    public void setPosPositionName(String posPositionName) {
        this.posPositionName = posPositionName;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionState() {
        return positionState;
    }

    public void setPositionState(String positionState) {
        this.positionState = positionState;
    }

    public String getPositionPath() {
        return positionPath;
    }

    public void setPositionPath(String positionPath) {
        this.positionPath = positionPath;
    }

    @Override
    public String toString() {
        return "Position{" +
            "positionNumber = " + positionNumber +
            ", posPositionNumber = " + posPositionNumber +
            ", posPositionName = " + posPositionName +
            ", departmentNumber = " + departmentNumber +
            ", departmentName = " + departmentName +
            ", positionName = " + positionName +
            ", positionState = " + positionState +
            ", positionPath = " + positionPath +
        "}";
    }
}
