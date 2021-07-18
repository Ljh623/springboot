package com.ljh.service;

public interface UserService {

    //用户登录
    boolean queryByNameAndPass(String userName, String password);

}
