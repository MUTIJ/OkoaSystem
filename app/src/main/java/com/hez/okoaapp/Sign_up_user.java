package com.hez.okoaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_up_user extends AppCompatActivity {

    private TextView adminpage, vendorpage,accounts;
    private Button userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);


        TextView accounts = findViewById(R.id.accounts);

        Button userlogin = findViewById(R.id.userlogin);

       accounts.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Sign_up_user.this, Accounts.class);
               startActivity(intent);
           }
       });



        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_up_user.this, login_User.class);
                startActivity(intent);
            }
        });


    }
}