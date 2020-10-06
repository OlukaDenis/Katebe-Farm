/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author Eco
 */
public class Expense {
    private String expenseDate;
    private String item;
    private int cost;
    private String goatTag;

    public Expense() {
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public String getGoatTag() {
        return goatTag;
    }

    public void setGoatTag(String goatTag) {
        this.goatTag = goatTag;
    }

         
    
}
