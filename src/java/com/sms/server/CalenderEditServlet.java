/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.server;

import com.sms.events.AnnualEventFunctions;
import com.sms.events.CalenderFunctions;
import com.sms.model.AnnuEvents;
import com.sms.model.Ccalender;
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
public class CalenderEditServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            CalenderFunctions Functions = new CalenderFunctions();

            String mode = request.getParameter("mode");

            if (mode.equals("load")) {

                String type = request.getParameter("user_type");
                ArrayList<Ccalender> Eventss = Functions.getAllDates();
                System.out.println("allUsersallUsersallUsersallUsersallUsers=" + Eventss.size());

                String _return = "";

                _return += "<table class='table'> <thead> <tr>";
                _return += " <th scope='col'>#</th>";
                _return += " <th scope='col'>Name</th>";
                _return += " <th scope='col'>Date</th>";
                _return += " <th scope='col'>University</th>";
                _return += " <th scope='col'>Action</th>";
                _return += " </tr>";
                _return += " </thead>";
                _return += "<tbody>";

                int i = 0;
                for (Ccalender usr : Eventss) {
                    i++;
                    _return += "  <tr>";
                    _return += "<th scope='row'>" + i + "</th>";
                    _return += " <td>" + usr.getTitle() + "</td>";
                    _return += " <td>" + usr.getStart() + "</td>";
                    _return += " <td>" + usr.getEnd() + "</td>";
                    _return += " <td> <div class='btn-group'>\n"
                                + "    <button type='button' class='btn btn-primary' onClick='doEdit(" + usr.getIndexNo() + ")' >Edit</button>\n"
                                + "    <button type='button' class='btn btn-danger' onClick='doDelete(" + usr.getIndexNo() + ")' >Delete</button>\n"
                                + "  </div></td>";
                    _return += " </tr>";

                }
                _return += " </tbody>";
                _return += "</table>";

                response.getWriter().write(_return);

            } else if (mode.equals("edit")) {

                String _returnUser = "";

                String id = request.getParameter("id");

                Ccalender events = Functions.getCalenderEvents(id);

                _returnUser
                            += events.getIndexNo() + "~@~"
                            + events.getTitle() + "~@~"
                            + events.getStart() + "~@~"
                            + events.getEnd();

                response.getWriter().write(_returnUser);
            }
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
