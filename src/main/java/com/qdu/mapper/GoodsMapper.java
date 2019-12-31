package com.qdu.mapper;

import com.qdu.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    int addGoods(Goods goods);

    List<Goods> queryList();

    int updateGoods(Goods goods);

    int changeStatus(@Param("id") int id,@Param("status") int status);

    List<Goods> queryListByTag(@Param("category") String category,@Param("name") String name,@Param("status") int status);

    Goods queryGoodsById(int id);
}
