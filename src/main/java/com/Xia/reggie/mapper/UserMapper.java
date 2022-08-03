package com.Xia.reggie.mapper;

import com.Xia.reggie.common.BaseContext;
import com.Xia.reggie.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
