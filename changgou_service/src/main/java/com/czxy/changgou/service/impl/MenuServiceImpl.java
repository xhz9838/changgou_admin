package com.czxy.changgou.service.impl;

import com.czxy.changgou.domain.Menu;
import com.czxy.changgou.mapper.MenuMapper;
import com.czxy.changgou.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/19
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findMenuByAdminId(Integer adminId) {
        //查询用户的所有菜单
        List<Menu> allMenu = menuMapper.findMenuByAdminId(adminId);
        //存放一级菜单的集合
        List<Menu> rootMenu = new ArrayList<>();
        //缓存所有菜单  方便子菜单快速获得父菜单
        HashMap<Integer, Menu> cacheMap = new HashMap<>();
        for (Menu menu : allMenu) {
            //获得父菜单
            Menu cacheMenu = cacheMap.get(menu.getPid());
            if(cacheMenu==null){
                //如果不存在，表示一级菜单
                rootMenu.add(menu);
            }else {
                //如果父菜单存在，将当前菜单添加到父菜单中
                cacheMenu.getChildren().add(menu);
            }
            /* 缓存当前菜单，方便当前菜单的子菜单快速获得 */
            cacheMap.put(menu.getId(),menu);
        }
        return rootMenu;
    }
}
