package com.example.datapersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DataPersistenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence);
    }

    public void tn_file_output_inputClick(View v){
        FileOutputInputActivity.start(this);
    }
}
