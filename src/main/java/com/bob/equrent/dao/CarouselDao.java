package com.bob.equrent.dao;

import com.bob.equrent.entity.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarouselDao extends JpaRepository<Carousel,Integer> {
    List<Carousel> findAllByEnableOrderBySortAsc(boolean enable);

    /**
     * 查询最后一个排序编号
     * @return
     */
    @Query(value = "select max(sort) as sort from Carousel ")
    Integer findLastSortNum();
}
