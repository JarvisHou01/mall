package com.qdu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCarVo extends ShopCar {
    private String name;
    private double price;
    private int stock;
    private String category;
    private String info;
    private String pic;
    private double totalprice;
}
