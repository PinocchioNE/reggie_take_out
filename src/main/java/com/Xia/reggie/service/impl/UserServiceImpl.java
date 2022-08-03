package com.Xia.reggie.service.impl;

import com.Xia.reggie.entity.User;
import com.Xia.reggie.mapper.UserMapper;
import com.Xia.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
