package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JumpBetweenActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_bettwen_activitys);
        Button buttonBack = (Button) findViewById(R.id.back_bt);
        buttonBack.setOnClickListener(v -> finish());
    }

    public static void showMe(Context context) {
        Intent intent = new Intent(context, JumpBetweenActivities.class);
        context.startActivity(intent);
    }
}
