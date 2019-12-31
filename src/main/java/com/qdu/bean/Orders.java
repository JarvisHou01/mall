package com.qdu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private int uid;
    private int gid;
    private int count;
    private int status;
    private String createtime;
    private String updatetime;
}
