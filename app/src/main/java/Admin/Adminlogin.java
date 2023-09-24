package Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hez.okoaapp.R;

public class Adminlogin extends AppCompatActivity {

    private EditText adminname, adminemail, adminpass ;
    private Button adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        String name = "Hezron";
        String email = "Jeihezmurithi@gmail.com";
        String password = "Hezron12";

        EditText adminname = findViewById(R.id.adminName);
        EditText adminemail = findViewById(R.id.adminEmail);
        EditText adminpass = findViewById(R.id.adminPassword);
        Button adminlogin = findViewById(R.id.adminLogin);


        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!adminname.getText().toString().equals(name) && !adminemail.getText().toString().equals(email)
                && !adminpass.getText().toString().equals(password)){
                    Toast.makeText(Adminlogin.this, "Oops! Login Failed", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(Adminlogin.this, AdminHome.class);
                    startActivity(intent);
                    Toast.makeText(Adminlogin.this, "Login successful", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}