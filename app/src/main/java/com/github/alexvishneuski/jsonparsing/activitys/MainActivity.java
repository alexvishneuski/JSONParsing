package com.github.alexvishneuski.jsonparsing.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.alexvishneuski.jsonparsing.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCustomerSaveActivity();
    }

    public void startCustomerSaveActivity() {
        startActivity(new Intent(this, CustomerSaveActivity.class));
    }
}
