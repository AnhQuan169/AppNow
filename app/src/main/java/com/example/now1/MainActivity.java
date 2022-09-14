package com.example.now1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.now1.daluu.DaLuuFrag;
import com.example.now1.donhang.DonHangFrag;
import com.example.now1.home.HomeFrag;
import com.example.now1.thongbao.ThongBaoFrag;
import com.example.now1.toi.ToiFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFrag()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFrag();
                            break;
                        case R.id.navigation_order:
                            selectedFragment = new DonHangFrag();
                            break;
                        case R.id.navigation_collections:
                            selectedFragment = new DaLuuFrag();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new ThongBaoFrag();
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = new ToiFrag();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}