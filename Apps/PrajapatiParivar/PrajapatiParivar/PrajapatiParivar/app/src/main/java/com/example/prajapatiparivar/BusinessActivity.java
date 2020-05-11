package com.example.prajapatiparivar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prajapatiparivar.adepter.BusinessAdepter;
import com.example.prajapatiparivar.model.BusinessModel;
import com.example.prajapatiparivar.response.ResponseBusiness;
import com.example.prajapatiparivar.response.ResponseNews;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BusinessModel> businessModelList=new ArrayList<>();
BusinessAdepter  businessAdepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        recyclerView = findViewById(R.id.BusinessRecycler);

        businessAdepter=new BusinessAdepter(getApplicationContext(),businessModelList);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBusiness> call = apiService.getBusiness();
        call.enqueue(new Callback<ResponseBusiness>() {
            @Override
            public void onResponse(Call<ResponseBusiness> call, Response<ResponseBusiness> response) {


                businessModelList=response.body().getBusinessDetail();
                recyclerView.setAdapter(new BusinessAdepter(getApplicationContext(),businessModelList));
            }

            @Override
            public void onFailure(Call<ResponseBusiness> call, Throwable t) {

            }
        });

    }
}
