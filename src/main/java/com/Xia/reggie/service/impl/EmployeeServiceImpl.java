package com.Xia.reggie.service.impl;


import com.Xia.reggie.entity.Employee;
import com.Xia.reggie.mapper.EmployeeMapper;
import com.Xia.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
