package com.example.prajapatiparivar.forgot_password;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prajapatiparivar.LoginActivity;
import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.response.ResponseForgotNumber;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forgot_MobileActivity extends AppCompatActivity {
    EditText editTextMobile;
    String mobile;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__mobile);
        editTextMobile = findViewById(R.id.editTextMobile);


        final Button button = findViewById(R.id.buttonContinue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = editTextMobile.getText().toString().trim();

                if (TextUtils.isEmpty(mobile) || mobile.length() < 10) {
                    editTextMobile.setError("Enter Mobile numbae");

                } else {

                    forgotNumbar();

                }
                editTextMobile.setText("");

            }

            private void forgotNumbar() {
                dialog.setMessage("Data is Updating...");
                dialog.show();

                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<ResponseForgotNumber> call = apiService.getForgot(mobile);


                call.enqueue(new Callback<ResponseForgotNumber>() {
                    @Override
                    public void onResponse(Call<ResponseForgotNumber> call, Response<ResponseForgotNumber> response) {
                        dialog.dismiss();

                        if (response != null && response.isSuccessful()) {
                            if (response.body().getSuccess().equals("Yes")) {

                                Toast.makeText(Forgot_MobileActivity.this, mobile, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Forgot_MobileActivity.this, Otp_Activity.class);

                               // Intent intent1 = new Intent(Forgot_MobileActivity.this, ForgotPasswordActivity.class);

                                intent.putExtra("mobile", mobile);

                                startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Forgot_MobileActivity.this);

                                builder.setIcon(R.drawable.ic_newspaper);
                                builder.setTitle(" User Not Registered");
                                builder.setMessage(response.body().getMessage());
                                builder.setNegativeButton("Exit ",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                                Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
                                            }
                                        });

                                builder.show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseForgotNumber> call, Throwable t) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}
