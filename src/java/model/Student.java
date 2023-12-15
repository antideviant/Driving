/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Student {
    private int studID;
    private String studName;
    private String studPhone;
    private String studPass;
    private String studEmail;
    private String studIC;
    private String studPhoto;
    private String licenseType;

    public Student() {
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudPhone() {
        return studPhone;
    }

    public void setStudPhone(String studPhone) {
        this.studPhone = studPhone;
    }

    public String getStudPass() {
        return studPass;
    }

    public void setStudPass(String studPass) {
        this.studPass = studPass;
    }
    
    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudIC() {
        return studIC;
    }

    public void setStudIC(String studIC) {
        this.studIC = studIC;
    }

    public String getStudPhoto() {
        return studPhoto;
    }

    public void setStudPhoto(String studPhoto) {
        this.studPhoto = studPhoto;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public Student(String studName, String studPhone, String studPass, String studEmail, String studIC, String studPhoto, String licenseType) {
        this.studName = studName;
        this.studPhone = studPhone;
        this.studPass = studPass;
        this.studEmail = studEmail;
        this.studIC = studIC;
        this.studPhoto = studPhoto;
        this.licenseType = licenseType;
    }
    
}
