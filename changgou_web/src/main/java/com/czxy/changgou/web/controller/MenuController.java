package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Menu;
import com.czxy.changgou.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/19
 */
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Resource
    private MenuService menuService;
    @GetMapping("/{adminId}")
    public BaseResult findMenuByAdminId(@PathVariable Integer adminId){
        List<Menu>  menuList = menuService.findMenuByAdminId(adminId);
        return BaseResult.ok("查询成功",menuList);
    }
}
