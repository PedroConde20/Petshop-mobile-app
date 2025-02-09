package com.example.pfpetshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfpetshop.Models.Appoitment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

public class AppoitmentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Appoitment> appoitmentArrayList;
    private TextView tvDuenio, tvCi, tvPet,tvDate;

    public AppoitmentAdapter(){

    }
    public AppoitmentAdapter(Context context, int layout, ArrayList<Appoitment> appoitmentArrayList) {
        this.context = context;
        this.layout = layout;
        this.appoitmentArrayList = appoitmentArrayList;
    }

    @Override
    public int getCount() {
        return appoitmentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return appoitmentArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.item_appointment,null);
        String petName = appoitmentArrayList.get(i).getNamePet();
        String date = appoitmentArrayList.get(i).getDate();
        String userName = appoitmentArrayList.get(i).getName();
        String ci = appoitmentArrayList.get(i).getCi();
        tvDuenio = v.findViewById(R.id.tvDuenio);
        tvDate = v.findViewById(R.id.tvDate);
        tvPet = v.findViewById(R.id.tvPet);
        tvCi = v.findViewById(R.id.tvCi);

        tvPet.setText(""+petName);

        tvDate.setText(""+date);

        tvDuenio.setText(""+userName);

        tvCi.setText(""+ci);
        return v;
    }
}
