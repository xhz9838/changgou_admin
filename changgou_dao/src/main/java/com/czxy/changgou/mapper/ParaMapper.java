package com.czxy.changgou.mapper;

import com.czxy.changgou.domain.Para;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
public interface ParaMapper extends Mapper<Para> {

    @Select("select * from tb_para where category_id=#{cid}")
    List<Para> findAllByCategory(@Param("cid") Integer cid);
}
