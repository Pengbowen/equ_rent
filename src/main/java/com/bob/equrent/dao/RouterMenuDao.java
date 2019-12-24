package com.bob.equrent.dao;

import com.bob.equrent.entity.RouterMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouterMenuDao extends JpaRepository<RouterMenu,Integer> {
    /**
     * 根据id查询路由菜单
     * @param pid
     * @return
     */
    List<RouterMenu> findAllByPid(int pid);

    /**
     * 根据id删除路由菜单(以及其子菜单)
     * @param id
     * @param pid
     */
    void deleteByIdIsOrPidIs(Integer id,Integer pid);

}
