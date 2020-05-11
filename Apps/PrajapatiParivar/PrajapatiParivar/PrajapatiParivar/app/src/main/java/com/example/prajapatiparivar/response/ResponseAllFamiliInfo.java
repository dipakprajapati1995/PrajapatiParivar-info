package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.Famaliy_infoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAllFamiliInfo {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("memberinfo")
    @Expose
    private List<Famaliy_infoModel> memberinfo = null;

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

    public List<Famaliy_infoModel> getMemberinfo() {
        return memberinfo;
    }

    public void setMemberinfo(List<Famaliy_infoModel> memberinfo) {
        this.memberinfo = memberinfo;
    }
}
