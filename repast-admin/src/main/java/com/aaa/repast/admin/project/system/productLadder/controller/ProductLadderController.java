package com.aaa.repast.admin.project.system.productLadder.controller;

import java.util.List;
import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.productLadder.domain.ProductLadder;
import com.aaa.repast.admin.project.system.productLadder.service.IProductLadderService;

/**
 * 产品阶梯价格(只针对同商品) 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Controller
@RequestMapping("/system/productLadder")
public class ProductLadderController extends BaseController
{
    private String prefix = "system/productLadder";
	
	@Autowired
	private IProductLadderService productLadderService;
	
	@RequiresPermissions("system:productLadder:view")
	@GetMapping()
	public String productLadder()
	{
	    return prefix + "/productLadder";
	}
	
	/**
	 * 查询产品阶梯价格(只针对同商品)列表
	 */
	@RequiresPermissions("system:productLadder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductLadder productLadder)
	{
		startPage();
        List<ProductLadder> list = productLadderService.selectProductLadderList(productLadder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出产品阶梯价格(只针对同商品)列表
	 */
	@RequiresPermissions("system:productLadder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductLadder productLadder)
    {
    	List<ProductLadder> list = productLadderService.selectProductLadderList(productLadder);
        ExcelUtil<ProductLadder> util = new ExcelUtil<ProductLadder>(ProductLadder.class);
        return util.exportExcel(list, "productLadder");
    }
	
	/**
	 * 新增产品阶梯价格(只针对同商品)
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存产品阶梯价格(只针对同商品)
	 */
	@RequiresPermissions("system:productLadder:add")
	@Log(title = "产品阶梯价格(只针对同商品)", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProductLadder productLadder)
	{		
		return toAjax(productLadderService.insertProductLadder(productLadder));
	}

	/**
	 * 修改产品阶梯价格(只针对同商品)
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ProductLadder productLadder = productLadderService.selectProductLadderById(id);
		mmap.put("productLadder", productLadder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存产品阶梯价格(只针对同商品)
	 */
	@RequiresPermissions("system:productLadder:edit")
	@Log(title = "产品阶梯价格(只针对同商品)", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProductLadder productLadder)
	{		
		return toAjax(productLadderService.updateProductLadder(productLadder));
	}
	
	/**
	 * 删除产品阶梯价格(只针对同商品)
	 */
	@RequiresPermissions("system:productLadder:remove")
	@Log(title = "产品阶梯价格(只针对同商品)", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productLadderService.deleteProductLadderByIds(ids));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:52
	 * @Description
	 *  添加商品的阶梯价格
	 */
	@RequiresPermissions("system:productLadder:insertLadder")
	@Log(title = "添加商品的阶梯价格", businessType = BusinessType.DELETE)
	@PostMapping( "/insertLadder")
	@ResponseBody
	public  AjaxResult insertLadder(ProductLadder productLadder){
		return toAjax(productLadderService.insertLadder(productLadder));
	}
}
