/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.events;

import com.sms.server.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lkfaswuser2
 */
public class UniversityFunctions {

    public static ArrayList<String> getAllUniversities() throws Exception {

        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM `user` u WHERE u.`type`='UNIVERSITY'";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        while (rs.next()) {
            arrayList.add(rs.getString("name"));

        }
        return arrayList;
    }
}
