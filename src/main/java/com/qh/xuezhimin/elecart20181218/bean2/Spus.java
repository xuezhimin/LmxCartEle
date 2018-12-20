package com.qh.xuezhimin.elecart20181218.bean2;

import java.util.List;

public class Spus {
    private String _id;

    private int id;

    private int restaurant_id;

    private int category_id;

    private String name;

    private int praise_num;

    private String praise_content;

    private int month_saled;

    private String month_saled_content;

    private String pic_url;

    private int __v;

    private String created_at;

    private List<Skus> skus;

//    private List<Attrs> attrs ;
//
//    private List<Status_remind_list> status_remind_list ;

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return this._id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getRestaurant_id() {
        return this.restaurant_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public int getPraise_num() {
        return this.praise_num;
    }

    public void setPraise_content(String praise_content) {
        this.praise_content = praise_content;
    }

    public String getPraise_content() {
        return this.praise_content;
    }

    public void setMonth_saled(int month_saled) {
        this.month_saled = month_saled;
    }

    public int getMonth_saled() {
        return this.month_saled;
    }

    public void setMonth_saled_content(String month_saled_content) {
        this.month_saled_content = month_saled_content;
    }

    public String getMonth_saled_content() {
        return this.month_saled_content;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public int get__v() {
        return this.__v;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setSkus(List<Skus> skus) {
        this.skus = skus;
    }

    public List<Skus> getSkus() {
        return this.skus;
    }
//    public void setAttrs(List<Attrs> attrs){
//        this.attrs = attrs;
//    }
//    public List<Attrs> getAttrs(){
//        return this.attrs;
//    }
//    public void setStatus_remind_list(List<Status_remind_list> status_remind_list){
//        this.status_remind_list = status_remind_list;
//    }
//    public List<Status_remind_list> getStatus_remind_list(){
//        return this.status_remind_list;
//    }


}
