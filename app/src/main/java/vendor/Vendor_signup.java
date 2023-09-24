package vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hez.okoaapp.R;

public class Vendor_signup extends AppCompatActivity {
    private EditText vendorname, vendoremail, vendorpass, vendorconfpass;
    private Button btnvensorsignup, btnvendorlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_signup);

        EditText vendorname = findViewById(R.id.vendorname);
        EditText vendoremail = findViewById(R.id.vendoremail);
        EditText vendorpass = findViewById(R.id.vendorpass);
        EditText vendorconfpass = findViewById(R.id.vendorconfpass);
        Button btnvensorsignup = findViewById(R.id.btnvendorsignup);
        Button btnvendorlogin = findViewById(R.id.btnvendorlogin);

        btnvendorlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vendor_signup.this, Vendor_login.class);
                startActivity(intent);
            }
        });
    }
}