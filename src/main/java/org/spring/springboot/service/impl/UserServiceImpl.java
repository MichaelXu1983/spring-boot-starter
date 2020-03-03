package org.spring.springboot.service.impl;


import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mapper.UserMapper;
import com.user.model.User;

/**
 * 员工业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    public User findUserByName(String userName) {
        return userDao.findByName(userName);
    }
    public User selectByPrimaryKey(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
