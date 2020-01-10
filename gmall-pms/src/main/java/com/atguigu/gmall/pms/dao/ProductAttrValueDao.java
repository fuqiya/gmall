package com.atguigu.gmall.pms.dao;

import com.atguigu.gmall.pms.entity.ProductAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * spu属性值
 * 
 * @author yangfuqi
 * @email 1654771175@qq.com
 * @date 2020-01-01 11:22:09
 */
@Mapper
public interface ProductAttrValueDao extends BaseMapper<ProductAttrValueEntity> {

    List<ProductAttrValueEntity> querySearchAttrValue(long spuId);
}
