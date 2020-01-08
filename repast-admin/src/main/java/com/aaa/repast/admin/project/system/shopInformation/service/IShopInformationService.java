package com.aaa.repast.admin.project.system.shopInformation.service;

import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 店铺的基本 服务层
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public interface IShopInformationService 
{
	/**
     * 查询店铺的基本信息
     * 
     * @param id 店铺的基本ID
     * @return 店铺的基本信息
     */
	public ShopInformation selectShopInformationById(Long id);
	
	/**
     * 查询店铺的基本列表
     * 
     * @param shopInformation 店铺的基本信息
     * @return 店铺的基本集合
     */
	public List<ShopInformation> selectShopInformationList(ShopInformation shopInformation);
	
	/**
     * 新增店铺的基本
     * 
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
	public int insertShopInformation(MultipartFile[] files, ShopInformation shopInformation);
	
	/**
     * 修改店铺的基本
     * 
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
	public int updateShopInformation(MultipartFile[] files, ShopInformation shopInformation);
		
	/**
     * 删除店铺的基本信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopInformationByIds(String ids);
	/**
	 * 查询店铺的名称信息
	 * @return 店铺的名称信息
	 */
	public List<ShopInformation> selectShopInformationName();
	/**
	 * 修改营业状态
	 * @param id
	 * @param closed
	 * @return
	 */
	public int updateClosed(Long id, Integer closed);



	// 刘扬写的代码：
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 20:23
	 * @Description
	 * 查询所有的店铺
	 */
	List<ShopInformation> getShopinformation();

	//董彤彤
	/**
	 * 查询店铺的名称信息
	 * @return 店铺的名称信息
	 */
	public List<ShopInformation> selectShopInformationNames();

}
