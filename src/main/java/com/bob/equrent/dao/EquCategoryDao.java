package com.bob.equrent.dao;

import com.bob.equrent.entity.EquCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquCategoryDao extends JpaRepository<EquCategory,Integer> {
    /**
     * 根据pid查询所有的子类
     * @param pid
     * @return
     */
    List<EquCategory> findAllByPid(int pid);
}
