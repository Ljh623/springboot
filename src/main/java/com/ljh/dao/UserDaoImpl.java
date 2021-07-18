package com.ljh.dao;
import com.ljh.entity.User;
import com.ljh.jdbcUtil.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDaoImpl implements UserDAO {

    //用户登录
    @Override
    public User queryByNameAndPass(String userName, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getCon();
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            User user = null;
            while(rs.next()) {
                user =  new User();
                user.setId(rs.getInt("Id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null, pstmt, rs);
        }
        return null;
    }
}
