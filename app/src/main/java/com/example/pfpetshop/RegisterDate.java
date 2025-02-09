package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pfpetshop.Controllers.AppoitmentController;
import com.example.pfpetshop.Models.Appoitment;
import com.example.pfpetshop.Models.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterDate extends AppCompatActivity {

    private  Button btncita;
    private EditText etNamePet, etTypePet,etDate;
    Appoitment appoitment;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_date);
        etNamePet = findViewById(R.id.etNamePet);
        etTypePet = findViewById(R.id.etTypePet);
        //etDate = findViewById(R.id.etDate);

        btncita = findViewById(R.id.btncita);
        AppoitmentController appoitmentController = new AppoitmentController(RegisterDate.this);



        btncita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                try {
                    String nameString = etNamePet.getText().toString();
                    String typeString = etTypePet.getText().toString();
                    if (etNamePet.equals("")){
                        etNamePet.setText("please insert the pet's name");
                        etNamePet.requestFocus();
                        return;
                    }
                    if (etTypePet.equals("")){
                        etTypePet.setText("please insert the type of the pet");
                        etTypePet.requestFocus();
                        return;
                    }else{

                        //String dateString = etDate.getText().toString();

                        SimpleDateFormat format = new SimpleDateFormat();
                        //Date dateDate = format.parse(dateString);

                        Integer id = Session.idUser;
                        appoitment = new Appoitment(nameString,typeString,id);
                        long res = appoitmentController.InsertPet(appoitment);
                        if (res != -1){
                            Toast.makeText(RegisterDate.this, "Success!!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(RegisterDate.this, "Error!!!", Toast.LENGTH_SHORT).show();

                        }
                    }


                }catch (Exception e){
                    Log.e("Appoitment", "onClick: " + e.getMessage().toString()  );

                }

            }
        });
    }
}