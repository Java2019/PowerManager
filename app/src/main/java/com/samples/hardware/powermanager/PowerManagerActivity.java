package com.samples.hardware.powermanager;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PowerManagerActivity extends AppCompatActivity
        implements View.OnClickListener{

    private PowerManager manager;
    private WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_manager);
    }

    @Override
    public void onClick(View view) {

    }
}
