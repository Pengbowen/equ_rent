package com.bob.equrent.dao;

import com.bob.equrent.entity.Carousel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarouselDaoTest {

    @Autowired
    private CarouselDao dao;
    @Test
    public void testAdd(){
        Carousel carousel = new Carousel();
        carousel.setSrc("/chandi.jpg");
        carousel.setPath("/chandi.jpg");
        carousel.setBackground("rbg(21,34,23)");
        carousel.setSort(1);
        carousel.setEnable(true);
        carousel.setId(null);
        dao.save(carousel);
        carousel.setId(null);
        carousel.setSort(2);
        carousel.setEnable(true);
        dao.save(carousel);
        carousel.setId(null);
        carousel.setSort(3);
        carousel.setEnable(true);
        dao.save(carousel);
        carousel.setId(null);
        carousel.setSort(4);
        carousel.setEnable(false);
        dao.save(carousel);
        carousel.setId(null);
        carousel.setSort(5);
        carousel.setEnable(true);
        dao.save(carousel);

    }
    @Test
    public void findAllByEnableOrderBySortDesc() {

        List<Carousel> bySortDesc = dao.findAllByEnableOrderBySortDesc(true);
        System.out.println(bySortDesc);
    }
}