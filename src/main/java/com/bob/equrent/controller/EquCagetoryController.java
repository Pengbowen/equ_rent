package com.bob.equrent.controller;


import com.bob.equrent.entity.EquCategory;
import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.service.EquCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

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

    @PostMapping("addChild")
    @ApiOperation(value ="新增子类别信息" )
    public ResponseData addChildCategory(EquCategory category, MultipartFile file){
        return service.addCategory(category,file);
    }

    @PostMapping("add")
    @ApiOperation(value ="新增父类别信息" )
    public ResponseData addCategory(@RequestBody EquCategory category, MultipartFile file){
        return service.addCategory(category,file);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value ="根据id删除类别及子类别" )
    public ResponseData deleteById(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }

}
