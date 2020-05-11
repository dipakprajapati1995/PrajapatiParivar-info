package com.example.prajapatiparivar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FamilyInfoModel {

    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("main_member_number")
    @Expose
    private String mainMemberNumber;
    @SerializedName("famile_id")
    @Expose
    private String famileId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("meridas_status")
    @Expose
    private String meridasStatus;
    @SerializedName("bod")
    @Expose
    private String bod;
    @SerializedName("study")
    @Expose
    private String study;
    @SerializedName("mossad")
    @Expose
    private String mossad;
    @SerializedName("sasri")
    @Expose
    private String sasri;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("pyramid_address")
    @Expose
    private String pyramidAddress;
    @SerializedName("residential_address")
    @Expose
    private String residentialAddress;
    @SerializedName("mobile_login")
    @Expose
    private String mobileLogin;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("main_member")
    @Expose
    private String mainMember;
    @SerializedName("time_stemp")
    @Expose
    private String timeStemp;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMainMemberNumber() {
        return mainMemberNumber;
    }

    public void setMainMemberNumber(String mainMemberNumber) {
        this.mainMemberNumber = mainMemberNumber;
    }

    public String getFamileId() {
        return famileId;
    }

    public void setFamileId(String famileId) {
        this.famileId = famileId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMeridasStatus() {
        return meridasStatus;
    }

    public void setMeridasStatus(String meridasStatus) {
        this.meridasStatus = meridasStatus;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getMossad() {
        return mossad;
    }

    public void setMossad(String mossad) {
        this.mossad = mossad;
    }

    public String getSasri() {
        return sasri;
    }

    public void setSasri(String sasri) {
        this.sasri = sasri;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPyramidAddress() {
        return pyramidAddress;
    }

    public void setPyramidAddress(String pyramidAddress) {
        this.pyramidAddress = pyramidAddress;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getMobileLogin() {
        return mobileLogin;
    }

    public void setMobileLogin(String mobileLogin) {
        this.mobileLogin = mobileLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMainMember() {
        return mainMember;
    }

    public void setMainMember(String mainMember) {
        this.mainMember = mainMember;
    }

    public String getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(String timeStemp) {
        this.timeStemp = timeStemp;
    }
}
