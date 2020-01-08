package com.aaa.repast.admin.project.system.productLadder.mapper;

import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.project.system.productLadder.domain.ProductLadder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品阶梯价格(只针对同商品) 数据层
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Repository
public interface ProductLadderMapper 
{
	/**
     * 查询产品阶梯价格(只针对同商品)信息
     * 
     * @param id 产品阶梯价格(只针对同商品)ID
     * @return 产品阶梯价格(只针对同商品)信息
     */
	public ProductLadder selectProductLadderById(Long id);
	
	/**
     * 查询产品阶梯价格(只针对同商品)列表
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 产品阶梯价格(只针对同商品)集合
     */
	public List<ProductLadder> selectProductLadderList(ProductLadder productLadder);
	
	/**
     * 新增产品阶梯价格(只针对同商品)
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 结果
     */
	public int insertProductLadder(ProductLadder productLadder);
	
	/**
     * 修改产品阶梯价格(只针对同商品)
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 结果
     */
	public int updateProductLadder(ProductLadder productLadder);
	
	/**
     * 删除产品阶梯价格(只针对同商品)
     * 
     * @param id 产品阶梯价格(只针对同商品)ID
     * @return 结果
     */
	public int deleteProductLadderById(Long id);
	
	/**
     * 批量删除产品阶梯价格(只针对同商品)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductLadderByIds(String[] ids);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:52
	 * @Description
	 *  添加商品的阶梯价格
	 */
	public Integer insertLadder(ProductLadder productLadder);
	
}