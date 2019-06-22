package com.itcast.service.impl;

import com.itcast.dao.TbUserMapper;
import com.itcast.domain.TbUser;
import com.itcast.domain.TbUserExample;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public boolean login(TbUser user) {
        TbUserExample userExample = new TbUserExample();
        TbUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<TbUser> tbUsers = userMapper.selectByExample(userExample);
        if (tbUsers==null||tbUsers.size()<1){
            throw new RuntimeException("用户名或密码错误");
        }
        return true;
    }
}
