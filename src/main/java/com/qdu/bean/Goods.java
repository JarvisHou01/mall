package com.qdu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String category;
    private String info;
    private String pic;
    private int status;


//    public void setId(){
//        this.id = id;
//    }
//    public int getId(){
//        return this.id;
//    }

}
