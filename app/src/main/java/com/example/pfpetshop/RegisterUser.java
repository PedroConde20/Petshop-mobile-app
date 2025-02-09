package com.example.pfpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pfpetshop.Controllers.UserController;
import com.example.pfpetshop.Models.User;

public class RegisterUser extends AppCompatActivity {

    private EditText etName, etLastName,etUser,etCi,etPass, etRepeatPass,etEmail;
    private User user;


    private Button btnRegistrarse;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        etName = findViewById(R.id.txtnombre);
        etLastName = findViewById(R.id.txtapellido);
        etCi = findViewById(R.id.txtci);
        etUser = findViewById(R.id.txtusuario);
        etPass = findViewById(R.id.txtPassword);
        etRepeatPass = findViewById(R.id.txtRepeatPass);
        etEmail = findViewById(R.id.txtemail);
        UserController userController = new UserController(RegisterUser.this);

        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                try {
                    String nameString = etName.getText().toString().trim();
                    String lastnameString = etLastName.getText().toString().trim();
                    String ciString = etCi.getText().toString().trim();
                    String userString = etUser.getText().toString().trim();
                    String passString = etPass.getText().toString().trim();
                    String repeatString = etRepeatPass.getText().toString().trim();
                    String emailString = etEmail.getText().toString().trim();
                    if (nameString.equals("")){
                        etName.setText("Please insert name");
                        etName.requestFocus();
                        return;
                    }
                    if (lastnameString.equals("")){
                        etLastName.setText("Please insert lastname");
                        etLastName.requestFocus();
                        return;
                    }
                    if (ciString.equals("")){
                        etCi.setText("Please insert ci");
                        etCi.requestFocus();
                        return;
                    }
                    if (emailString.equals("")){
                        etEmail.setText("Please insert email");
                        etEmail.requestFocus();
                        return;
                    }
                    if (userString.equals("")){
                        etUser.setText("Please insert User");
                        etUser.requestFocus();
                        return;
                    }
                    if (passString.equals("")){
                        etPass.setText("Please insert Password");
                        etPass.requestFocus();
                        return;
                    }
                    if (passString.length()<6){
                        etPass.setError("please insert words more than 6 characters");
                        return;
                    }
                    if (repeatString.equals("")){
                        etRepeatPass.setText("Please repeat Password");
                        etRepeatPass.requestFocus();
                        return;
                    }
                    if (passString.equals(repeatString)){
                        user = new User(nameString,lastnameString,emailString,userString,passString,ciString);
                        long res = userController.insertUser(user);
                        if (res == -1){
                            Toast.makeText(RegisterUser.this, "Error!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RegisterUser.this, "Success!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }else{
                        etPass.setText("the password is not the same");
                        etPass.requestFocus();
                        etRepeatPass.setText("the password is not the same");
                        etRepeatPass.requestFocus();
                    }


                }catch (Exception e){

                }



            }
        });
    }
}