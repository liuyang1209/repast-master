package com.aaa.repast.admin.project.system.homeRecommendProduct.controller;

import java.util.List;

import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.homeRecommendProduct.vo.HomeRecommendProductVo;
import com.aaa.repast.admin.project.system.product.domain.Product;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.aaa.repast.admin.project.system.homeRecommendProduct.domain.HomeRecommendProduct;
import com.aaa.repast.admin.project.system.homeRecommendProduct.service.IHomeRecommendProductService;
/**
 * 人气推荐商品 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-05
 */
@Controller
@RequestMapping("/system/homeRecommendProduct")
public class HomeRecommendProductController extends BaseController
{
    private String prefix = "system/homeRecommendProduct";
	
	@Autowired
	private IHomeRecommendProductService homeRecommendProductService;
	
	@RequiresPermissions("system:homeRecommendProduct:view")
	@GetMapping()
	public String homeRecommendProduct()
	{
	    return prefix + "/homeRecommendProduct";
	}
	
	/**
	 * 查询人气推荐商品列表
	 */
	@RequiresPermissions("system:homeRecommendProduct:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeRecommendProduct homeRecommendProduct)
	{
		startPage();
        List<HomeRecommendProduct> list = homeRecommendProductService.selectHomeRecommendProductList(homeRecommendProduct);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人气推荐商品列表
	 */
	@RequiresPermissions("system:homeRecommendProduct:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeRecommendProduct homeRecommendProduct)
    {
    	List<HomeRecommendProduct> list = homeRecommendProductService.selectHomeRecommendProductList(homeRecommendProduct);
        ExcelUtil<HomeRecommendProduct> util = new ExcelUtil<HomeRecommendProduct>(HomeRecommendProduct.class);
        return util.exportExcel(list, "homeRecommendProduct");
    }
	
	/**
	 * 新增人气推荐商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人气推荐商品
	 */
	@RequiresPermissions("system:homeRecommendProduct:add")
	@Log(title = "人气推荐商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HomeRecommendProduct homeRecommendProduct)
	{		
		return toAjax(homeRecommendProductService.insertHomeRecommendProduct(homeRecommendProduct));
	}

	/**
	 * 修改人气推荐商品
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HomeRecommendProduct homeRecommendProduct = homeRecommendProductService.selectHomeRecommendProductById(id);
		mmap.put("homeRecommendProduct", homeRecommendProduct);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人气推荐商品
	 */
	@RequiresPermissions("system:homeRecommendProduct:edit")
	@Log(title = "人气推荐商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeRecommendProduct homeRecommendProduct)
	{		
		return toAjax(homeRecommendProductService.updateHomeRecommendProduct(homeRecommendProduct));
	}
	
	/**
	 * 删除人气推荐商品
	 */
	@RequiresPermissions("system:homeRecommendProduct:remove")
	@Log(title = "人气推荐商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeRecommendProductService.deleteHomeRecommendProductByIds(ids));
	}



	/**
	 * 下拉框动态获取店铺id
	 * @return
	 */
	//@RequiresPermissions("system:homeRecommendProduct:list")
	//@RequestMapping(value = "queryWhun")
	@PostMapping("/queryWhun")
	@ResponseBody
	public List<ShopInformation>  findWhun(){
		return homeRecommendProductService.findWhun();
	}


	/**
	 * 二级下拉框、获取一级菜单查到的店铺id。根据店铺id查询商品
	 * @param
	 * @return
	 */
	@PostMapping(value = "queryRegion")
	@ResponseBody
	public List<Product>  findRegion(Long id){
		return homeRecommendProductService.findRegion(id);
	}



	/**
	 *liyong
	 * 	修改前台推荐状态
	 *
	 */
	@Log(title = "推荐状态", businessType = BusinessType.UPDATE)
	@PostMapping("/recommend_status")
	@ResponseBody
	public AjaxResult recommendStatus( Long id,Integer recommend_status)
	{
		return toAjax(homeRecommendProductService.recommendStatus(id,recommend_status));
	}


	/**
	 * liyong
	 *
	 * 		查询修改商品获取店铺id
	 */
	@Log(title = "查询修改商品模态框显示数据", businessType = BusinessType.UPDATE)
	@PostMapping("/queryshoId")
	@ResponseBody
	public List<HomeRecommendProductVo> updateGoods(Long shopId){
		return homeRecommendProductService.updateGoods(shopId);
	}


	/**
	 * liyong
	 * 	查询商品id放入 到修改模态框中
	 *
	 */
	@Log(title = "查询商品id", businessType = BusinessType.UPDATE)
	@PostMapping("/queryproductId")
	@ResponseBody
	public List<HomeRecommendProductVo> selectProductId(Long productId ){
		return homeRecommendProductService.selectProductId(productId);
	}

}
