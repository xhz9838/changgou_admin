package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Category;
import com.czxy.changgou.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/findChildren/{pid}")
    public BaseResult findChildren(@PathVariable("pid") Integer parentId){
        List<Category> list = categoryService.findChildren(parentId);
        return BaseResult.ok("查询所有",list);
    }
}
