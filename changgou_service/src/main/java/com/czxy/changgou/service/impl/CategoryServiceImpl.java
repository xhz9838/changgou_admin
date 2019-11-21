package com.czxy.changgou.service.impl;

import com.czxy.changgou.domain.Category;
import com.czxy.changgou.mapper.CategoryMapper;
import com.czxy.changgou.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findChildren(Integer parentId) {
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("parentId",parentId);
        return categoryMapper.selectByExample(example);
    }
}
