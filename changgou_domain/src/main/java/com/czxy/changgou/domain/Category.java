package com.czxy.changgou.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@Data
@Table(name="tb_category")
public class Category implements Serializable {
    @Id
    private Integer id;

    private String name;

    private Integer goodsNum;

    private String isShow;

    private String isMenu;

    private Integer seq;

    private Integer parentId;

    private Integer templateId;


}
