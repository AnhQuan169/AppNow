package com.example.now1.thongbao.khuyenmai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.now1.R;
import com.example.now1.thongbao.ThongBaoFrag;
import com.example.now1.thongbao.tintuc.TinTucTBAct;

public class KhuyenMaiTBAct extends AppCompatActivity {

    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai_t_b);
        back=(ImageView) findViewById(R.id.backkhuyenmai);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openThongBaoKM();
            }
        });
    }

    private void openThongBaoKM(){
        Intent intent=new Intent(KhuyenMaiTBAct.this, ThongBaoFrag.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}