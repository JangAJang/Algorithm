package com.example.study5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frame1, frame2, frame3;
        frame1 = (FrameLayout) findViewById(R.id.frame1);
        frame2 = (FrameLayout) findViewById(R.id.frame2);
        frame3 = (FrameLayout) findViewById(R.id.frame3);
        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, frame1.getWidth()+" "+frame1.getHeight(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, frame2.getWidth()+" "+frame2.getHeight(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        frame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, frame3.getWidth()+" "+frame3.getHeight(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}