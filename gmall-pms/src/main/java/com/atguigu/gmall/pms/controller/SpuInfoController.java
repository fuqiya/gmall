package com.atguigu.gmall.pms.controller;

import java.util.Arrays;
import java.util.List;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.pms.vo.SpuInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import com.atguigu.gmall.pms.service.SpuInfoService;




/**
 * spu信息
 *
 * @author yangfuqi
 * @email 1654771175@qq.com
 * @date 2020-01-01 11:22:09
 */
@Api(tags = "spu信息 管理")
@RestController
@RequestMapping("pms/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;


    @PostMapping("page")
    public Resp<List<SpuInfoEntity>> querySpuByPage(@RequestBody QueryCondition condition){
        /*IPage<SpuInfoEntity> page = this.spuInfoService.page(new Query<SpuInfoEntity>().getPage(condition), new QueryWrapper<SpuInfoEntity>().eq("publish_status", "1"));
        return Resp.ok(page.getRecords());*/
        PageVo page = spuInfoService.queryPage(condition);
        List<SpuInfoEntity> list = (List<SpuInfoEntity>)page.getList();
        return Resp.ok(list);
    }


    @ApiOperation("spu商品信息查询")
    @GetMapping
    public Resp<PageVo> querySpuInfo(QueryCondition condition
            ,@RequestParam(value = "carId",defaultValue = "0") Long catId) {
        PageVo page = this.spuInfoService.querySpuInfo(condition,catId);
        return Resp.ok(page);
    }

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:spuinfo:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuInfoService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('pms:spuinfo:info')")
    public Resp<SpuInfoEntity> info(@PathVariable("id") Long id){
		SpuInfoEntity spuInfo = spuInfoService.getById(id);

        return Resp.ok(spuInfo);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:spuinfo:save')")
    public Resp<Object> save(@RequestBody SpuInfoVO spuInfoVO){
		spuInfoService.saveSpuInfoVO(spuInfoVO);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:spuinfo:update')")
    public Resp<Object> update(@RequestBody SpuInfoEntity spuInfo){
		spuInfoService.updateById(spuInfo);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:spuinfo:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuInfoService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
