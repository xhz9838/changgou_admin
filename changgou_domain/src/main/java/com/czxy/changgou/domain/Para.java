package com.czxy.changgou.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="tb_para")
public class Para implements Serializable {
    @Id
    private Integer id;

    private  String name;

    private String options;

    private Integer seq;

    private Integer categoryId;


}
