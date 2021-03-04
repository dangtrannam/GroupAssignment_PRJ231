/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.AccountDAO;
import dtos.Account;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macbookpro2018
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String login = "login&register.jsp";
        String main = "MainServlet";
        String home = "home.jsp";
        if (action == null) {
            action = "Register";
        }

        try {
            if (action.equals("Register")) {

                request.setAttribute("action", "Register");
                RequestDispatcher rd = request.getRequestDispatcher(login);
                rd.forward(request, response);

            } else if (action.equals("handleLogin")) {

                String userForm = request.getParameter("uname");
                String passForm = request.getParameter("psw");
                Account acc = new Account(userForm, passForm, "");
                AccountDAO accDAO = new AccountDAO();
                acc.setRole(accDAO.login(acc));

                if (!acc.getRole().isEmpty()) {
                    response.sendRedirect(home);
                } else {
                    request.setAttribute("action", "Login");
                    request.setAttribute("alert", "Login failed!");

                    RequestDispatcher rd = request.getRequestDispatcher(login);
                    rd.forward(request, response);
                }
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
