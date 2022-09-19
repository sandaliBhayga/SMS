/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.events;

import com.sms.model.User;
import com.sms.server.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lkfaswuser2
 */
public class UserFunctions {

    public void saveUser(User user) throws Exception {
        String sql = "INSERT INTO `user` (\n"
                    + "  `name`,\n"
                    + "  `email`,\n"
                    + "  `password`,\n"
                    + "  `type`\n"
                    + ")\n"
                    + " VALUES \n"
                    + "  (\n"
                    + "    '" + user.getName() + "',\n"
                    + "    '" + user.getEmail() + "',\n"
                    + "    '" + user.getPassword() + "',\n"
                    + "    '" + user.getType() + "'\n"
                    + "  );\n"
                    + "";

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public void editUser(User user) throws Exception {
        String sql = "UPDATE user SET"
                    + "    name='" + user.getName() + "',\n"
                    + "    email='" + user.getEmail() + "',\n"
                    + "    password='" + user.getPassword() + "',\n"
                    + "    type='" + user.getType() + "'\n"
                    + " WHERE index_no='" + user.getIndexNo() + "'    ";

        System.out.println(sql);
        
        JDBC.con().createStatement().executeUpdate(sql);
    }

    public User checkUser(String email, String password) throws Exception {

        String sql = "SELECT * FROM user u "
                    + "WHERE u.email='" + email + "' "
                    + "AND u.password='" + password + "' ";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        if (rs.next()) {

            User user = new User(
                        rs.getString("index_no"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
            );
            return user;
        } else {
            return null;
        }

    }

    public ArrayList<User> getAllUsers(String type) throws Exception {

        ArrayList<User> arrayList = new ArrayList<>();

        String sql = "SELECT * FROM user u "
                    + "WHERE u.type='" + type + "' ";

        System.out.println(sql);

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        while (rs.next()) {

            User user = new User(
                        rs.getString("index_no"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
            );
            arrayList.add(user);

        }
        return arrayList;
    }

    public User getUser(String iId) throws Exception {

        String sql = "SELECT * FROM user u "
                    + "WHERE u.index_no='" + iId + "' ";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        if (rs.next()) {

            User user = new User(
                        rs.getString("index_no"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
            );
            return user;
        } else {
            return null;
        }

    }

}
