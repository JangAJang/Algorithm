package com.example.practise4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox enable, clickable, angle;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        enable = (CheckBox)findViewById(R.id.enable);
        clickable = (CheckBox)findViewById(R.id.clickable);
        angle = (CheckBox)findViewById(R.id.angle);

        enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(enable.isChecked()==true){
                    button.setEnabled(true);
                }
                else{
                    button.setEnabled(false);
                }
            }
        });

        clickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(clickable.isChecked()==true){
                    button.setClickable(true);
                }
                else{
                    button.setClickable(false);
                }
            }
        });

        angle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(angle.isChecked()==true){
                    button.setRotation(45);
                }
                else{
                    button.setRotation(0);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}