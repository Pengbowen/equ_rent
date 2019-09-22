package com.bob.equrent.controller;

import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.entity.RouterMenu;
import com.bob.equrent.entity.RouterMenuMeta;
import com.bob.equrent.service.RouterMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("router")
@Api(value="菜单路由管理接口",description = "菜单路由接口，提供菜单路由的增删改查功能接口")
public class RouterMenuController {

    @Autowired
    private RouterMenuService service;

    @GetMapping("listAll")
    @ApiOperation(value = "查询所有的主菜单路由")
    public ResponseData findAll(){
        return service.findAllParentRouterMenu();
    }

    @PostMapping("addParentRouter")
    @ApiOperation(value = "添加新的菜单路由")
    public ResponseData addParentRouter( @RequestBody RouterMenu routerMenu){
        //routerMenu.setMeta(meta);
        return service.addParentRouter(routerMenu);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "根据id删除菜单以及子菜单")
    public ResponseData delteRouter(@PathVariable("id") Integer id){
        return service.deleteRouterById(id);
    }
}
