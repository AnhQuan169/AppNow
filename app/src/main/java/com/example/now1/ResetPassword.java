package com.example.now1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
    TextView username_reset;
    EditText password_reset, repassword_reset;
    Button btnconfirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        username_reset = (TextView) findViewById(R.id.username_reset_text);
        password_reset = (EditText) findViewById(R.id.password_reset);
        repassword_reset = (EditText) findViewById(R.id.repassword_reset);
        btnconfirm = (Button) findViewById(R.id.btnconform);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        username_reset.setText(intent.getStringExtra("username"));
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username_reset.getText().toString();
                String password = password_reset.getText().toString();
                String repassword = repassword_reset.getText().toString();

                if (password.equals(repassword)) {
                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), DangNhap.class);
                        startActivity(intent);
                        Toast.makeText(ResetPassword.this, "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetPassword.this, "Cập nhật mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ResetPassword.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}