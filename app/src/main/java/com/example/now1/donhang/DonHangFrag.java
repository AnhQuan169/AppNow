package com.example.now1.donhang;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.now1.R;
import com.example.now1.donhang.Adapter.SectionPagerAdapter;
import com.example.now1.donhang.tab.dangden.DangDen;
import com.example.now1.donhang.tab.donnhap.DonNhap;
import com.example.now1.donhang.tab.lichsu.LichSu;
import com.google.android.material.tabs.TabLayout;


public class DonHangFrag extends Fragment {


    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;


    public DonHangFrag() {
        // Required empty public constructor
    }

    public static DonHangFrag getInstance() {
        return new DonHangFrag();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_don_hang, container, false);
        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);
        return myFragment;
    }
    //Call onActivity Create method

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new DangDen(), "Đang đến");
        adapter.addFragment(new LichSu(), "Lịch sử");
        adapter.addFragment(new DonNhap(), "Đơn nháp");
        viewPager.setAdapter(adapter);
    }
}