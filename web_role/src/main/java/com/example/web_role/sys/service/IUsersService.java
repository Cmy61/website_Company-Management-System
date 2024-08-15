package com.example.web_role.sys.service;

import com.example.web_role.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
public interface IUsersService extends IService<Users> {
    Map<String,Object> login(Users user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}
