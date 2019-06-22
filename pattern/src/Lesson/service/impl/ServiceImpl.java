package Lesson.service.impl;

import Lesson.domain.User;
import Lesson.service.Service;

public class ServiceImpl implements Service{
    @Override
    public void addUser(User user) {
        System.out.println("执行添加方法");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("执行更新方法");
    }

    @Override
    public User selectUser(String s) {

        return null;
    }
}
