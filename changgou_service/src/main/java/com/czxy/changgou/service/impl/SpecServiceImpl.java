package com.czxy.changgou.service.impl;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Category;
import com.czxy.changgou.domain.Spec;
import com.czxy.changgou.mapper.CategoryMapper;
import com.czxy.changgou.mapper.SpecMapper;
import com.czxy.changgou.service.SpecService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@Service
@Transactional
public class SpecServiceImpl implements SpecService {
    @Resource
    private SpecMapper specMapper;

    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public BaseResult save(Spec spec) {
        Category category = categoryMapper.selectByPrimaryKey(spec.getCategoryId());
        if(category==null){
            return BaseResult.error("当前分类不存在");
        }
        Example example = new Example(Spec.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("name",spec.getName());
        c.andEqualTo("categoryId",spec.getCategoryId());
        int count = specMapper.selectCountByExample(example);
        if(count>0){
            return BaseResult.error("["+spec.getName()+"]参数已存在");
        }
        spec.setSeq(1);
        specMapper.insertSelective(spec);
        return BaseResult.ok("添加成功");
    }

    @Override
    public List<Spec> findAllByCategory(Integer cid) {
        Example example = new Example(Spec.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("categoryId",cid);
        return specMapper.selectByExample(example);
    }
}
