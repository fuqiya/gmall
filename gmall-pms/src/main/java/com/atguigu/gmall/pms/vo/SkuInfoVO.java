package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SkuInfoEntity;
import com.atguigu.gmall.pms.entity.SkuSaleAttrValueEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

@Data
public class SkuInfoVO extends SkuInfoEntity {
    private BigDecimal growBounds;
    private BigDecimal buyBounds;
    private List<Integer> work;

    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private Integer fullAddOther;

    private Integer fullCount;
    private BigDecimal discount;
    private Integer ladderAddOther;

    private List<SkuSaleAttrValueEntity> saleAttrs;

    private List<String> images;
}
