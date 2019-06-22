package com.itcast.service;

import com.itcast.domain.TbUser;

public interface UserService {

    /*
    * 登录方法
    * */
    boolean login(TbUser user);
}
