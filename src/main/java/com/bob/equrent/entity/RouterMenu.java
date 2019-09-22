package com.bob.equrent.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
public class RouterMenu {

    //id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    //父级id 默认为0(最高级)
    @Column(columnDefinition = "int default 0")
    private Integer pid;
    //路由地址
    @Column
    private String path;
    //是否在侧边栏出现
    @Column
    private Boolean hidden;
    //面包屑导航点击重定向地址,如果需要设置为不可被点击,值为:'noRedirect'
    @Column
    private String redirect;
    //当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
    //只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
    //若你想不管路由下面的 children 声明的个数都显示你的根路由
    //你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
    @Column
    private Boolean alwaysShow;
    //路由名称
    @Column(length = 16)
    private String name;
    //组件地址
    @Column
    private String component;

    //排序
    @Column
    private Integer sort;

    //路由元数据
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "meta_id")
    private RouterMenuMeta meta;

    //子路由
    @OneToMany(mappedBy = "pid")
    private List<RouterMenu> children;




}
