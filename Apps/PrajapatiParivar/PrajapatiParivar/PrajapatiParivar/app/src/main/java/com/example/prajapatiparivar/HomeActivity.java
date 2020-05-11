package com.example.prajapatiparivar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class HomeActivity extends AppCompatActivity   implements View.OnClickListener {
    SliderLayout sliderLayout;
    ImageButton imageButton;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView UpDateprofile = findViewById(R.id.profile);
        ImageView UserInfo = findViewById(R.id.UserList);
        ImageView directory = findViewById(R.id.Directoty);
        ImageView news = findViewById(R.id.News);
        ImageView business = findViewById(R.id.Business);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
        //sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(5); //set scroll delay in seconds :

        session = new SessionManager(getApplicationContext());

        session.checkLogin();


        setSliderViews();
        UpDateprofile.setOnClickListener(this);
        UserInfo.setOnClickListener(this);
        directory.setOnClickListener(this);
        news.setOnClickListener(this);    business.setOnClickListener(this);
    }


    //img Slider
    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("http://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageUrl("http://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageUrl("http://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageUrl("http://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            // set img  botam name
            // sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    // Toast.makeText(HomeActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    public void logout(View view) {
        session.logoutUser();
        Intent intent = new Intent(getApplication(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        //     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity

        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.profile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                break;
            case R.id.UserList:

                startActivity(new Intent(HomeActivity.this, UpDateDirectoryActivity.class));
                break;

            case R.id.Directoty:

                startActivity(new Intent(HomeActivity.this, DirectotyActivity.class));
                break;
            case R.id.News:

                startActivity(new Intent(HomeActivity.this, NewsActivity.class));
                break;
                case R.id.Business:

                startActivity(new Intent(HomeActivity.this, BusinessActivity.class));
                break;
        }
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
