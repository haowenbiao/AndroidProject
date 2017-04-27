package com.example.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class SharedPreferencesActivity extends AppCompatActivity {

    TextInputEditText tiet_sample1;
    TextInputEditText tiet_sample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        final TextInputLayout til_sample1 = (TextInputLayout) findViewById(R.id.til_sample1);
        tiet_sample1 = (TextInputEditText) findViewById(R.id.tiet_sample1);
        tiet_sample1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 8) {
                    til_sample1.setErrorEnabled(true);
                    til_sample1.setError("数字不能大于8位");
                } else {
                    til_sample1.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tiet_sample2 = (TextInputEditText) findViewById(R.id.tiet_sample2);

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SharedPreferencesActivity.class);
        context.startActivity(starter);
    }

    public void btn_saveClick(View v) {
        SharedPreferences.Editor spf_editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        spf_editor.putLong("number", Integer.valueOf(tiet_sample1.getText().toString()));
        spf_editor.putString("anything", tiet_sample2.getText().toString());
        spf_editor.apply();
    }

    public void btn_loadClick(View v) {
        SharedPreferences spf = getSharedPreferences("data", MODE_PRIVATE);
        tiet_sample1.setText(String.valueOf(spf.getLong("number", 0)));
        tiet_sample2.setText(spf.getString("anything", ""));
    }
}
