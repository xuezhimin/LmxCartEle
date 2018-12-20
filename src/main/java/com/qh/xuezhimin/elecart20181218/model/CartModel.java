package com.qh.xuezhimin.elecart20181218.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qh.xuezhimin.elecart20181218.bean.Result;
import com.qh.xuezhimin.elecart20181218.bean2.Data;
import com.qh.xuezhimin.elecart20181218.utils.HttpUtils;
import com.qh.xuezhimin.elecart20181218.utils.HttpUtils2;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author dingtao
 * @date 2018/12/6 14:55
 * qq:1940870847
 */
public class CartModel {

    public static Result goodsList() {
        String resultString = HttpUtils.get("http://www.wanandroid.com/tools/mockapi/6523/restaurant-list");

        try {
            Gson gson = new Gson();

            Type type = new TypeToken<Result<List<Data>>>() {
            }.getType();

            Result result = gson.fromJson(resultString, type);

            return result;
        } catch (Exception e) {

        }
        Result result = new Result();
        result.setCode(-1);
        result.setMsg("数据解析异常");
        return result;
    }

}
