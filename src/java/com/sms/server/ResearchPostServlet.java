/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.server;

import com.sms.model.ResearchPost;
import com.sms.events.ResearchPostFunctions;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author lkfaswuser2
 */
public class ResearchPostServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:/uploads";

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
        try {
            String fileName = "";

            ResearchPost researchPost = new ResearchPost();

            ResearchPostFunctions researchPostFunctions = new ResearchPostFunctions();

            String formData[] = new String[3];

            //process only if its multipart content
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new ServletFileUpload(
                                new DiskFileItemFactory()).parseRequest(request);

                    int i = 0;
                    for (FileItem item : multiparts) {
                        if (!item.isFormField()) {
                            fileName = new File(item.getName()).getName();
                            item.write(new File(UPLOAD_DIRECTORY + File.separator + fileName));

                            researchPost.setFileName(fileName);
                        } else {

                            formData[i] = item.getString();
                            System.out.println("FOCCCCCCCCCCC=" + item.getString());
//                            System.out.println("FOCCCCCCCCCCC="+item.getName());
                            i++;
                        }
                    }
                    
                    System.out.println(formData);

                    researchPost.setHeading(formData[1]);
                    researchPost.setDescription(formData[2]);

                    researchPostFunctions.savePost(researchPost);

                    //File uploaded successfully
                    request.setAttribute("message", "File Uploaded Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", "File Upload Failed due to " + ex);
                }

            } else {
                request.setAttribute("message",
                            "Sorry this Servlet only handles file upload request");
            }

            request.getRequestDispatcher("/create_research_post.jsp").forward(request, response);

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
