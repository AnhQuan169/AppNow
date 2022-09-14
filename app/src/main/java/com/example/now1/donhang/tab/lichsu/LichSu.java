package com.example.now1.donhang.tab.lichsu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.now1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


public class LichSu extends Fragment {

    Spinner spinnerloaihinhls,spinnerlsdh;
    TextView selectionloails,selectionlsdh,txtchonngay;
    ArrayList<String> arrayList,arrayList1;
    Context context;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        View root= inflater.inflate(R.layout.fragment_lich_su, container, false);

        //Spinner loai lich su
        selectionloails =root.findViewById(R.id.txtloaihinhlichsu);
        spinnerloaihinhls=root.findViewById(R.id.sploailichsu);
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
        spinnerloaihinhls.setAdapter(arrayAdapter);

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinnerloaihinhls.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                selectionloails.setText(arrayList.get(position));
                Toast.makeText(getActivity(),  arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        }); //

        //Spinner loại kiểu đơn lịch sử
        selectionlsdh =root.findViewById(R.id.txtlsdh);
        spinnerlsdh=root.findViewById(R.id.sploailsdh);
        arrayList1 = new ArrayList<String>();
        arrayList1.add("Tất cả");
        arrayList1.add("Đã hủy");
        arrayList1.add("Hoàn thành");
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_single_choice,arrayList1);
        spinnerlsdh.setAdapter(arrayAdapter1);

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinnerlsdh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                //đối số postion là vị trí phần tử trong list Data
                selectionlsdh.setText(arrayList1.get(position1));
                Toast.makeText(getActivity(),  arrayList1.get(position1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        }); //

        // Chọn ngày
        txtchonngay=root.findViewById(R.id.txtngayls);
        Calendar calendar=Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month= calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        txtchonngay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(LichSu.this.getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        txtchonngay.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        return root;
    }
}