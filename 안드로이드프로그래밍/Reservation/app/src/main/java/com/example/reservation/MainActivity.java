package com.example.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calenderview1;
    TimePicker timepicker1;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        timepicker1 = (TimePicker) findViewById(R.id.timepicker1);
        calenderview1 = (CalendarView) findViewById(R.id.calendarview1);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        timepicker1.setVisibility(View.INVISIBLE);
        calenderview1.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener((view -> {
            timepicker1.setVisibility(View.INVISIBLE);
            calenderview1.setVisibility(View.VISIBLE);
        }));

        rdoTime.setOnClickListener((view -> {
            timepicker1.setVisibility(View.VISIBLE);
            calenderview1.setVisibility(View.INVISIBLE);
        }));

        btnStart.setOnClickListener((view -> {
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
        }));

        btnEnd.setOnClickListener((view -> {
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            tvYear.setText(Integer.toString(selectYear));
            tvMonth.setText(Integer.toString(selectMonth));
            tvDay.setText(Integer.toString(selectDay));
            tvHour.setText(Integer.toString(timepicker1.getCurrentHour()));
            tvMinute.setText(Integer.toString(timepicker1.getCurrentMinute()));
        }));

        calenderview1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfmonth) {
                selectYear = year;
                selectMonth = month;
                selectDay = dayOfmonth;
            }
        });
    }
}