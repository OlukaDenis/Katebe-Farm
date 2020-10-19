/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author denis
 */
public class Dipping {
    private String dippingDate;
    private String comments;
    private String goatTag;

    public Dipping() {
    }

    public void setDippingDate(String dippingDate) {
        this.dippingDate = dippingDate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setGoatTag(String goatTag) {
        this.goatTag = goatTag;
    }

    public String getDippingDate() {
        return dippingDate;
    }

    public String getComments() {
        return comments;
    }

    public String getGoatTag() {
        return goatTag;
    }
    
    
    
}
