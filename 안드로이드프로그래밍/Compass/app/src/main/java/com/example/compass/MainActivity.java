package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Float azimuth_angle;
    private SensorManager compassSensorManager;
    Sensor accelerometer;
    Sensor magnetometer;
    TextView tv_degrees;
    ImageView iv_degrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compassSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    protected void onResume(){
        super.onResume();
        compassSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        compassSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause(){
        super.onPause();
        compassSensorManager.unregisterListener(this);
    }

    float[] accel_read;
    float[] magnetic_read;
    @Override
    public void onSensorChanged(SensorEvent event) {
        tv_degrees = (TextView) findViewById(R.id.tv_degrees);
        iv_degrees = (ImageView) findViewById(R.id.iv_compass);
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) accel_read = event.values;
        if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) magnetic_read = event.values;
        if(accel_read!=null&&magnetic_read!=null){
            float R[] = new float[9];
            float I[] = new float[9];
            boolean successfulread = SensorManager.getRotationMatrix(R, I, accel_read, magnetic_read);
            if(successfulread){
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);
                azimuth_angle = orientation[0];
                float degrees = ((azimuth_angle*180f)/3.14f);
                int degreesInt = Math.round(degrees);
                tv_degrees.setText(Integer.toString(degreesInt) + (char)0x0000 + " to absolute north");
                float currentdegree = 0f;
                RotateAnimation rotate = new RotateAnimation(currentdegree, -degreesInt, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(100);
                rotate.setFillAfter(true);
                iv_degrees.startAnimation(rotate);
                currentdegree = -degreesInt;
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}