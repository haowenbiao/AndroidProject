package com.example.administrator.picturetransformtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Camera;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        imageView = findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.picture1);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener((View v) -> {
            float r = Float.parseFloat(editText.getText().toString());
            Matrix matrix = getMatrix(r);
            matrix.preTranslate(0, -bitmap.getHeight() / 2);
            matrix.postTranslate(0, -bitmap.getHeight() / 2);
            Bitmap bitmapTemp = getBitmap(bitmap, matrix);
            imageView.setImageBitmap(bitmapTemp);
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.picture1);
            imageView.setImageBitmap(bitmap);
        });

    }

    private Bitmap getBitmap(Bitmap bitmap, Matrix matrix) {
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Matrix getMatrix(float r) {
        Matrix matrix = new Matrix();
        Camera camera = new Camera();
        camera.save();
        camera.rotateY(r);
        camera.getMatrix(matrix);
        camera.restore();
        return matrix;
    }
}
