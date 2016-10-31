package views;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import org.zzgsc.com.demo_ch.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/10/31.
 */
public class MyRvAdapter extends RecyclerView.Adapter {
    List<CheckBoxBean> checkBoxBeen;
   final int HEADTYPE=0;
   final int NOMAL=1;
    List<Integer>a=new ArrayList<>();
    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEADTYPE;
        }
        else{
            return NOMAL;
        }
    }
    public MyRvAdapter(List<CheckBoxBean> checkBoxBeen) {
        this.checkBoxBeen = checkBoxBeen;
        a.add(HEADTYPE);
        a.add(NOMAL);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh=null;
        if (viewType==HEADTYPE){
            vh= new Vh1(LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_items2,parent,false));
        }
       if (viewType==NOMAL){
           vh=new Vh(LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_items,parent,false));
       }
          return vh;
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case HEADTYPE:
                break;
            case NOMAL:
                final Vh holder1 = (Vh) holder;
                ((Vh) holder).cb.setChecked(checkBoxBeen.get(position-1).getIcheck());
                ((Vh) holder).cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (on!=null){
                            on.OnItem(holder1.getLayoutPosition()-1,v);

                        }
                    }
                });
                break;
    }
  }
    public OnItemListenr on;
    public void setOn(OnItemListenr on) {
        this.on = on;
    }
    @Override
    public int getItemCount() {
        return checkBoxBeen.size();
    }
    public class Vh extends RecyclerView.ViewHolder {
        public CheckBox cb;
        public TextView tv;

        public Vh(View itemView) {
            super(itemView);
            cb= (CheckBox) itemView.findViewById(R.id.cb);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }
    public class Vh1 extends RecyclerView.ViewHolder {
        public Vh1(View itemView) {
          super(itemView);

        }
    }
}
