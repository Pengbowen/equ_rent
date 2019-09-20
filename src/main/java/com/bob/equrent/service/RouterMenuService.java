package com.bob.equrent.service;

import com.bob.equrent.dao.RouterMenuDao;
import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.entity.RouterMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterMenuService {

    @Autowired
    private RouterMenuDao dao;


    public ResponseData findAllParentRouterMenu(){
        List<RouterMenu> parentMenus = dao.findAllByPid(0);
        return new ResponseData(20000,"成功",parentMenus);
    }

}
