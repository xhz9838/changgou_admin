package com.czxy.changgou.web.controller;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Spec;
import com.czxy.changgou.service.SpecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Resource
    private SpecService specService;

    @PostMapping
    public BaseResult save(@RequestBody Spec spec){
      return specService.save(spec);

    }

    @GetMapping("/category/{cid}")
    public BaseResult findAllByCategory(@PathVariable("cid") Integer cid){
        List<Spec> specList = specService.findAllByCategory(cid);
        return BaseResult.ok("查询成功",specList);
    }
}
