package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    private TextView tvAtrasInfo;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvAtrasInfo = findViewById(R.id.tvDuenio);

        tvAtrasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(Info.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}