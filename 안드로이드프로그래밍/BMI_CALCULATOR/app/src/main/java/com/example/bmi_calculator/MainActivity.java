package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod(){
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText heightText = (EditText) findViewById(R.id.heightinput);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);


                final EditText weightText = (EditText) findViewById(R.id.weightinput);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);

                double BMI = weight / (height*height);
                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_trimmed = Double.parseDouble(df.format(BMI));
                final TextView BMIResult = (TextView) findViewById(R.id.bmiresult);
                BMIResult.setText("Your BMI is "+ Double.toString(BMI_trimmed));

                String BMI_Cat;
                if(BMI<15) BMI_Cat = "Very Severely underweight";
                else if (BMI <16) BMI_Cat = "Severely underweight";
                else if(BMI<18.5) BMI_Cat="Underweight";
                else if(BMI<25)BMI_Cat="Normal";
                else if(BMI<30) BMI_Cat="Overweight";
                else if(BMI<35) BMI_Cat="Obese Class 1";
                else if(BMI<40)BMI_Cat="Obese Class 2";
                else BMI_Cat="Obese Class 3";
                TextView BMICAT = (TextView) findViewById(R.id.bmicat);
                BMICAT.setText(BMI_Cat);
            }
        });
    }


}