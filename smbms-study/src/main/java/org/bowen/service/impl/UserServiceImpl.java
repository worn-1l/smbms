package org.bowen.service.impl;

import org.bowen.dao.BaseDao;
import org.bowen.dao.UserDao;
import org.bowen.dao.impl.UserDaoImpl;
import org.bowen.pojo.User;
import org.bowen.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author bowencoder
 * @date 2021/12/18 20:26
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        if (null != user) {
            if (!user.getUserPassword().equals(userPassword)) {
                user = null;
            }
        }

        return user;
    }

    public boolean updatePwd(int id, String pwd) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            if (userDao.updatePwd(connection, id, pwd) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
