package com.aaa.repast.admin.project.system.productLadder.service;

import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.productLadder.mapper.ProductLadderMapper;
import com.aaa.repast.admin.project.system.productLadder.domain.ProductLadder;

/**
 * 产品阶梯价格(只针对同商品) 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Service
public class ProductLadderServiceImpl implements IProductLadderService 
{
	@Autowired
	private ProductLadderMapper productLadderMapper;

	/**
     * 查询产品阶梯价格(只针对同商品)信息
     * 
     * @param id 产品阶梯价格(只针对同商品)ID
     * @return 产品阶梯价格(只针对同商品)信息
     */
    @Override
	public ProductLadder selectProductLadderById(Long id)
	{
	    return productLadderMapper.selectProductLadderById(id);
	}
	
	/**
     * 查询产品阶梯价格(只针对同商品)列表
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 产品阶梯价格(只针对同商品)集合
     */
	@Override
	public List<ProductLadder> selectProductLadderList(ProductLadder productLadder)
	{
	    return productLadderMapper.selectProductLadderList(productLadder);
	}
	
    /**
     * 新增产品阶梯价格(只针对同商品)
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 结果
     */
	@Override
	public int insertProductLadder(ProductLadder productLadder)
	{
	    return productLadderMapper.insertProductLadder(productLadder);
	}
	
	/**
     * 修改产品阶梯价格(只针对同商品)
     * 
     * @param productLadder 产品阶梯价格(只针对同商品)信息
     * @return 结果
     */
	@Override
	public int updateProductLadder(ProductLadder productLadder)
	{
	    return productLadderMapper.updateProductLadder(productLadder);
	}

	/**
     * 删除产品阶梯价格(只针对同商品)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductLadderByIds(String ids)
	{
		return productLadderMapper.deleteProductLadderByIds(Convert.toStrArray(ids));
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:52
	 * @Description
	 *  添加商品的阶梯价格
	 */
	@Override
	public Integer insertLadder(ProductLadder productLadder){
		return  productLadderMapper.insertLadder(productLadder);
	}
}
