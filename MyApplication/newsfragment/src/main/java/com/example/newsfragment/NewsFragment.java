package com.example.newsfragment;

import android.support.v4.app.Fragment;

/**
 * 作者：郝文标 on 2017/4/6 16:40
 * 邮箱：haowenbiao@126.com
 */

class News {
    String m_Title;
    String m_Content;

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String m_Title) {
        this.m_Title = m_Title;
    }

    public String getContent() {
        return m_Content;
    }

    public void setContent(String m_Content) {
        this.m_Content = m_Content;
    }
}

public class NewsFragment extends Fragment {
}
