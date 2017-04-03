package com.example.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends ActivityWithCloseMenu {

    ListView lv_sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        yangshi1();

        //样式1-复杂（默认）
        Button bt_yangshi1 = (Button) findViewById(R.id.bt_yangshi1);
        bt_yangshi1.setOnClickListener(v -> yangshi1());

        //样式2-简单
        Button bt_yangshi2 = (Button) findViewById(R.id.bt_yangshi2);
        bt_yangshi2.setOnClickListener(v -> yangshi2());

    }

    private void yangshi1() {
        List<My_ListItem> my_listItems = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            My_ListItem my_listItem = new My_ListItem(i, "sample");
            my_listItems.add(my_listItem);
        }
        My_Adapter my_listItemMyAdapter = new My_Adapter(ListViewActivity.this, R.layout.layout_item, my_listItems);
        lv_sample = (ListView) findViewById(R.id.lv_sample);
        lv_sample.setAdapter(my_listItemMyAdapter);
    }

    private void yangshi2() {
        //简单ListView
        String[] list = {"string-1", "string-2", "string-3", "string-4", "string-5", "string-6",
                "string-1", "string-2", "string-3", "string-4", "string-5", "string-6",
                "string-1", "string-2", "string-3", "string-4", "string-5", "string-6"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv_sample = (ListView) findViewById(R.id.lv_sample);
        lv_sample.setAdapter(stringArrayAdapter);
    }

    private class My_ListItem {
        private int m_id;
        private String m_name;

        public int getId() {
            return m_id;
        }

        public String getName() {
            return m_name;
        }

        public My_ListItem(int id, String name) {
            this.m_id = id;
            this.m_name = name;
        }
    }

    private class My_Adapter extends ArrayAdapter<My_ListItem> {

        private int resourceIdOfLayoutItem;

        public My_Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<My_ListItem> objects) {
            super(context, resource, objects);
            resourceIdOfLayoutItem = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            My_ListItem my_listItem = getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resourceIdOfLayoutItem, parent, false);

            TextView tv_Item_Id = (TextView) view.findViewById(R.id.tv_item_Id);
            tv_Item_Id.setText(String.valueOf(my_listItem.getId()));

            TextView tv_item_name = (TextView) view.findViewById(R.id.tv_item_Name);
            tv_item_name.setText(my_listItem.getName());
            return view;
        }
    }
}



