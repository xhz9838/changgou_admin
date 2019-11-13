package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Admin;
import com.czxy.changgou.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/12
 */
@RestController
@RequestMapping
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 登录
     * @param admin
     * @return
     */
    @PostMapping("/access_token")
    public BaseResult login(@RequestBody Admin admin){
        Admin loginResult = adminService.login(admin);
        if(loginResult == null){
            return BaseResult.error("登录用户名或密码不匹配");
        }
        return BaseResult.ok("登录成功").append("token","abc").append("loginAdmin",loginResult);
    }
}
