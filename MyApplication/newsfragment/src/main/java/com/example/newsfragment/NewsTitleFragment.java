package com.example.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
        RecyclerView rv_NewsList = (RecyclerView) view.findViewById(R.id.rv_NewsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_NewsList.setLayoutManager(linearLayoutManager);
        initNewsList();//初始化新闻数据
        NewsTitleAdapter newsTitleAdapter = new NewsTitleAdapter(m_newsList);
        rv_NewsList.setAdapter(newsTitleAdapter);
        return view;
    }

    private List<News> m_newsList = new ArrayList<>();

    private void initNewsList() {
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.setTitle("News-" + i);
            news.setContent("为期４天的２０１７拉丁美洲航空航天与防务展（又称巴西防务展）４" +
                    "日在巴西里约热内卢开幕。中国国家国防科技工业局组织的多家企业以“中国防务”" +
                    "的整体形象亮相展会。值得关注的是，中国在此次巴西防务展上以模型的方式展示了" +
                    "“辽宁”号航母，巧合的是巴西海军不久前刚刚退役了从法国获得的“圣保罗”号航母并" +
                    "宣称将国产2艘航母。而目前世界上能提供全套常规动力（弹射起飞拦阻降落）航母技" +
                    "术的国家只有中国一家了。-----------------------" + i);
            m_newsList.add(news);
        }
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
