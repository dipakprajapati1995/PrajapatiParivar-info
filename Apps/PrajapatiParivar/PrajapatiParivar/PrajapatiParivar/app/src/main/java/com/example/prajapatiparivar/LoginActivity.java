package com.example.prajapatiparivar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.forgot_password.Forgot_MobileActivity;
import com.example.prajapatiparivar.model.UserInfoModel;
import com.example.prajapatiparivar.response.ResponseLogin;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtMobileNO, edtPassword;
    Button btnSignUp;
    private TextInputLayout inputLayoutMobile, inputLayoutPassword;
    ProgressDialog dialog;
    private ProgressBar progressBar;
    TextView forgot_password;

    SessionManager session;

    public String familyID = "", mainMemberNumber = "", status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        edtMobileNO = (EditText) findViewById(R.id.input_name);
        edtPassword = (EditText) findViewById(R.id.input_password);
        btnSignUp = (Button) findViewById(R.id.btnSubmit);
        edtMobileNO.addTextChangedListener(new MyTextWatcher(edtMobileNO));
        edtPassword.addTextChangedListener(new MyTextWatcher(edtPassword));
        forgot_password = findViewById(R.id.forgot_password);
        // Session Manager Class

        // Session Manager
        session = new SessionManager(getApplicationContext());

        dialog = new ProgressDialog(LoginActivity.this);


        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Forgot_MobileActivity.class));
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }


    private void submitForm() {
        if (!validateMobile()) {
            return;
        }


        if (!validatePassword()) {
            return;
        }


        authFireBaseLogin();

    }

    private void authFireBaseLogin() {

     /*   dialog.setMessage("Data is Updating...");
        dialog.show();*/

        dialog.setMessage("Processing...........");
          dialog.show();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseLogin> call = apiService.getlogin(edtMobileNO.getText().toString(), edtPassword.getText().toString());
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if (response != null && response.isSuccessful()) {
                    if (response.body().getSuccess().equals("Yes")) {





                        status = response.body().getSuccess();
                     //   familyID = response.body().getUserinfo().get(0).getFamileId();
                        familyID = response.body().getUserinfo().get(0).getFamileId();

response.body().getUserinfo().get(0).getBod();



                        mainMemberNumber = response.body().getUserinfo().get(0).getMainMemberNumber();
                        Log.d("asd", "onResponse: " + familyID);
                        Log.d("asd", "onResponse: " + mainMemberNumber);
                        Log.d("asd", "onResponse: " + status);

                        session.createLoginSession(mainMemberNumber, familyID);

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        // Staring Login Activity

                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

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
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                dialog.dismiss();
                Log.d("test", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private boolean validateMobile() {
        if (edtMobileNO.getText().toString().trim().isEmpty() || edtMobileNO.length() < 10) {
            inputLayoutMobile.setError("Enter Mobile");
            requestFocus(edtMobileNO);
            return false;
        } else {
            inputLayoutMobile.setErrorEnabled(false);
        }

        return true;
    }


    @SuppressLint("ResourceAsColor")
    private boolean validatePassword() {
        if (edtPassword.getText().toString().trim().isEmpty() || edtPassword.length() < 6) {
            inputLayoutPassword.setError("Password not valide");

            requestFocus(edtPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateMobile();
                    break;

                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }

}