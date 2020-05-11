package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.MemberinfoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMamberInfo {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("memberinfo")
    @Expose
    private List<MemberinfoModel> memberinfo = null;


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

    public List<MemberinfoModel> getMemberinfo() {
        return memberinfo;
    }

    public void setMemberinfo(List<MemberinfoModel> memberinfo) {
        this.memberinfo = memberinfo;
    }
}
