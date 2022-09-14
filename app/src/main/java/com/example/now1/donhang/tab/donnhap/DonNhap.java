package com.example.now1.donhang.tab.donnhap;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.now1.R;

import java.util.ArrayList;


public class DonNhap extends Fragment {

    Spinner spinnerdonnhap;
    TextView selectiondnhap;
    ArrayList<String> arrayList;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        View root= inflater.inflate(R.layout.fragment_don_nhap, container, false);

        //Spinner
        selectiondnhap =root.findViewById(R.id.txtloaihinhdonnhap);
        spinnerdonnhap=root.findViewById(R.id.sploaidonnhap);
        arrayList = new ArrayList<String>();
        arrayList.add("Dịch vụ");
        arrayList.add("Đồ ăn");
        arrayList.add("Thực phẩm");
        arrayList.add("Bia");
        arrayList.add("Hoa");
        arrayList.add("Siêu thị");
        arrayList.add("Thuốc");
        arrayList.add("Thú cưng");
        arrayList.add("Giặt ủi");
        arrayList.add("Giao hàng");
        arrayList.add("Đặt bàn");
        arrayList.add("Salon");
        arrayList.add("Giúp việc");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_single_choice,arrayList);
        spinnerdonnhap.setAdapter(arrayAdapter);

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinnerdonnhap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                selectiondnhap.setText(arrayList.get(position));
                Toast.makeText(getActivity(),  arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        }); //

        return root;
    }
}