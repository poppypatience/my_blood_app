package com.example.mybloodapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybloodapp.Models.BloodgroupsModel;
import com.example.mybloodapp.Models.DonorsModel;
import com.example.mybloodapp.R;

import java.util.List;

public class BloodgroupsAddapter extends RecyclerView.Adapter<BloodgroupsAddapter.BloodgroupsViewHolder> {
    Context context;
    List<BloodgroupsModel> mData;

    public BloodgroupsAddapter(Context context, List<BloodgroupsModel> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public BloodgroupsAddapter.BloodgroupsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_donors,null,false);
        return new BloodgroupsViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodgroupsAddapter.BloodgroupsViewHolder holder, final int position) {
        BloodgroupsModel BloodgroupsModel = mData.get(position);
holder.name_holder.setText(mData.get(position).getName());
holder.location_holder.setText(mData.get(position).getLocation());
holder.phonenumber_holder.setText(mData.get(position).getPhonenumber());
holder.bloodgroup_holder.setText(mData.get(position).getBloodgroup());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class BloodgroupsViewHolder  extends RecyclerView.ViewHolder{
        TextView name_holder, location_holder,phonenumber_holder,bloodgroup_holder;
        CardView Bloodgroup_card;


        public BloodgroupsViewHolder(@NonNull View itemView) {
            super(itemView);
            Bloodgroup_card = itemView.findViewById(R.id.Bloodgroup_card);
            name_holder = itemView.findViewById(R.id.name_holder);
            location_holder = itemView.findViewById(R.id.location_holder);
            phonenumber_holder = itemView.findViewById(R.id.phone_holder);
            bloodgroup_holder = itemView.findViewById(R.id.bloodgroup_holder);
        }
    }
}
