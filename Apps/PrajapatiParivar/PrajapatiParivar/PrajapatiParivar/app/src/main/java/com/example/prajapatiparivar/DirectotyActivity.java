package com.example.prajapatiparivar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.prajapatiparivar.adepter.FamliyAdepter;
import com.example.prajapatiparivar.adepter.MemberAdepter;
import com.example.prajapatiparivar.model.FamilyInfoModel;
import com.example.prajapatiparivar.model.MemberDetailModel;
import com.example.prajapatiparivar.response.ResponseAllMemberInfo;
import com.example.prajapatiparivar.response.ResponseFamilyInfo;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DirectotyActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    SessionManager session;
    List<MemberDetailModel> detailModelList = new ArrayList<>();
    MemberAdepter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directoty);
        session = new SessionManager(getApplicationContext());

        recyclerView = findViewById(R.id.allmemberRecyclerview);

        mAdapter = new MemberAdepter(detailModelList, getApplicationContext());
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                MemberDetailModel memberDetailModel = detailModelList.get(position);
                Toast.makeText(DirectotyActivity.this, memberDetailModel.getUserName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DirectoryListActivity.class);
              String maimMember=memberDetailModel.getMainMemberNumber();
              intent.putExtra("midUser",maimMember);
                Log.d("123654", "onCreate: "+maimMember);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseAllMemberInfo> call = apiService.getAllMemberDetel();
        call.enqueue(new Callback<ResponseAllMemberInfo>() {
            @Override
            public void onResponse(Call<ResponseAllMemberInfo> call, Response<ResponseAllMemberInfo> response) {
                detailModelList = response.body().getMemberDetail();


                recyclerView.setAdapter(new MemberAdepter(detailModelList, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ResponseAllMemberInfo> call, Throwable t) {

            }
        });

    }
}
