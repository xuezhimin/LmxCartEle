package com.qh.xuezhimin.elecart20181218.core;

import com.qh.xuezhimin.elecart20181218.bean.Result;


public interface DataCall<T> {

    void success(T data);

    void fail(Result result);

}
