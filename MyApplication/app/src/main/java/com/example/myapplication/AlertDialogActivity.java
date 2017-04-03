package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogActivity extends ActivityWithCloseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        Button bt_AlertDialog = (Button) findViewById(R.id.bt_AlertDialog);
        bt_AlertDialog.setOnClickListener((v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
            alertDialogBuilder.setTitle("警告");
            alertDialogBuilder.setMessage("注意注意！！！");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("确定", (dialog, which) -> {

            });
            alertDialogBuilder.setNegativeButton("取消", (dialog, which) -> {

            });
            alertDialogBuilder.show();
        }));
    }
}
