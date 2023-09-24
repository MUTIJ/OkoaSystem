package com.hez.okoaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Admin.Adminlogin;

public class Sign_up_user extends AppCompatActivity {

    private TextView adminpage, vendorpage,accounts;
    private EditText user_name, user_email, user_passsword, conf_password;
    private Button userlogin, signup_user;
    FirebaseAuth mAuth;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        mAuth = FirebaseAuth.getInstance();

        TextView adminpage = findViewById(R.id.adminpage);
        Button userlogin = findViewById(R.id.userlogin);
        Button signup_user = findViewById(R.id.btnsignup_user);
        EditText user_name = findViewById(R.id.user_name);
        EditText user_email = findViewById(R.id.user_email);
        EditText user_passsword = findViewById(R.id.user_password);
        EditText conf_password = findViewById(R.id.conf_password);
        ProgressBar progressBar = findViewById(R.id.progressbar);


        adminpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Sign_up_user.this, Adminlogin.class);
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

        signup_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String name, email,password,conf_pass;
                name = String.valueOf(user_name.getText());
                email = String.valueOf(user_email.getText());
                password = String.valueOf(user_passsword.getText());
                conf_pass = String.valueOf(conf_password.getText());

                if (TextUtils.isEmpty(name)){

                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Sign_up_user.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Sign_up_user.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Sign_up_user.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!conf_pass.equals(password)) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Sign_up_user.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    return;
                }else {

                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()){
                                        Toast.makeText(Sign_up_user.this, "Account Created successfully", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Sign_up_user.this, MainActivity.class);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(Sign_up_user.this, "Failed to create account", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }


            }
        });
    }
}