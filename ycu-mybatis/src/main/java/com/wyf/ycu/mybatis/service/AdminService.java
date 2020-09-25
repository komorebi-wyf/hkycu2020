package com.wyf.ycu.mybatis.service;

import com.wyf.ycu.mybatis.model.UmsAdmin;
import com.wyf.ycu.mybatis.result.Result;

public interface AdminService {
    /** 使用用户名和密码进行登录 */
    Result<UmsAdmin> login(UmsAdmin umsAdmin) ;

    int register(UmsAdmin umsAdmin);


}
