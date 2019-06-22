package com.itcast.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    private Integer id;
    private String rName;
    private String rDesc;
    private List<User> users;

    public Role() {
    }

    public Role(Integer id, String rName, String rDesc, List<User> users) {
        this.id = id;
        this.rName = rName;
        this.rDesc = rDesc;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rName='" + rName + '\'' +
                ", rDesc='" + rDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
