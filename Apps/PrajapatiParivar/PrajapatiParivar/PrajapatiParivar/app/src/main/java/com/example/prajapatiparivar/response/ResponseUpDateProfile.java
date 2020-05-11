package com.example.prajapatiparivar.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUpDateProfile {
    @SerializedName("image")
    private String image;

    @SerializedName("main_member_number")
    private String main_member_number;

    @SerializedName("famile_id")
    private String famile_id;

    @SerializedName("name")
    private String name;

    @SerializedName("relation")
    private String relation;

    @SerializedName("meridas_status")
    private String meridas_status;

    @SerializedName("bod")
    private String bod;

    @SerializedName("study")
    private String study;

    @SerializedName("mossad")
    private String mossad;

    @SerializedName("sasri")
    private String sasri;

    @SerializedName("blood_group")
    private String blood_group;

    @SerializedName("pyramid_address")
    private String pyramid_address;

    @SerializedName("mobile_login")
    private String mobile_login;

    @SerializedName("mid")
    private String mid;


    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
