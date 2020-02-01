package com.atguigu.gmall.index.service;

import com.atguigu.gmall.pms.entity.CategoryEntity;

import java.util.List;

public interface IndexService {
    List<CategoryEntity> queryLevel1Category();

    List<CategoryEntity> querySubCategories(Long pid);
}