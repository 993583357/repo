package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    void checkUserPassWord(User user);

    void selectAll();
}
