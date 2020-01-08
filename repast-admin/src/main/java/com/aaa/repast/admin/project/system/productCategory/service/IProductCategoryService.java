package com.aaa.repast.admin.project.system.productCategory.service;

import com.aaa.repast.admin.project.system.productCategory.domain.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 产品分类 服务层
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
public interface IProductCategoryService 
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
     * 删除产品分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductCategoryByIds(String ids);

	//添加的方法
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 21:03
	 * @Description
	 *
	 * 添加一级类目
	 */
	public Boolean addProductCategory(ProductCategory productCategory, MultipartFile file);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 20:40
	 * @Description
	 * 根据一级类目的id 查询二级类目的商品信息
	 */
	List<ProductCategory> selectTow(Long id);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 18:52
	 * @Description
	 *  修改二级类目信息
	 */
	Boolean twoInfo(ProductCategory productCategory, MultipartFile file);
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 19:35
	 * @Description
	 * 删除（修改状态）一级类目
	 */
	public Boolean delTwoStatus(Long id);

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 09:45
	 * @Description
	 *  添加二级类目
	 */
	public Boolean twoProinfo(ProductCategory productCategory,MultipartFile file);
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:50
	 * @Description
	 * 查询二级类目
	 */
	public  List<ProductCategory> selectTwoProduct();
}
