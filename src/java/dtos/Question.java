/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.ArrayList;

/**
 *
 * @author OS
 */
public class Question {
 private String ID;
 private String QuizID;
 private String Content;
 private String url;
 private ArrayList<Answer> ListAnswer;

    public Question(String ID, String QuizID, String Content, String url, ArrayList<Answer> ListAnswer) {
        this.ID = ID;
        this.QuizID = QuizID;
        this.Content = Content;
        this.url = url;
        this.ListAnswer = ListAnswer;
    }
   

    public Question() {
        ID="";
        QuizID="";
        Content="";
        url="";
    }

    public String getID() {
        return ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQuizID() {
        return QuizID;
    }

    public void setQuizID(String QuizID) {
        this.QuizID = QuizID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
     public ArrayList<Answer> getListAnswer() {
        return ListAnswer;
    }

    public void setListAnswer(ArrayList<Answer> ListAnswer) {
        this.ListAnswer = ListAnswer;
    }
}
