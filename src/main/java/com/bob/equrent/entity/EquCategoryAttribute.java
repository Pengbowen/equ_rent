package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 类别属性类
 */
@Data
@Entity
@Table(name = "pms_equ_attribute")
public class EquCategoryAttribute {

    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    //类别id
    @Column
    private Integer categoryId;

    //属性名称
    @Column(length = 64)
    private String name;

    //属性类别 1：规格 /2：参数
    @Column
    private Integer type;
}
