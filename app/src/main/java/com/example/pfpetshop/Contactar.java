package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contactar extends AppCompatActivity {

    private Button btnContactarWpp;
    private String url;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);
        btnContactarWpp = findViewById(R.id.btnContactarWpp);

        btnContactarWpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                try {
                    String phoneString = "59165807633";
                    String messageString = "Hola!! queria contactarnos con la veterinaria";
                    url = "https://wa.me/+"+phoneString+"/?text="+messageString;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}