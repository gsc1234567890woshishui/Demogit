package com.example.tabhost;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
public class MainActivity extends ActivityGroup
{
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabs();
        
    }

    private void initTabs()
    {
        mTabHost = (TabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this.getLocalActivityManager());
        
        Intent intent = new Intent(this, HomepageActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec("Tab1")
                .setIndicator(getString(R.string.homepage_indicator), getResources().getDrawable(R.drawable.homepage_indicator_selector))
                .setContent(intent));
       
        
        intent = new Intent(this, BillboardActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec("Tab2")
                .setIndicator(getString(R.string.billboard_indicator), getResources().getDrawable(R.drawable.billboard_indicator_selector))
                .setContent(intent));
        
        intent = new Intent(this, MyLotteryActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec("Tab3")
                .setIndicator(getString(R.string.mylottery_indicator), getResources().getDrawable(R.drawable.mylottery_indicator_selector))
                .setContent(intent));
        
        intent = new Intent(this, MoreActivity.class);
        mTabHost.addTab(mTabHost.newTabSpec("Tab4")
                .setIndicator(getString(R.string.more_indicator), getResources().getDrawable(R.drawable.more_indicator_selector))
                .setContent(intent));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
