package com.qdu.service;

import com.qdu.bean.Page;
import com.qdu.bean.ShopCarVo;

public interface ShopCarService {
    int add(int gid, int uid, int count);

    Page<ShopCarVo> queryList(int pageNum, int pageSize, int uid);

    int delById(int carId);
}
