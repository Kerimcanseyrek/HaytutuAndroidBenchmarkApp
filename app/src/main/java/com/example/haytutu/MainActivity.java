package com.example.haytutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonCpu,buttonStorage,buttonBattery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCpu = (Button) findViewById(R.id.cpuTest);
        buttonCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CpuActivity.class);
                startActivity(intent);
            }
        });
        buttonStorage = (Button) findViewById(R.id.storageTest);
        buttonStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2  = new Intent(MainActivity.this,StorageActivity.class);
                startActivity(intent2);
            }
        });
        buttonBattery = (Button) findViewById(R.id.batteryTest);
        buttonBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this,BatteryActivity.class);
                startActivity(intent3);
            }
        });

    }
}