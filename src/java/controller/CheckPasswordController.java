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

/**
 *
 * @author macbookpro2018
 */
@WebServlet(name = "CheckPasswordController", urlPatterns = {"/CheckPasswordController"})
public class CheckPasswordController extends HttpServlet {

    private static String ERROR = "error.js";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String password = request.getParameter("Password") == null ? "" : request.getParameter("Password");
            String repassword = request.getParameter("re-Password") == null ? "" : request.getParameter("re-Password");

            //If password or re-password is empty -> send back the msg
            if (password.isEmpty()) {
                request.setAttribute("emptyPass", "<p class='text-danger'>This should not be empty!</p>");
                url = "profile.jsp";
                request.setAttribute("state", "changePassword");
            }
            if (repassword.isEmpty()) {
                request.setAttribute("emptyRePass", "<p class='text-danger'>This should not be empty!</p>");
                url = "profile.jsp";
                request.setAttribute("state", "changePassword");
                
            } else {
                if (password.equals(repassword)) {
                    AccountDAO accDao = new AccountDAO();
                    
                    Account user = (Account) request.getSession(false).getAttribute("user");
                    boolean check = accDao.changePassword(new Account(user.getUserName(), password, user.getRole()));
                    if (check) {
                        url = "home.jsp";
                    }
                } else {
                    request.setAttribute("ERROR", "");
                    url = "profile.jsp";
                }
            }

        }catch(Exception e){
            log("Error at Check password Controller: "+e.getMessage());
        }
        finally {
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
