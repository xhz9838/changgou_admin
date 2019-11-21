package com.czxy.changgou.service;

import com.czxy.changggou.vo.BaseResult;
import com.czxy.changgou.domain.Para;

import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
public interface ParaService {

    BaseResult save(Para para);

    List<Para> findAllByCategory(Integer cid);
}
