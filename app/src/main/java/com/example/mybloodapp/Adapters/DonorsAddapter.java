package com.example.mybloodapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybloodapp.Models.DonorsModel;
import com.example.mybloodapp.R;

import java.util.List;

public class DonorsAddapter extends RecyclerView.Adapter<DonorsAddapter.DonorsViewHolder> {
    Context context;
    List<DonorsModel> mData;

    public DonorsAddapter(Context context, List<DonorsModel> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public DonorsAddapter.DonorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_donors,null,false);
        return new DonorsViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorsAddapter.DonorsViewHolder holder, final int position) {
DonorsModel donorsModel = mData.get(position);
holder.name_holder.setText(mData.get(position).getNames());
holder.email_holder.setText(mData.get(position).getEmail());
holder.phone_holder.setText(mData.get(position).getPhone());
holder.username_holder.setText(mData.get(position).getUsername());
holder.password_holder.setText(mData.get(position).getPassword());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DonorsViewHolder  extends RecyclerView.ViewHolder{
        TextView name_holder, email_holder,phone_holder,username_holder,password_holder;
        CardView Donors_card;


        public DonorsViewHolder(@NonNull View itemView) {
            super(itemView);
            Donors_card = itemView.findViewById(R.id.Donors_card);
            name_holder = itemView.findViewById(R.id.name_holder);
            email_holder = itemView.findViewById(R.id.email_holder);
            phone_holder = itemView.findViewById(R.id.phone_holder);
            username_holder = itemView.findViewById(R.id.username_holder);
            password_holder= itemView.findViewById(R.id.password_holder);
        }
    }
}
