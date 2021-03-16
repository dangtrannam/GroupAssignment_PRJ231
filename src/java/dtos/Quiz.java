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
public class Quiz {

    private ArrayList<Question> list;

    public Quiz() {
        list = new ArrayList();
    }

    public Quiz(ArrayList<Question> list) {
        this.list = list;
    }

    public ArrayList<Question> getList() {
        return list;
    }

    public void setList(ArrayList<Question> list) {
        this.list = list;
    }

}
