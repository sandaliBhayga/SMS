/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.events;

import com.sms.model.AnnuEvents;
import com.sms.server.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lkfaswuser2
 */
public class AnnualEventFunctions {

    public void saveAnnualEvent(AnnuEvents annuEvents) throws Exception {
        String sql = "INSERT INTO `event` (\n"
                    + "  `name`,\n"
                    + "  `datetime`,\n"
                    + "  `university`,\n"
                    + "  `venue`,\n"
                    + "  `remark`,\n"
                    + "  `location`,\n"
                    + "  `type`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "  (\n"
                    + "    '" + annuEvents.getName() + "',\n"
                    + "    '" + annuEvents.getDate() + "',\n"
                    + "    '" + annuEvents.getUniversity() + "',\n"
                    + "    '" + annuEvents.getVenue() + "',\n"
                    + "    '" + annuEvents.getRemark() + "',\n"
                    + "    '" + annuEvents.getLocation() + "',\n"
                    + "    '" + annuEvents.getType() + "'\n"
                    + "  );\n"
                    + "";
        
        System.out.println(sql);

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public void editAnnualEvent(AnnuEvents annuEvents) throws Exception {
        String sql = "UPDATE event SET"
                    + "    name='" + annuEvents.getName() + "',\n"
                    + "    datetime='" + annuEvents.getDate() + "',\n"
                    + "    university='" + annuEvents.getUniversity() + "',\n"
                    + "    venue='" + annuEvents.getVenue() + "',\n"
                    + "    remark='" + annuEvents.getRemark() + "',\n"
                    + "    location='" + annuEvents.getLocation() + "',\n"
                    + "    type='" + annuEvents.getType() + "'\n"
                    + " WHERE index_no='" + annuEvents.getIndexNo() + "'    ";

        System.out.println(sql);

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public ArrayList<AnnuEvents> getAllAnnuEventss() throws Exception {

        ArrayList<AnnuEvents> arrayList = new ArrayList<>();

        String sql = "SELECT * FROM event u ";

        System.out.println(sql);

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        while (rs.next()) {

            AnnuEvents event = new AnnuEvents(
                        rs.getString("index_no"),
                        rs.getString("name"),
                        rs.getString("datetime"),
                        rs.getString("venue"),
                        rs.getString("remark"),
                        rs.getString("location"),
                        rs.getString("type"),
                        rs.getString("university")
            );
            arrayList.add(event);

        }
        return arrayList;
    }

    public AnnuEvents getAnnuEvents(String iId) throws Exception {

        String sql = "SELECT * FROM event u "
                    + "WHERE u.index_no='" + iId + "' ";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        if (rs.next()) {

            AnnuEvents event = new AnnuEvents(
                        rs.getString("index_no"),
                        rs.getString("name"),
                        rs.getString("datetime"),
                        rs.getString("venue"),
                        rs.getString("remark"),
                        rs.getString("location"),
                        rs.getString("type"),
                        rs.getString("university")
            );
            return event;
        } else {
            return null;
        }

    }
}
