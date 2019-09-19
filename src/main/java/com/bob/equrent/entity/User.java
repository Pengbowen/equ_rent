package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class User {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //账号
    @Column
    private String name;
    //昵称
    @Column
    private String nikcname;
    //密码
    @Column
    private String pwd;
    //盐值
    @Column
    private String salt;
    //头像地址
    @Column
    private String portrait;
    //手机
    @Column
    private String mobile;
    //邮箱
    @Column
    private String email;
    //介绍
    @Column
    private String introduction;



}
