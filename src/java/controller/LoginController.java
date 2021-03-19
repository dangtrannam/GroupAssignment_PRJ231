package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        String login = "login&register.jsp";
        String main = "MainServlet";

        String success = "welcomepage.jsp";
        String url = ERROR;
        
        if (action == null) {
            url = main;
        } else {
            url = login;
        }

        try {
            if (action.equals("Register")) {
                request.setAttribute("action", "Register");

            } else if (action.equals("Login")) {
                request.setAttribute("action", "Login");

            } else if (action.equals("handleLogin")) {

                String userForm = request.getParameter("uname");
                String passForm = request.getParameter("psw");
                Account acc = new Account(userForm, passForm, "");
                AccountDAO accDAO = new AccountDAO();
                acc.setRole(accDAO.login(acc));

                if (!acc.getRole().isEmpty()) {

                    url = success;
                    HttpSession session = request.getSession();
                    session.setAttribute("user", acc);

                } else {
                    request.removeAttribute("action");
                    request.setAttribute("action", "Login");
                    request.setAttribute("msg", "<p class='text-danger'>Login failed!</p>");
                }

            } else if (action.equals("Logout")) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.removeAttribute("user");
                    request.setAttribute("action", "Login");
                    url = "welcomepage.jsp";
                }
            } else if (action.equals("handleRegister")) {
                String userForm = request.getParameter("uname");
                String passForm = request.getParameter("psw");
                String repassForm = request.getParameter("re-psw");

                String msg = "<p class='text-danger'>Register failed!</p>";

                if (passForm.equals(repassForm)) {
                    Account acc = new Account(userForm, passForm, "user");
                    AccountDAO accDAO = new AccountDAO();
                    if (accDAO.register(acc)) {
                        msg = "<p class='text-success'>Register success!</p>";
                    }
                }

                request.setAttribute("msg", msg);
                request.setAttribute("action", "Login");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
