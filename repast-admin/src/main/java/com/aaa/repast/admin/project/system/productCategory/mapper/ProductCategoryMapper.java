package com.aaa.repast.admin.project.system.productCategory.mapper;

import com.aaa.repast.admin.project.system.productCategory.domain.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品分类 数据层
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Repository
public interface ProductCategoryMapper 
{
	/**
     * 查询产品分类信息
     * 
     * @param id 产品分类ID
     * @return 产品分类信息
     */
	public ProductCategory selectProductCategoryById(Long id);
	
	/**
     * 查询产品分类列表
     * 
     * @param productCategory 产品分类信息
     * @return 产品分类集合
     */
	public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory);
	
	/**
     * 新增产品分类
     * 
     * @param productCategory 产品分类信息
     * @return 结果
     */
	public int insertProductCategory(ProductCategory productCategory);
	
	/**
     * 修改产品分类
     * 
     * @param productCategory 产品分类信息
     * @return 结果
     */
	public int updateProductCategory(ProductCategory productCategory);
	
	/**
     * 删除产品分类
     * 
     * @param id 产品分类ID
     * @return 结果
     */
	public int deleteProductCategoryById(Long id);
	
	/**
     * 批量删除产品分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductCategoryByIds(String[] ids);


	// 新增的方法
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 21:15
	 * @Description
	 * 添加一级类目 并返回对应主键id
	 */
	public Long returnId(ProductCategory productCategory);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 21:37
	 * @Description
	 * 根据类目id 添加或修改 图片路径
	 */
	Integer getIcon(@Param("icon") String icon, @Param("id") Long id);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 20:40
	 * @Description
	 * 新增保存产品分类
	 */
	public List<ProductCategory> selectTow(Long id);


	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 17:05
	 * @Description
	 * 修改二级类目的信息(不修改图片)
	 */
	public Integer updateTwoInfo(ProductCategory productCategory);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 17:12
	 * @Description
	 * 修改 图片的路径
	 */
	public Integer updateTwoInfoAndImage(ProductCategory productCategory);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 19:35
	 * @Description
	 * 删除（修改状态）一级类目
	 */
	public Integer delTwoStatus(Long id);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 09:30
	 * @Description
	 * 	添加二级类目
	 */

	  public  Integer twoProinfo(ProductCategory productCategory);

}