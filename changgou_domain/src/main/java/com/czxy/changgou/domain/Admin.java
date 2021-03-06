package com.czxy.changgou.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/12
 */
@Data
@Table(name="tb_admin")
public class Admin implements Serializable {

    @Id
    private Integer id;

    private String loginName;

    private String password;

    private String status;
}
