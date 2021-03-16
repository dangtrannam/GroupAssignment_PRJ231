/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.QuizDAO;
import dtos.Answer;
import dtos.Question;
import dtos.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OS
 */
public class SubmitController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String QuizID = (String) request.getParameter("QuizID");
        String url = ERROR;
        System.out.println("abc");
        try {
            QuizDAO dao = new QuizDAO();
            Quiz quiz = dao.getQuizbyQuizID(QuizID);
            ArrayList<Question> questions = quiz.getList();
            ArrayList<Integer> chosenAns=new ArrayList<>();
            int grade = 0;
            int i;
            for (i = 0; i < questions.size(); i++) {
                String x = (String) request.getParameter(String.valueOf(i));
                if (x != null) {
                    
                    Question q = questions.get(i);
                    Answer ans = q.getListAnswer().get(Integer.parseInt(x));
                    if (ans != null && ans.getIsCorrect().trim().equals("true")) {
                        grade++;
                    }
                    chosenAns.add(Integer.parseInt(x));
                } else chosenAns.add(-1);
            }
            request.setAttribute("grade", grade);
            request.setAttribute("ChosenAns", chosenAns);
            request.setAttribute("Quiz", quiz);
            url = "test.jsp";
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
            Logger.getLogger(SubmitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubmitController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubmitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubmitController.class.getName()).log(Level.SEVERE, null, ex);
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
