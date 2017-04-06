package com.example.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/6.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_news_content_fragment, container, false);
        this.view = view;
        return view;
    }

    /**
     * 刷新新闻
     * @param title 标题
     * @param content 内容
     */
    public void refresh(String title, String content) {
        TextView tv_Title = (TextView) view.findViewById(R.id.tv_Title);
        tv_Title.setText(title);

        TextView tv_Content = (TextView) view.findViewById(R.id.tv_Content);
        tv_Content.setText(content);
    }
}
