package com.example.prajapatiparivar.response;

import com.example.prajapatiparivar.model.NewsModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNews {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("NewsDetail")
    @Expose
    private List<NewsModel> newsDetail = null;

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

    public List<NewsModel> getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(List<NewsModel> newsDetail) {
        this.newsDetail = newsDetail;
    }
}
