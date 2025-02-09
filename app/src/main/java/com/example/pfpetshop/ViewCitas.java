package com.example.pfpetshop;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfpetshop.Controllers.AppoitmentController;
import com.example.pfpetshop.Models.Appoitment;

import java.util.ArrayList;

public class ViewCitas extends AppCompatActivity {

    private ArrayList<Appoitment> appoitmentArrayList;
    private RecyclerView rvCita;
    private AppoitmentAdapter appoitmentAdapter;
    private ListView lvCita;
    private Appoitment appoitment;
    private AppoitmentController appoitmentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_citas);
        lvCita = findViewById(R.id.lvCita);

        appoitmentController = new AppoitmentController(ViewCitas.this);
        appoitmentArrayList = new ArrayList<Appoitment>();
        updateListView();
       /* rvCita = findViewById(R.id.rvCitas);
        appoitmentAdapter = new AppoitmentAdapter(appoitmentArrayList);
        rvCita.setLayoutManager(new GridLayoutManager(this,1));;
        rvCita.setAdapter(appoitmentAdapter);*/


    }

    private void updateListView() {
        appoitmentArrayList = appoitmentController.loadMeetingLV();
        appoitmentAdapter = new AppoitmentAdapter(ViewCitas.this,R.layout.item_appointment,appoitmentArrayList);
        lvCita.setAdapter(appoitmentAdapter);
    }


}