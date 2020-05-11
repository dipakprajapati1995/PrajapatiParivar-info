package com.example.prajapatiparivar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.prajapatiparivar.adepter.MemberAdepter;
import com.example.prajapatiparivar.adepter.NewsAdepter;
import com.example.prajapatiparivar.model.MemberDetailModel;
import com.example.prajapatiparivar.model.NewsModel;
import com.example.prajapatiparivar.response.ResponseAllMemberInfo;
import com.example.prajapatiparivar.response.ResponseNews;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    SuperRecyclerView recyclerView;

    List<NewsModel> newsList = new ArrayList<>();
    NewsAdepter newsAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.newsRecycler);



            newsAdepter = new NewsAdepter(getApplicationContext(), newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseNews> call = apiService.getNews();

       call.enqueue(new Callback<ResponseNews>() {
           @Override
           public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
               newsList=response.body().getNewsDetail();


               recyclerView.setAdapter(new NewsAdepter(getApplicationContext(),newsList));
           }

           @Override
           public void onFailure(Call<ResponseNews> call, Throwable t) {

           }
       });
    }

}
