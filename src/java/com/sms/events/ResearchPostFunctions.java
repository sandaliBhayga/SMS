/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.events;

import com.sms.model.ResearchPost;
import com.sms.server.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lkfaswresearchPost2
 */
public class ResearchPostFunctions {

    public void savePost(ResearchPost researchPost) throws Exception {
        String sql = "INSERT INTO `research_post` (\n"
                    + "  `heading`,\n"
                    + "  `des`,\n"
                    + "  `file_name`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "  (\n"
                    + "    '" + researchPost.getHeading() + "',\n"
                    + "    '" + researchPost.getDescription() + "',\n"
                    + "    '" + researchPost.getFileName() + "'\n"
                    + "  );\n"
                    + "";

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public void editPost(ResearchPost researchPost) throws Exception {
        String sql = "UPDATE research_post SET"
                    + "    heading='" + researchPost.getHeading() + "',\n"
                    + "    des='" + researchPost.getDescription() + "',\n"
                    + "    file_name='" + researchPost.getFileName() + "',\n"
                    + " WHERE index_no='" + researchPost.getIndexNo() + "'    ";

        JDBC.con().createStatement().executeUpdate(sql);
    }

    public ArrayList<ResearchPost> getAllPosts() throws Exception {

        ArrayList<ResearchPost> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM  research_post";

        ResultSet rs = JDBC.con().createStatement().executeQuery(sql);
        while (rs.next()) {
            ResearchPost post = new ResearchPost(
                        rs.getString("heading"),
                        rs.getString("des"),
                        rs.getString("file_name"));

            arrayList.add(post);

        }
        return arrayList;
    }

}
