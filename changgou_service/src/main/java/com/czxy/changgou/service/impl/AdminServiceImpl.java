package com.czxy.changgou.service.impl;

import com.czxy.changggou.config.BCrypt;
import com.czxy.changgou.domain.Admin;
import com.czxy.changgou.mapper.AdminMapper;
import com.czxy.changgou.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/12
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        Admin tempAdmin = new Admin();
        tempAdmin.setLoginName(admin.getLoginName());
        Admin queryAdmin = adminMapper.selectOne(tempAdmin);
        if (queryAdmin == null) {
            return null;
        }
        if (!BCrypt.checkpw(admin.getPassword(), queryAdmin.getPassword())) {
            return null;
        }
        return queryAdmin;
    }
}
