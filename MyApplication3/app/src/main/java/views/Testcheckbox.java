package views;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import org.zzgsc.com.demo_ch.R;
import java.util.ArrayList;
/**
 * Created by Administrator on 2016/10/31.
 */
public class Testcheckbox extends AppCompatActivity implements View.OnClickListener {
    private ListView lv;
    private MyAdapter myAdapter;
    private Button qx,fx,canle;
    private ArrayList<CheckBoxBean> sum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textcheckbox);
        lv= (ListView) findViewById(R.id.lv);
        qx= (Button) findViewById(R.id.qx);
        fx= (Button) findViewById(R.id.fx);
        canle= (Button) findViewById(R.id.qxiao);
        qx.setOnClickListener(this);
        canle.setOnClickListener(this);
        fx.setOnClickListener(this);
       sum=new ArrayList<>();
        final CheckBoxBean checkBoxBean=new CheckBoxBean();
        checkBoxBean.setIcheck(true);
        checkBoxBean.setContent("a");
        sum.add(checkBoxBean);
        CheckBoxBean checkBoxBean1=new CheckBoxBean();
        checkBoxBean1.setIcheck(false);
        checkBoxBean1.setContent("b");
        sum.add(checkBoxBean1);
        CheckBoxBean checkBoxBean2=new CheckBoxBean();
        checkBoxBean2.setIcheck(false);
        checkBoxBean2.setContent("c");
        sum.add(checkBoxBean2);
        CheckBoxBean checkBoxBean3=new CheckBoxBean();
        checkBoxBean3.setIcheck(true);
        checkBoxBean3.setContent("D");
        sum.add(checkBoxBean3);
        CheckBoxBean checkBoxBean4=new CheckBoxBean();
        checkBoxBean4.setIcheck(true);
        checkBoxBean4.setContent("E");
        sum.add(checkBoxBean4);
        CheckBoxBean checkBoxBean40=new CheckBoxBean();
        checkBoxBean40.setIcheck(true);
        checkBoxBean40.setContent("E");
        sum.add(checkBoxBean40);
        CheckBoxBean checkBoxBean41=new CheckBoxBean();
        checkBoxBean41.setIcheck(true);
        checkBoxBean41.setContent("F");
        sum.add(checkBoxBean41);
        CheckBoxBean checkBoxBean42=new CheckBoxBean();
        checkBoxBean42.setIcheck(true);
        checkBoxBean42.setContent("G");
        sum.add(checkBoxBean42);
        CheckBoxBean checkBoxBean43=new CheckBoxBean();
        checkBoxBean43.setIcheck(true);
        checkBoxBean43.setContent("H");
        sum.add(checkBoxBean43);
        CheckBoxBean checkBoxBean44=new CheckBoxBean();
        checkBoxBean44.setIcheck(true);
        checkBoxBean44.setContent("E");
        sum.add(checkBoxBean44);
        CheckBoxBean checkBoxBean45=new CheckBoxBean();
        checkBoxBean45.setIcheck(true);
        checkBoxBean45.setContent("E");
        sum.add(checkBoxBean45);
        CheckBoxBean checkBoxBean46=new CheckBoxBean();
        checkBoxBean46.setIcheck(true);
        checkBoxBean46.setContent("I");
        sum.add(checkBoxBean46);
        CheckBoxBean checkBoxBean47=new CheckBoxBean();
        checkBoxBean47.setIcheck(true);
        checkBoxBean47.setContent("E");
        sum.add(checkBoxBean47);
        CheckBoxBean checkBoxBean48=new CheckBoxBean();
        checkBoxBean48.setIcheck(true);
        checkBoxBean48.setContent("J");
        sum.add(checkBoxBean48);
        CheckBoxBean checkBoxBean491=new CheckBoxBean();
        checkBoxBean491.setIcheck(true);
        checkBoxBean491.setContent("E");
        sum.add(checkBoxBean491);
        CheckBoxBean checkBoxBean492=new CheckBoxBean();
        checkBoxBean492.setIcheck(true);
        checkBoxBean492.setContent("K");
        sum.add(checkBoxBean492);
        CheckBoxBean checkBoxBean493=new CheckBoxBean();
        checkBoxBean493.setIcheck(true);
        checkBoxBean493.setContent("L");
        sum.add(checkBoxBean493);
        CheckBoxBean checkBoxBean494=new CheckBoxBean();
        checkBoxBean494.setIcheck(true);
        checkBoxBean494.setContent("M");
        sum.add(checkBoxBean494);
        CheckBoxBean checkBoxBean495=new CheckBoxBean();
        checkBoxBean495.setIcheck(true);
        checkBoxBean495.setContent("N");
        sum.add(checkBoxBean495);
        CheckBoxBean checkBoxBean496=new CheckBoxBean();
        checkBoxBean496.setIcheck(true);
        checkBoxBean496.setContent("E");
        sum.add(checkBoxBean496);
        CheckBoxBean checkBoxBean497=new CheckBoxBean();
        checkBoxBean497.setIcheck(true);
        checkBoxBean497.setContent("O");
        sum.add(checkBoxBean497);
        CheckBoxBean checkBoxBean498=new CheckBoxBean();
        checkBoxBean498.setIcheck(true);
        checkBoxBean498.setContent("P");
        sum.add(checkBoxBean498);
        CheckBoxBean checkBoxBean499=new CheckBoxBean();
        checkBoxBean499.setIcheck(true);
        checkBoxBean499.setContent("Q");
        sum.add(checkBoxBean499);
        CheckBoxBean checkBoxBean4901=new CheckBoxBean();
        checkBoxBean4901.setIcheck(true);
        checkBoxBean4901.setContent("X");
        sum.add(checkBoxBean4901);
        CheckBoxBean checkBoxBean4902=new CheckBoxBean();
        checkBoxBean4902.setIcheck(true);
        checkBoxBean4902.setContent("R");
        sum.add(checkBoxBean4902);
        CheckBoxBean checkBoxBean4903=new CheckBoxBean();
        checkBoxBean4903.setIcheck(true);
        checkBoxBean4903.setContent("T");
        sum.add(checkBoxBean4903);
        CheckBoxBean checkBoxBean4904=new CheckBoxBean();
        checkBoxBean4904.setIcheck(true);
        checkBoxBean4904.setContent("U");
        sum.add(checkBoxBean4904);
        myAdapter = new MyAdapter(this, sum);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBoxBean checkBoxBean5 = sum.get(position);
                checkBoxBean5.setIcheck(!checkBoxBean5.getIcheck());
                myAdapter.notifyDataSetChanged();

            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v==qx){
            for(CheckBoxBean c:sum){
                Boolean icheck = c.getIcheck();
               if (!icheck){
                  c.setIcheck(true);
                   myAdapter.notifyDataSetChanged();
               }
            }
        }
        if (v==fx){
            for(CheckBoxBean c:sum){
                Boolean icheck = c.getIcheck();
                 c.setIcheck(!icheck);
                  myAdapter.notifyDataSetChanged();

            }
        }
        if (v==canle){
            for(CheckBoxBean c:sum){
                Boolean icheck = c.getIcheck();
                if (icheck){
                    c.setIcheck(false);
                    myAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
