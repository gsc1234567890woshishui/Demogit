package views;

import android.content.Intent;
import android.view.View;

import org.zzgsc.com.demo_ch.R;

/**
 * Created by Administrator on 2016/11/8.
 */

public class TestDb2 extends BaseActivity {
    @Override
    protected void initData() {

    }
public void tz(View view){
    Intent i=new Intent("com.panku.insuranceforoldman");

    startActivity(i);
    finish();

}
    @Override
    protected int getLayId() {
        return R.layout.activity_main;
    }
}
