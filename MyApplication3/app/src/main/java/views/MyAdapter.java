package views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import org.zzgsc.com.demo_ch.R;
import java.util.List;
/**
 * Created by Administrator on 2016/10/31.
 */
public class MyAdapter extends BaseAdapter {
    private final Context context;
    private final List<CheckBoxBean> sum;
    public MyAdapter(Context context, List<CheckBoxBean> sum) {
        this.context=context;
        this.sum=sum;
    }
    @Override
    public int getCount() {
        return sum.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        System.out.println("-------pos------"+position);
        Volder volder;
        if (convertView==null){
            volder=new Volder();
            convertView= LayoutInflater.from(context).inflate(R.layout.lv_items,parent,false);
            volder.cb=(CheckBox)convertView.findViewById(R.id.cb);


            convertView.setTag(volder);
        }
        else{
            volder= (Volder) convertView.getTag();
        }
//        //找到需要选中的条目
//        if(map!=null && map.containsKey(position))
//        {
//            volder.cb.setChecked(map.get(position));
//        }
//        else
//        {
//            volder.cb.setChecked(false);
//        }
        volder.tv=(TextView)convertView.findViewById(R.id.tv);
         volder.tv.setText(sum.get(position).getContent());
        volder.cb.setChecked(sum.get(position).getIcheck());
        return convertView;
    }
    class  Volder{

        public CheckBox cb;
        public TextView tv;
    }
}
