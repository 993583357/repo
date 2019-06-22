package com.itcast.domain;

public class Account {
    private Integer id;
    private String name;
    private String account;

    public Account() {
    }

    public Account(Integer id, String name, String account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
