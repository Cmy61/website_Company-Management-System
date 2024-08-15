package com.example.web_role.sys.controller;

import com.example.web_role.common.vo.Result;
import com.example.web_role.sys.entity.Company;
import com.example.web_role.sys.service.ICompanyService;
import io.lettuce.core.pubsub.RedisPubSubAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@CrossOrigin
@RequestMapping("/sys/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;
    @GetMapping("allCompany")
    public Result<?> getAllCompany(){
        List<Company> list=companyService.list();
        System.out.println(list);
        return Result.success(list);
    }
}
