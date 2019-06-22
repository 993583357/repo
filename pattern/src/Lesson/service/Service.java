package Lesson.service;

import Lesson.domain.User;

public interface Service {
    void addUser(User user);
    void updateUser(User user);
    User selectUser(String s);
}
