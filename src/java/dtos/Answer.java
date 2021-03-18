/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author OS
 */
public class Answer {
    private String QuestionID;
    private String Content;
    private String isCorrect;
    private String ID;
    public Answer() {
    QuestionID = "";
    Content="";
    isCorrect="";
    ID="";
    }
    
    public Answer(String QuestionID, String Content, String isCorrect) {
        this.QuestionID = QuestionID;
        this.Content = Content;
        this.isCorrect = isCorrect;
    }

    public Answer(String QuestionID, String Content, String isCorrect, String ID) {
        this.QuestionID = QuestionID;
        this.Content = Content;
        this.isCorrect = isCorrect;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(String QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    
}
