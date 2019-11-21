package com.czxy.changgou.mapper;

import com.czxy.changgou.domain.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/19
 */

public interface MenuMapper extends Mapper<Menu> {

    @Select("SELECT * FROM tb_menus WHERE id IN (SELECT menu_id FROM tb_role_menus WHERE role_id IN (SELECT role_id FROM tb_admin_roles WHERE admin_id=#{aid}))")
    List<Menu> findMenuByAdminId(@Param("aid") Integer adminId);
}
