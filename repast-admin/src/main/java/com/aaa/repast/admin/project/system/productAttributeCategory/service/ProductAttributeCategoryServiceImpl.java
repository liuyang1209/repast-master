package com.aaa.repast.admin.project.system.productAttributeCategory.service;

import com.aaa.repast.admin.project.system.productAttribute.domain.ProductAttribute;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.productAttributeCategory.mapper.ProductAttributeCategoryMapper;
import com.aaa.repast.admin.project.system.productAttributeCategory.domain.ProductAttributeCategory;

/**
 * 产品属性分类 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
@Service
public class ProductAttributeCategoryServiceImpl implements IProductAttributeCategoryService 
{
	@Autowired
	private ProductAttributeCategoryMapper productAttributeCategoryMapper;

	/**
     * 查询产品属性分类信息
     * 
     * @param id 产品属性分类ID
     * @return 产品属性分类信息
     */
    @Override
	public ProductAttributeCategory selectProductAttributeCategoryById(Long id)
	{
	    return productAttributeCategoryMapper.selectProductAttributeCategoryById(id);
	}
	
	/**
     * 查询产品属性分类列表
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 产品属性分类集合
     */
	@Override
	public List<ProductAttributeCategory> selectProductAttributeCategoryList(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.selectProductAttributeCategoryList(productAttributeCategory);
	}
	
    /**
     * 新增产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	@Override
	public int insertProductAttributeCategory(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.insertProductAttributeCategory(productAttributeCategory);
	}
	
	/**
     * 修改产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	@Override
	public int updateProductAttributeCategory(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.updateProductAttributeCategory(productAttributeCategory);
	}

	/**
     * 删除产品属性分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductAttributeCategoryByIds(String ids)
	{
		return productAttributeCategoryMapper.deleteProductAttributeCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ProductAttribute> selectGuiGe(Long id) {
		List<ProductAttribute> selectGuiGe = productAttributeCategoryMapper.selectGuiGe(id);
		return selectGuiGe;
	}

	@Override
	public List<ProductAttribute> selectShuXing(Long id) {
		List<ProductAttribute> selectShuXing = productAttributeCategoryMapper.selectShuXing(id);
		return selectShuXing;
	}
	// 刘扬
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 22:06
	 * @Description
	 *  查询商品属性id 和名字
	 */
	@Override
	public  List<ProductAttributeCategory> selectProductAttribute(){
		return productAttributeCategoryMapper.selectProductAttribute();
	}
}
