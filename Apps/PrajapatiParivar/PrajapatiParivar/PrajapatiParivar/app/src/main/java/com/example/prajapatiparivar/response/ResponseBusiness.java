package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.BusinessModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBusiness {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("businessDetail")
    @Expose
    private List<BusinessModel> businessDetail = null;

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

    public List<BusinessModel> getBusinessDetail() {
        return businessDetail;
    }

    public void setBusinessDetail(List<BusinessModel> businessDetail) {
        this.businessDetail = businessDetail;
    }
}
