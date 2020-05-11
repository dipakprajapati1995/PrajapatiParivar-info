package com.example.prajapatiparivar.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.model.MemberDetailModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;


public class MemberAdepter extends RecyclerView.Adapter<MemberAdepter.MemberModel> {
    private List<MemberDetailModel> detailModelList;
    Context context;

    public MemberAdepter(List<MemberDetailModel> detailModelList, Context context) {
        this.detailModelList = detailModelList;
        this.context = context;
    }



    @NonNull
    @Override
    public MemberAdepter.MemberModel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_list_adepter, viewGroup, false);
        return new MemberModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdepter.MemberModel memberModel, int i) {
        memberModel.tvName.setText(detailModelList.get(i).getUserName());
        memberModel.tvMobile.setText(detailModelList.get(i).getMobileLogin());


      /*  Glide.with(context).load(IMG_URL_MOBILE + detailModelList.get(i).getImage())
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.usericon)
                .into(memberModel.imageView);*/

        Picasso.with(context).load(IMG_URL_MOBILE + detailModelList.get(i).getImage())
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(memberModel.imageView);
    }

    @Override
    public int getItemCount() {

        return detailModelList == null ? 0 : detailModelList.size();

    }

    public class MemberModel extends RecyclerView.ViewHolder {
        TextView tvName, tvMobile;
        ImageView imageView;

        public MemberModel(@NonNull View itemView) {
            super(itemView);
          //  cardView = itemView.findViewById(R.id.cardview);
            tvName = itemView.findViewById(R.id.tvname);
            tvMobile = itemView.findViewById(R.id.tvMobile);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}
