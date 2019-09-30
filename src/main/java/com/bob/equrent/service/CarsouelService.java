package com.bob.equrent.service;

import com.bob.equrent.dao.CarouselDao;
import com.bob.equrent.entity.Carousel;
import com.bob.equrent.entity.ResponseData;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CarsouelService {
    @Autowired
    private CarouselDao dao;

    @Autowired
    private FileService fileService;

    @Value("${image.root.path}")
    private String imgRootPath;

    //文件保存文件夹
    @Value("${image.location.path}")
    private String resourceDir;

    public String uploadCarsouelImg(MultipartFile file) {
        String fileName = fileService.generateFileName(file);
        String fileSavePath = fileService.saveFile(file, resourceDir, fileName);
        //保存到数据库
        this.addNewCarsouel(imgRootPath + fileName, fileSavePath);
        return fileSavePath;
    }

    public ResponseData<List<Carousel>> listAll() {
        Sort sort = Sort.by("sort");
        List<Carousel> all = dao.findAll(sort);
        return new ResponseData<>(20000, "成功", all);
    }

    public ResponseData update(Carousel carousel) {
        dao.saveAndFlush(carousel);
        return new ResponseData(20000, "成功", null);
    }

    public ResponseData delele(int id) {
        dao.deleteById(id);
        return new ResponseData(20000, "删除成功", null);
    }

    @Transactional()
    public void addNewCarsouel(String src, String savePath) {
        Carousel carousel = new Carousel();
        carousel.setEnable(false);
        Integer maxSort = dao.findLastSortNum();
        if (maxSort == null) {
            maxSort = 0;
        }
        carousel.setSort(maxSort + 1);
        carousel.setPath(savePath);
        carousel.setSrc(src);
        dao.save(carousel);
    }


}
