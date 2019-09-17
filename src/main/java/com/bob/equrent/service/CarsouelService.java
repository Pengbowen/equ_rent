package com.bob.equrent.service;

import com.bob.equrent.dao.CarouselDao;
import com.bob.equrent.entity.Carousel;
import com.bob.equrent.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarsouelService {
    @Autowired
    private CarouselDao dao;


    public ResponseData<List<Carousel>> listAll(){
        Sort sort = Sort.by("sort");
        List<Carousel> all = dao.findAll(sort);
        return new ResponseData<>(20000,"成功",all);
    }

    public ResponseData update(Carousel carousel){
        dao.saveAndFlush(carousel);
        return  new ResponseData(20000,"成功",null);
    }


}
