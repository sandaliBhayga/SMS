/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.server;

import com.sms.model.ResearchPost;
import com.sms.events.ResearchPostFunctions;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lkfaswuser2
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String _return = "";

            ResearchPostFunctions functions = new ResearchPostFunctions();

            ArrayList<ResearchPost> allPosts = functions.getAllPosts();

            int i = 0;
            for (ResearchPost post : allPosts) {
                if (i == 0) {
                    _return += "<div class='item active'  >";
                } else {
                    _return += "<div class='item'  >";
                }

                _return += "<h2 class='text-center' >" + post.getHeading() + "</h2>";
                _return += "<p style='padding: 20px'>" + post.getDescription() + "</p>";
                _return += "<div style='padding-left: 40%'>";
                _return += "<a class='btn btn-primary' href='FileDownloadServlet?fileName=" + post.getFileName() + "'> <span class='glyphicon glyphicon-envelope'> </span> Download Documents </a>";
                _return += " </div> </div>";

                i++;
            }

            response.getWriter().write(_return);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
