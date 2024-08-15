package com.example.web_role.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.common.vo.Result;
import com.example.web_role.sys.entity.Belong1;
import com.example.web_role.sys.entity.Role;
import com.example.web_role.sys.service.IBelong1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@RestController
@RequestMapping("/sys/belong1")
@CrossOrigin
public class Belong1Controller {

    @Autowired
    private IBelong1Service belong1Service;
    @GetMapping("/chooseRole")
    public Result<List<String>> getChooseRole(@RequestParam Integer userNumber) {
        System.out.println(userNumber);
        QueryWrapper<Belong1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_number", userNumber);
        List<Belong1> list=belong1Service.list(queryWrapper);
        List<String> RoleName=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            RoleName.add(list.get(i).getRoleName());
        }
        return Result.success(RoleName,"查询成功");
    }
}
