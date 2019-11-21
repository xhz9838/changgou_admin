package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Spu;
import com.czxy.changgou.service.SpuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/18
 */
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Resource
    private SpuService spuService;
    @PostMapping
    public BaseResult save(@RequestBody Spu spu){
        spuService.save(spu);
        return BaseResult.ok("添加成功");
    }
}
