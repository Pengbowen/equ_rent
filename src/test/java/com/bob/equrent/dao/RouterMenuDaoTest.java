package com.bob.equrent.dao;

import com.bob.equrent.entity.RouterMenu;
import com.bob.equrent.entity.RouterMenuMeta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RouterMenuDaoTest {
    @Autowired
    private RouterMenuDao dao;


    @Test
    public void testAdd(){
        RouterMenuMeta meta = new RouterMenuMeta();
        meta.setNoCache(false);
        meta.setTitle("测试主菜单");
        meta.setIcon("test");
        meta.setBreadcrumb(true);
        RouterMenu routerMenu = new RouterMenu();
        routerMenu.setAlwaysShow(true);
        routerMenu.setComponent("view/test");
        routerMenu.setHidden(false);
        routerMenu.setMeta(meta);
        routerMenu.setName("haha");
        routerMenu.setRedirect("noRedirect");
        routerMenu.setPath("view/wer");
        routerMenu.setPid(0);
        dao.save(routerMenu);
    }

}