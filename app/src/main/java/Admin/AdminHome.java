package Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.hez.okoaapp.LoanRequest;
import com.hez.okoaapp.Newproduct;
import com.hez.okoaapp.R;
import com.hez.okoaapp.ViewAllProduct;
import com.hez.okoaapp.ViewCustomerOrders;
import com.hez.okoaapp.ViewCustomerfeedback;

public class AdminHome extends AppCompatActivity {

    private RelativeLayout newproduct, viewproduct, viewfeedback,vieworder, loanrequest, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        newproduct = findViewById(R.id.new_product_layout1);
        viewproduct = findViewById(R.id.view_all_products);
        viewfeedback = findViewById(R.id.view_all_feedback);
        vieworder = findViewById(R.id.view_customer_order);
        loanrequest = findViewById(R.id.view_loan_layout);
        logout = findViewById(R.id.logout_btn);

        newproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, Newproduct.class);
                startActivity(intent);
            }
        });
        viewproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AdminHome.this, ViewAllProduct.class);
                startActivity(intent);
            }
        });
        viewfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, ViewCustomerfeedback.class);
                startActivity(intent);
            }
        });
        vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, ViewCustomerOrders.class);
                startActivity(intent);
            }
        });
        loanrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, LoanRequest.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}