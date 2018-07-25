package com.ricardogwill.listapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    // Class constructor
    public ItemAdapter(Context c, String[] items, String[] prices, String[] descriptions) {
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.prices = prices;
        this.descriptions = descriptions;
    }

    // Below are methods that must be overridden (via Alt+Enter) to extend the BaseAdapter class.
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = inflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);

        String name = items[position];
        String cost = prices[position];
        String desc = descriptions[position];

        nameTextView.setText(name);
        priceTextView.setText(cost);
        descriptionTextView.setText(desc);

        return v;
    }
}
