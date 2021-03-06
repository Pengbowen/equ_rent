package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 器材类别类
 */
@Entity
@Table(name = "pms_equ_category")
@Data
public class EquCategory {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;
    //父类id
    @Column
    private Integer pid;
    //名称
    @Column(length = 64)
    private String name;
    //排序
    @Column
    private Integer sort;
    //图片
    @Column
    private String picture;
    //描述
    @Column
    private String description;

    //子类集合
    @OneToMany(mappedBy = "pid")
    private List<EquCategory> children;

}
