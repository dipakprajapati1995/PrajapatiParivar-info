package com.example.prajapatiparivar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prajapatiparivar.model.FamilyInfoModel;
import com.example.prajapatiparivar.model.MemberinfoModel;
import com.example.prajapatiparivar.response.ResponseLogin;
import com.example.prajapatiparivar.retrofit.ApiClient;
import com.example.prajapatiparivar.retrofit.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.prajapatiparivar.retrofit.ApiClient.IMG_URL_MOBILE;

public class MemberFullDetailActivity extends AppCompatActivity {
    ArrayList<MemberinfoModel> familyList;
    ExpandableListView expandableListView;
    // String mainMemberMobileno = "9925098422";
    Button button;

    String mid, img, Sname, Sbod, Sstudy, SmaridStatus, Spiyar, Smoshad, SboladGroup, Smobile, Saddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_full_detail);
        ImageView imageView = findViewById(R.id.ImgUser);
        TextView name = findViewById(R.id.tvname);
        TextView bod = findViewById(R.id.tvBod);
        TextView study = findViewById(R.id.tvstudy);
        TextView maridStatus = findViewById(R.id.tvMaridStatus);
        TextView piyar = findViewById(R.id.tvPiyar);
        TextView moshad = findViewById(R.id.tvMoshad);
        TextView boladGroup = findViewById(R.id.tvBloadGroop);
        TextView mobile = findViewById(R.id.tvMobile);
        TextView address = findViewById(R.id.tvAddress);
        button = findViewById(R.id.updateButton);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mid = bundle.getString("mid");
            img = bundle.getString("img");
            Sname = bundle.getString("name");
            Sbod = bundle.getString("bod");
            Sstudy = bundle.getString("study1");
            Log.d("dipak", "onCreate: " + Sstudy);
            SmaridStatus = bundle.getString("maridstatus");
            SmaridStatus = bundle.getString("maridstatus");
            Spiyar = bundle.getString("sasri");
            Smoshad = bundle.getString("mossad");
            SboladGroup = bundle.getString("bloodgroup");
            Smobile = bundle.getString("mobile");
            Saddress = bundle.getString("address");


        }
        Log.d("dipak", "onCreate: " + IMG_URL_MOBILE+img);

        /*Glide.with(getApplicationContext()).load(IMG_URL_MOBILE+img)
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .placeholder(R.drawable.usericon)
                .into(imageView);*/
        Picasso.with(this).load(IMG_URL_MOBILE+img)
                .placeholder(R.drawable.usericon)
                .error(R.drawable.usericon)
                .noFade().into(imageView);

        name.setText(Sname);
        bod.setText(Sbod);
        study.setText(Sstudy);
        maridStatus.setText(SmaridStatus);
        piyar.setText(Spiyar);
        moshad.setText(Smoshad);
        boladGroup.setText(SboladGroup);
        mobile.setText(Smobile);
        address.setText(Saddress);

       /* ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MemberinfoModel> call = apiService.getMemberinfo("9925098422");
*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UpDateProfileActivity.class);
                intent.putExtra("midUpDate", mid);
                intent.putExtra("Simg", img);

                intent.putExtra("Sname", Sname);
                intent.putExtra("Sbod", Sbod);
                intent.putExtra("Sstudy", Sstudy);
                intent.putExtra("Spiyar", Spiyar);
                intent.putExtra("Smoshad", Smoshad);
                intent.putExtra("Smobile", Smobile);
                intent.putExtra("Saddress", Saddress);
                intent.putExtra("SmaridStatus", SmaridStatus);
                intent.putExtra("SboladGroup", SboladGroup);
                startActivity(intent);
            }
        });
    }


    public class MemberFullDetailAdepter extends BaseExpandableListAdapter {
        private Context _context;
        private List<MemberinfoModel> familyInfoList;

        public MemberFullDetailAdepter(Context _context, List<MemberinfoModel> familyInfoList) {
            this._context = _context;
            this.familyInfoList = familyInfoList;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            FamilyInfoModel member = (FamilyInfoModel) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.singlelist_list_header, null);
            }

            // For Default Open Groups. Group can't close
            //ExpandableListView mExpandableListView = (ExpandableListView) parent;
            //mExpandableListView.expandGroup(groupPosition);

            TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.headerNameTV);
            lblListHeader.setText(member.getRelation() + " : " + member.getUserName());

            if (isExpanded) {
                convertView.setBackgroundColor(Color.parseColor("#5c6bc0"));
                lblListHeader.setTextColor(Color.parseColor("#ffffff"));

            } else {
                convertView.setBackgroundColor(Color.WHITE);
                lblListHeader.setTextColor(Color.parseColor("#3F51B5"));
            }

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            final FamilyInfoModel member = (FamilyInfoModel) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.member_adepter, null);
            }
            TextView bod = (TextView) convertView.findViewById(R.id.tvBod);
            TextView study = (TextView) convertView.findViewById(R.id.tvstudy);
            TextView maridStatus = (TextView) convertView.findViewById(R.id.tvMaridStatus);
            TextView piyar = (TextView) convertView.findViewById(R.id.tvPiyar);
            TextView moshad = (TextView) convertView.findViewById(R.id.tvMoshad);
            TextView boladGroup = (TextView) convertView.findViewById(R.id.tvBloadGroop);
            TextView mobile = (TextView) convertView.findViewById(R.id.tvMobile);
            TextView address = (TextView) convertView.findViewById(R.id.tvAddress);

            bod.setText(member.getBod());
            study.setText(member.getStudy());
            maridStatus.setText(member.getMeridasStatus());
            piyar.setText(member.getMossad());
            moshad.setText(member.getSasri());
            boladGroup.setText(member.getBloodGroup());
            mobile.setText(member.getMobileNo());
            address.setText(member.getPyramidAddress());
            return convertView;
        }

        @Override
        public int getGroupCount() {
            return this.familyInfoList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this.familyInfoList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return this.familyInfoList.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return groupPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }


        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}