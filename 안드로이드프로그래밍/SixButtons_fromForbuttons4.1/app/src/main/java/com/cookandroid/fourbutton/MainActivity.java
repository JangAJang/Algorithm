package com.cookandroid.fourbutton;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    Button btnNate, btn911, btnGal, btnEnd, btnGrn, btnBlue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        btnNate = (Button) findViewById(R.id.btnNate);
        btn911 = (Button) findViewById(R.id.btn911);
        btnGal = (Button) findViewById(R.id.btnGal);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnGrn = (Button) findViewById(R.id.btnGrn);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        btnNate.setBackgroundColor(Color.GRAY);
        btn911.setBackgroundColor(Color.GREEN);
        btnGal.setBackgroundColor(Color.RED);
        btnEnd.setBackgroundColor(Color.YELLOW);
        btnGrn.setBackgroundColor(Color.GREEN);
        btnBlue.setBackgroundColor(Color.BLUE);

        btnNate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("http://m.nate.com"));
                startActivity(mIntent);

            }
        });

        btn911.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("tel:/911"));
                startActivity(mIntent);

            }
        });

        btnGal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse("content://media/internal/images/media"));
                startActivity(mIntent);

            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();

            }
        });

        btnGrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNate.setBackgroundColor(Color.GREEN);
                btn911.setBackgroundColor(Color.GREEN);
                btnGal.setBackgroundColor(Color.GREEN);
                btnEnd.setBackgroundColor(Color.GREEN);
                btnGrn.setBackgroundColor(Color.GREEN);
                btnBlue.setBackgroundColor(Color.GREEN);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNate.setBackgroundColor(Color.BLUE);
                btn911.setBackgroundColor(Color.BLUE);
                btnGal.setBackgroundColor(Color.BLUE);
                btnEnd.setBackgroundColor(Color.BLUE);
                btnGrn.setBackgroundColor(Color.BLUE);
                btnBlue.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
