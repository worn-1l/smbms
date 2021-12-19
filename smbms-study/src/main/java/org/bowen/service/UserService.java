package org.bowen.service;

import org.bowen.pojo.User;

/**
 * @author bowencoder
 * @date 2021/12/18 20:22
 */
public interface UserService {

     User login(String userCode,String userPassword);
     public boolean updatePwd(int id, String pwd);
}
