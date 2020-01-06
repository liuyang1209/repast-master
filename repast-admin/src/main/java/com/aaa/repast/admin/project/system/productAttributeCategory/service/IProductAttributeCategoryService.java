package com.aaa.repast.admin.project.system.productAttributeCategory.service;

import com.aaa.repast.admin.project.system.productAttribute.domain.ProductAttribute;
import com.aaa.repast.admin.project.system.productAttributeCategory.domain.ProductAttributeCategory;
import java.util.List;

/**
 * 产品属性分类 服务层
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
public interface IProductAttributeCategoryService 
{
	/**
     * 查询产品属性分类信息
     * 
     * @param id 产品属性分类ID
     * @return 产品属性分类信息
     */
	public ProductAttributeCategory selectProductAttributeCategoryById(Long id);
	
	/**
     * 查询产品属性分类列表
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 产品属性分类集合
     */
	public List<ProductAttributeCategory> selectProductAttributeCategoryList(ProductAttributeCategory productAttributeCategory);
	
	/**
     * 新增产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	public int insertProductAttributeCategory(ProductAttributeCategory productAttributeCategory);
	
	/**
     * 修改产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	public int updateProductAttributeCategory(ProductAttributeCategory productAttributeCategory);
		
	/**
     * 删除产品属性分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductAttributeCategoryByIds(String ids);

	/**
	 * 根据属性类别id获取规格
	 * @param id
	 * @return
	 */
	public List<ProductAttribute> selectGuiGe(Long id);


	/**
	 * 根据属性类别id获取属性
	 * @param id
	 * @return
	 */
	public List<ProductAttribute> selectShuXing(Long id);
}
