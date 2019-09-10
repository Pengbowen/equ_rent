package com.bob.equrent.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "pms_equ_attribute_value")
public class EquAttributeValue {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //属性id
    @Column
    private Integer attributeId;

    //器材id
    @Column
    private Integer equId;

    //属性值
    @Column
    private String value;

    @ManyToOne(targetEntity = EquCategoryAttribute.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "attributeId",referencedColumnName = "id",insertable = false,updatable = false)
    private EquCategoryAttribute attribute;

}
