package com.example.lun.uitester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lun on 06/07/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> city;
    public CustomAdapter(Context context, ArrayList<String> city){
        super();
        this.context = context;
        this.city = city;
    }
    @Override
    public int getCount() {
        return city.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View dropdownItem = convertView;
        if(dropdownItem == null){
            dropdownItem = LayoutInflater.from(context).inflate(R.layout.spinner_dropdown, null);
        }

        String selectedCity = city.get(position);

        TextView cityText = (TextView)dropdownItem.findViewById(R.id.city_text);
        cityText.setText(selectedCity);

        ImageView cityImage = (ImageView) dropdownItem.findViewById(R.id.city_image);
        cityImage.setImageResource(R.mipmap.ic_launcher_round);

        return dropdownItem;
    }
}
