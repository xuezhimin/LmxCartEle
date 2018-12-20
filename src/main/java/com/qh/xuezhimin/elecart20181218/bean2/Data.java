package com.qh.xuezhimin.elecart20181218.bean2;

import com.qh.xuezhimin.elecart20181218.R;

import java.util.List;

public class Data {

    private int id;

    private String name;

    private int restaurant_id;

    private String created_at;

    private List<Spus> spus ;

    private int __v;

    int textColor = 0xffffffff;
    int background = R.color.grayblack;

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setRestaurant_id(int restaurant_id){
        this.restaurant_id = restaurant_id;
    }
    public int getRestaurant_id(){
        return this.restaurant_id;
    }
    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public void setSpus(List<Spus> spus){
        this.spus = spus;
    }
    public List<Spus> getSpus(){
        return this.spus;
    }
    public void set__v(int __v){
        this.__v = __v;
    }
    public int get__v(){
        return this.__v;
    }


}
