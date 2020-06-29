package com.zr.servlet.dao;

import com.zr.servlet.bean.User;
import com.zr.servlet.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static void main(String[] args) {

    }

    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();

            String sql = "select * from tb_user";

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                userList.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.closeAll(resultSet, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userList;
    }

    public User getOneUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from tb_user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.closeAll(resultSet, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from tb_user where id = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("Successful execution");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.closeAll(null, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public void insertOne(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();

            String sql = "INSERT INTO `tb_user` VALUES (?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
            System.out.println("Successful execution");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.closeAll(null, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void UpdateOne(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();

            String sql = "update tb_user set username = ?,password = ? where id = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
            System.out.println("Successful execution");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.closeAll(null, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
