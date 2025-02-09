package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pfpetshop.Models.Session;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnInfo, btnContacto, btnVerCitas, btnRegistrarCitas;
    private TextView tvNombreB;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNombreB = findViewById(R.id.tvNombreB);
        btnContacto = findViewById(R.id.ibtnContacto);
        btnInfo = findViewById(R.id.ibtnInfo);
        btnVerCitas = findViewById(R.id.ibtnVerCitas);
        btnRegistrarCitas = findViewById(R.id.ibtnRegistrarCita);
        tvNombreB.setText(Session.Name.toString());

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, Contactar.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            }
        });

        btnRegistrarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, RegisterDate.class);
                startActivity(intent);
            }
        });

        btnVerCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ViewCitas.class);
                startActivity(intent);
            }
        });

    }
}