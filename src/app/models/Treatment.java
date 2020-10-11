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
public class Treatment {
    private String goatTag;
    private String treatmentDate;
    private String description;
    private String dateAdded;

    public Treatment() {
    }

    public String getGoatTag() {
        return goatTag;
    }

    public void setGoatTag(String goatTag) {
        this.goatTag = goatTag;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
   
    
}
