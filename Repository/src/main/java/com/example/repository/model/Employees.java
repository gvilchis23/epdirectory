
package com.example.repository.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Employees implements Serializable{

    @SerializedName("uuid")
    private String uuid;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("email_address")
    private String emailAddress;
    @SerializedName("biography")
    private String biography;
    @SerializedName("photo_url_small")
    private String photoUrlSmall;
    @SerializedName("photo_url_large")
    private String photoUrlLarge;
    @SerializedName("team")
    private String team;
    @SerializedName("employee_type")
    private String employeeType;

    public Employees() {
    }

    public Employees(String uuid, String fullName, String phoneNumber, String emailAddress, String biography, String photoUrlSmall, String photoUrlLarge, String team, String employeeType) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.biography = biography;
        this.photoUrlSmall = photoUrlSmall;
        this.photoUrlLarge = photoUrlLarge;
        this.team = team;
        this.employeeType = employeeType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoUrlSmall() {
        return photoUrlSmall;
    }

    public void setPhotoUrlSmall(String photoUrlSmall) {
        this.photoUrlSmall = photoUrlSmall;
    }

    public String getPhotoUrlLarge() {
        return photoUrlLarge;
    }

    public void setPhotoUrlLarge(String photoUrlLarge) {
        this.photoUrlLarge = photoUrlLarge;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}
