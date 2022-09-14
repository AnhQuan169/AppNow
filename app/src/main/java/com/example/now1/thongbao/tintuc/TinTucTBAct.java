package com.example.now1.thongbao.tintuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.now1.R;
import com.example.now1.thongbao.ThongBaoFrag;

public class TinTucTBAct extends AppCompatActivity {

    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc_tb);
        back=(ImageView) findViewById(R.id.backtintuc);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openThongBao();
            }
        });
    }

    private void openThongBao(){
        Intent intent=new Intent(TinTucTBAct.this, ThongBaoFrag.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

}