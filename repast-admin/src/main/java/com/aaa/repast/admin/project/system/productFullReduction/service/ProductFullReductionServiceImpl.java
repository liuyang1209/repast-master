package com.aaa.repast.admin.project.system.productFullReduction.service;

import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.productFullReduction.mapper.ProductFullReductionMapper;
import com.aaa.repast.admin.project.system.productFullReduction.domain.ProductFullReduction;

/**
 * 产品满减(只针对同商品) 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Service
public class ProductFullReductionServiceImpl implements IProductFullReductionService 
{
	@Autowired
	private ProductFullReductionMapper productFullReductionMapper;

	/**
     * 查询产品满减(只针对同商品)信息
     * 
     * @param id 产品满减(只针对同商品)ID
     * @return 产品满减(只针对同商品)信息
     */
    @Override
	public ProductFullReduction selectProductFullReductionById(Long id)
	{
	    return productFullReductionMapper.selectProductFullReductionById(id);
	}
	
	/**
     * 查询产品满减(只针对同商品)列表
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 产品满减(只针对同商品)集合
     */
	@Override
	public List<ProductFullReduction> selectProductFullReductionList(ProductFullReduction productFullReduction)
	{
	    return productFullReductionMapper.selectProductFullReductionList(productFullReduction);
	}
	
    /**
     * 新增产品满减(只针对同商品)
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 结果
     */
	@Override
	public int insertProductFullReduction(ProductFullReduction productFullReduction)
	{
	    return productFullReductionMapper.insertProductFullReduction(productFullReduction);
	}
	
	/**
     * 修改产品满减(只针对同商品)
     * 
     * @param productFullReduction 产品满减(只针对同商品)信息
     * @return 结果
     */
	@Override
	public int updateProductFullReduction(ProductFullReduction productFullReduction)
	{
	    return productFullReductionMapper.updateProductFullReduction(productFullReduction);
	}

	/**
     * 删除产品满减(只针对同商品)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductFullReductionByIds(String ids)
	{
		return productFullReductionMapper.deleteProductFullReductionByIds(Convert.toStrArray(ids));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 20:30
	 * @Description
	 * 添加商品满减信息
	 */
	@Override
	public  Integer insetFullReduction(ProductFullReduction productFullReduction){
		return productFullReductionMapper.insertProductFullReduction(productFullReduction);
	}
	
}
