package com.evolutionarysoftwares.vmathebula.justpoetry.main;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.evolutionarysoftwares.vmathebula.justpoetry.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(2000);
        Intent justPoetryIntent = new Intent(this, MainActivity.class);
        startActivity(justPoetryIntent);
        finish();
    }
}
