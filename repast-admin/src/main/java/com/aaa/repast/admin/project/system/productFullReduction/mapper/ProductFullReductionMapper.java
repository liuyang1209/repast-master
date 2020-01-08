package com.aaa.repast.admin.project.system.productFullReduction.mapper;

import com.aaa.repast.admin.project.system.productFullReduction.domain.ProductFullReduction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品满减(只针对同商品) 数据层
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Repository
public interface ProductFullReductionMapper 
{
	/**
     * 查询产品满减(只针对同商品)信息
     * 
     * @param id 产品满减(只针对同商品)ID
     * @return 产品满减(只针对同商品)信息
     */
	public ProductFullReduction selectProductFullReductionById(Long id);
	
	/**
     * 查询产品满减(只针对同商品)列表
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 产品满减(只针对同商品)集合
     */
	public List<ProductFullReduction> selectProductFullReductionList(ProductFullReduction productFullReduction);
	
	/**
     * 新增产品满减(只针对同商品)
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 结果
     */
	public int insertProductFullReduction(ProductFullReduction productFullReduction);
	
	/**
     * 修改产品满减(只针对同商品)
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 结果
     */
	public int updateProductFullReduction(ProductFullReduction productFullReduction);
	
	/**
     * 删除产品满减(只针对同商品)
     * 
     * @param id 产品满减(只针对同商品)ID
     * @return 结果
     */
	public int deleteProductFullReductionById(Long id);
	
	/**
     * 批量删除产品满减(只针对同商品)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductFullReductionByIds(String[] ids);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 20:30
	 * @Description
	 * 添加商品满减信息
	 */
	public  Integer insetFullReduction(ProductFullReduction productFullReduction);
}