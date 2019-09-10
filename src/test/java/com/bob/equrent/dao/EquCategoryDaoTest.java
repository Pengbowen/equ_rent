package com.bob.equrent.dao;

import com.bob.equrent.entity.EquCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquCategoryDaoTest {

    @Autowired
    private EquCategoryDao dao;

    @Test
    public void testAdd(){
        EquCategory equCategory = new EquCategory();
        equCategory.setPid(1);
        equCategory.setName("灯光器材");
        equCategory.setDescription("灯光所需器材");
        EquCategory save = dao.save(equCategory);
        Assert.assertNotNull(save);
    }
    @Test
    public void testFind(){
        EquCategory equCategory = new EquCategory();
        equCategory.setPid(1);
    }
}