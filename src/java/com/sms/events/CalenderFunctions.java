/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.events;

import com.sms.model.Ccalender;
import com.sms.server.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lkfaswuser2
 */
public class CalenderFunctions {

    public void saveCalender(Ccalender ccalender) throws Exception {
        String sql = "INSERT INTO `cclender` (\n"
                    + "  `title`,\n"
                    + "  `sstart`,\n"
                    + "  `eend`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "  (\n"
                    + "    '" + ccalender.getTitle() + "',\n"
                    + "    '" + ccalender.getStart() + "',\n"
                    + "    '" + ccalender.getEnd() + "'\n"
                    + "  );\n"
                    + "";

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public void editCalender(Ccalender ccalender) throws Exception {
        String sql = "UPDATE cclender SET"
                    + "    title='" + ccalender.getTitle() + "',\n"
                    + "    sstart='" + ccalender.getStart() + "',\n"
                    + "    eend='" + ccalender.getEnd() + "',\n"
                    + " WHERE index_no='" + ccalender.getIndexNo() + "'    ";

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public ArrayList<Ccalender> getAllDates() throws Exception {

        ArrayList<Ccalender> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM  cclender";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        while (rs.next()) {
            Ccalender post = new Ccalender(
                        rs.getString("title"),
                        rs.getString("sstart"),
                        rs.getString("eend"));

            arrayList.add(post);

        }
        return arrayList;
    }

    public Ccalender getCalenderEvents(String iId) throws Exception {

        String sql = "SELECT * FROM cclender u "
                    + "WHERE u.index_no='" + iId + "' ";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        if (rs.next()) {

            Ccalender event = new Ccalender(
                        rs.getString("title"),
                        rs.getString("sstart"),
                        rs.getString("eend"),
                        rs.getString("venue")
            );
            return event;
        } else {
            return null;
        }

    }
}
