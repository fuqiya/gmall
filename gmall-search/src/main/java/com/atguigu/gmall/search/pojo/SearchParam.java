package com.atguigu.gmall.search.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SearchParam {
    private Long[] catelog3; //三级分类id

    private Long[] brand; //品牌id

    private String key; //检索的关键字

    private String order;  //0:综合排序 1：销量 2;价格

    private Integer pageNum = 1; //分页信息
    private Integer pageSize = 64;

    private List<String> props; //页面提交得的数组


    private Double priceFrom; //价格区间开始

    private Double priceTo; //价格区间结束

    private Boolean store;
}
