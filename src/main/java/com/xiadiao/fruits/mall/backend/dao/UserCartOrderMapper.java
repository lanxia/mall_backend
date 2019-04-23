package com.xiadiao.fruits.mall.backend.dao;

import com.xiadiao.fruits.mall.backend.model.UserCartOrder;
import com.xiadiao.fruits.mall.backend.model.UserCartOrderExample;
import com.xiadiao.fruits.mall.backend.model.UserCartOrderWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCartOrderMapper {
    int countByExample(UserCartOrderExample example);

    int deleteByExample(UserCartOrderExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(UserCartOrderWithBLOBs record);

    int insertSelective(UserCartOrderWithBLOBs record);

    List<UserCartOrderWithBLOBs> selectByExampleWithBLOBs(UserCartOrderExample example);

    List<UserCartOrder> selectByExample(UserCartOrderExample example);

    UserCartOrderWithBLOBs selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") UserCartOrderWithBLOBs record, @Param("example") UserCartOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") UserCartOrderWithBLOBs record, @Param("example") UserCartOrderExample example);

    int updateByExample(@Param("record") UserCartOrder record, @Param("example") UserCartOrderExample example);

    int updateByPrimaryKeySelective(UserCartOrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserCartOrderWithBLOBs record);

    int updateByPrimaryKey(UserCartOrder record);
}