package com.example.now1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.Login;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LogoBK extends AppCompatActivity {

    private static  int SPLASH_SCREEN = 5000;
    //variables
    Animation topAnim , bottonAnim,midAnim;
    ImageView img;
    TextView tv_app,solgan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_bk);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottonAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        midAnim = AnimationUtils.loadAnimation(this,R.anim.mid_animation);
        // hooks
//        tv_app = findViewById(R.id.tv_app);
        solgan = findViewById(R.id.solgan);
        img = findViewById(R.id.logolk);
        img.setAnimation(topAnim);
//        tv_app.setAnimation(midAnim);
        solgan.setAnimation(bottonAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoBK.this, DangNhap.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}