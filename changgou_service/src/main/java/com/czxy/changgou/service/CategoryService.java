package com.czxy.changgou.service;

import com.czxy.changgou.domain.Category;

import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
public interface CategoryService {

    /**
     * 查询指定分类的所有子分类
     */
    List<Category> findChildren(Integer parentId);

}
