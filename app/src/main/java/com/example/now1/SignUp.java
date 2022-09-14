package com.example.now1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    TextView dangnhap;
    //    TextView forgot;
    EditText username,password,repassword;
    Button btnsignup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //1. Kích chuyển sang trang SignUp nếu bấm chữ
        dangnhap = (TextView) findViewById(R.id.dangnhap);
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        //2. DB đăng kí tài khoản
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);

        DB=new DBHelper(this);
        btnsignup=(Button) findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(SignUp.this,"Vui lòng nhập tất cả giá trị",Toast.LENGTH_SHORT).show();
                } else {
                    if(pass.equals(repass)){
                        Boolean checkuser =DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(SignUp.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
//                                Intent intent=new Intent(getApplicationContext(), HomeFragment.class);
//                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp.this,"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUp.this,"Tên đăng nhập đã tồn tại. Mời đăng kí lại",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this,"Mật khẩu không đúng",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        //3. DB quên mật khẩu
//        forgot=(TextView) findViewById(R.id.forgot);
//        forgot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openForgotPassword();
//            }
//        });

    }
    //1. Kích nhảy trang Sign UP
    public void openLogin() {
        Intent intent = new Intent(this, DangNhap.class);
        startActivity(intent);
        finish();
    }
//    //2. Kích nhảy trang Forgot Password
//    public void openForgotPassword() {
//        Intent intent = new Intent(this, ForgotPassword.class);
//        startActivity(intent);
//        finish();
//    }
}