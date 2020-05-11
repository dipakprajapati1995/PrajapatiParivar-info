package com.example.prajapatiparivar.forgot_password;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prajapatiparivar.LoginActivity;
import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.response.ResponseUpdatePass;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText password, confromPassword;
    TextInputLayout tvErrorPass, tvErrorConPass;
    Boolean isPasswordSame = false;
    String pass, conpassword;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button button = findViewById(R.id.btnsubmitForgot);
        password = findViewById(R.id.edtPassword);
        confromPassword = findViewById(R.id.edtConfromPassword);

        tvErrorPass = findViewById(R.id.input_layout_password);
        tvErrorConPass = findViewById(R.id.input_layoutasd_conPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);

                //startActivity(intent);


                pass = password.getText().toString().trim();
                conpassword = confromPassword.getText().toString().trim();


                boolean isPasswordSame = false;

                if (TextUtils.isEmpty(pass) || pass.length() < 6) {
                    tvErrorPass.setError("Enter Password  6 Character");
                    return;
                } else {
                    tvErrorPass.setError(null);
                }


                if (TextUtils.isEmpty(conpassword) || conpassword.length() < 6) {
                    tvErrorConPass.setError("Enter Confirm Password");
                    return;
                } else {
                    tvErrorConPass.setError(null);
                }

                if (!TextUtils.isEmpty(pass) && !TextUtils.isEmpty(conpassword)) {
                    if (!pass.equals(conpassword)) {
                        tvErrorConPass.setError("Enter same pass");

                        isPasswordSame = false;
                    } else {


                        isPasswordSame = true;
                    }
                }

                if (!TextUtils.isEmpty(pass) && !TextUtils.isEmpty(conpassword) && isPasswordSame) {

                    forPassword();
                }
            }
        });

    }

    private void forPassword() {
        dialog.setMessage("Data is Updating...");
        dialog.show();

        Intent intent = getIntent();
        String mobile = intent.getStringExtra("number");
        Log.d("asd", "forPassword: " + mobile);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseUpdatePass> call = apiService.getUpdatePass(pass, mobile);
        call.enqueue(new Callback<ResponseUpdatePass>() {
            @Override
            public void onResponse(Call<ResponseUpdatePass> call, Response<ResponseUpdatePass> response) {
dialog.dismiss();

                if (response != null && response.isSuccessful()) {
                    if (response.body().getSuccess().equals("Yes")) {
                        Toast.makeText(ForgotPasswordActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseUpdatePass> call, Throwable t) {
dialog.dismiss();
            }
        });


    }
}
