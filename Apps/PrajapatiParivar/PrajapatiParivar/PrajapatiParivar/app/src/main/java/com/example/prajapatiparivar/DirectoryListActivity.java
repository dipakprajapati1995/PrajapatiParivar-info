package com.example.prajapatiparivar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.prajapatiparivar.adepter.DirectoryAdepter;
import com.example.prajapatiparivar.model.Famaliy_infoModel;
import com.example.prajapatiparivar.response.ResponseAllFamiliInfo;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DirectoryListActivity extends AppCompatActivity {

    List<Famaliy_infoModel> list;
    RecyclerView recyclerView;
    DirectoryAdepter directoryAdepter;
    String mainMemberMobileno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_directory_list);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerDirectory123);




        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            mainMemberMobileno = bundle.getString("midUser");

        }
        Log.d("123654", "onCreate: "+mainMemberMobileno);
        list = new ArrayList<>();
         directoryAdepter = new DirectoryAdepter(getApplicationContext(), list);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseAllFamiliInfo> call = apiService.getuserInfi(mainMemberMobileno);

        call.enqueue(new Callback<ResponseAllFamiliInfo>() {
            @Override
            public void onResponse(Call<ResponseAllFamiliInfo> call, Response<ResponseAllFamiliInfo> response) {
                list = response.body().getMemberinfo();

                recyclerView.setAdapter(new DirectoryAdepter(getApplicationContext(), list));

            }

            @Override
            public void onFailure(Call<ResponseAllFamiliInfo> call, Throwable t) {

            }
        });


    }


}


























