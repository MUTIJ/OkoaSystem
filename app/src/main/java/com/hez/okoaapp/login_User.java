package com.hez.okoaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_User extends AppCompatActivity {

    private EditText useremail, userpass;
    private Button usersignup, userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        EditText useremail = findViewById(R.id.userloginemail);
        EditText userpass = findViewById(R.id.userloginpass);
        Button usersignup = findViewById(R.id.userloginsignup);
        Button userlogin = findViewById(R.id.btnuserlogin);


        usersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login_User.this, Sign_up_user.class);
                startActivity(intent);
            }
        });
    }
}