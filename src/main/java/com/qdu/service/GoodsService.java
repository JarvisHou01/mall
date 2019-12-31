package com.qdu.service;

import com.qdu.bean.Goods;
import com.qdu.bean.Page;

public interface GoodsService {
    int addGoods(Goods goods);

    Page<Goods> queryList(int pageNum, int pageSize);

    int updateGoods(Goods goods);

    int changeStatus(int id, int status);

    Page<Goods> queryListByTag(int pageNum, int pageSize, String category, String name,int status);

    Goods queryGoodsById(int id);
}
