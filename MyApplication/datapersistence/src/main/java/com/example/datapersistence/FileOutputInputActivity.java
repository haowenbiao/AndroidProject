package com.example.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOutputInputActivity extends AppCompatActivity {

    EditText et_sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_output_input);
        et_sample = (EditText) findViewById(R.id.et_sample);
        et_sample.setText(load());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(et_sample.getText().toString());
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, FileOutputInputActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    private String load() {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileInputStream = openFileInput("data");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    private void save(String m_string) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileOutputStream = openFileOutput("data", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(m_string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
