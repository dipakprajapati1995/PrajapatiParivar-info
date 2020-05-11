package com.example.prajapatiparivar.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.R;
import com.example.prajapatiparivar.model.BusinessModel;

import java.util.List;

public class BusinessAdepter extends RecyclerView.Adapter<BusinessAdepter.BusinessHolder> {


    Context context;
    List<BusinessModel> businessModelList;

    public BusinessAdepter(Context context, List<BusinessModel> businessModelList) {
        this.context = context;
        this.businessModelList = businessModelList;
    }

    @NonNull
    @Override
    public BusinessHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.business_adepter, viewGroup, false);

        return new BusinessHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BusinessHolder businessHolder, final int i) {

        businessHolder.firm.setText(businessModelList.get(i).getFirm());

        businessHolder.name.setText(businessModelList.get(i).getOwnerName());
        businessHolder.category.setText(businessModelList.get(i).getCategory());
        businessHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, businessModelList.get(i).getBusinessId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return businessModelList == null ? 0 : businessModelList.size();
    }

    public class BusinessHolder extends RecyclerView.ViewHolder {
        TextView firm, name, category;
        CardView cardView;

        public BusinessHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_viewBusiness);
            firm = itemView.findViewById(R.id.Tvfirm);

            name = itemView.findViewById(R.id.TvownerName);

            category = itemView.findViewById(R.id.Tvcategory);
        }
    }
}
