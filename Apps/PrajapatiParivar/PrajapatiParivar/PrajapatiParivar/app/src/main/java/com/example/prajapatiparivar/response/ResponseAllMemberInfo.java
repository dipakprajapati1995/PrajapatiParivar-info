package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.MemberDetailModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAllMemberInfo {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("MemberDetail")
    @Expose
    private List<MemberDetailModel> memberDetail = null;

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

    public List<MemberDetailModel> getMemberDetail() {
        return memberDetail;
    }

    public void setMemberDetail(List<MemberDetailModel> memberDetail) {
        this.memberDetail = memberDetail;
    }
}
