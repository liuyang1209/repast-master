package com.aaa.repast.admin.project.system.product.service;

import com.aaa.repast.admin.project.system.product.domain.Product;
import com.aaa.repast.admin.project.system.product.domain.ProductVos;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品 服务层
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
public interface IProductService 
{
	/**
     * 查询商品信息
     * 
     * @param id 商品ID
     * @return 商品信息
     */
	public Product selectProductById(Long id);
	
	/**
     * 查询商品列表
     * 
     * @param product 商品信息
     * @return 商品集合
     */
	public List<Product> selectProductList(Product product);
	
	/**
     * 新增商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	public int insertProduct(Product product, MultipartFile file);
	
	/**
     * 修改商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	public int updateProduct(Product product);
		
	/**
     * 删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductByIds(String ids);
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/7 22:28
	 * @Description
	 * 查询商品 vo
	 */
	public List<ProductVos> ProductVos(ProductVos productVos);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 00:46
	 * @Description
	 * 根据id 查询商品的信息
	 */
	public  Product findByIdProduct(Long id);
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 12:53
	 * @Description
	 * 修改商品信息
	 */
	public Integer updateFindByIdProduct(Product product,MultipartFile file);

	/**
 * @Author Yang
 * @Date Create in  2020/1/8 14:31
 * @Description
 * 更改删除状态
 */
public Integer deleteStatus(Long id,Integer status);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:24
	 * @Description
	 * 修改上下架状态
	 */
	public Integer publishStatus( Long id, Integer status);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:54
	 * @Description
	 * 更改 是否新品状态
	 */
	public Integer newStatus( Long id, Integer status);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:11
	 * @Description
	 * 添加促销商品
	 */
	public Integer promotionProduct( Long id ,  BigDecimal promotionPrice, String promotionStartTime, String promotionEndTime);
}
