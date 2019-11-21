package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Para;
import com.czxy.changgou.service.ParaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/para")
public class ParaController {
    @Resource
    private ParaService paraService;

    @PostMapping
    public BaseResult save(@RequestBody Para para){
        return paraService.save(para);
    }

    @GetMapping("/category/{cid}")
    public BaseResult findAllByCategory(@PathVariable("cid")Integer cid){
        List<Para> paraList = paraService.findAllByCategory(cid);
        return BaseResult.ok("查询成功",paraList);
    }
}
