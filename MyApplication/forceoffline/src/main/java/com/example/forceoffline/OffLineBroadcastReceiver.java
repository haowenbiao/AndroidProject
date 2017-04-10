package com.example.forceoffline;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * 作者：郝文标 on 2017/4/10 15:22
 * 邮箱：haowenbiao@126.com
 */
public class OffLineBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("警告")
                .setMessage("您将被强制下线，请重新登陆。")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivitiesCollection.finishAll();
                        Intent intent1 = new Intent(context, LoginActivity.class);
                        context.startActivity(intent1);
                    }
                });
        alertDialogBuilder.show();
    }
}
