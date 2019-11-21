package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Brand;
import com.czxy.changgou.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@RestController("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    @GetMapping
    public BaseResult findAll(){
        List<Brand> brandList = brandService.findAll();
        return BaseResult.ok("查询成功",brandList);
    }

}
