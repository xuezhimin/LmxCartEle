package com.qh.xuezhimin.elecart20181218.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.qh.xuezhimin.elecart20181218.R;
import com.qh.xuezhimin.elecart20181218.bean.Shop;
import com.qh.xuezhimin.elecart20181218.bean2.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingtao
 * @date 2018/12/19 10:56
 * qq:1940870847
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyHolder> {

    private List<Data> mList = new ArrayList<>();

    public void addAll(List<Data> list) {
        mList.addAll(list);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.recycler_left_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
        final Data data = mList.get(i);
        myHolder.text.setText(data.getName());
        myHolder.text.setBackgroundResource(data.getBackground());
        myHolder.text.setTextColor(data.getTextColor());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int j = 0; j < mList.size(); j++) {
                    mList.get(j).setTextColor(0xffffffff);
                    mList.get(j).setBackground(R.color.grayblack);
                }
                data.setBackground(R.color.white);
                data.setTextColor(0xff000000);
                notifyDataSetChanged();
                onItemClickListenter.onItemClick(data);//切换右边的列表
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<Data> getList() {
        return mList;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.left_text);
        }
    }

    private OnItemClickListenter onItemClickListenter;

    public void setOnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        this.onItemClickListenter = onItemClickListenter;
    }

    public interface OnItemClickListenter {
        void onItemClick(Data data);
    }

}
