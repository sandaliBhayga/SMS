/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author lkfaswuser2
 */
public class JDBC {

    public static Connection con() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
        return c;
    }

    public static void putData(String sql) throws Exception {
        con().createStatement().executeUpdate(sql);
    }

    public static ResultSet getData(String sql) throws Exception {
        ResultSet rs = con().createStatement().executeQuery(sql);
        return rs;
    }

    public static void main(String[] args) {
        try {
            ResultSet rs = con().createStatement().executeQuery("select * from `user`");
            while (rs.next()) {                
                System.out.println("AAAAAAAAAAAAA=="+rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
