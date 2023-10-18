package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.LocaleListCompat;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnTime;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTime = findViewById(R.id.btnTime);
    }

    public void TimePicking(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                hour = h;
                minute = m;
                btnTime.setText(String.format(Locale.getDefault(), "%02d:%02d", h, m));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select time");
        timePickerDialog.show();
    }
}