
package app.models;

import java.io.File;

public class Goat {
    private String ID;
    private String name;
    private String breed;
    private String sex;
    private String birthDate;
    private String source;
    private String buck_id;
    private String doe_id;
    private byte[] image_front;
    private byte[] image_side;
    private byte[] image_rear;

    public Goat() {
    }
    
    public Goat(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBuck_id() {
        return buck_id;
    }

    public void setBuck_id(String buck_id) {
        this.buck_id = buck_id;
    }

    public String getDoe_id() {
        return doe_id;
    }

    public void setDoe_id(String doe_id) {
        this.doe_id = doe_id;
    }

    public byte[] getImage_front() {
        return image_front;
    }

    public void setImage_front(byte[] image_front) {
        this.image_front = image_front;
    }

    public byte[] getImage_side() {
        return image_side;
    }

    public void setImage_side(byte[] image_side) {
        this.image_side = image_side;
    }

    public byte[] getImage_rear() {
        return image_rear;
    }

    public void setImage_rear(byte[] image_rear) {
        this.image_rear = image_rear;
    }

    

    
}
