package com.aaa.repast.admin.project.system.advertise.mapper;

import com.aaa.repast.admin.project.system.advertise.domain.Advertise;
import com.aaa.repast.admin.project.system.advertise.domain.AdvertiseAndPositionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 广告位 数据层
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Repository
public interface AdvertiseMapper {
    /**
     * 查询广告位信息
     *
     * @param id 广告位ID
     * @return 广告位信息
     */
    public AdvertiseAndPositionVo selectAdvertiseById(Long id);

    /**
     * 查询广告位列表
     *
     * @param advertiseAndPositionVo 广告位信息
     * @return 广告位集合
     */
    public List<AdvertiseAndPositionVo> selectAdvertiseList(AdvertiseAndPositionVo advertiseAndPositionVo);

    /**
     * 新增广告位
     *
     * @param advertise 广告位信息
     * @return 结果
     */
    public int insertAdvertise(Advertise advertise);

    /**
     * 修改广告位
     *
     * @param advertise 广告位信息
     * @return 结果
     */
    public int updateAdvertise(Advertise advertise);

    /**
     * 删除广告位
     *
     * @param id 广告位ID
     * @return 结果
     */
    public int deleteAdvertiseById(Long id);

    /**
     * 批量删除广告位
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAdvertiseByIds(String[] ids);

    /**
     * 修改上下线状态
     *
     * @param id
     * @return
     */
    public int status(@Param("id") Long id, @Param("status") Integer status);

}