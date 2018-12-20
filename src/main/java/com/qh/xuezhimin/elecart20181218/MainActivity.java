package com.qh.xuezhimin.elecart20181218;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qh.xuezhimin.elecart20181218.adapter.LeftAdapter;
import com.qh.xuezhimin.elecart20181218.adapter.RightAdapter;
import com.qh.xuezhimin.elecart20181218.bean.Goods;
import com.qh.xuezhimin.elecart20181218.bean.Result;
import com.qh.xuezhimin.elecart20181218.bean.Shop;
import com.qh.xuezhimin.elecart20181218.bean2.Data;
import com.qh.xuezhimin.elecart20181218.bean2.Spus;
import com.qh.xuezhimin.elecart20181218.core.DataCall;
import com.qh.xuezhimin.elecart20181218.presenter.CartPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataCall<List<Data>> {

    private RecyclerView mLeftRecycler;
    private RecyclerView mRightRecycler;
    private ImageView mShopCarImage;
    /**
     * 价格：
     */
    private TextView mGoodsSumPrice;
    /**
     * 数量
     */
    private TextView mGoodsNumber;
    private CartPresenter cartPresenter = new CartPresenter(this);
    private LeftAdapter mLeftAdapter;
    private RightAdapter mRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mLeftRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRightRecycler.setLayoutManager(new LinearLayoutManager(this));

        mLeftAdapter = new LeftAdapter();
        mLeftAdapter.setOnItemClickListenter(new LeftAdapter.OnItemClickListenter() {
            @Override
            public void onItemClick(Data data) {
                mRightAdapter.clearList();//清空数据
                mRightAdapter.addAll(data.getSpus());
                mRightAdapter.notifyDataSetChanged();
            }
        });

        mLeftRecycler.setAdapter(mLeftAdapter);
        mRightAdapter = new RightAdapter(this);
        mRightAdapter.setOnNumListener(new RightAdapter.OnNumListener() {
            @Override
            public void onNum() {
                calculatePrice(mLeftAdapter.getList());
            }
        });

        mRightRecycler.setAdapter(mRightAdapter);

        cartPresenter.requestData();


    }

    private void calculatePrice(List<Data> shopList) {
//        double totalPrice=0;
//        int totalNum = 0;
//        for (int i = 0; i < shopList.size(); i++) {//循环的商家
//            Data data = shopList.get(i);
//            for (int j = 0; j < data.getSpus().size(); j++) {
//                Spus spus = data.getSpus().get(j);
//                //计算价格
//                totalPrice = totalPrice + (spus.getPraise_num() * (spus.getSkus().get(j).getPrice()));
//                totalNum+=goods.getNum();//计数
//            }
//        }
//        mGoodsSumPrice.setText("价格："+totalPrice);
//        mGoodsNumber.setText(""+totalNum);

    }

    private void initView() {
        mLeftRecycler = findViewById(R.id.left_recycler);
        mRightRecycler = findViewById(R.id.right_recycler);
        mShopCarImage = findViewById(R.id.shop_car_image);
        mGoodsSumPrice = findViewById(R.id.goods_sum_price);
        mGoodsNumber = findViewById(R.id.goods_number);
    }

    @Override
    public void success(List<Data> data) {
        calculatePrice(data);//计算价格和数量

        mLeftAdapter.addAll(data);//左边的添加类型

        //得到默认选中的shop，设置上颜色和背景
        Data data1 = data.get(1);
        data1.setTextColor(0xff000000);
        data1.setBackground(R.color.white);
        mRightAdapter.addAll(data1.getSpus());


        mLeftAdapter.notifyDataSetChanged();
        mRightAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result) {
        Toast.makeText(this, result.getCode() + "   " + result.getMsg(), Toast.LENGTH_LONG).show();
    }
}
