package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explicitIntent_bt1 = (Button) findViewById(R.id.explicitIntent_bt1);
        explicitIntent_bt1.setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, JumpBetweenActivities.class);
            startActivity(intent);
        });

        Button explicitIntent_bt2 = (Button) findViewById(R.id.explicitIntent_bt2);
        explicitIntent_bt2.setOnClickListener((v) -> {
            //JumpBetweenActivities.showMe(MainActivity.this, "hello");
            //JumpBetweenActivities.showMeWithResult(MainActivity.this, "helloooo", 1);
            Intent intent = new Intent(MainActivity.this, JumpBetweenActivities.class);
            intent.putExtra("Data1", "helloooo");
            startActivityForResult(intent, 1);
        });

        Button implicitIntent_bt1 = (Button) findViewById(R.id.implicitIntent_bt1);
        implicitIntent_bt1.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.myapplication.ACTION_START");
            intent.addCategory("com.example.myapplication.MY_CATEGORY");
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String data_t = data.getStringExtra("data_result");
                    Toast.makeText(this, data_t, Toast.LENGTH_SHORT).show();
                }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_toast:
                Toast.makeText(this, "test...", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_close:
                finish();
                break;
            default:
        }
        return true;
    }

}
