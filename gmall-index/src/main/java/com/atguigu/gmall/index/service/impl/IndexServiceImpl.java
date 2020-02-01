package com.atguigu.gmall.index.service.impl;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.index.annotation.GmallCache;
import com.atguigu.gmall.index.feign.GmallPmsClient;
import com.atguigu.gmall.index.service.IndexService;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private GmallPmsClient gmallPmsClient;

    @Override
    public List<CategoryEntity> queryLevel1Category() {
        Resp<List<CategoryEntity>> categoriesResp = this.gmallPmsClient.queryCategoriesByLevelOrPid(1, null);
        List<CategoryEntity> categoryEntities = categoriesResp.getData();
        return categoryEntities;
    }

    @Override
    public List<CategoryEntity> querySubCategories(Long pid) {
        // 如果缓存中没有则调用远程接口获取
        Resp<List<CategoryEntity>> subCategoryResp = this.gmallPmsClient.querySubCategory(pid);
        List<CategoryEntity> categoryEntities = subCategoryResp.getData();

        return categoryEntities;
    }
}
