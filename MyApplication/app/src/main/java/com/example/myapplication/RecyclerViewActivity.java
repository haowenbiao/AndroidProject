package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
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
                tv_Id = (TextView) findViewById(R.id.tv_item_Id);
                tv_Name = (TextView) findViewById(R.id.tv_item_Name);
            }
        }
    }
}
