package com.qdu.mapper;

import com.qdu.bean.ShopCarVo;

import java.util.List;

public interface ShopCarMapper {
    int add(int gid, int uid, int count);

    List<ShopCarVo> queryList(int uid);

    int delById(int id);
}
