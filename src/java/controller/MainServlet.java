/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;

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

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;

        String action = request.getParameter("action");
//        String login = "login&register.jsp";
//        
//        String main = "MainServlet";
        String welcomepage = "welcomepage.jsp";

        String loginServlet = "LoginController";

        ArrayList<String> loginActions = new ArrayList<String>();
        loginActions.add("Login");
        loginActions.add("Register");
        loginActions.add("handleLogin");
        loginActions.add("handleRegister");
        loginActions.add("Logout");

        try {
            //default page is homepage;
            if (action == null) {
                url = welcomepage;
            } else if (loginActions.contains(action)) {
                request.setAttribute("action", action);
                url = loginServlet;
            } else if (action.equals("viewQuiz")) {
                url = "ViewQuizController";
            } else if (action.equals("ChooseQuiz")) {
                url = "ChooseQuizController";
            } else if (action.equals("Submit")) {
                url = "SubmitController";
            } else if (action.equals("ViewProfileController")) {
                url = "ViewProfileController";
            } else if (action.equals("ChangePasswordController")) {
                url = "ChangePasswordController";
            }else if(action.equals("goAdminpage")){
                url = "ViewAdminpageController";
            }else if(action.equals("DeleteQuiz")){
                request.setAttribute("QuizID", request.getAttribute("QuizID"));
                url = "DeleteQuizController";
            }

        } catch (Exception e) {
            log("Error at Main Controller: " + e.getMessage());
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
