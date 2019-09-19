package com.bob.equrent.controller;

import com.bob.equrent.entity.Carousel;
import com.bob.equrent.service.CarsouelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("file")
public class FileUploadController {

    //获取配置文件的路径
    @Value("${image.location.path}")
    private String resourceDir;

    @Value("${image.root.path}")
    private String imgRootPath;

    @Autowired
    private CarsouelService carsouelService;

    // 批量上传
    @PostMapping("/batchUploadImg")
    public String bacthFileUpload(MultipartFile[] file) throws Exception {
        StringBuffer buffer = new StringBuffer();
        for (MultipartFile multipartFile : file) {
            String str = fileUpload(multipartFile);
            buffer.append(str);
            buffer.append(",");
        }
        String all = buffer.substring(0, buffer.length() - 1);
        return all;
    }

    public String fileUpload( MultipartFile file) {
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
            //保存到数据库
            carsouelService.addNewCarsouel(imgRootPath+fileName,fileSavePath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileSuffix.equals("apk")) {
            return "/apk/" + fileName;
        } else {
            return "/image/" + fileName;
        }
    }
}
