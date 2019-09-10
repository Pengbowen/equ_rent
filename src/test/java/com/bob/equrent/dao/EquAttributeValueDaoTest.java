package com.bob.equrent.dao;

import com.bob.equrent.entity.EquAttributeValue;
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
public class EquAttributeValueDaoTest {
    @Autowired
    private EquAttributeValueDao equAttributeValueDao;

    @Test
    public void testAdd(){
        EquAttributeValue equAttributeValue = new EquAttributeValue();
        equAttributeValue.setAttributeId(1);
        equAttributeValue.setValue("500W");
        EquAttributeValue save = equAttributeValueDao.save(equAttributeValue);
        Assert.assertNotNull(save);
    }

    @Test
    public void testFind(){
        Optional<EquAttributeValue> byId = equAttributeValueDao.findById(1);
        if (byId.isPresent()){
            System.out.println(byId.get());
        }

    }

}