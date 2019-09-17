package com.bob.equrent.controller;

import com.bob.equrent.entity.Carousel;
import com.bob.equrent.entity.ResponseData;
import com.bob.equrent.service.CarsouelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carsouel")
@Api(value="轮播图配置接口",description = "轮播图配置接口，提供轮播图的各种管理接口")
public class CarsouelController {
    @Autowired
    private CarsouelService service;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有轮播图信息",notes="查询所有轮播图")
    public ResponseData listAll(){
        return service.listAll();
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新轮播图设置")
    public ResponseData update(Carousel carousel){
        return service.update(carousel);
    }
}
