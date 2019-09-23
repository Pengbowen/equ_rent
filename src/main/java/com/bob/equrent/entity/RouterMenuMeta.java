package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class RouterMenuMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //该路由在侧边栏和面包屑中展示的名字
    @Column(length = 16)
    private String title;

    //该路由的图标
    @Column(length = 16)
    private String icon;

    //如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    @Column
    private Boolean noCache;

    // 如果设置为false，则不会在breadcrumb面包屑中显示
    @Column
    private Boolean breadcrumb;






}
