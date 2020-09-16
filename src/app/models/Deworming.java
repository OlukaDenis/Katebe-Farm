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
public class Deworming {
    private String goatTag;
    private String dewormingDate;
    private String dewormUsed;
    private String doseAdministered;
    private String nextDueDate;

    public Deworming() {
    }

    public String getGoatTag() {
        return goatTag;
    }

    public void setGoatTag(String goatTag) {
        this.goatTag = goatTag;
    }
    

    public String getDewormingDate() {
        return dewormingDate;
    }

    public void setDewormingDate(String dewormingDate) {
        this.dewormingDate = dewormingDate;
    }

    public String getDewormUsed() {
        return dewormUsed;
    }

    public void setDewormUsed(String dewormUsed) {
        this.dewormUsed = dewormUsed;
    }

    public String getDoseAdministered() {
        return doseAdministered;
    }

    public void setDoseAdministered(String doseAdministered) {
        this.doseAdministered = doseAdministered;
    }

    public String getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(String nextDueDate) {
        this.nextDueDate = nextDueDate;
    }
    
    
    
}
