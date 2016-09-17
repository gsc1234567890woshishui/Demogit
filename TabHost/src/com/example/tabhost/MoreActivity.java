package com.example.tabhost;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MoreActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_more, menu);
        return true;
    }
}
