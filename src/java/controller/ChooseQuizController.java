/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.HighScoreDAO;
import daos.QuizDAO;
import dtos.Account;
import dtos.Quiz;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OS
 */
public class ChooseQuizController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "test.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("In.... ChooseQuizController.....");

        String quiz = (String) request.getParameter("QuizID");
        String type = request.getParameter("type");
        HttpSession session=request.getSession();
        HighScoreDAO hsDAO=new HighScoreDAO();
        Account acc=(Account) session.getAttribute("user");
        System.out.println(acc);
        if (acc!=null) {
     
        String highscore = hsDAO.getHighScore( acc.getUserName(), type);
            System.out.println(highscore);
        request.setAttribute("highscore", highscore);
        }
        System.out.println(quiz);
        
        String url = ERROR;

        try {
            QuizDAO dao = new QuizDAO();

            Quiz Quiz;
            if (quiz==null) {
                System.out.println("test....");
                Quiz = dao.getRandomQuiz(type);
                request.setAttribute("QuizID", "Random");
                System.out.println("Ramdon");
            } else {
                Quiz = dao.getQuizbyQuizID(quiz);
                
                request.setAttribute("QuizID", quiz);
            }
            System.out.println(Quiz);
            System.out.println(Quiz.getList().size());
            System.out.println(Quiz.getList().get(0).getContent());
            request.setAttribute("Quiz", Quiz);
            request.setAttribute("type", type);
          
            
            url = SUCCESS;
        } catch (SQLException | NamingException e) {
            log("Error at ChooseQuizController: " + e.getMessage());
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ChooseQuizController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChooseQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ChooseQuizController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChooseQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
