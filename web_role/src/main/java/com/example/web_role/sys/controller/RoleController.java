package com.example.web_role.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.common.vo.Result;
import com.example.web_role.common.vo.Temp_role;
import com.example.web_role.sys.entity.*;
import com.example.web_role.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@RestController
@RequestMapping("/sys/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IAuthorityService authorityService;
    @Autowired
    private IHave1Service have1Service;
    @Autowired
    private IBelong1Service belong1Service;
    @GetMapping("/allRoleName")
    public Result<List<String>> getAllRoleName() {
        List<Role> list = roleService.list();
        List<String> RoleName=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            RoleName.add(list.get(i).getRoleName());
        }
        return Result.success(RoleName,"查询成功");
    }

    @PostMapping("/editRole")
    public Result<?> editRole(@RequestBody Map<String, Object> request){
        Integer userNumber = (Integer) request.get("userNumber");
        List<String> userRole = (List<String>) request.get("userRole");
        System.out.println(userNumber);
        System.out.println(request);
        QueryWrapper<Belong1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_number", userNumber);
        List<Belong1> list_=belong1Service.list(queryWrapper);//1对应的belong1
        System.out.println(list_);
        List<String> list_role=new ArrayList<>();
        belong1Service.remove(queryWrapper);//先清空
        for(int i=0;i<list_.size();i++)
        {
            list_role.add(list_.get(i).getRoleName());
        }
        for(int i=0;i<userRole.size();i++)
        {

            QueryWrapper<Role> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("role_name", userRole.get(i));
            Role role=roleService.getOne(queryWrapper2);
            Integer roleNumber=role.getRoleNumber();//得到要添加的role的信息
            Users users=usersService.getById(userNumber);
            String userName=users.getUserName();//得到要添加的user的信息
            Belong1 belong1=new Belong1();
            belong1.setRoleName(userRole.get(i));
            belong1.setUserName(userName);
            belong1.setUserNumber(userNumber);
            belong1.setRoleNumber(roleNumber);
            belong1Service.save(belong1);

        }
        return Result.success(20000);
    }

    @PostMapping("editRoleSelf")
    public void editRoleSelf(@RequestBody Map<String, Object> request){
        Integer roleNumber = (Integer) request.get("roleNumber");
        String roleName=(String) request.get("roleName");
        System.out.println(roleName);
        Role role=roleService.getById(roleNumber);
        role.setRoleName(roleName);
        System.out.println(role.getRoleName());
        roleService.updateById(role);
    }
    @PostMapping("/deleteRole")
    public Result<?> deleteUsers(@RequestBody Map<String, Object> request) {
        String roleName=(String) request.get("roleName");
        Integer roleNumber=(Integer) request.get("roleNumber");
        System.out.println("delete:"+roleNumber);
        try {
            roleService.removeById(roleNumber);
            return Result.success(20000,"操作成功");
        }
        catch(DataAccessException e)
        {
            return Result.fail(20002,"无法删除");
        }
    }
    @PostMapping("/addRole")
    public void addUsers(@RequestBody Map<String, Object> request) {
        String roleName = (String) request.get("roleName");
        List<String> roleAutho = (List<String>) request.get("roleAutho");
        //先添加role
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRoleKind("null");
        roleService.save(role);
        Integer roleNumber=role.getRoleNumber();
        //添加have1部分

        for(int i=0;i<roleAutho.size();i++)
        {
            Have1 have1=new Have1();
            have1.setRoleNumber(roleNumber);
            have1.setRoleName(roleName);
            have1.setAuthorityName(roleAutho.get(i));
            //根据roleAuhtoname得到number
            QueryWrapper<Authority> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("authority_name", roleAutho.get(i));
            Authority authority=authorityService.getOne(queryWrapper);
            have1.setAuthorityNumber(authority.getAuthorityNumber());
        }
    }
    @GetMapping("/allRole")
    public Result<List<Temp_role>> getAllRole() {
        List<Temp_role> temp_roles=new ArrayList<>();
        List<Role> list = roleService.list();
        List<String> RoleName=new ArrayList<>();
        List<String> AuthName=new ArrayList<>();
        List<Have1> list_=new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            List<String>list_name=new ArrayList<>();
            List<Integer>list_number=new ArrayList<>();
            Temp_role temp_role=new Temp_role();
            Integer roleNumber=list.get(i).getRoleNumber();
            temp_role.setRoleNumber(roleNumber);
            temp_role.setRoleName((list.get(i).getRoleName()));
            QueryWrapper<Have1> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_number", roleNumber);
            list_=have1Service.list(queryWrapper);//1对应的have1
            for(int j=0;j<list_.size();j++)
            {
                Have1 have1=list_.get(j);
                list_name.add(have1.getAuthorityName());
                list_number.add(have1.getAuthorityNumber());
            }
            temp_role.setRoleAutho(list_name);
            temp_roles.add(temp_role);
        }
        return Result.success(temp_roles,"查询成功");
    }
    @GetMapping("allSearch")
    public Result<?> searchRole(@RequestParam String roleName){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("role_name", roleName);
        List<Role> list=roleService.list(queryWrapper);
        return Result.success(list,"查询成功");
    }
    @GetMapping("roleDelete")
    public Result<?> checkDelete(@RequestParam String token){
        System.out.println("roleDelete："+token);
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("role:delete")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("roleAdd")
    public Result<?> checkAdd(@RequestParam String token){
        System.out.println("roleDelete："+token);
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("role:add")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("roleUpdate")
    public Result<?> checkUpdate(@RequestParam String token){
        System.out.println("roleUpdate："+token);
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("role:edit")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("roleSee")
    public Result<?> checkSee(@RequestParam String token){
        System.out.println("roleSee："+token);
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("role:see")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }

}
