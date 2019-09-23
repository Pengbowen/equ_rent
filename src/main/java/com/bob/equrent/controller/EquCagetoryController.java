package com.bob.equrent.controller;


import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.service.EquCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@Api(value="设备类别管理接口",description = "设备类别接口，提供设备类别的增删改查功能接口")
public class EquCagetoryController {

    @Autowired
    private EquCategoryService service;


    @GetMapping("listAll")
    @ApiOperation(value = "查询所有的类别信息")
    public ResponseData listAll(){
        return service.findAllParentEquCategories();
    }
}
