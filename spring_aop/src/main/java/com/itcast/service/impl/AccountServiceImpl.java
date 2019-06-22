package com.itcast.service.impl;

import com.itcast.dao.Dao;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private Dao dao;

    public void setAccount() {
        int put = 1;
        int out = 2;
        int money = 8000;
        try{
            dao.setAccount(put,money);
            int a = 1/0;
            dao.setAccountOut(out,money);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
