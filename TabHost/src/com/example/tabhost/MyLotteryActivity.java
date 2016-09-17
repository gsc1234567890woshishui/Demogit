package com.example.tabhost;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MyLotteryActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lottery);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_my_lottery, menu);
        return true;
    }
}
