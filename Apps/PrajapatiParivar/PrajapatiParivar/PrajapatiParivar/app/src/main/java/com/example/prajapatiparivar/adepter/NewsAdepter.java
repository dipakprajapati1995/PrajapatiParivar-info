package com.example.prajapatiparivar.adepter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.NewsDetailsActivity;
import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.model.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.prajapatiparivar.retrofit.ApiClient.BASE_URL1;
import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;

public class NewsAdepter extends RecyclerView.Adapter<NewsAdepter.NewsViewHolder> {

    Context context;
    List<NewsModel> newsList;

    public NewsAdepter(Context contextl, List<NewsModel> modelList) {
        this.context = contextl;
        this.newsList = modelList;
    }

    @NonNull
    @Override
    public NewsAdepter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_adepter, viewGroup, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdepter.NewsViewHolder newsViewHolder, final int i) {


        newsViewHolder.titleView.setText(newsList.get(i).getTitel());

        newsViewHolder.dateView.setText(newsList.get(i).getDateTime());

        newsViewHolder.share.setTag(i);
        newsViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int pos = Integer.parseInt(v.getTag().toString());

                    String content = newsList.get(pos).getTitel();
                    content += "\n\n" + IMG_URL_MOBILE + newsList.get(pos).getId();

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, content);
                    sendIntent.setType("text/plain");
                    context.startActivity(sendIntent);
                } catch (Exception e) {
                }
            }
        });


      /*  Glide.with(context)
                .load(BASE_URL1 + newsList.get(i).getPickupload())
                .diskCacheStrategy(DiskCacheStrategy.ALL)

                .placeholder(R.drawable.usericon)
                .into(newsViewHolder.imageView);*/


        Picasso.with(context).load(BASE_URL1+newsList.get(i).getPickupload())
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(newsViewHolder.imageView);
//        newsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NewsModel data = newsList.get(i);
//                Toast.makeText(context, data.getTitel(), Toast.LENGTH_SHORT).show();
//            }
//        });

        newsViewHolder.main.setTag(i);
        newsViewHolder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // int pos = Integer.parseInt(v.getTag().toString());

                    NewsModel data = newsList.get(i);
                    Intent intent = new Intent(context, NewsDetailsActivity.class);

               String img = data.getPickupload();
                    String titel = data.getTitel();
                    String date = data.getDateTime();
                    String msg = data.getMessag();
                    Log.d("asdqw", "onClick: " + img + " " + titel + " " + date + " " + msg);

                    intent.putExtra("img", img);
                    intent.putExtra("titel", titel);
                    intent.putExtra("date", date);
                    intent.putExtra("msg", msg);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);

                } catch (Exception e) {
                    Log.d("test", "onClick: "+e.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return newsList == null ? 0 : newsList.size();

    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView, dateView, calender;
        public LinearLayout share;
        public RelativeLayout main;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleView = (TextView) itemView.findViewById(R.id.titleTV);
            dateView = (TextView) itemView.findViewById(R.id.dateTV);
            calender = (TextView) itemView.findViewById(R.id.calender);
            share = (LinearLayout) itemView.findViewById(R.id.shareTV);
            main = (RelativeLayout) itemView.findViewById(R.id.mainLayout);

        }
    }
}
