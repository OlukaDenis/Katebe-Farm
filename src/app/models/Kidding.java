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
public class Kidding {
    private int id;
    private String goatTag;
    private String tattoo;
    private String dateBred;
    private String kiddingDate;
    private String kidName;
    private String kidSire;
    private String sex;
    private double birthWeight;
    private String dateAdded;

    public Kidding() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getGoatTag() {
        return goatTag;
    }

    public void setGoatTag(String goatTag) {
        this.goatTag = goatTag;
    }

    public String getTattoo() {
        return tattoo;
    }

    public void setTattoo(String tattoo) {
        this.tattoo = tattoo;
    }

    public String getDateBred() {
        return dateBred;
    }

    public void setDateBred(String dateBred) {
        this.dateBred = dateBred;
    }

    public String getKiddingDate() {
        return kiddingDate;
    }

    public void setKiddingDate(String kiddingDate) {
        this.kiddingDate = kiddingDate;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public String getKidSire() {
        return kidSire;
    }

    public void setKidSire(String kidSire) {
        this.kidSire = kidSire;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(double birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    
    
}
