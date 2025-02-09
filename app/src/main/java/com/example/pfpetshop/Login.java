package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfpetshop.Controllers.UserController;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvRegistrar;
    UserController userController = new UserController(Login.this);

    private EditText etRegistro, etContrasenia;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etRegistro = findViewById(R.id.txtnombre);
        etContrasenia = findViewById(R.id.txtContrasenia);

        btnLogin = findViewById(R.id.btnRegistrarse);

        tvRegistrar = findViewById(R.id.tvDate);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                try {
                    String userString= etRegistro.getText().toString().trim();
                    String passwordString = etContrasenia.getText().toString().trim();

                    if (userString.equals("")){
                        etRegistro.setError("please insert user");
                        etRegistro.requestFocus();
                        return;
                    }
                    if (passwordString.equals("")) {
                        etContrasenia.setError("please insert password");
                        etContrasenia.requestFocus();
                        return;
                    }

                    if (userController.validateUser(userString,passwordString)){
                        userController.SelectUserID();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception exception){
                    Log.e("LOGIN", "onClick: " + exception.getMessage().toString()  );
                }
            }
        });
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(Login.this, RegisterUser.class);
                startActivity(intent);
            }
        });

    }
}