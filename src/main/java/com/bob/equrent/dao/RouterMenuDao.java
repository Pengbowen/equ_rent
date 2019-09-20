package com.bob.equrent.dao;

import com.bob.equrent.entity.RouterMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouterMenuDao extends JpaRepository<RouterMenu,Integer> {

    List<RouterMenu> findAllByPid(int pid);

}
