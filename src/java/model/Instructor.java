/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author PC
 */
public class Instructor {
    
    private int instID;
    private String instPassword;
    private String instEmail;
    private String instName;
    private String instPhone;
    private String instPhoto;

    public String getInstEmail() {
        return instEmail;
    }

    public void setInstEmail(String instEmail) {
        this.instEmail = instEmail;
    }
    
    public Instructor() {
    }

    public int getInstID() {
        return instID;
    }

    public void setInstID(int instID) {
        this.instID = instID;
    }

    public String getInstPassword() {
        return instPassword;
    }

    public void setInstPassword(String instPassword) {
        this.instPassword = instPassword;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getInstPhone() {
        return instPhone;
    }

    public void setInstPhone(String instPhone) {
        this.instPhone = instPhone;
    }

    public String getInstPhoto() {
        return instPhoto;
    }

    public void setInstPhoto(String instPhoto) {
        this.instPhoto = instPhoto;
    }

    public Instructor(String instPassword, String instName, String instPhone, String instPhoto, String instEmail) {
        this.instPassword = instPassword;
        this.instName = instName;
        this.instPhone = instPhone;
        this.instPhoto = instPhoto;
        this.instEmail = instEmail;
    }
}
