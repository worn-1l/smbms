package org.bowen.dao.impl;

import org.bowen.dao.BaseDao;
import org.bowen.dao.UserDao;
import org.bowen.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bowencoder
 * @date 2021/12/18 19:40
 */
public class UserDaoImpl implements UserDao {
//    private static final String GET_USER_BY_USERCODE= "SELECT * from smbms_user where userCode=?";
//    private static final String UPDATEPWD = "UPDATE smbms_user SET userPassword =? WHERE id =? ";

    public User getLoginUser(Connection connection, String userCode)
            throws Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if(null != connection){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    public int updatePwd(Connection connection, int id, String pwd) throws Exception {
        System.out.println("UserDaoImpl"+pwd);

        int flag = 0;
        PreparedStatement pStatement = null;
        if(connection != null){
            String sql = "update smbms_user set userPassword= ? where id = ?";
            Object[] params = {pwd,id};
            flag = BaseDao.execute(connection, pStatement, sql, params);
            BaseDao.closeResource(null, pStatement, null);
        }
        return flag;

    }


}
