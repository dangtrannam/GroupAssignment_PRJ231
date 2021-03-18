/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.AnswerDAO;
import daos.QuestionDAO;
import daos.QuizDAO;
import dtos.Answer;
import dtos.Question;
import dtos.Quiz;
import java.io.IOException;
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
    private static final String SUCCESS = "test.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        
        String url = ERROR;

        System.out.println("...In SubmitController...");
        try {
           
            AnswerDAO dao=new AnswerDAO();
            QuestionDAO qdao=new QuestionDAO();
            Quiz quiz=new Quiz();
            ArrayList<String> chosenAns = new ArrayList<>();
            ArrayList<String> results=new ArrayList<>();
            int size=Integer.parseInt(request.getParameter("size"));
            int grade = 0; 
            int i;
            for (i = 0; i < size ; i++) {
                String x = (String) request.getParameter(String.valueOf(i));   
                String y= (String) request.getParameter("q"+String.valueOf(i));
                quiz.getList().add(qdao.getQuestionByID(y));
                if (x != null) {
                    
                    
                    if (x != null && dao.checkAns(x)) {
                        grade++;
                        results.add("bg-success");
                    } else results.add("bg-danger");
                    chosenAns.add(x);
                } else {
                    chosenAns.add("");
                    results.add("bg-secondary");
                }
            }
            
            request.setAttribute("grade", grade);
            request.setAttribute("ChosenAns", chosenAns);
            request.setAttribute("Quiz", quiz);
            request.setAttribute("results", results);
            request.setAttribute("QuizID", request.getParameter("QuizID"));
            for (int j=0; j < chosenAns.size(); j++) {
                System.out.println("choAns" +j+":"+chosenAns.get(j) +" - ");
            }
            
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
        } catch (NamingException | SQLException ex) {
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
        } catch (NamingException | SQLException ex) {
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
