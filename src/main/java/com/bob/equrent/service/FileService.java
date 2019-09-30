package com.bob.equrent.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service
public class FileService {

    //获取配置文件的路径
    @Value("${image.location.path}")
    private String resourceDir;
    @Value("${image.root.path}")
    private String imgRootPath;


    public String fileUpload( MultipartFile file,String savePath) {
        // 获取上传文件路径
        String uploadPath = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPath.substring(uploadPath.lastIndexOf(".") + 1, uploadPath.length());
        uploadPath = resourceDir;
        // 上传文件名
        String fileName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
        String fileSavePath = uploadPath + fileName;
        File savefile = new File(fileSavePath);
        if (!savefile.getParentFile().exists()) {
            savefile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(savefile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  fileSavePath;
    }
    public String generateFileName(MultipartFile file){
        // 获取上传文件路径
        String uploadPath = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPath.substring(uploadPath.lastIndexOf(".") + 1, uploadPath.length());
        // 上传文件名
        String fileName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
        return fileName;
    }

    public String saveFile(MultipartFile file,String fileSaveDirPath,String fileName){
        String fileSavePath = fileSaveDirPath + fileName;
        File savefile = new File(fileSavePath);
        if (!savefile.getParentFile().exists()) {
            savefile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(savefile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileSavePath;

    }

}
