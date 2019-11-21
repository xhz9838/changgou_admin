package com.czxy.changgou.service.impl;

import com.czxy.changgou.domain.Brand;
import com.czxy.changgou.mapper.BrandMapper;
import com.czxy.changgou.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
       return brandMapper.selectAll();
    }
}
