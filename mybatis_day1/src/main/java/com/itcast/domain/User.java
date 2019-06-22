package com.itcast.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
    private Integer uid;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private List<Account> account;
    private List<Role> roles;

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public User(Integer uid, String username, Date birthday, String sex, String address,List<Account> account,List<Role> roles) {
        this.uid = uid;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.account = account;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
