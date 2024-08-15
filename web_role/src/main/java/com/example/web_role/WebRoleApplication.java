package com.example.web_role;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.web_role.*.mapper")
//@MapperScan("com.example.web_role.*.*")
public class WebRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebRoleApplication.class, args);
    }

}
