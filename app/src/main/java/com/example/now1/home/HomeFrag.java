package com.example.now1.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.now1.R;
import com.example.now1.home.Adapter.SectionPagerAdapterHome;
import com.example.now1.home.IconMenu.IconMenuAdapter;
import com.example.now1.home.IconMenu.ListIcon;
import com.example.now1.home.Tab.banchay.BanChayFrag;
import com.example.now1.home.Tab.GanToiFrag;
import com.example.now1.home.Tab.GiaoNhanhFrag;
import com.example.now1.home.bosuutap1.Bosuutap1Adapter;
import com.example.now1.home.bosuutap1.ListBoSuuTap1;
import com.example.now1.home.listProvince.ListProvinceAct;
import com.example.now1.home.tonghopicon.TongHopIconAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class HomeFrag extends Fragment {

    private TextView txtProvince, txtmap,txtxemthembst;
    RecyclerView recyclerViewbosuutap;
    private View root;
    public EditText txtlocation;
    Context context;
    RecyclerView mList1,mList2,mListbst1,mListthicon;
    List<ListIcon> appList1,appList2,appListthicon;
    List<ListBoSuuTap1> appListbst1;
    ViewPager viewPagerhome;
    TabLayout tabLayouthome;
    Spinner spinnerDanhSach;
    TextView selection;
    ArrayList<String> arrayList;

    public HomeFrag() {
        // Required empty public constructor
    }

    public static HomeFrag getInstance() {
        return new HomeFrag();
    }

    interface FragmentCallback {
        void onClickButton(HomeFrag fragment);
    }
    private FragmentCallback mCallback;
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        context=getActivity();
        root = inflater.inflate(R.layout.fragment_home, container, false);

        // List Tỉnh Thành
        txtProvince = root.findViewById(R.id.selection);
        txtProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListprovince();
            }
        });

        //Xem thêm bộ sưu tập
//        txtxemthembst=root.findViewById(R.id.xemthembst);
//        txtxemthembst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openXemThemBoSuuTap();
//            }
//        });

        // List Icon
        mList1 = root.findViewById(R.id.listicon1);
        mListbst1=root.findViewById(R.id.listbst1);
        appList1 = new ArrayList<>();
        appListbst1= new ArrayList<>();

        appList1.add(new ListIcon(R.drawable.trasua,"Trà sữa"));
        appList1.add(new ListIcon(R.drawable.tigersugar,"Tiger Sugar"));
        appList1.add(new ListIcon(R.drawable.rice,"Cơm"));
        appList1.add(new ListIcon(R.drawable.freeship,"Freeship XTra"));
        appList1.add(new ListIcon(R.drawable.snack,"Ăn vặt"));
        appList1.add(new ListIcon(R.drawable.nowship,"Now ship"));
        appList1.add(new ListIcon(R.drawable.quanmoi,"Quán mới"));
        appList1.add(new ListIcon(R.drawable.airpay,"Airpay"));
        appList1.add(new ListIcon(R.drawable.nowtable,"NowTable"));
        appList1.add(new ListIcon(R.drawable.nowfresh,"NowFresh"));
        appList1.add(new ListIcon(R.drawable.doitac,"Đối tác"));
        appList1.add(new ListIcon(R.drawable.hoa,"Hoa"));
        appList1.add(new ListIcon(R.drawable.pet,"Thú cưng"));
        appList1.add(new ListIcon(R.drawable.sieuthi,"Siêu thị"));
        appList1.add(new ListIcon(R.drawable.giatui,"Giặt ủi"));
        appList1.add(new ListIcon(R.drawable.thuoc,"Thuốc"));
        appList1.add(new ListIcon(R.drawable.lamdep,"Làm đẹp"));
        appList1.add(new ListIcon(R.drawable.bia,"Bia"));
        appList1.add(new ListIcon(R.drawable.sale,"Sale"));
        appList1.add(new ListIcon(R.drawable.giupviec,"Giúp việc"));

        GridLayoutManager manager1 = new GridLayoutManager(HomeFrag.this.getActivity(),2);
        manager1.setOrientation(GridLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        IconMenuAdapter adaptor1 = new IconMenuAdapter(HomeFrag.this.getActivity(),appList1);
        mList1.setAdapter(adaptor1);



        // List Bộ siêu tập1
        appListbst1.add(new ListBoSuuTap1(1,R.drawable.bst1,"Combo x3 với thẻ Visa"));
        appListbst1.add(new ListBoSuuTap1(2,R.drawable.bst2,"Bữa tiệc đa dạng"));
        appListbst1.add(new ListBoSuuTap1(3,R.drawable.bst3,"Combo lẩu tươi"));
        appListbst1.add(new ListBoSuuTap1(4,R.drawable.bst4,"Combo cơm Lào"));
        appListbst1.add(new ListBoSuuTap1(5,R.drawable.bst5,"Deal đỉnh mỗi ngày"));

        LinearLayoutManager manager3 = new LinearLayoutManager(HomeFrag.this.getActivity());
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListbst1.setLayoutManager(manager3);

        Bosuutap1Adapter adaptor3 = new Bosuutap1Adapter(HomeFrag.this.getActivity(),appListbst1);
        mListbst1.setAdapter(adaptor3);



        viewPagerhome = root.findViewById(R.id.viewPagerhome);
        tabLayouthome = root.findViewById(R.id.tabLayouthome);

        txtlocation=root.findViewById(R.id.textlocation);

        //ImageSlider

        ImageSlider imageSlider = (ImageSlider) root.findViewById ( R.id.slide );
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add ( new SlideModel (R.drawable.sld1) );
        slideModels.add ( new SlideModel (R.drawable.sld2) );
        slideModels.add ( new SlideModel (R.drawable.sld3) );
        slideModels.add ( new SlideModel (R.drawable.sld4) );
        slideModels.add ( new SlideModel (R.drawable.sld7) );
        imageSlider.setImageList ( slideModels,true );

        //ImageSlider1
        ImageSlider imageSlider1 = (ImageSlider) root.findViewById ( R.id.slide1 );
        List<SlideModel> slideModels1 = new ArrayList<>();
        slideModels1.add ( new SlideModel (R.drawable.sld6) );
        slideModels1.add ( new SlideModel (R.drawable.sld8) );
        slideModels1.add ( new SlideModel (R.drawable.sld9) );
        slideModels1.add ( new SlideModel (R.drawable.sld10) );
        slideModels1.add ( new SlideModel (R.drawable.sld11) );
        imageSlider1.setImageList ( slideModels1,true );

        // List tổng hợp icon
        mListthicon=root.findViewById(R.id.listthonghop);
        appListthicon= new ArrayList<>();

        appListthicon.add(new ListIcon(R.drawable.tatca,"Tất cả"));
        appListthicon.add(new ListIcon(R.drawable.food,"Đồ ăn"));
        appListthicon.add(new ListIcon(R.drawable.douong,"Đồ uống"));
        appListthicon.add(new ListIcon(R.drawable.monchay,"Đồ chay"));
        appListthicon.add(new ListIcon(R.drawable.banhkem,"Bánh kem"));
        appListthicon.add(new ListIcon(R.drawable.trangmieng,"Tráng miệng"));
        appListthicon.add(new ListIcon(R.drawable.homemade,"Homemade"));
        appListthicon.add(new ListIcon(R.drawable.viahe,"Vỉa hè"));
        appListthicon.add(new ListIcon(R.drawable.burger,"Pizza/Burger"));
        appListthicon.add(new ListIcon(R.drawable.monga,"Món gà"));
        appListthicon.add(new ListIcon(R.drawable.lau,"Món lẩu"));
        appListthicon.add(new ListIcon(R.drawable.sushi,"Sushi"));
        appListthicon.add(new ListIcon(R.drawable.noodle,"Mì phở"));
        appListthicon.add(new ListIcon(R.drawable.com,"Cơm hộp"));

        LinearLayoutManager manager4 = new LinearLayoutManager(HomeFrag.this.getActivity());
        manager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListthicon.setLayoutManager(manager4);

        TongHopIconAdapter adaptor4 = new TongHopIconAdapter(HomeFrag.this.getActivity(),appListthicon);
        mListthicon.setAdapter(adaptor4);

        //chọn địa chỉ
        selection =root.findViewById(R.id.selection);
        spinnerDanhSach=root.findViewById(R.id.spChiNhanh);
        arrayList = new ArrayList<String>();
        arrayList.add("Đà Nẵng");
        arrayList.add("HCM");
        arrayList.add("Hà Nội");
        arrayList.add("Huế");
        arrayList.add("Hà Giang");
        arrayList.add("Cần Thơ");
        arrayList.add("Hà Tĩnh");
        arrayList.add("Quảng Bình");
        arrayList.add("Quảng Trị");
        arrayList.add("Quảng Nam");
        arrayList.add("Phú Yên");
        arrayList.add("Bình Định");
        arrayList.add("Nha Trang");
        arrayList.add("Quảng Ninh");
        arrayList.add("Lai Châu");
        arrayList.add("Sơn La");
        arrayList.add("Dak Lak");
        arrayList.add("Cà Mau");
        arrayList.add("Bình Thuận");
        arrayList.add("Ninh Thuận");
        arrayList.add("Khánh Hòa");
        arrayList.add("Nghệ An");
        arrayList.add("Thanh Hóa");
        arrayList.add("Hà Nam");
        arrayList.add("Bắc Giang");
        arrayList.add("Lạng Sơn");
        arrayList.add("Lai Châu");
        arrayList.add("Hải Phòng");
        arrayList.add("Bình Dương");
        arrayList.add("Đồng Tháp");
        arrayList.add("Đồng Nai");
        arrayList.add("Kon Tum");
        arrayList.add("Lâm Đồng");
        arrayList.add("Dak Nông");
        arrayList.add("Hậu Giang");
        arrayList.add("Tiền Giang");
        arrayList.add("Nha Trang");
        arrayList.add("Bạc Liêu");
        arrayList.add("Sóc Trăng");
        arrayList.add("Tây Ninh");
        arrayList.add("BM Thuật");
        arrayList.add("Gia Lai");
        arrayList.add("Bắc Kan");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_single_choice,arrayList);
        spinnerDanhSach.setAdapter(arrayAdapter);

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinnerDanhSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                selection.setText(arrayList.get(position));
                Toast.makeText(getActivity(),  arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        }); //


        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPagerHome(viewPagerhome);
        tabLayouthome.setupWithViewPager(viewPagerhome);
        tabLayouthome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private void setUpViewPagerHome(ViewPager viewPager) {
        SectionPagerAdapterHome adapter = new SectionPagerAdapterHome(getChildFragmentManager());

        adapter.addFragment(new BanChayFrag(), "Bán chạy");
        adapter.addFragment(new GanToiFrag(), "Gần tôi");
        adapter.addFragment(new BanChayFrag(), "Đánh giá");
        adapter.addFragment(new GiaoNhanhFrag(), "Giao nhanh");
        viewPagerhome.setAdapter(adapter);
    }

    public void openListprovince(){
        Intent intent=new Intent(HomeFrag.this.getActivity(), ListProvinceAct.class);
        startActivity(intent);
    }
}