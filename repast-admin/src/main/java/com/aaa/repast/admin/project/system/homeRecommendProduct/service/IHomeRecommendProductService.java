package com.aaa.repast.admin.project.system.homeRecommendProduct.service;

import com.aaa.repast.admin.project.system.homeRecommendProduct.domain.HomeRecommendProduct;
import com.aaa.repast.admin.project.system.homeRecommendProduct.vo.HomeRecommendProductVo;
import com.aaa.repast.admin.project.system.product.domain.Product;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;

import java.util.List;

/**
 * 人气推荐商品 服务层
 * 
 * @author Seven Lee
 * @date 2020-01-05
 */
public interface IHomeRecommendProductService 
{
	/**
     * 查询人气推荐商品信息
     * 
     * @param id 人气推荐商品ID
     * @return 人气推荐商品信息
     */
	public HomeRecommendProduct selectHomeRecommendProductById(Long id);
	
	/**
     * 查询人气推荐商品列表
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 人气推荐商品集合
     */
	public List<HomeRecommendProduct> selectHomeRecommendProductList(HomeRecommendProduct homeRecommendProduct);
	
	/**
     * 新增人气推荐商品
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 结果
     */
	public int insertHomeRecommendProduct(HomeRecommendProduct homeRecommendProduct);
	
	/**
     * 修改人气推荐商品
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 结果
     */
	public int updateHomeRecommendProduct(HomeRecommendProduct homeRecommendProduct);
		
	/**
     * 删除人气推荐商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeRecommendProductByIds(String ids);


	/**
	 * liyong
	 * 		三级联动获取店铺的id
	 *
	 */
	public List<ShopInformation>  findWhun();

	/**
	 * liyong
	 *
	 * 	二级菜单、二级下拉框、获取一级菜单查到的店铺id。根据店铺id查询商品
	 *
	 */
	public List<Product> findRegion(Long id);


	/**
	 * liyong
	 * 		前台修改推荐状态
	 *
	 */
	public int recommendStatus(Long id, Integer recommend_status);


	/**
	 * liyong
	 * 		修改商品获取店铺的id
	 *
	 */
	public List<HomeRecommendProductVo> updateGoods(Long shopId);


	/**
	 * liyong
	 * 		查询商品id放入到修改模态框中
	 *
	 */
	public List<HomeRecommendProductVo> selectProductId(Long productId);
	
}
