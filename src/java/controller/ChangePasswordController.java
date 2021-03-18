/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.AccountDAO;
import dtos.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author macbookpro2018
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {

    private static String ERROR = "error.jsp";
    private static String SUCCESS = "profile.jsp";
    private static String INVALID = "login&register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {

            HttpSession session = request.getSession(false);
            Account user = (Account) session.getAttribute("user");
            if (user != null) {
                String confirm = request.getParameter("confirm") == null ? "" : request.getParameter("confirm");
                if (confirm.equals("confirm")) {
                    
                    String password = (String) request.getParameter("Password");
                    String repassword = (String) request.getParameter("re-Password");
                    System.out.println(password);
                    
                    if(password.equals(repassword)){
                        AccountDAO accDao = new AccountDAO();
                        boolean check = accDao.changePassword(new Account( user.getUserName(),password,user.getRole() ));
                        if (check) {
                            url = "home.jsp";
                        }
                    }else{
                        request.setAttribute("ERROR", "");
                        url = "profile.jsp";
                    }
                    
                } else {
                    request.setAttribute("state", "changePassword");
                    url = SUCCESS;
                }

            } else {
                request.setAttribute("INVALID", "<p class='text-danger'>You don't have permission to use this function!</p>");
                url = INVALID;
            }

        } catch (Exception e) {
            log("Error at ChangePassword Controller" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
