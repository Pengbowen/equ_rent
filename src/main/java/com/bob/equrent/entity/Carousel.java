package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 首页轮播图
 */
@Data
@Entity
@Table
public class Carousel {

    //自增id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //图片访问地址
    @Column
    private String src;
    //图片存放路径
    @Column
    private String path;
    //背景颜色
    @Column
    private String background;
    //排序
    @Column(length = 2)
    private Integer sort;
    //是否启用
    @Column
    private Boolean enable;

}
