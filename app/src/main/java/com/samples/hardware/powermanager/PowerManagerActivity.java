package com.samples.hardware.powermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class PowerManagerActivity extends AppCompatActivity
        implements View.OnClickListener{

    private PowerManager manager;
    private WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_manager);
        manager = (PowerManager)getSystemService(
                Context.POWER_SERVICE);
    }

    @Override
    public void onClick(View view) {
        // Освобождаем предыдущий Wake Lock,
        // если такой существует
        if (wakeLock != null) {
            wakeLock.release();
        }
        String wlName = "";
        switch (view.getId()) {
            case R.id.bPartialWL:
                wlName = getResources().getString(
                        R.string.partial_wake_lock);
                wakeLock = manager.newWakeLock(
                        PowerManager.PARTIAL_WAKE_LOCK, wlName);
                break;
            case R.id.bScreenBrightWL:
                wlName = getResources().getString(
                        R.string.screen_bright_wake_lock);
                wakeLock = manager.newWakeLock(
                        PowerManager.SCREEN_BRIGHT_WAKE_LOCK, wlName);
                break;
            case R.id.bScreenDimWL:
                wlName = getResources().getString(
                        R.string.screen_dim_wake_lock);
                wakeLock = manager.newWakeLock(
                        PowerManager.SCREEN_DIM_WAKE_LOCK, wlName);
                break;
            case R.id.bFullWL:
                wlName = getResources().getString(
                        R.string.full_wake_lock);
                wakeLock = manager.newWakeLock(
                        PowerManager.FULL_WAKE_LOCK, wlName);
                break;
        }
        Toast.makeText(this, wlName + " ON", Toast.LENGTH_LONG).show();
        wakeLock.acquire();
    }
}
