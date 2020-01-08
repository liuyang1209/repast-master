package com.aaa.repast.admin.project.system.shopInformation.service;

import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.shopInformation.mapper.ShopInformationMapper;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;

/**
 * 店铺的基本 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-06
 */
@Service
public class ShopInformationServiceImpl implements IShopInformationService 
{
	@Autowired
	private ShopInformationMapper shopInformationMapper;

	/**
     * 查询店铺的基本信息
     * 
     * @param id 店铺的基本ID
     * @return 店铺的基本信息
     */
    @Override
	public ShopInformation selectShopInformationById(Long id)
	{
	    return shopInformationMapper.selectShopInformationById(id);
	}
	
	/**
     * 查询店铺的基本列表
     * 
     * @param shopInformation 店铺的基本信息
     * @return 店铺的基本集合
     */
	@Override
	public List<ShopInformation> selectShopInformationList(ShopInformation shopInformation)
	{
	    return shopInformationMapper.selectShopInformationList(shopInformation);
	}
	
    /**
     * 新增店铺的基本
     * 
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
	@Override
	public int insertShopInformation(ShopInformation shopInformation)
	{
	    return shopInformationMapper.insertShopInformation(shopInformation);
	}
	
	/**
     * 修改店铺的基本
     * 
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
	@Override
	public int updateShopInformation(ShopInformation shopInformation)
	{
	    return shopInformationMapper.updateShopInformation(shopInformation);
	}

	/**
     * 删除店铺的基本对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopInformationByIds(String ids)
	{
		return shopInformationMapper.deleteShopInformationByIds(Convert.toStrArray(ids));
	}
	// 刘扬写的代码：
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 20:23
	 * @Description
	 * 查询所有的店铺
	 */
	@Override
	public List<ShopInformation> getShopinformation(){
		return  shopInformationMapper.getShopinformation();
	}


	//董彤彤
	/**
	 * 查询店铺的名称信息
	 * @return 店铺的名称信息
	 */
	@Override
	public List<ShopInformation> selectShopInformationName() {
		List<ShopInformation> shopInformations = shopInformationMapper.selectShopInformationName();
		return shopInformations;
	}

}
