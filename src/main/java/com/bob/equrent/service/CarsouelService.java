package com.bob.equrent.service;

import com.bob.equrent.dao.CarouselDao;
import com.bob.equrent.entity.Carousel;
import com.bob.equrent.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsouelService {
    @Autowired
    private CarouselDao dao;

    public ResponseData<List<Carousel>> listAll(){
        List<Carousel> all = dao.findAll();
        return new ResponseData<>(20000,"成功",all);
    }
}
