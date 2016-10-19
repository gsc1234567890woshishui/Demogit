package org.zzgsc.com.demo_ch;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
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
     //设置线上每个点的坐标点
        List<PointValue> values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 2));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 3));
        values.add(new PointValue(3, 4));
     //点加入到线对象
        Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);
        //线设置数据模型
        LineChartData data = new LineChartData();
        data.setLines(lines);
        //管理X，y轴参数对象
        Axis axisX = new Axis();
        axisX.setName("X轴");
        Axis axisY = new Axis().setHasLines(true);
        axisY.setName("Y轴");
        //设置x,y轴显示的位置参数
        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);
      //线加入到chart表
        lc.setLineChartData(data);
    }
}
