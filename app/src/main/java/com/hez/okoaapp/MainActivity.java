package com.hez.okoaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationBarMenu;
import com.google.android.material.navigation.NavigationView;

import comm.android.Cart;
import comm.android.Feedback;
import comm.android.Home;
import comm.android.LoanRequest;
import comm.android.Order;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout1 = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout1,
                R.string.open_nav, R.string.close_nav);
        drawerLayout1.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState ==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        R.id.nav_home = 1;
        R.id.nav_cart = 2;
        R.id.nav_orders = 3;
        R.id.nav_feedback  = 5;
        R.id.request_loan = 6;

        switch (item.getItemId()){
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Cart()).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Order()).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Feedback()).commit();
                break;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoanRequest()).commit();
                break;

        }
        drawerLayout1.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout1.isDrawerOpen(GravityCompat.START)){
            drawerLayout1.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
