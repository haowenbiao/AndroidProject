package com.example.forceoffline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/9.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitiesCollection.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivitiesCollection.removeActivity(this);
    }
}
