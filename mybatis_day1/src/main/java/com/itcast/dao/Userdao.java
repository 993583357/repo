package com.itcast.dao;

import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface Userdao {
    //查询所有
    @Select("select * from user")
    List<User> findAll();


    //添加用户
    @Insert("insert into user (username,address,sex,birthday) VALUES (#{username},#{address},#{sex},#{birthday})")
    @SelectKey(statement = "SELECT Last_insert_id()", keyProperty = "uid", keyColumn = "id", before = false, resultType = Integer.class)
    void addUser(User user);


    //更新用户
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id = #{uid}")
    void updateUser(User user);


    //删除用户
    @Delete("DELETE FROM user where id = #{uid}")
    void deleteUser(Integer id);


    //模糊查询参数多个参数，返回结果集为集合
    //多个参数的时候，使用@Param起别名，在配置文件里识别
    @Select("select * from user where username like #{username} and address like #{ address}")
    List<User> selectMore(@Param("username")String username,@Param("address")String address);


    //判断用户性别 是男的话 查询住址为北京的  是女的话 查询住址为石家庄的
    @Select("SELECT * FROM USER")

    List<User> selectBySex(User user);


    //更新用户的信息，根据用户的id
    void updateUser11(User user);

    //查询User的所有信息，并把所对应的账户查询出来
    List<User> selectUserByAccount();

    //查询账户，把有账户的用户查询出来
    List<Account> selectAccount();


    //查询用户信息，并展示用户对应的关系
    List<User> selectUserAndRole();






}
