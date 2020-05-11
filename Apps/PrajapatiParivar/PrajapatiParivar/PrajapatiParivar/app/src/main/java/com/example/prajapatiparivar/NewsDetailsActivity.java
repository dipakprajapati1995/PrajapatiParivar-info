package com.example.prajapatiparivar;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.prajapatiparivar.retrofit.ApiClient.BASE_URL1;
import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;

public class NewsDetailsActivity extends AppCompatActivity {
    TextView tvMessage, tvtitel, tvDate;
    ImageView imgDetailsNews;
    String img, titel, date, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        setToolbar();
        imgDetailsNews = findViewById(R.id.imgDetailsNews);
        tvMessage = findViewById(R.id.tvMessageDetailsNews);
        tvtitel = findViewById(R.id.tvtitel);
        tvDate = findViewById(R.id.tvDate);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            img = bundle.getString("img");

            titel = bundle.getString("titel");

            date = bundle.getString("date");

            msg = bundle.getString("msg");

        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titel);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Log.d("asdqw111", "onCreate: " + img + " " + titel + " " + date + " " + msg);
        Picasso.with(this).load(BASE_URL1 + img)
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(imgDetailsNews);


        tvtitel.setText(titel);
        tvDate.setText(date);
        tvMessage.setText(msg);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
