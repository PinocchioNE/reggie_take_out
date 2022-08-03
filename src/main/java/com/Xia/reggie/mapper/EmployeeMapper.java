package com.Xia.reggie.mapper;


import com.Xia.reggie.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


//继承了Employee的实体类
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
