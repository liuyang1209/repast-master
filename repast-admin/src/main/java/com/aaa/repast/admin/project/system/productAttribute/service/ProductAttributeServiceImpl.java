package com.aaa.repast.admin.project.system.productAttribute.service;

import com.aaa.repast.admin.project.system.productAttributeCategory.domain.ProductAttributeCategory;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.productAttribute.mapper.ProductAttributeMapper;
import com.aaa.repast.admin.project.system.productAttribute.domain.ProductAttribute;

/**
 * 商品属性参数 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-02
 */
@Service
public class ProductAttributeServiceImpl implements IProductAttributeService 
{
	@Autowired
	private ProductAttributeMapper productAttributeMapper;

	/**
     * 查询商品属性参数信息
     * 
     * @param id 商品属性参数ID
     * @return 商品属性参数信息
     */
    @Override
	public ProductAttribute selectProductAttributeById(Long id)
	{
	    return productAttributeMapper.selectProductAttributeById(id);
	}
	
	/**
     * 查询商品属性参数列表
     * 
     * @param productAttribute 商品属性参数信息
     * @return 商品属性参数集合
     */
	@Override
	public List<ProductAttribute> selectProductAttributeList(ProductAttribute productAttribute)
	{
	    return productAttributeMapper.selectProductAttributeList(productAttribute);
	}
	
    /**
     * 新增商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	@Override
	public int insertProductAttribute(ProductAttribute productAttribute)
	{
	    return productAttributeMapper.insertProductAttribute(productAttribute);
	}
	
	/**
     * 修改商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	@Override
	public int updateProductAttribute(ProductAttribute productAttribute)
	{
	    return productAttributeMapper.updateProductAttribute(productAttribute);
	}

	/**
     * 删除商品属性参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductAttributeByIds(String ids)
	{
		return productAttributeMapper.deleteProductAttributeByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ProductAttributeCategory> selectCategoryName() {
		List<ProductAttributeCategory> productAttributeCategories = productAttributeMapper.selectCategoryName();
		return productAttributeCategories;
	}


	// 刘扬
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/7 13:21
	 * @Description
	 * 	查询类型 查询属性
	 */
	@Override
	public List<ProductAttribute> selectAttributeByType(Integer type){
		return productAttributeMapper.selectAttributeByType(type);
	}
}
