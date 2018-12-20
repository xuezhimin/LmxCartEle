package com.qh.xuezhimin.elecart20181218.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qh.xuezhimin.elecart20181218.R;
import com.qh.xuezhimin.elecart20181218.bean.Goods;
import com.qh.xuezhimin.elecart20181218.bean2.Spus;
import com.qh.xuezhimin.elecart20181218.view.AddSubLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingtao
 * @date 2018/12/19 10:56
 * qq:1940870847
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ChildHolder> {


    private Context context;

    public RightAdapter(Context context) {
        this.context = context;
    }

    private List<Spus> mList = new ArrayList<>();

    public void addAll(List<Spus> list) {
        mList.addAll(list);
    }

    @NonNull
    @Override
    public ChildHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = View.inflate(viewGroup.getContext(), R.layout.recycler_right_item, null);
        ChildHolder myHolder = new ChildHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildHolder childHolder, int position) {

        final Spus spus = mList.get(position);
        childHolder.text.setText(spus.getName());
        childHolder.price.setText("单价：" + spus.getRestaurant_id());//单价

//        String imageurl = "https" + spus.getImages().split("https")[1];
//        Log.i("dt", "imageUrl: " + imageurl);
//        imageurl = imageurl.substring(0, imageurl.lastIndexOf(".jpg") + ".jpg".length());
        Glide.with(context).load(spus.getPic_url()).into(childHolder.image);//加载图片

        childHolder.addSub.setCount(spus.getPraise_num());//设置商品数量
        childHolder.addSub.setAddSubListener(new AddSubLayout.AddSubListener() {
            @Override
            public void addSub(int count) {
//                goods.setNum(count);
                spus.setPraise_num(count);
                onNumListener.onNum();//计算价格
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearList() {
        mList.clear();
    }


    class ChildHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView price;
        ImageView image;
        AddSubLayout addSub;

        public ChildHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.text_price);
            image = itemView.findViewById(R.id.image);
            addSub = itemView.findViewById(R.id.add_sub_layout);
        }
    }

    private OnNumListener onNumListener;

    public void setOnNumListener(OnNumListener onNumListener) {
        this.onNumListener = onNumListener;
    }

    public interface OnNumListener {
        void onNum();
    }
}
