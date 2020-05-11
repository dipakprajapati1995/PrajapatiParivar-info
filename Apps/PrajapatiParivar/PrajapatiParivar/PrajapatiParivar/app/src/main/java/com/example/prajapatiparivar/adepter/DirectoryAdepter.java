package com.example.prajapatiparivar.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.model.Famaliy_infoModel;
import com.example.prajapatiparivar.response.ResponseAllFamiliInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;

public class DirectoryAdepter extends RecyclerView.Adapter<DirectoryAdepter.DirectoryHolder> {
    private static int currentPosition = 0;

    Context context;
    List<Famaliy_infoModel> list;

    public DirectoryAdepter(Context context, List<Famaliy_infoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DirectoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_adepter, viewGroup, false);

        return new DirectoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectoryHolder directoryHolder, final int i) {
        directoryHolder.name.setText(list.get(i).getUserName());
        directoryHolder.dob.setText(list.get(i).getBod());
        directoryHolder.marital.setText(list.get(i).getMeridasStatus());
        directoryHolder.mosal.setText(list.get(i).getSasri());
        directoryHolder.piyar.setText(list.get(i).getMossad());
        directoryHolder.bloodgroup.setText(list.get(i).getBloodGroup());

        directoryHolder.mobile.setText(list.get(i).getMobileLogin());
        directoryHolder.currentplace.setText(list.get(i).getPyramidAddress());
        directoryHolder.dob.setText(list.get(i).getBod());
        directoryHolder.dob.setText(list.get(i).getBod());
       /* Glide.with(context).load(IMG_URL_MOBILE + list.get(i).getImage())
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.usericon)
                .into(directoryHolder.imageView);*/


        Picasso.with(context).load(IMG_URL_MOBILE + list.get(i).getImage())
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(directoryHolder.imageView);

        directoryHolder.linearLayout.setVisibility(View.GONE);
        if (currentPosition == i) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            directoryHolder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            directoryHolder.linearLayout.startAnimation(slideDown);
        } else {


            directoryHolder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //getting the position of the item to expand it
                    currentPosition = i;

                    //reloding the list
                    notifyDataSetChanged();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();

    }

    public class DirectoryHolder extends RecyclerView.ViewHolder {
        TextView name, dob, mosal, edu, marital, piyar, mobile, occu, bloodgroup, currentplace;
        ImageView imageView, whatsapp;
        LinearLayout linearLayout;

        public DirectoryHolder(@NonNull View convertView) {
            super(convertView);

           name = (TextView) convertView.findViewById(R.id.tvname);
            dob = (TextView) convertView.findViewById(R.id.dobTV);
            mosal = (TextView) convertView.findViewById(R.id.mosalTV);
            edu = (TextView) convertView.findViewById(R.id.educationTV);
            marital = (TextView) convertView.findViewById(R.id.maritalTV);
            piyar = (TextView) convertView.findViewById(R.id.piyarTV);

            mobile = (TextView) convertView.findViewById(R.id.mobileBtn);
linearLayout=(LinearLayout)convertView.findViewById(R.id.linearLayout);
            bloodgroup = (TextView) convertView.findViewById(R.id.bloodgroupTV);
            currentplace = (TextView) convertView.findViewById(R.id.currentTV);
            imageView = (ImageView) convertView.findViewById(R.id.photoIV);
            whatsapp = (ImageView) convertView.findViewById(R.id.whatsappBtn);
        }
    }
}
