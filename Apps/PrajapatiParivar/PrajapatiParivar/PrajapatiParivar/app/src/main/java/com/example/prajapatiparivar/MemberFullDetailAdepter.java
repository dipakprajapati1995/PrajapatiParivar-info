package com.example.prajapatiparivar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.prajapatiparivar.model.FamilyInfoModel;

import java.util.List;

public class MemberFullDetailAdepter extends BaseExpandableListAdapter {
    private Context _context;
    private List<FamilyInfoModel> familyInfoList;
TextView bod;
    public MemberFullDetailAdepter(Context _context, List<FamilyInfoModel> familyInfoList) {
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
