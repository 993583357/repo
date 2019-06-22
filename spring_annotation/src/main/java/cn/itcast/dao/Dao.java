package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface Dao {
    User getColumUser();

    List<User> selectAll();
}
