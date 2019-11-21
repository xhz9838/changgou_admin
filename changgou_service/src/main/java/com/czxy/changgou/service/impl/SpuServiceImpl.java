package com.czxy.changgou.service.impl;

import com.czxy.changggou.config.IdWorker;
import com.czxy.changgou.domain.Brand;
import com.czxy.changgou.domain.Category;
import com.czxy.changgou.domain.Spu;
import com.czxy.changgou.mapper.BrandMapper;
import com.czxy.changgou.mapper.CategoryMapper;
import com.czxy.changgou.mapper.SkuMapper;
import com.czxy.changgou.mapper.SpuMapper;
import com.czxy.changgou.service.SpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/18
 */
@Service
@Transactional
public class SpuServiceImpl implements SpuService {

    @Resource
   private SpuMapper spuMapper;

    @Resource
    private IdWorker idWorker;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private SkuMapper skuMapper;
    @Override
    public void save(Spu spu) {
        spu.setId(idWorker.nextId()+"");
        spu.setSaleNum(0);
        spu.setCommentNum(0);
        spu.setIsEnableSpec("1");
        spu.setIsDelete("0");
        spuMapper.insertSelective(spu);
        Category category = categoryMapper.selectByPrimaryKey(spu.getCategory3Id());
        Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());

        spu.getSkuData().forEach(sku->{

            sku.setId(idWorker.nextId()+"");
            sku.setCategoryName(category.getName());
            sku.setBrandName(brand.getName());
            sku.setCreateTime(new Date());
            sku.setUpdateTime(new Date());
            sku.setSaleNum(0);
            sku.setCommentNum(0);
            sku.setSpuId(spu.getId());
            skuMapper.insertSelective(sku);
        });
    }
}
