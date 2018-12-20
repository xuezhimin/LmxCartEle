package com.qh.xuezhimin.elecart20181218.presenter;


import com.qh.xuezhimin.elecart20181218.bean.Result;
import com.qh.xuezhimin.elecart20181218.core.BasePresenter;
import com.qh.xuezhimin.elecart20181218.core.DataCall;
import com.qh.xuezhimin.elecart20181218.model.CartModel;

/**
 * @author dingtao
 * @date 2018/12/6 14:41
 * qq:1940870847
 */
public class CartPresenter extends BasePresenter {


    public CartPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getData(Object... args) {
        Result result = CartModel.goodsList();//调用网络请求获取数据
        return result;
    }

}
