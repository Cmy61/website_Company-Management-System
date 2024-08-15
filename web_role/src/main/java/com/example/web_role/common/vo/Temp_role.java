package com.example.web_role.common.vo;

import java.util.List;

public class Temp_role {
    private Integer roleNumber;
    private String roleName;
    public void setRoleName(String roleName){
        this.roleName=roleName;
    }
    public void setRoleNumber(Integer roleNumber){
        this.roleNumber=roleNumber;
    }
    private List<String> roleAutho;
   public void setRoleAutho(List<String> roleAutho){
       this.roleAutho=roleAutho;
   }

   public String getRoleName(){
       return this.roleName;
   }
    public Integer getRoleNumber(){
        return this.roleNumber;
    }
    public List<?> getRoleAutho(){
        return this.roleAutho;
    }
}
