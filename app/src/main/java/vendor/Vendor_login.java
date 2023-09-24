package vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hez.okoaapp.R;

public class Vendor_login extends AppCompatActivity {

    Button btnback ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_login);
        btnback = findViewById(R.id.btnbacksignup);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vendor_login.this, Vendor_signup.class);
                startActivity(intent);
            }
        });
    }
}