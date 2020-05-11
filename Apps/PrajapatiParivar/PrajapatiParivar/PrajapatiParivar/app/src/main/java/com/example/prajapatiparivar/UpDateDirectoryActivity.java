package com.example.prajapatiparivar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prajapatiparivar.adepter.FamliyAdepter;
import com.example.prajapatiparivar.model.FamilyInfoModel;
import com.example.prajapatiparivar.response.ResponseFamilyInfo;
import com.example.prajapatiparivar.response.ResponseLogin;
import com.example.prajapatiparivar.response.ResponseUpdatePass;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpDateDirectoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SessionManager session;
    List<FamilyInfoModel> movies = new ArrayList<>();
    FamliyAdepter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        session = new SessionManager(getApplicationContext());

        recyclerView = findViewById(R.id.recyclerDirectory);

        mAdapter = new FamliyAdepter(movies, getApplicationContext());

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();
        String main_mamber_id = user.get(SessionManager.mainMemberNumber);
        String famili_id = user.get(SessionManager.familyID);



        Log.d("asd1", "apiCalling: main_mamber_id " + main_mamber_id);
        Log.d("asd1", "apiCalling: famili_id  " + famili_id);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                FamilyInfoModel familyInfoModel = movies.get(position);
                Toast.makeText(getApplicationContext(), familyInfoModel.getUserName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MemberFullDetailActivity.class);
                intent.putExtra("mid",familyInfoModel.getMid());
                intent.putExtra("img", familyInfoModel.getImage());
                intent.putExtra("name", familyInfoModel.getUserName());
                intent.putExtra("bod", familyInfoModel.getBod());
                intent.putExtra("study1", familyInfoModel.getStudy());
                intent.putExtra("maridstatus", familyInfoModel.getMeridasStatus());
                intent.putExtra("sasri", familyInfoModel.getSasri());
                intent.putExtra("mossad", familyInfoModel.getMossad());
                intent.putExtra("bloodgroup", familyInfoModel.getBloodGroup());
                intent.putExtra("mobile", familyInfoModel.getMobileLogin());
                intent.putExtra("address", familyInfoModel.getPyramidAddress());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseFamilyInfo> call = apiService.getMemberDetel(main_mamber_id, famili_id);
        call.enqueue(new Callback<ResponseFamilyInfo>() {
            @Override
            public void onResponse(Call<ResponseFamilyInfo> call, Response<ResponseFamilyInfo> response) {
                movies = response.body().getFamilyinfo();


                recyclerView.setAdapter(new FamliyAdepter(movies, getApplicationContext()));


            }

            @Override
            public void onFailure(Call<ResponseFamilyInfo> call, Throwable t) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
startActivity(new Intent(UpDateDirectoryActivity.this,HomeActivity.class));

    }
}
