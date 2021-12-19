package org.bowen.dao;

import org.bowen.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bowencoder
 * @date 2021/12/18 19:39
 */
public interface UserDao {

    public User getLoginUser(Connection connection,String userCode)throws Exception;

     //修改当前用户密码
    public int updatePwd(Connection connection, int id, String pwd)throws Exception;



}
