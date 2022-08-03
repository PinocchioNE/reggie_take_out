package com.Xia.reggie.service.impl;

import com.Xia.reggie.common.CustomException;
import com.Xia.reggie.entity.Category;
import com.Xia.reggie.entity.Dish;
import com.Xia.reggie.entity.Setmeal;
import com.Xia.reggie.mapper.CategoryMapper;
import com.Xia.reggie.service.CategoryService;
import com.Xia.reggie.service.DishService;
import com.Xia.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl <CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;
    /**
     * 根据id删除分类，删除之气那需要进行判断
     * @param id
     */
    public void remove(Long id){
        LambdaQueryWrapper<Dish> dishlambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件i，根据分类id进行查询
        dishlambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishlambdaQueryWrapper);


        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if(count1 > 0){
            //已经关联了，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmeallambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmeallambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmeallambdaQueryWrapper);
        if(count2 > 0){
            //已经关联套餐，抛出一个业务一场
            throw new CustomException("当前分类下关联了套餐，不能删除");

        }

        //正常删除分癸
        super.removeById(id);
    }
}
