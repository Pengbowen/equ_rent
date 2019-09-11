package com.bob.equrent.dao;

import com.bob.equrent.entity.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarouselDao extends JpaRepository<Carousel,Integer> {
    List<Carousel> findAllByEnableOrderBySortAsc(boolean enable);
}
