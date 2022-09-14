package com.example.now1.home.listProvince;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.now1.R;
import com.example.now1.home.HomeFrag;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListProvinceAct extends AppCompatActivity {

    ArrayList<ProvinceModel> provinceModels;
    ListView listView;
    private static ProvinceAdapter adapter;

    ImageView back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_province);
        back=(ImageView) findViewById(R.id.backchontinh);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });
        listView=(ListView)findViewById(R.id.listView);
        provinceModels = new ArrayList<>();
        provinceModels.add(new ProvinceModel("Hà Nội"));
        provinceModels.add(new ProvinceModel("Thành phố Hồ Chí Minh"));
        provinceModels.add(new ProvinceModel("Đà Nẵng"));
        provinceModels.add(new ProvinceModel("Huế"));
        provinceModels.add(new ProvinceModel("Cần Thơ"));
        provinceModels.add(new ProvinceModel("Thái Bình"));
        provinceModels.add(new ProvinceModel("Nghệ An"));
        provinceModels.add(new ProvinceModel("Nam Định"));
        provinceModels.add(new ProvinceModel("Hải Phòng"));
        provinceModels.add(new ProvinceModel("Quảng Ninh"));
        provinceModels.add(new ProvinceModel("Quảng Bình"));
        provinceModels.add(new ProvinceModel("Điện Biên Phủ"));
        provinceModels.add(new ProvinceModel("Lào Cai"));
        provinceModels.add(new ProvinceModel("Hà Giang"));
        provinceModels.add(new ProvinceModel("Ninh Bình"));
        provinceModels.add(new ProvinceModel("Hà Tĩnh"));
        provinceModels.add(new ProvinceModel("Thanh Hóa"));
        provinceModels.add(new ProvinceModel("Quảng Trị"));
        provinceModels.add(new ProvinceModel("Hậu Giang"));
        provinceModels.add(new ProvinceModel("Quảng Nam"));
        provinceModels.add(new ProvinceModel("Bình Định"));
        provinceModels.add(new ProvinceModel("Hải Dương"));
        provinceModels.add(new ProvinceModel("Bình Dương"));
        provinceModels.add(new ProvinceModel("Long An"));
        provinceModels.add(new ProvinceModel("Bình Thuận"));
        provinceModels.add(new ProvinceModel("Quảng Ngãi"));
        provinceModels.add(new ProvinceModel("Đà Lạt"));
        provinceModels.add(new ProvinceModel("Lâm Đồng"));
        provinceModels.add(new ProvinceModel("Tiền Giang"));
        provinceModels.add(new ProvinceModel("Phú Yên"));
        provinceModels.add(new ProvinceModel("Cà Mau"));
        provinceModels.add(new ProvinceModel("Dak Lak"));
        provinceModels.add(new ProvinceModel("Sóc Trăng"));
        provinceModels.add(new ProvinceModel("Gia Lai"));
        provinceModels.add(new ProvinceModel("Khánh Hòa"));
        provinceModels.add(new ProvinceModel("Đồng Tháp"));
        provinceModels.add(new ProvinceModel("Tây Ninh"));
        provinceModels.add(new ProvinceModel("Bến Tre"));
        provinceModels.add(new ProvinceModel("Hòa Bình"));
        provinceModels.add(new ProvinceModel("Bắc Giang"));
        adapter= new ProvinceAdapter(provinceModels,getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProvinceModel provinceModel= provinceModels.get(position);

                Snackbar.make(view, provinceModel.getProvince(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void openMainActivity(){
        Intent intent=new Intent(ListProvinceAct.this, HomeFrag.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}