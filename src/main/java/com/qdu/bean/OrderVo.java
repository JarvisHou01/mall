package com.qdu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo extends Orders{
    private String pic;
    private String name;
    private String username;
    private String category;
    private String price;
    private String totalprice;
}
