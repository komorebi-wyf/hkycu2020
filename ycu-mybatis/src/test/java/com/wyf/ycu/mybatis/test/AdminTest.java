package com.wyf.ycu.mybatis.test;

import com.wyf.ycu.mybatis.mapper.UmsAdminDao;
import com.wyf.ycu.mybatis.model.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    private UmsAdminDao adminDao;

    @Test
    public void insertAdminTest() {
        UmsAdmin admin = new UmsAdmin();
        admin.setNickName("san");
        admin.setCreateTime(new Date());
        admin.setPassword("123456");
        admin.setUsername("张三");

        this.adminDao.insertSelective(admin);
    }

    @Test
    public void deleteAdminTest(){
        this.adminDao.deleteByPrimaryKey(9L);
    }

    @Test
    public void selectByPrimaryKey(){
        this.adminDao.selectByPrimaryKey(11L);
    }

    @Test
    public void selectAll(){
        this.adminDao.selectAll();
    }

    @Test
    public void updateByPrimaryKeySelective(){
        UmsAdmin admin = new UmsAdmin();
        admin.setId(11L);
        admin.setNickName("si");
        admin.setUsername("李四");

        this.adminDao.updateByPrimaryKeySelective(admin);
    }


}


