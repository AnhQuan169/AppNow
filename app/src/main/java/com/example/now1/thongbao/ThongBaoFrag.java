package com.example.now1.thongbao;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.now1.R;
import com.example.now1.thongbao.caidatthongbao.CaiDatThongBaoAct;
import com.example.now1.thongbao.khuyenmai.KhuyenMaiTBAct;
import com.example.now1.thongbao.tintuc.TinTucTBAct;


public class ThongBaoFrag extends Fragment {

    private ImageView thongbaott,thongbaokm,caidattb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_thong_bao, container, false);

        // Thông báo tin tức
        thongbaott=root.findViewById(R.id.thongbaott);
        thongbaott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThongBaoTinTuc();
            }
        });

        // Thông báo khuyến mãi
        thongbaokm=root.findViewById(R.id.thongbaokm);
        thongbaokm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThongBaoKhuyenMai();
            }
        });

        // Cài đặt thông báo
        caidattb=root.findViewById(R.id.caidattb);
        caidattb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCaiDatThongBao();
            }
        });

        return root;
    }

    private void openThongBaoTinTuc(){
        Intent intent=new Intent(ThongBaoFrag.this.getActivity(), TinTucTBAct.class);
        startActivity(intent);
    }

    private void openThongBaoKhuyenMai(){
        Intent intent=new Intent(ThongBaoFrag.this.getActivity(), KhuyenMaiTBAct.class);
        startActivity(intent);
    }

    private void openCaiDatThongBao(){
        Intent intent=new Intent(ThongBaoFrag.this.getActivity(), CaiDatThongBaoAct.class);
        startActivity(intent);
    }
}