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
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.MemberFullDetailActivity;
import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.model.FamilyInfoModel;
import com.example.prajapatiparivar.model.MemberDetailModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;

public class FamliyAdepter extends RecyclerView.Adapter<FamliyAdepter.FamilyViewHolder> {
   // public static final String BASE_URL = "http://192.168.0.107/api_prajapatiParivar/";
    private List<FamilyInfoModel> infoModelList;
    private Context context;
    ImageView imageView;
    CardView cardView;

    public FamliyAdepter(List<FamilyInfoModel> infoModelList, Context context) {
        this.infoModelList = infoModelList;
        this.context = context;
    }



    @NonNull
    @Override
    public FamliyAdepter.FamilyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adepter, viewGroup, false);
        return new FamilyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyViewHolder familyViewHolder, int i) {

        familyViewHolder.tvName.setText(infoModelList.get(i).getUserName());
        familyViewHolder.tvMobile.setText(infoModelList.get(i).getMobileLogin());

/*
        Glide.with(context).load(IMG_URL_MOBILE+infoModelList.get(i).getImage())
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.usericon)
                .into(familyViewHolder.imageView);*/
        Picasso.with(context).load(IMG_URL_MOBILE+infoModelList.get(i).getImage())
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(familyViewHolder.imageView);

        Log.d("imgLogtest", "onBindViewHolder: "+IMG_URL_MOBILE+infoModelList.get(i).getImage());

      /*  cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Name = null;



                Intent intent=new Intent(context, MemberFullDetailActivity.class);


                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {

        return infoModelList == null ? 0 : infoModelList.size();
    }

    public class FamilyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvMobile;
        ImageView imageView;


        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            tvName = itemView.findViewById(R.id.tvname);
            tvMobile = itemView.findViewById(R.id.tvMobile);
            imageView = itemView.findViewById(R.id.img);

        }
    }

}
