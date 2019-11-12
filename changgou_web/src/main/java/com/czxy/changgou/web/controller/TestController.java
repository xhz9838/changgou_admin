package com.czxy.changgou.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/12
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "测试成功";
    }

    @PostMapping
    public String add(){
       return "添加成功";
    }
}
