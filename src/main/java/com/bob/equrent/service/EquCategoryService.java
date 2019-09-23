package com.bob.equrent.service;

import com.bob.equrent.dao.EquCategoryDao;
import com.bob.equrent.entity.EquCategory;
import com.bob.equrent.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquCategoryService {

    @Autowired
    private EquCategoryDao dao;

    public ResponseData findAllParentEquCategories(){
        List<EquCategory> categories = dao.findAllByPid(0);
        return  new ResponseData(20000,"成功",categories);
    }

}
