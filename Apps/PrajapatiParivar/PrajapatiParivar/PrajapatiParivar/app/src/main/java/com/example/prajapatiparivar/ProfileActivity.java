package com.example.prajapatiparivar;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.response.ResponseAddUser;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String IMAGE_DIRECTORY = "/demonuts";
    TextView tvBod;
    ProgressDialog dialog;
    String item0=null;
    String item1=null;
    String maridStatus;
    String userGender="";
    RadioButton genderradioButton;
    RadioGroup maridStatusRadioGroup;
    int selectedId;
   // String[] relesan = {"પોતે", "પત્ની", "પુત્ર", "પૂત્રવધુ", "પોત્રી", "પોત્ર"};
    String[]relesan={"pote","patni,","putra"};

    String[] bloodGroup = {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};
    String[] Study = {"ધૉરણ-1", "ધૉરણ-2", "ધૉરણ-3", "ધૉરણ-4", "ધૉરણ-5", "ધૉરણ-6", "ધૉરણ-7", "ધૉરણ-8", "ધૉરણ-9", "ધૉરણ-10", "ધૉરણ-11", "ધૉરણ-12", "ITI", "BCOM", "MCOM"};
    EditText edtUserName, edtmobile, edtAddress, edtmoshad, edtshsari, edtstudy;
    String userName, mobile, address, moshad, shashri, study;
    private Button btnSubmit;
    private ImageView imageview;
    private int GALLERY = 1, CAMERA = 2;
    private int mYear, mMonth, mDay;
    Bitmap bitmap;
    private static final int READ_REQUEST_CODE = 777;


    SessionManager session;

    private  static final int IMAGE = 100;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        requestMultiplePermissions();
        imageview = (ImageView) findViewById(R.id.img);
        tvBod = findViewById(R.id.tvBod);
        btnSubmit = findViewById(R.id.btnAddUser);
        edtUserName = findViewById(R.id.edtName);
        edtmobile = findViewById(R.id.edtMobile);
        edtAddress = findViewById(R.id.edtAddress);
        edtmoshad = findViewById(R.id.edtMoshad);
        edtshsari = findViewById(R.id.edtShashri);
        edtstudy = findViewById(R.id.edtStudy);
        session = new SessionManager(getApplicationContext());


        dialog=new ProgressDialog(ProfileActivity.this);
        //    btnSubmit.setVisibility(View.GONE);
        maridStatusRadioGroup = (RadioGroup) findViewById(R.id.MaragStatusgroup);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  maridSatusRedioGroup();

                //    mainManmerSattusRedioGroup();


                allValidesion();
            }


        });


        /*------------------------------Relesan----------------------------------------------------*/
        Spinner spinnerRelesan = (Spinner) findViewById(R.id.spinner);
        spinnerRelesan.setOnItemSelectedListener(this);
        ArrayAdapter RelesanArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, relesan);
        RelesanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spinnerRelesan.setAdapter(RelesanArrayAdapter);
        /*------------bloodGroup---------------------------------------------*/
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spinnerBloodGroup = (Spinner) findViewById(R.id.spBloodGroup);
        spinnerBloodGroup.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bloodGroup);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerBloodGroup.setAdapter(aa);


     /*   *//*-----------------Student-----------------------------------*//*
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spinnerstudy = (Spinner) findViewById(R.id.spStudy);
        spinnerstudy.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapterStudy = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Study);
        adapterStudy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerstudy.setAdapter(adapterStudy);
*/
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    showPictureDialog();

                imageview.setBackground(null);
                selectImage();
            }
        });

        tvBod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ProfileActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                tvBod.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();

            }

        });

    }

    public void RadioButtonClicked(View view) {




// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();
// Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbUnmarid:
                if (checked)
                    userGender = "mail";///"અપરણીત";
                break;
            case R.id.rbMarid:
                if (checked)
                    userGender = "femail";//"પરણીત";
                break;
        }

    }


    //================imgsetImgViewStart=============================
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imageview.setImageBitmap(bitmap);





            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //================imgsetImgViewEnd=============================



    private String imageToString() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte, Base64.DEFAULT);

    }


   /* private void maridSatusRedioGroup() {

        int selectedId = maridStatusRadioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            Toast.makeText(ProfileActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ProfileActivity.this, genderradioButton.getText(), Toast.LENGTH_SHORT).show();
            Log.d("asd", "maridSatusRedioGroup: " + genderradioButton.getText().toString());
        //    maridStatus = String.valueOf(genderradioButton.getText());


          //  Log.d("asd", "maridSatusRedioGroup: "+genderradioButton.getText());
        }



    }
*/
//======================================================
   /* private void showPictureDialog() {

        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                     bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(ProfileActivity.this, "Image Saved!111111111", Toast.LENGTH_SHORT).show();
                    imageview.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ProfileActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(ProfileActivity.this, "Image Saved!............", Toast.LENGTH_SHORT).show();
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
    */






    //===============


    private void requestMultiplePermissions() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }


                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }



    //===========================================

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        Spinner spinnerRelesan = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;
        Spinner spinerStudy = (Spinner) parent;



        if (spinnerRelesan.getId() == R.id.spinner) {
            item0 = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, "Your choose :" + item0, Toast.LENGTH_SHORT).show();

        }
        if (spin2.getId() == R.id.spBloodGroup) {
            item1 = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, "Your choose :" + item1 /*bloodGroup[position]*/, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




//=========================================================================================================================

    private void allValidesion() {

        userName = edtUserName.getText().toString().trim();
        mobile = edtmobile.getText().toString().trim();
        address = edtAddress.getText().toString().trim();
        moshad = edtmoshad.getText().toString().trim();
        shashri = edtshsari.getText().toString().trim();
        study = edtstudy.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            edtUserName.setError("Enter Name");
            return;
        } else {
            edtUserName.setError(null);
        }

        if (TextUtils.isEmpty(mobile) || mobile.length() < 10) {
            edtmobile.setError("Enter Mobile");
            return;
        } else {
            edtmobile.setError(null);
        }
        if (TextUtils.isEmpty(address)) {
            edtAddress.setError("Enter Address");
            return;
        } else {
            edtAddress.setError(null);
        }

        if (TextUtils.isEmpty(moshad)) {
            edtmoshad.setError("Enter Moshad");
            return;
        } else {
            edtmoshad.setError(null);
        }
        if (imageview.getDrawable() == null){
            Toast.makeText(this, "select Image.......", Toast.LENGTH_SHORT).show();
        }else {   // implementation 'com.github.bumptech.glide:glide:4.7.1'

            //Toast.makeText(this, "image is Selected.......", Toast.LENGTH_SHORT).show();
        }

       /* if (TextUtils.isEmpty(shashri)) {
            edtshsari.setError("Enter Moshad");
            return;
        } else {
            edtshsari.setError(null);
        }*/



        if (tvBod.getText().toString().equals("  જન્મ તારીખ")) {

           Toast.makeText(this, "Select Birth of Date ", Toast.LENGTH_SHORT).show();

        }

     //   maridSatusRedioGroup();


        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(mobile)
                && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(moshad) /*&&
               !TextUtils.isEmpty(shashri)*/ && !TextUtils.isEmpty(study) && !tvBod.getText().toString().equals("  જન્મ તારીખ")&& imageview.getDrawable()!= null ) {


        /*    int selectedId = maridStatusRadioGroup.getCheckedRadioButtonId();
            genderradioButton = (RadioButton) findViewById(selectedId);
            if (selectedId == -1) {
                Toast.makeText(ProfileActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ProfileActivity.this, genderradioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                Log.d("asd", "maridSatusRedioGroup: " + genderradioButton.getText().toString());
                maridStatus=genderradioButton.getText().toString();
                String mySelectedText = genderradioButton.getText().toString();
                Log.d("asd", "allValidesion: "+mySelectedText);
                //    maridStatus = String.valueOf(genderradioButton.getText());


                //  Log.d("asd", "maridSatusRedioGroup: "+genderradioButton.getText());
            }*/
            apiCalling();


        }










    }

    private void apiCalling() {
        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String main_mamber_id = user.get(SessionManager.mainMemberNumber);

        // email
        String famili_id = user.get(SessionManager.familyID);

        Log.d("asd1", "apiCalling: main_mamber_id "+main_mamber_id);
        Log.d("asd1", "apiCalling: famili_id  "+famili_id);


        dialog.setMessage("Processing......");
        dialog.show();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        String img = imageToString();
     //  String userName = edtUserName.getText().toString();
        Call<ResponseAddUser> call = apiService.getAddUser(img,main_mamber_id, famili_id, userName, item0, userGender, tvBod.getText().toString(), study, moshad, shashri, item1, address, mobile);


call.enqueue(new Callback<ResponseAddUser>() {
    @Override
    public void onResponse(Call<ResponseAddUser> call, Response<ResponseAddUser> response) {
        dialog.dismiss();
     if (response!=null&&response.isSuccessful()){


         Toast.makeText(ProfileActivity.this, "successfully Add ", Toast.LENGTH_LONG).show();
     }
    }

    @Override
    public void onFailure(Call<ResponseAddUser> call, Throwable t) {
        Log.d("asd1", "onFailure: "+t.getLocalizedMessage());
        Toast.makeText(ProfileActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
});

    }


}
