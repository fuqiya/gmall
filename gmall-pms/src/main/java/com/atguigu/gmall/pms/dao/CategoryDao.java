package com.atguigu.gmall.pms.dao;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yangfuqi
 * @email 1654771175@qq.com
 * @date 2020-01-01 11:22:09
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}