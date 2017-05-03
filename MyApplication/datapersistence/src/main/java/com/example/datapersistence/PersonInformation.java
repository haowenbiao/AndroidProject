package com.example.datapersistence;

/**
 * 作者： Administrator on 2017/5/3.22:21
 * 邮箱：郝文标
 */

public class PersonInformation {
    private Integer mID;
    private Integer mXuHao;
    private String mName;

    public PersonInformation(Integer id, Integer xuhao, String name) {
        mID = id;
        mXuHao = xuhao;
        mName = name;
    }

    public Integer getmID() {
        return mID;
    }

    public Integer getmXuHao() {
        return mXuHao;
    }

    public String getmName() {
        return mName;
    }
}
