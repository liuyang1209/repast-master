package com.aaa.repast.admin.project.system.advertisePosition.service;

import com.aaa.repast.admin.project.system.advertisePosition.domain.AdvertisePosition;
import java.util.List;

/**
 * 广告位位置 服务层
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public interface IAdvertisePositionService 
{
	/**
     * 查询广告位位置信息
     * 
     * @param id 广告位位置ID
     * @return 广告位位置信息
     */
	public AdvertisePosition selectAdvertisePositionById(Long id);
	
	/**
     * 查询广告位位置列表
     * 
     * @param advertisePosition 广告位位置信息
     * @return 广告位位置集合
     */
	public List<AdvertisePosition> selectAdvertisePositionList(AdvertisePosition advertisePosition);
	
	/**
     * 新增广告位位置
     * 
     * @param advertisePosition 广告位位置信息
     * @return 结果
     */
	public int insertAdvertisePosition(AdvertisePosition advertisePosition);
	
	/**
     * 修改广告位位置
     * 
     * @param advertisePosition 广告位位置信息
     * @return 结果
     */
	public int updateAdvertisePosition(AdvertisePosition advertisePosition);
		
	/**
     * 删除广告位位置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAdvertisePositionByIds(String ids);
	/**
	 * 查询广告位置名称
	 * @return
	 */
	public List<AdvertisePosition> selectAdvertisePositionName();
}
