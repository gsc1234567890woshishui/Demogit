package org.zzgsc.com.demo_ch;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.InjectView;
import lecho.lib.hellocharts.view.LineChartView;
/**
 * Created by Administrator on 2016/10/19.
 */
public class CharDemo extends Activity {
    @InjectView(R.id.lc)
    LineChartView lc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        ButterKnife.inject(this);
       // 可以通过一些公共方法设置其行为属性，下面是一些例子：



    }
}
