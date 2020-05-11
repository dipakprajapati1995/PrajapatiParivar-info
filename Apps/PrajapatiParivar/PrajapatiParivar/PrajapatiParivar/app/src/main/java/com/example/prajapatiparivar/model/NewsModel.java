package com.example.prajapatiparivar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("titel")
    @Expose
    private String titel;
    @SerializedName("messag")
    @Expose
    private String messag;
    @SerializedName("pickupload")
    @Expose
    private String pickupload;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getMessag() {
        return messag;
    }

    public void setMessag(String messag) {
        this.messag = messag;
    }

    public String getPickupload() {
        return pickupload;
    }

    public void setPickupload(String pickupload) {
        this.pickupload = pickupload;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @SerializedName("date_time")
    @Expose
    private String dateTime;
}
