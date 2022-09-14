package com.example.now1.thongbao.caidatthongbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.now1.R;
import com.example.now1.thongbao.ThongBaoFrag;
import com.example.now1.thongbao.tintuc.TinTucTBAct;

public class CaiDatThongBaoAct extends AppCompatActivity {

    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat_thong_bao);
        back=(ImageView) findViewById(R.id.backcaidattb);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openThongBaoCD();
            }
        });
    }

    private void openThongBaoCD(){
        Intent intent=new Intent(CaiDatThongBaoAct.this, ThongBaoFrag.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}