package com.example.haytutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {
    BroadcastReceiver batteryBroadcast;
    TextView batteryHealthTxt,batteryTempTxt,batteryChargingStatusTxt,batteryVoltageTxt,batteryLevelTxt;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        batteryHealthTxt = (TextView) findViewById(R.id.batteryHealhtTxt);
        batteryTempTxt = (TextView) findViewById(R.id.batteryTempTxt);
        batteryChargingStatusTxt = (TextView) findViewById(R.id.batteryChargingStatusTxt);
        batteryVoltageTxt = (TextView) findViewById(R.id.batteryVoltage);
        batteryLevelTxt = (TextView) findViewById(R.id.batteryLevelTxt);
        intentFilterAndBroadcast();
    }
    private void intentFilterAndBroadcast()
    {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        batteryBroadcast = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction()))
                {
                    final int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
                    if(health == BatteryManager.BATTERY_HEALTH_GOOD)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Good");
                    }
                    else if(health == BatteryManager.BATTERY_HEALTH_COLD)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Cold");
                    }
                    else if(health == BatteryManager.BATTERY_HEALTH_DEAD)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Dead");
                    }
                    else if(health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Over Voltage");
                    }
                    else if(health == BatteryManager.BATTERY_HEALTH_OVERHEAT)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Over Heat");
                    }
                    else if(health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE)
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Failed");
                    }
                    else
                    {
                        batteryHealthTxt.setText(batteryHealthTxt.getText()+"Unknown");
                    }

                    final int temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
                    batteryTempTxt.setText(batteryTempTxt.getText()+Integer.toString(temp));
                    final int chargingStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
                    if(chargingStatus == BatteryManager.BATTERY_STATUS_CHARGING)
                    {
                        batteryChargingStatusTxt.setText(batteryChargingStatusTxt.getText() + "Charging");
                    }
                    else
                    {
                        batteryChargingStatusTxt.setText(batteryChargingStatusTxt.getText() +"Not Charging");
                    }

                    final int batteryVoltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
                    batteryVoltageTxt.setText(batteryVoltageTxt.getText() +Integer.toString(batteryVoltage));

                    final int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                    batteryLevelTxt.setText(batteryLevelTxt.getText() + Integer.toString(batteryLevel));

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(batteryBroadcast,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryBroadcast);
    }
}