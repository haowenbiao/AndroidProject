package com.example.forceoffline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button bt_denglu = (Button) findViewById(R.id.bt_denglu);
        bt_denglu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_denglu: {
                TestActivity.start(this);
                finish();
                break;
            }
            case R.id.bt_guanbi :
            {
                finish();
            }
            default:
                break;
        }
    }
}
