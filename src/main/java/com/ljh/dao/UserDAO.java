package com.ljh.dao;

import com.ljh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {

    //用户登录
    User queryByNameAndPass(String userName,String password);




}
