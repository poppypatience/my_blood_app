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
import com.example.mybloodapp.Models.drivesModel;
import com.example.mybloodapp.R;

import java.util.List;

public class drivesAddapter extends RecyclerView.Adapter<drivesAddapter.drivesViewHolder> {
    Context context;
    List<drivesModel> mData;

    public drivesAddapter(Context context, List<drivesModel> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public drivesAddapter.drivesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_drives,null,false);
        return new drivesViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull drivesAddapter.drivesViewHolder holder, final int position) {
        drivesModel drivesModel = mData.get(position);
holder.name_holder.setText(mData.get(position).getNames());
holder.location_holder.setText(mData.get(position).getLocation());
holder.donation_date_holder.setText(mData.get(position).getDonation_date());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class drivesViewHolder  extends RecyclerView.ViewHolder{
        TextView name_holder, location_holder,donation_date_holder;
        CardView drives_card;


        public drivesViewHolder(@NonNull View itemView) {
            super(itemView);
            drives_card = itemView.findViewById(R.id.drives_card);
            name_holder = itemView.findViewById(R.id.name_holder);
            location_holder= itemView.findViewById(R.id.location_holder);
            donation_date_holder = itemView.findViewById(R.id.donation_date_holder);

        }
    }
}
