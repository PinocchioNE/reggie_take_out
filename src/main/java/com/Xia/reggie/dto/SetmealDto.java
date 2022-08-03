package com.Xia.reggie.dto;

import com.Xia.reggie.entity.Setmeal;
import com.Xia.reggie.entity.SetmealDish;
import com.Xia.reggie.entity.Setmeal;
import com.Xia.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
