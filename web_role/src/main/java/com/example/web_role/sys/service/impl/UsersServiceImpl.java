package com.example.web_role.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.sys.controller.UsersController;
import com.example.web_role.sys.entity.Belong1;
import com.example.web_role.sys.entity.Have1;
import com.example.web_role.sys.entity.Users;
import com.example.web_role.sys.mapper.UsersMapper;
import com.example.web_role.sys.service.IBelong1Service;
import com.example.web_role.sys.service.IHave1Service;
import com.example.web_role.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
@Autowired
private RedisTemplate redisTemplate;
    @Autowired
    private IBelong1Service belong1Service;
    @Autowired
    private IHave1Service have1Service;
    @Override
    public Map<String, Object> login(Users user) {
        LambdaQueryWrapper<Users> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUserName,user.getUserName());
        wrapper.eq(Users::getUserPassword,user.getUserPassword());
        Users loginUser=this.baseMapper.selectOne(wrapper);
        if(loginUser!=null)
        {
           String key="user:"+ UUID.randomUUID();
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
           Map<String,Object> data=new HashMap<>();
           data.put("token",key);
           return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj=redisTemplate.opsForValue().get(token);
        if(obj!=null){
            System.out.println("object is not empty");
            Users loginUser=JSON.parseObject(JSON.toJSONString(obj),Users.class);
            Map<String,Object>data=new HashMap<>();
            data.put("userName",loginUser.getUserName());
            data.put("userNumber",loginUser.getUserNumber());
            UsersController usersController=new UsersController();
//            List<String> list_autho=usersController.getUserAuthoName(loginUser.getUserNumber());
//            data.put("userAutho",list_autho);
//            List<String> list_role=usersController.getUserRoleName(loginUser.getUserNumber());
//            data.put("userRole",list_role);
//
            //--------------------------------------------------------------------
            QueryWrapper<Belong1> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("user_number", loginUser.getUserNumber());
            List<Belong1> list_=new ArrayList<>();
            list_=belong1Service.list(queryWrapper2);
            List<String>list_name=new ArrayList<>();
            List<Integer>list_number=new ArrayList<>();
            for(int i=0;i<list_.size();i++)
            {
                Belong1 belong1=list_.get(i);
                list_name.add(belong1.getRoleName());
                list_number.add(belong1.getRoleNumber());
            }
            List<Have1> list_2=new ArrayList<>();
            List<String>list_name2=new ArrayList<>();
            List<Integer>list_number2=new ArrayList<>();
            for(int i=0;i<list_number.size();i++)//遍历每一个角色
            {
                Integer roleNumber=list_number.get(i);
                QueryWrapper<Have1> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.eq("role_number", roleNumber);
                list_2=have1Service.list(queryWrapper3);

                for(int j=0;j<list_2.size();j++)
                {
                    Have1 have1=list_2.get(j);
                    list_name2.add(have1.getAuthorityName());
                    list_number2.add(have1.getAuthorityNumber());
                }

            }
            System.out.println(list_name2);
            data.put("userAutho",list_name2);
            data.put("userRole",list_name);
            return data;
        }
        System.out.println("object is empty");
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
