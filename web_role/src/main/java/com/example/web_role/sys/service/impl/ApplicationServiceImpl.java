package com.example.web_role.sys.service.impl;

import com.example.web_role.sys.entity.Application;
import com.example.web_role.sys.mapper.ApplicationMapper;
import com.example.web_role.sys.service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cmy
 * @since 2023-10-24
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {

}
