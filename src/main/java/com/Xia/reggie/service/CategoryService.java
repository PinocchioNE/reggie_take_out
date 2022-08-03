package com.Xia.reggie.service;

import com.Xia.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
