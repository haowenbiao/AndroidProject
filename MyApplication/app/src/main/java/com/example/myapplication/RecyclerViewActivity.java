package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends ActivityWithCloseMenu {

    List<My_ListItem> my_listItems = new ArrayList<>();
    RecyclerView rv_sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        yangshi1();

        rv_sample = (RecyclerView) findViewById(R.id.rv_sample);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_sample.setLayoutManager(linearLayoutManager);
        My_RecycleViewAdapter my_recycleViewAdapter = new My_RecycleViewAdapter(my_listItems);
        rv_sample.setAdapter(my_recycleViewAdapter);

    }

    private void yangshi1() {
        for (int i = 0; i < 300; i++) {
            My_ListItem listItem = new My_ListItem(i, "sample");
            my_listItems.add(listItem);
        }
    }

    public static void start(Context context, Class<?> cls) {
        Intent starter = new Intent(context, cls);
        context.startActivity(starter);
    }

    public class My_ListItem {
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

    public class My_RecycleViewAdapter extends RecyclerView.Adapter<My_RecycleViewAdapter.ViewHolder> {

        List<My_ListItem> my_listItems;

        public My_RecycleViewAdapter(List<My_ListItem> listItems) {
            my_listItems = listItems;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.tv_Id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RecyclerViewActivity.this,
                            String.valueOf(my_listItems.get(viewHolder.getAdapterPosition()).getId()), Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.tv_Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RecyclerViewActivity.this,
                            my_listItems.get(viewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            My_ListItem my_listItem = my_listItems.get(position);
            holder.tv_Id.setText(String.valueOf(my_listItem.getId()));
            holder.tv_Name.setText(my_listItem.getName());
        }

        @Override
        public int getItemCount() {
            return my_listItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_Id;
            TextView tv_Name;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_Id = (TextView) itemView.findViewById(R.id.tv_item_Id);
//                tv_Id.setOnClickListener(v -> Toast.makeText(RecyclerViewActivity.this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show());
                tv_Name = (TextView) itemView.findViewById(R.id.tv_item_Name);
//                tv_Name.setOnClickListener(v -> Toast.makeText(RecyclerViewActivity.this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show());
            }
        }
    }
}
