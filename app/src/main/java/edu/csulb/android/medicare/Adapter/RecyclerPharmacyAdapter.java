package edu.csulb.android.medicare.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.csulb.android.medicare.Model.MedicationInformation;
import edu.csulb.android.medicare.Model.Pharmacy;
import edu.csulb.android.medicare.R;
import edu.csulb.android.medicare.Activity.ViewMedicationActivity;

/**
 * Created by Samruddhi on 4/16/2017.
 */

public class RecyclerPharmacyAdapter extends RecyclerView.Adapter<RecyclerPharmacyAdapter.ViewHolder> {

    private List<Pharmacy> pharmacyList;
    Context context;

    public RecyclerPharmacyAdapter(List<Pharmacy> pharmacyList, Context context) {
        this.pharmacyList = pharmacyList;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        String medicineName;
        public TextView itemPharmacyName;
        public TextView itemAddress;
        public TextView itemIsOpen;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemPharmacyName = (TextView) itemView.findViewById(R.id.textPharmacyName);
            itemAddress = (TextView) itemView.findViewById(R.id.textAddress);
            itemIsOpen = (TextView) itemView.findViewById(R.id.textIsOpen);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Pharmacy pharmacy = pharmacyList.get(position);
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, ViewMedicationActivity.class);
                    context.startActivity(intent);

                }
            });*/
        }
    }

    @Override
    public RecyclerPharmacyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_pharmacy_layout, viewGroup, false);
        RecyclerPharmacyAdapter.ViewHolder viewHolder = new RecyclerPharmacyAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerPharmacyAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemPharmacyName.setText(pharmacyList.get(i).getPharmacyName());
        //viewHolder.itemAddress.setText(pharmacyList.get(i).getAddress());
        viewHolder.itemIsOpen.setText("open at");
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }
}