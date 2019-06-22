package com.itcast.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.dao.Userdao;
import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class MybatisTest {

    private Userdao mapper;
    private SqlSession session;
    private InputStream in;
    private User user = new User();

    @Before
    public void init() throws IOException {

        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession();
        mapper = session.getMapper(Userdao.class);


    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    //查询所有
    @Test
    public void findAll() {
        PageHelper.startPage(2,3);
        Page<User> users = (Page<User>) mapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(users.getTotal());
        System.out.println(users.getPages());
        System.out.println(users.getPageNum());
        System.out.println(users.getPageSize());

    }
    //添加用户
    @Test
    public void addUser() {
        user.setUid(null);
        user.setAddress("石家庄");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("齐德龙");

        mapper.addUser(user);


    }
    //更新用户
    @Test
    public void updateUser() {
        user.setUid(51);
        user.setSex("女");
        user.setAddress("石家庄");
        user.setBirthday(new Date());
        user.setUsername("隆冬强");
        mapper.updateUser(user);
    }
    //模糊查询用户，多个参数，返回结果集为list
    @Test
    public void selectMore() {
        List<User> userList = mapper.selectMore("%王%", "%北京%");
        for (User user : userList) {
            System.out.println(user);
        }

    }
    //判断用户性别 是男的话 查询住址为北京的  是女的话 查询住址为石家庄的
    @Test
    public void selectBySex() {


        user.setSex("男");
        List<User> userList = mapper.selectBySex(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }


    }
    //更新用户的信息，根据用户的id
    @Test
    public void updateUser11() {

        user.setUid(51);
        user.setSex("男");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setUsername("凯特琳娜");
        mapper.updateUser11(user);
    }
    //查询用户的所有信息
    @Test
    public void selectUserByAccount(){

        List<User> userList = mapper.selectUserByAccount();

        for (User user1 : userList) {
            System.out.println(user1);
            System.out.println(user1.getAccount());
        }

        //System.out.println(user.getAccount());
    }
    //查询账户，把有账户的用户查询出来
    @Test
    public void selectAccount() {
        List<Account> accounts = mapper.selectAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    //查询用户信息和所对应的角色信息
    @Test
    public void selectUserAndRole(){
        List<User> userList = mapper.selectUserAndRole();
        for (User user1 : userList) {
            System.out.println(user1);
            System.out.println(user1.getRoles());
        }

    }


}
