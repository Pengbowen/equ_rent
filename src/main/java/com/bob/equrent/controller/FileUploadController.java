package com.bob.equrent.controller;

import com.bob.equrent.service.CarsouelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("file")
public class FileUploadController {


    @Autowired
    private CarsouelService carsouelService;

    // 批量上传
    @PostMapping("/batchUploadImg")
    public String bacthFileUpload(MultipartFile[] file) throws Exception {
        StringBuffer buffer = new StringBuffer();
        for (MultipartFile multipartFile : file) {
            String str = carsouelService.uploadCarsouelImg(multipartFile);
            buffer.append(str);
            buffer.append(",");
        }
        String all = buffer.substring(0, buffer.length() - 1);
        return all;
    }


}
