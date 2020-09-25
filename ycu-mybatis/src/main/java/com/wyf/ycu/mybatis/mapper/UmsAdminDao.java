package com.wyf.ycu.mybatis.mapper;

import com.wyf.ycu.mybatis.model.UmsAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);
    //根据用户名和密码进行查询
    UmsAdmin selectByUsernameAndPassword(UmsAdmin umsAdmin);

    UmsAdmin selectAll();

    /** 根据用户名查询 */
    UmsAdmin selectByUsername(UmsAdmin umsAdmin);

}