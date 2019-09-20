package com.bob.equrent.controller;

import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.service.RouterMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("router")
@Api(value="菜单路由管理接口",description = "菜单路由接口，提供菜单路由的增删改查功能接口")
public class RouterMenuController {

    @Autowired
    private RouterMenuService service;

    @RequestMapping("listAll")
    @ApiOperation(value = "查询所有的主菜单路由")
    public ResponseData findAll(){
        return service.findAllParentRouterMenu();
    }

}
