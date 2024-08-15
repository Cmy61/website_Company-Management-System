package com.example.web_role.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.web_role.common.vo.Result;
import com.example.web_role.common.vo.Temp_role;
import com.example.web_role.sys.entity.Have1;
import com.example.web_role.sys.entity.Role;
import com.example.web_role.sys.service.IHave1Service;
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
@RequestMapping("/sys/have1")
@CrossOrigin
public class Have1Controller {

    @Autowired
    private IHave1Service have1Service;

    @GetMapping("/chooseAutho")
    public Result<?> getChooseAutho(@RequestParam Integer roleNumber)
    {
        System.out.println(roleNumber);
        List<Have1> list_=new ArrayList<>();
        List<String>list_name=new ArrayList<>();
        List<Integer>list_number=new ArrayList<>();
        QueryWrapper<Have1> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_number", roleNumber);
        list_=have1Service.list(queryWrapper);
        for(int j=0;j<list_.size();j++)
        {
            Have1 have1=list_.get(j);
            list_name.add(have1.getAuthorityName());
            list_number.add(have1.getAuthorityNumber());
        }
        System.out.println(list_name);
        return Result.success(list_name,"查询成功");
    }


}
