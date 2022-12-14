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

        // List T???nh Th??nh
        txtProvince = root.findViewById(R.id.selection);
        txtProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListprovince();
            }
        });

        //Xem th??m b??? s??u t???p
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

        appList1.add(new ListIcon(R.drawable.trasua,"Tr?? s???a"));
        appList1.add(new ListIcon(R.drawable.tigersugar,"Tiger Sugar"));
        appList1.add(new ListIcon(R.drawable.rice,"C??m"));
        appList1.add(new ListIcon(R.drawable.freeship,"Freeship XTra"));
        appList1.add(new ListIcon(R.drawable.snack,"??n v???t"));
        appList1.add(new ListIcon(R.drawable.nowship,"Now ship"));
        appList1.add(new ListIcon(R.drawable.quanmoi,"Qu??n m???i"));
        appList1.add(new ListIcon(R.drawable.airpay,"Airpay"));
        appList1.add(new ListIcon(R.drawable.nowtable,"NowTable"));
        appList1.add(new ListIcon(R.drawable.nowfresh,"NowFresh"));
        appList1.add(new ListIcon(R.drawable.doitac,"?????i t??c"));
        appList1.add(new ListIcon(R.drawable.hoa,"Hoa"));
        appList1.add(new ListIcon(R.drawable.pet,"Th?? c??ng"));
        appList1.add(new ListIcon(R.drawable.sieuthi,"Si??u th???"));
        appList1.add(new ListIcon(R.drawable.giatui,"Gi???t ???i"));
        appList1.add(new ListIcon(R.drawable.thuoc,"Thu???c"));
        appList1.add(new ListIcon(R.drawable.lamdep,"L??m ?????p"));
        appList1.add(new ListIcon(R.drawable.bia,"Bia"));
        appList1.add(new ListIcon(R.drawable.sale,"Sale"));
        appList1.add(new ListIcon(R.drawable.giupviec,"Gi??p vi???c"));

        GridLayoutManager manager1 = new GridLayoutManager(HomeFrag.this.getActivity(),2);
        manager1.setOrientation(GridLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        IconMenuAdapter adaptor1 = new IconMenuAdapter(HomeFrag.this.getActivity(),appList1);
        mList1.setAdapter(adaptor1);



        // List B??? si??u t???p1
        appListbst1.add(new ListBoSuuTap1(1,R.drawable.bst1,"Combo x3 v???i th??? Visa"));
        appListbst1.add(new ListBoSuuTap1(2,R.drawable.bst2,"B???a ti???c ??a d???ng"));
        appListbst1.add(new ListBoSuuTap1(3,R.drawable.bst3,"Combo l???u t????i"));
        appListbst1.add(new ListBoSuuTap1(4,R.drawable.bst4,"Combo c??m L??o"));
        appListbst1.add(new ListBoSuuTap1(5,R.drawable.bst5,"Deal ?????nh m???i ng??y"));

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

        // List t???ng h???p icon
        mListthicon=root.findViewById(R.id.listthonghop);
        appListthicon= new ArrayList<>();

        appListthicon.add(new ListIcon(R.drawable.tatca,"T???t c???"));
        appListthicon.add(new ListIcon(R.drawable.food,"????? ??n"));
        appListthicon.add(new ListIcon(R.drawable.douong,"????? u???ng"));
        appListthicon.add(new ListIcon(R.drawable.monchay,"????? chay"));
        appListthicon.add(new ListIcon(R.drawable.banhkem,"B??nh kem"));
        appListthicon.add(new ListIcon(R.drawable.trangmieng,"Tr??ng mi???ng"));
        appListthicon.add(new ListIcon(R.drawable.homemade,"Homemade"));
        appListthicon.add(new ListIcon(R.drawable.viahe,"V???a h??"));
        appListthicon.add(new ListIcon(R.drawable.burger,"Pizza/Burger"));
        appListthicon.add(new ListIcon(R.drawable.monga,"M??n g??"));
        appListthicon.add(new ListIcon(R.drawable.lau,"M??n l???u"));
        appListthicon.add(new ListIcon(R.drawable.sushi,"Sushi"));
        appListthicon.add(new ListIcon(R.drawable.noodle,"M?? ph???"));
        appListthicon.add(new ListIcon(R.drawable.com,"C??m h???p"));

        LinearLayoutManager manager4 = new LinearLayoutManager(HomeFrag.this.getActivity());
        manager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListthicon.setLayoutManager(manager4);

        TongHopIconAdapter adaptor4 = new TongHopIconAdapter(HomeFrag.this.getActivity(),appListthicon);
        mListthicon.setAdapter(adaptor4);

        //ch???n ?????a ch???
        selection =root.findViewById(R.id.selection);
        spinnerDanhSach=root.findViewById(R.id.spChiNhanh);
        arrayList = new ArrayList<String>();
        arrayList.add("???? N???ng");
        arrayList.add("HCM");
        arrayList.add("H?? N???i");
        arrayList.add("Hu???");
        arrayList.add("H?? Giang");
        arrayList.add("C???n Th??");
        arrayList.add("H?? T??nh");
        arrayList.add("Qu???ng B??nh");
        arrayList.add("Qu???ng Tr???");
        arrayList.add("Qu???ng Nam");
        arrayList.add("Ph?? Y??n");
        arrayList.add("B??nh ?????nh");
        arrayList.add("Nha Trang");
        arrayList.add("Qu???ng Ninh");
        arrayList.add("Lai Ch??u");
        arrayList.add("S??n La");
        arrayList.add("Dak Lak");
        arrayList.add("C?? Mau");
        arrayList.add("B??nh Thu???n");
        arrayList.add("Ninh Thu???n");
        arrayList.add("Kh??nh H??a");
        arrayList.add("Ngh??? An");
        arrayList.add("Thanh H??a");
        arrayList.add("H?? Nam");
        arrayList.add("B???c Giang");
        arrayList.add("L???ng S??n");
        arrayList.add("Lai Ch??u");
        arrayList.add("H???i Ph??ng");
        arrayList.add("B??nh D????ng");
        arrayList.add("?????ng Th??p");
        arrayList.add("?????ng Nai");
        arrayList.add("Kon Tum");
        arrayList.add("L??m ?????ng");
        arrayList.add("Dak N??ng");
        arrayList.add("H???u Giang");
        arrayList.add("Ti???n Giang");
        arrayList.add("Nha Trang");
        arrayList.add("B???c Li??u");
        arrayList.add("S??c Tr??ng");
        arrayList.add("T??y Ninh");
        arrayList.add("BM Thu???t");
        arrayList.add("Gia Lai");
        arrayList.add("B???c Kan");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_single_choice,arrayList);
        spinnerDanhSach.setAdapter(arrayAdapter);

        //B???t s??? ki???n cho Spinner, khi ch???n ph???n t??? n??o th?? hi???n th??? l??n Toast
        spinnerDanhSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //?????i s??? postion l?? v??? tr?? ph???n t??? trong list Data
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

        adapter.addFragment(new BanChayFrag(), "B??n ch???y");
        adapter.addFragment(new GanToiFrag(), "G???n t??i");
        adapter.addFragment(new BanChayFrag(), "????nh gi??");
        adapter.addFragment(new GiaoNhanhFrag(), "Giao nhanh");
        viewPagerhome.setAdapter(adapter);
    }

    public void openListprovince(){
        Intent intent=new Intent(HomeFrag.this.getActivity(), ListProvinceAct.class);
        startActivity(intent);
    }
}