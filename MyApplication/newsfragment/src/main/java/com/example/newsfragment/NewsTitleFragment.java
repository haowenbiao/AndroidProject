package com.example.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_news_title_fragment, container, false);

        return view;
    }

    class NewsTitleAdapter extends RecyclerView.Adapter<NewsTitleAdapter.ViewHolder> {

        List<News> m_newsList = new ArrayList<>();

        public NewsTitleAdapter(List<News> newsList) {
            m_newsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_item, parent, false);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = m_newsList.get(viewHolder.getAdapterPosition());
                    NewsContentFragment newsContentFragment =
                            (NewsContentFragment) getFragmentManager().findFragmentById(R.id.fr_NewsContentFragment);
                    newsContentFragment.refresh(news.getTitle(), news.getContent());
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = m_newsList.get(position);
            holder.tv_Title.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return m_newsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_Title;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_Title = (TextView) itemView.findViewById(R.id.tv_Title);
            }
        }
    }
}
