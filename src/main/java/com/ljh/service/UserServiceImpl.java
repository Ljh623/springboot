package com.ljh.service;

import com.ljh.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    //用户登录
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryByNameAndPass(String userName, String password) {
        return userDAO.queryByNameAndPass(userName, password);
    }
}
