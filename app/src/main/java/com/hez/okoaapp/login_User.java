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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_User extends AppCompatActivity {

    private Button usersignup, userlogin;

    private EditText user_name, user_email, user_password, conf_password;

    FirebaseAuth mAuth;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        Button usersignup = findViewById(R.id.userloginsignup);
        Button userlogin = findViewById(R.id.btnuserlogin);
        mAuth = FirebaseAuth.getInstance();
        EditText user_email = findViewById(R.id.user_email);
        EditText user_password = findViewById(R.id.user_password);
        ProgressBar progressBar = findViewById(R.id.progressbar);


        usersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login_User.this, Sign_up_user.class);
                startActivity(intent);
            }
        });
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String  email,password;
                email = String.valueOf(user_email.getText());
                password = String.valueOf(user_password.getText());

                if (TextUtils.isEmpty(email)){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(login_User.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(login_User.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);


                                if (task.isSuccessful()){
                                    Toast.makeText(login_User.this, "login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(login_User.this, MainActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(login_User.this, "Login failed retry...", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            }
        });
    }
}