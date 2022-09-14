package com.example.now1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    EditText username_reset;
    Button btnreset;
    DBHelper DB;
    ImageView backfg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        username_reset=(EditText) findViewById(R.id.username_reset);
        btnreset=(Button) findViewById(R.id.btnreset);
        DB=new DBHelper(this);

        backfg = (ImageView) findViewById(R.id.backfg);
        backfg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username_reset.getText().toString();
                Boolean checkuser=DB.checkusername(user);
                if(checkuser==true){
                    Intent intent=new Intent(getApplicationContext(),ResetPassword.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgotPassword.this, "Username không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openLogin() {
        Intent intent = new Intent(this, DangNhap.class);
        startActivity(intent);
        finish();
    }
}