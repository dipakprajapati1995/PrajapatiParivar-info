package com.example.prajapatiparivar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessModel {
    @SerializedName("business_id")
    @Expose
    private String businessId;
    @SerializedName("businessCard")
    @Expose
    private String businessCard;
    @SerializedName("firm")
    @Expose
    private String firm;
    @SerializedName("ownerName")
    @Expose
    private String ownerName;
    @SerializedName("serviceArea")
    @Expose
    private String serviceArea;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("products")
    @Expose
    private String products;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("holiday")
    @Expose
    private String holiday;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("webside")
    @Expose
    private String webside;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getWebside() {
        return webside;
    }

    public void setWebside(String webside) {
        this.webside = webside;
    }
}
