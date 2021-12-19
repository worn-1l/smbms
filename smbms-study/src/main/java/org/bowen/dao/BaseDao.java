package org.bowen.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author bowencoder
 * @date 2021/12/18 9:58
 */
public class BaseDao {
    //静态代码块,在类加载的时候执行
    static {
        init();
    }

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //初始化连接参数,从配置文件里获得
    public static void init(){
        Properties properties = new Properties();
        String configFile = "db.properties";
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection =null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }


    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
            preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i <params.length ; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
         resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i <params.length ; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;
        if (resultSet != null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return false;
    }


}
