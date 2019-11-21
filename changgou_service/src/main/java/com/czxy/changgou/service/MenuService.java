package com.czxy.changgou.service;

import com.czxy.changgou.domain.Menu;

import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/19
 */
public interface MenuService {
    List<Menu> findMenuByAdminId(Integer adminId);
}
