package com.example.web_role.sys.controller;

import com.example.web_role.common.vo.Result;
import com.example.web_role.sys.entity.Company;
import com.example.web_role.sys.entity.Department;
import com.example.web_role.sys.service.ICompanyService;
import com.example.web_role.sys.service.IDepartmentService;
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
@RequestMapping("/sys/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping("/allDepartment")
    public Result<?> getAllDepartment(){
        List<Department> list=departmentService.list();
        System.out.println(list);
        return Result.success(list);
    }
}
