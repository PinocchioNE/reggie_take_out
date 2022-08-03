package com.Xia.reggie.service;

import com.Xia.reggie.dto.SetmealDto;
import com.Xia.reggie.entity.Dish;
import com.Xia.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
     void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
     void removeWithDish(List<Long> ids);

}
