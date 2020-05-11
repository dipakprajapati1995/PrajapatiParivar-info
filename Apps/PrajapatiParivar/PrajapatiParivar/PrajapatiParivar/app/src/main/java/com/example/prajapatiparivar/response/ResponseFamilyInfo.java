package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.FamilyInfoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFamilyInfo {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("familyinfo")
    @Expose
    private List<FamilyInfoModel> familyinfo = null;

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

    public List<FamilyInfoModel> getFamilyinfo() {
        return familyinfo;
    }

    public void setFamilyinfo(List<FamilyInfoModel> familyinfo) {
        this.familyinfo = familyinfo;
    }
}