package com.example.web_role.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.common.vo.Result;
import com.example.web_role.common.vo.Temp_role;
import com.example.web_role.sys.entity.*;
import com.example.web_role.sys.service.IAuthorityService;
import com.example.web_role.sys.service.IHave1Service;
import com.example.web_role.sys.service.IRoleService;
import com.example.web_role.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/sys/authority")
@CrossOrigin
public class AuthorityController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IAuthorityService authorityService;
    @Autowired
    private IHave1Service have1Service;
    @Autowired
    private IRoleService roleService;
    @GetMapping("/allAutho")//这个是name
    public Result<?> getAllAutho() {
        List<Authority> list = authorityService.list();
        List<String> list_=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            list_.add(list.get(i).getAuthorityName());
        }
        return Result.success(list_,"查询成功");
    }

    @GetMapping("/all")
    public Result<List<Authority>> getAllUsers() {
        List<Authority> list = authorityService.list();
        return Result.success(list,"查询成功");
    }
    @PostMapping("/deleteUsers")
    public Result<?> deleteUsers(@RequestBody Map<String,Object> request) {
        Integer authorityNumber=(Integer) request.get("authorityNumber");
        try{
            usersService.removeById(authorityNumber);
            return Result.success(20000);
        }
        catch(DataAccessException e)
        {
            return Result.fail(20002,"无法删除");
        }
    }
    @PostMapping("/editRoleAuhto")
    public void editRoleAutho(@RequestBody Map<String, Object> request) {
        Integer roleNumber = (Integer) request.get("roleNumber");
        List<String> roleAutho = (List<String>) request.get("roleAutho");
        //先把have1上面有的autho都清除掉
        QueryWrapper<Have1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_number", roleNumber);
        have1Service.remove(queryWrapper);
        String roleName=roleService.getById(roleNumber).getRoleName();

        for(int i=0;i<roleAutho.size();i++)
        {
            QueryWrapper<Authority> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("authority_name", roleAutho.get(i));
            Integer authorityNumber=authorityService.getOne(queryWrapper2).getAuthorityNumber();

            Have1 have1=new Have1();
            have1.setAuthorityName(roleAutho.get(i));
            have1.setRoleName(roleName);
            have1.setRoleNumber(roleNumber);
            have1.setAuthorityNumber(authorityNumber);
            have1Service.save(have1);
        }
    }
    @GetMapping("allSearch")
    public Result<?> searchRole(@RequestParam String authorityName){
        QueryWrapper<Authority> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("authority_name", authorityName);
        List<Authority> list=authorityService.list(queryWrapper);

        return Result.success(list,"查询成功");
    }
    @GetMapping("authoDelete")
    public Result<?> checkDelete(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("autho:delete")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("authoAdd")
    public Result<?> checkAdd(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("autho:add")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("authoUpdate")
    public Result<?> checkUpdate(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("autho:edit")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("authoSee")
    public Result<?> checkSee(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("autho:see")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @PostMapping("/editAuthority")
    public void editAuthority(@RequestBody Map<String, Object> request) {
        String authorityName = (String) request.get("authorityName");
        String functionName = (String) request.get("functionName");
        String authorityExplaination = (String) request.get("authorityExplaination");
        Integer authorityNumber = (Integer) request.get("authorityNumber");
        //找authorityNumber改
        Authority authority=authorityService.getById(authorityNumber);
        authority.setAuthorityName(authorityName);
        authority.setAuthorityExplaination(authorityExplaination);
        authorityService.updateById(authority);
    }

}
