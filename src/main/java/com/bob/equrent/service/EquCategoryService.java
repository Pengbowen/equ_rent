package com.bob.equrent.service;

import com.bob.equrent.dao.EquCategoryDao;
import com.bob.equrent.entity.EquCategory;
import com.bob.equrent.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EquCategoryService {

    @Autowired
    private EquCategoryDao dao;

    @Autowired
    private FileService fileService;

    @Value("${image.root.path}")
    private String imgRootPath;

    //文件保存文件夹
    @Value("${image.location.path}")
    private String resourceDir;


    public ResponseData findAllParentEquCategories(){
        List<EquCategory> categories = dao.findAllByPid(0);
        return  new ResponseData(20000,"成功",categories);
    }

    public ResponseData addCategory(EquCategory category,MultipartFile file){
        if (category == null){
            throw new IllegalArgumentException("类别信息为空！");
        }
        if (file != null){
            String fileName = fileService.generateFileName(file);
            fileService.saveFile(file, resourceDir, fileName);
            category.setPicture(imgRootPath+fileName);
        }
        if (category.getPid() == null){
            category.setPid(0);
        }
        dao.save(category);
        return new ResponseData(20000,"成功",null);
    }
    @Transactional
    public ResponseData deleteById(int id){
        dao.deleteByIdIsOrPidIs(id,id);
        return new ResponseData(20000,"成功",null);
    }

}
