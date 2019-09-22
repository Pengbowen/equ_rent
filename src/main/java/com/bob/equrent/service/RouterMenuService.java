package com.bob.equrent.service;

import com.bob.equrent.dao.RouterMenuDao;
import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.entity.RouterMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouterMenuService {

    @Autowired
    private RouterMenuDao dao;

    /**
     * 查询所有的父菜单路由
     * @return
     */
    public ResponseData findAllParentRouterMenu(){
        List<RouterMenu> parentMenus = dao.findAllByPid(0);
        return new ResponseData(20000,"成功",parentMenus);
    }

    /**
     * 添加新的菜单路由
     * @param routerMenu
     * @return
     */
    public ResponseData addParentRouter(RouterMenu routerMenu){
            routerMenu.setId(null);
            routerMenu.setPid(0);
        RouterMenu save = dao.save(routerMenu);
        return new ResponseData(20000,"添加成功",save);
    }

    @Transactional
    public ResponseData deleteRouterById(Integer id){
        dao.deleteByIdIsOrPidIs(id,id);
        return new ResponseData(20000,"删除成功",null);
    }

}
