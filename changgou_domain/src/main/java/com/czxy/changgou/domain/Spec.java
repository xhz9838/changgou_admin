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
@Table(name="tb_spec")
public class Spec implements Serializable {

    @Id
    private Integer id;

    private String name;

    private String options;

    private Integer seq;

    private Integer categoryId;
}
