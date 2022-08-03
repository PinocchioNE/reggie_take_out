package com.Xia.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Xia.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}