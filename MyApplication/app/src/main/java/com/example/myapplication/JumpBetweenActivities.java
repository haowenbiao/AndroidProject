package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class JumpBetweenActivities extends ActivityWithCloseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_bettwen_activitys);

        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        TextView showInputFromIntent = (TextView) findViewById(R.id.showInputFromIntent);
        if (TextUtils.isEmpty(data1)) {
            showInputFromIntent.setText("");
            showInputFromIntent.setVisibility(View.GONE);
        } else {
            showInputFromIntent.setText(data1);
        }

        Button buttonBack = (Button) findViewById(R.id.back_bt);
        buttonBack.setOnClickListener(v -> finish());

        Button backWithResult_bt = (Button) findViewById(R.id.backWithResult_bt);
        backWithResult_bt.setOnClickListener(v -> {
            Intent intent_t = new Intent();
            intent_t.putExtra("data_result", "Result_OKKKK");
            setResult(RESULT_OK, intent_t);
            finish();
        });

        LottieAnimationView lav_sample_1 = (LottieAnimationView) findViewById(R.id.lav_sample_1);
        lav_sample_1.setAnimation("coeur.json");
        lav_sample_1.loop(true);
        lav_sample_1.playAnimation();
        
    }

    /**
     * 自我显式     *
     *
     * @param context Context
     * @param data    数据
     */
    public static void showMe(Context context, String data) {
        Intent intent = new Intent(context, JumpBetweenActivities.class);
        intent.putExtra("data1", data);
        context.startActivity(intent);
    }

    /**
     * 返回结果的自我显示
     *
     * @param context     context
     * @param data        数据
     * @param requestCode 请求码
     */
    public static void showMeWithResult(Context context, String data, int requestCode) {
        Intent intent = new Intent(context, JumpBetweenActivities.class);
        intent.putExtra("data1", data);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }
}
