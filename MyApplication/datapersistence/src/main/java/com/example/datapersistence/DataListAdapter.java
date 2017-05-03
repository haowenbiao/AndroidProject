package com.example.datapersistence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：郝文标 on 2017/5/3 11:31
 * 邮箱：haowenbiao@126.com
 */
public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {

    private List<PersonInformation> mPersonInformationList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_xuhao;
        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_xuhao = (TextView) itemView.findViewById(R.id.tv_xuhao);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public DataListAdapter(List<PersonInformation> personInformationList) {
        mPersonInformationList = personInformationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_information_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PersonInformation personInformation = mPersonInformationList.get(position);
        holder.tv_xuhao.setText(personInformation.getmXuHao().toString());
        holder.tv_name.setText(personInformation.getmName());
    }

    @Override
    public int getItemCount() {
        return mPersonInformationList.size();
    }
}
