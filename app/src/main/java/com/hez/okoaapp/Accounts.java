package com.hez.okoaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Admin.Adminlogin;
import vendor.Vendor_signup;

public class Accounts extends AppCompatActivity {
   private TextView adminpage, vendorpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        TextView adminpage = findViewById(R.id.adminpage);
        TextView vendorpage = findViewById(R.id.vendorpage);


        adminpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Accounts.this, Adminlogin.class);
                startActivity(intent);
            }
        });
        vendorpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accounts.this, Vendor_signup.class);
                startActivity(intent);
            }
        });
    }
}