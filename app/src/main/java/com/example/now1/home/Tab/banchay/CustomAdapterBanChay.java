package com.example.now1.home.Tab.banchay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.now1.R;

import java.util.ArrayList;

public class CustomAdapterBanChay extends BaseAdapter {

    Context context;
    ArrayList<MonAnBanChayModel> monanBCData;
    LayoutInflater layoutInflater;
    MonAnBanChayModel monAnBanChayModel;

    public CustomAdapterBanChay(Context context, ArrayList<MonAnBanChayModel> monanBCData) {
        this.monanBCData = monanBCData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return monanBCData.size();
    }

    @Override
    public Object getItem(int i) {
        return monanBCData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return monanBCData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.row_listbanchay, null, true);
        }
        //link views
        ImageView imgbc = rowView.findViewById(R.id.idimgbanchay);
        TextView idtenmonanbc = rowView.findViewById(R.id.idtenmonanbanchay);
        TextView iddiachibc = rowView.findViewById(R.id.iddiachibanchay);
        TextView idgiabc = rowView.findViewById(R.id.idgiabanchay);

        monAnBanChayModel = monanBCData.get(position);

        imgbc.setImageResource(monAnBanChayModel.getIdimgbc());
        idtenmonanbc.setText(monAnBanChayModel.getIdtenmonanbc());
        idgiabc.setText(monAnBanChayModel.getIdgiabc());
        iddiachibc.setText(monAnBanChayModel.getIddiachibc());

        return rowView;
    }

}
