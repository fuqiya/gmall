package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.AttrGroupVO;
import com.atguigu.gmall.pms.vo.ItemGroupVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;


/**
 * 属性分组
 *
 * @author yangfuqi
 * @email 1654771175@qq.com
 * @date 2020-01-01 11:22:09
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryGroupsByCidPage(QueryCondition queryCondition, Long catId);

    AttrGroupVO queryById(Long gid);

    List<AttrGroupVO> queryByCid(Long cid);

    List<ItemGroupVO> queryItemGroupVOsByCidAndSpuId(Long cid, Long spuId);
}

