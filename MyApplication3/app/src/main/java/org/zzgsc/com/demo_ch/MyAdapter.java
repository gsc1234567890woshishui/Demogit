package org.zzgsc.com.demo_ch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MyAdapter extends SwipeMenuAdapter<MyAdapter.VH> {
    public MyAdapter(String[] str) {
        this.strs = str;
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    private String[]strs;
//    @Override
//    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false));
//    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
    }

    @Override
    public VH onCompatCreateViewHolder(View realContentView, int viewType) {
           return new VH(realContentView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
       holder.iv.setText(strs[position]);
    }

    @Override
    public int getItemCount() {
        return strs.length;
    }

    public class VH extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView iv;
        OnItemClickListener mOnItemClickListener;
        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }
        public VH(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv= (TextView) itemView.findViewById(R.id.tv);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }


}
