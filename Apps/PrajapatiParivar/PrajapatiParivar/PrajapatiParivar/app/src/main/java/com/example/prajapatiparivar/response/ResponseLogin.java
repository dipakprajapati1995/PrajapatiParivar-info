package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.UserInfoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseLogin {

    public ResponseLogin(String success, String message, List<UserInfoModel> userinfo) {
        this.success = success;
        this.message = message;
        this.userinfo = userinfo;
    }

    @SerializedName("success")
    @Expose
    private String success;

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

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userinfo")
    @Expose
    private List<UserInfoModel> userinfo = new ArrayList();

    public List<UserInfoModel> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(List<UserInfoModel> userinfo) {
        this.userinfo = userinfo;
    }
}