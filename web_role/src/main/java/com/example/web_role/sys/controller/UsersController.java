package com.example.web_role.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.common.vo.Result;
import com.example.web_role.sys.entity.Belong1;
import com.example.web_role.sys.entity.Have1;
import com.example.web_role.sys.entity.Role;
import com.example.web_role.sys.entity.Users;
import com.example.web_role.sys.service.IBelong1Service;
import com.example.web_role.sys.service.IHave1Service;
import com.example.web_role.sys.service.IRoleService;
import com.example.web_role.sys.service.IUsersService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@CrossOrigin
@RequestMapping("/sys/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IBelong1Service belong1Service;
    @Autowired
    private IHave1Service have1Service;
    @Autowired
    private IRoleService roleService;

    //先验证
    @GetMapping("/userSee")
    public Result<?> checkSee(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("user:see")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("/userAdd")
    public Result<?> checkAdd(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        System.out.println("拥有的权限："+Ahto);
        if(Ahto.contains("user:add")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }

    @GetMapping("userEdit")
    public Result<?> checkEdit(@RequestParam String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("user:edit")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("userDelete")
    public Result<?> checkDelete(@RequestParam String token){
        System.out.println("userDelete："+token);
        Map<String, Object> data=usersService.getUserInfo(token);
        List<String>Ahto= (List<String>) data.get("userAutho");
        if(Ahto.contains("user:delete")){
            return Result.success(20000);
        }
        return Result.fail(20001);
    }
    @GetMapping("/all")
    public Result<List<Users>> getAllUsers() {
        List<Users> list = usersService.list();
        return Result.success(list,"查询成功");
    }

    @GetMapping("/allSearch")
    public Result<List<Users>> getAllSearchUsers(@RequestParam String userName) {
        System.out.println(userName);
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", userName);
        List<Users> list=usersService.list(queryWrapper);
        System.out.println("this is allSearch:");
        System.out.println(list);
        return Result.success(list,"查询成功");
    }


    @PostMapping("/addUsers")
    @ResponseBody
    public void addUsers(@RequestBody Map<String, Object> request) {
        System.out.println(request);
        String userName = (String) request.get("userName");
        String userId = (String) request.get("userId");
        String companyNumberStr = (String) request.get("companyNumber");
        Integer companyNumber = Integer.parseInt(companyNumberStr);
        String departmentNumberStr = (String) request.get("departmentNumber");
        Integer departmentNumber = Integer.parseInt(departmentNumberStr);
        Users users=new Users();
        users.setUserPassword("123456");
        users.setUserName(userName);
        users.setUserId(userId);
        users.setCompanyNumber(companyNumber);
        users.setDepartmentNumber(departmentNumber);
        usersService.save(users);

        Integer userNumber=users.getUserNumber();
        List<String> userRole = (List<String>) request.get("userRole");
        for(int i=0;i<userRole.size();i++)
        {

            QueryWrapper<Role> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("role_name", userRole.get(i));
            Role role=roleService.getOne(queryWrapper2);
            Integer roleNumber=role.getRoleNumber();//得到要添加的role的信息
            Belong1 belong1=new Belong1();
            belong1.setRoleName(userRole.get(i));
            belong1.setUserName(userName);
            belong1.setUserNumber(userNumber);
            belong1.setRoleNumber(roleNumber);
            belong1Service.save(belong1);

        }

    }
    @PostMapping("/deleteUsers")
    @ResponseBody
    public Result<?> deleteUsers(@RequestBody Users users) {
        System.out.println(users.getUserNumber());
        try {
            usersService.removeById(users.getUserNumber());
            return Result.success(20000,"操作成功");
        }
        catch(DataAccessException e)
        {
            return Result.fail(20002,"无法删除");
        }
    }
    @PostMapping("/editUsers")
    @ResponseBody
    public void editUsers(@RequestBody Users users) {
        //Users users_origin=usersService.getOne(new QueryWrapper<Users>().eq("userNumber", users.getUserNumber()));
        Users users_origin=usersService.getById(users.getUserNumber());
        users_origin.setUserId(users.getUserId());
        users_origin.setUserName(users.getUserName());
        users_origin.setCompanyNumber(users.getCompanyNumber());
        users_origin.setDepartmentNumber(users.getDepartmentNumber());
        usersService.updateById(users_origin);
    }
    @GetMapping("/searchUsers")
    public void searchUsers(@RequestParam String userName) {
//        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_name", userName);
//        List<Users> list=usersService.list(queryWrapper);
//        System.out.println(list);
//        System.out.println(userName);
        Result<List<Users>> list=getAllSearchUsers(userName);
//        return Result.success(list,"查询成功");
    }
    @GetMapping("/login")
    public Result<?> login(@RequestParam String userName, @RequestParam String userPassword)
    {
        System.out.println(userName);
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        queryWrapper.eq("user_password", userPassword);
        Users user=usersService.getOne(queryWrapper);
        if(user!=null)
        {
            Map<String,Object> data=usersService.login(user);
            System.out.println(userPassword);
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }
    @PostMapping("/searchBySelect")
    public Result<?> searchBySelect(@RequestBody Map<String, Object> request) {
        String title = (String) request.get("title");
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("department_name", title);
        List<Users> list_=usersService.list(queryWrapper);
        if(list_.isEmpty())//返回的不是部门名称
        {
            QueryWrapper<Users> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("company_name", title);
            list_=usersService.list(queryWrapper2);
        }
        return Result.success(list_);
    }

    @GetMapping("/info")
    public Result<?> getUserInfo(@RequestParam("token") String token){
        Map<String, Object> data=usersService.getUserInfo(token);
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail(20003,"登录无效，请重新登录。");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("Authorization") String token){
        System.out.println(token);
        usersService.logout(token);
        return Result.success();
    }

    public List<String> getUserAuthoName(Integer userNumber){
        List<Integer> role_number=getUserRoleNumber(userNumber);
        List<Have1> list_=new ArrayList<>();
        List<String>list_name=new ArrayList<>();
        List<Integer>list_number=new ArrayList<>();
        for(int i=0;i<role_number.size();i++)
        {
            Integer roleNumber=role_number.get(i);
            QueryWrapper<Have1> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_number", roleNumber);

            list_=have1Service.list(queryWrapper);

            for(int j=0;j<list_.size();j++)
            {
                Have1 have1=list_.get(j);
                list_name.add(have1.getAuthorityName());
                list_number.add(have1.getAuthorityNumber());
            }

        }

        return list_name;
    }

    public List<Integer> getUserAuthoNumber(Integer userNumber){
        List<Integer> role_number=getUserRoleNumber(userNumber);
        List<Have1> list_=new ArrayList<>();
        List<String>list_name=new ArrayList<>();
        List<Integer>list_number=new ArrayList<>();
        for(int i=0;i<role_number.size();i++)
        {
            Integer roleNumber=role_number.get(i);
            QueryWrapper<Have1> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_number", roleNumber);

            list_=have1Service.list(queryWrapper);

            for(int j=0;j<list_.size();j++)
            {
                Have1 have1=list_.get(j);
                list_name.add(have1.getAuthorityName());
                list_number.add(have1.getAuthorityNumber());
            }

        }

        return list_number;
    }
    public List<Integer> getUserRoleNumber(Integer userNumber){
        QueryWrapper<Belong1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_number", userNumber);
        List<Belong1> list_=new ArrayList<>();
        list_=belong1Service.list(queryWrapper);
        List<String>list_name=new ArrayList<>();
        List<Integer>list_number=new ArrayList<>();
        for(int i=0;i<list_.size();i++)
        {
            Belong1 belong1=list_.get(i);
            list_name.add(belong1.getRoleName());
            list_number.add(belong1.getRoleNumber());
        }
        return list_number;
    }
    public List<String> getUserRoleName(Integer userNumber){
        QueryWrapper<Belong1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_number", userNumber);
        List<Belong1> list_=new ArrayList<>();
        list_=belong1Service.list(queryWrapper);
        List<String>list_name=new ArrayList<>();
        List<Integer>list_number=new ArrayList<>();
        for(int i=0;i<list_.size();i++)
        {
            Belong1 belong1=list_.get(i);
            list_name.add(belong1.getRoleName());
            list_number.add(belong1.getRoleNumber());
        }
        return list_name;
    }

}
