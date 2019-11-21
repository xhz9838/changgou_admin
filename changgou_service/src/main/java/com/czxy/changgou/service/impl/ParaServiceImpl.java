package com.czxy.changgou.service.impl;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Category;
import com.czxy.changgou.domain.Para;
import com.czxy.changgou.mapper.CategoryMapper;
import com.czxy.changgou.mapper.ParaMapper;
import com.czxy.changgou.service.ParaService;
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
public class ParaServiceImpl implements ParaService {
   @Resource
   private ParaMapper paraMapper;
   @Resource
   private CategoryMapper categoryMapper;

    @Override
    public BaseResult save(Para para) {
        Category category = categoryMapper.selectByPrimaryKey(para.getCategoryId());
        if(category==null){
            return BaseResult.error("当前类不存在");
        }
        Example example = new Example(Para.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("name",para.getName());
        c.andEqualTo("categoryId",para.getCategoryId());
        int count = paraMapper.selectCountByExample(example);
        if(count>0){
            return BaseResult.error("["+para.getName()+"]参数已存在");
        }
        para.setSeq(1);
        paraMapper.insertSelective(para);
        return BaseResult.ok("添加成功");
    }

    @Override
    public List<Para> findAllByCategory(Integer cid) {
        return paraMapper.findAllByCategory(cid);
    }
}
