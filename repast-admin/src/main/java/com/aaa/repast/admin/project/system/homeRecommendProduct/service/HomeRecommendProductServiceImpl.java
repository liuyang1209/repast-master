package com.aaa.repast.admin.project.system.homeRecommendProduct.service;

import com.aaa.repast.admin.project.system.homeRecommendProduct.vo.HomeRecommendProductVo;
import com.aaa.repast.admin.project.system.product.domain.Product;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.aaa.repast.admin.project.system.homeRecommendProduct.mapper.HomeRecommendProductMapper;
import com.aaa.repast.admin.project.system.homeRecommendProduct.domain.HomeRecommendProduct;

/**
 * 人气推荐商品 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-05
 */
@Service
public class HomeRecommendProductServiceImpl implements IHomeRecommendProductService 
{
	@Autowired
	private HomeRecommendProductMapper homeRecommendProductMapper;

	/**
     * 查询人气推荐商品信息
     * 
     * @param id 人气推荐商品ID
     * @return 人气推荐商品信息
     */
    @Override
	public HomeRecommendProduct selectHomeRecommendProductById(Long id)
	{
	    return homeRecommendProductMapper.selectHomeRecommendProductById(id);
	}
	
	/**
     * 查询人气推荐商品列表
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 人气推荐商品集合
     */
	@Override
	public List<HomeRecommendProduct> selectHomeRecommendProductList(HomeRecommendProduct homeRecommendProduct)
	{
	    return homeRecommendProductMapper.selectHomeRecommendProductList(homeRecommendProduct);
	}
	
    /**
     * 新增人气推荐商品
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 结果
     */
	@Override
	public int insertHomeRecommendProduct(HomeRecommendProduct homeRecommendProduct)
	{
	    return homeRecommendProductMapper.insertHomeRecommendProduct(homeRecommendProduct);
	}
	
	/**
     * 修改人气推荐商品
     * 
     * @param homeRecommendProduct 人气推荐商品信息
     * @return 结果
     */
	@Override
	public int updateHomeRecommendProduct(HomeRecommendProduct homeRecommendProduct)
	{
	    return homeRecommendProductMapper.updateHomeRecommendProduct(homeRecommendProduct);
	}

	/**
     * 删除人气推荐商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHomeRecommendProductByIds(String ids)
	{
		return homeRecommendProductMapper.deleteHomeRecommendProductByIds(Convert.toStrArray(ids));
	}


	/**
	 * liyong
	 * 	二级联动获取店铺的信息
	 *
	 */
	@Override
	public List<ShopInformation>  findWhun() {
		return homeRecommendProductMapper.findWhun();
	}

	/**
	 * liyong
	 * 		二级菜单、二级下拉框、获取一级菜单查到的店铺id。根据店铺id查询商品
	 *
	 */
	@Override
	public List<Product> findRegion(Long id) {
		return homeRecommendProductMapper.findRegion(id);
	}



	/**
	 * liyong
	 *
	 * 	前台修改推荐状态
	 *
	 */
	@Override
	public int recommendStatus(Long id,Integer recommend_status){
		if(recommend_status == 1){
			recommend_status = 0;
		}else if(recommend_status == 0){
			recommend_status = 1;
		}
		return homeRecommendProductMapper.recommendStatus(id,recommend_status);
	}


	/**
	 * liyong
	 * 		修改商品获取店铺的id
	 *
	 */
	@Override
	public List<HomeRecommendProductVo> updateGoods (Long shopId){
		List<HomeRecommendProductVo> homeRecommendProductVos = homeRecommendProductMapper.updateGoods(shopId);
		return homeRecommendProductVos;
	}

	/**
	 * liyong
	 * 		查询商品id放入到修改模态框中
	 *
	 */
	@Override
	public List<HomeRecommendProductVo> selectProductId(Long productId){
		List<HomeRecommendProductVo> homeRecommendProductVos = homeRecommendProductMapper.selectProductId(productId);
		return homeRecommendProductVos;
	}

}
