package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pms_equ")
public class Equ {

    //自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //类别id
    @Column
    private Integer categoryId;

    //器材名称
    @Column(length = 64)
    private String name;

    //器材图片
    @Column
    private String pic;

    //删除状态
    @Column
    private Integer deleteStatus;

    //上架状态
    @Column
    private Integer publishStatus;

    //排序
    @Column
    private Integer sort;

    //销量
    @Column
    private Integer sale;

    //价格
    @Column
    private Double price;

    //副标题
    @Column(length = 64)
    private String subTitle;

    //商品描述
    @Column
    private String description;

    //库存
    @Column
    private String stock;

    //画册图片(可多张)
    @Column
    private String albumPics;

    //详情标题
    @Column(length = 64)
    private String detailTitle;

    //详情描述
    @Column
    private String detailDesc;

    //详情网页内容
    @Column(columnDefinition = "blob")
    private String detailHtml;




}
