package com.aaa.repast.admin.project.system.shopFacility.mapper;

import com.aaa.repast.admin.project.system.shopFacility.domain.ShopFacility;
import java.util.List;	

/**
 * 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等 数据层
 * 
 * @author Seven Lee
 * @date 2020-01-06
 */
public interface ShopFacilityMapper 
{
	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * 
     * @param id 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等ID
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     */
	public ShopFacility selectShopFacilityById(Long id);
	
	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等列表
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等集合
     */
	public List<ShopFacility> selectShopFacilityList(ShopFacility shopFacility);
	
	/**
     * 新增店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	public int insertShopFacility(ShopFacility shopFacility);
	
	/**
     * 修改店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	public int updateShopFacility(ShopFacility shopFacility);
	
	/**
     * 删除店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param id 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等ID
     * @return 结果
     */
	public int deleteShopFacilityById(Long id);
	
	/**
     * 批量删除店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopFacilityByIds(String[] ids);
	
}