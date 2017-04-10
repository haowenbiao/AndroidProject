package com.example.forceoffline;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/9.
 */

public class BaseActivity extends AppCompatActivity {
    private OffLineBroadcastReceiver offLineBroadcastReceiver;

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

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.forceoffline.FORCE_OFFLINE");
        offLineBroadcastReceiver = new OffLineBroadcastReceiver();
        registerReceiver(offLineBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(offLineBroadcastReceiver);
        offLineBroadcastReceiver = null;
    }
}
