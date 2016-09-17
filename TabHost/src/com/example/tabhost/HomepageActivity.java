package com.example.tabhost;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HomepageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_homepage, menu);
        return true;
    }
}
