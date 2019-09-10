package com.bob.equrent.dao;

import com.bob.equrent.entity.EquCategoryAttribute;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EquCategoryAttributeDaoTest {
    @Autowired
    private EquCategoryAttributeDao dao;
    @Test
    public void testAdd(){
        EquCategoryAttribute equCategoryAttribute = new EquCategoryAttribute();
        equCategoryAttribute.setCategoryId(2);
        equCategoryAttribute.setName("功率");
        equCategoryAttribute.setType(1);
        EquCategoryAttribute save = dao.save(equCategoryAttribute);
        Assert.assertNotNull(save);
    }
}