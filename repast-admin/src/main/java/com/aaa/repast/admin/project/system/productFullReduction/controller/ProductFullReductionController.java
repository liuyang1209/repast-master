package com.aaa.repast.admin.project.system.productFullReduction.controller;

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

import com.aaa.repast.admin.project.system.productFullReduction.domain.ProductFullReduction;
import com.aaa.repast.admin.project.system.productFullReduction.service.IProductFullReductionService;

/**
 * 产品满减(只针对同商品) 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-08
 */
@Controller
@RequestMapping("/system/productFullReduction")
public class ProductFullReductionController extends BaseController
{
    private String prefix = "system/productFullReduction";
	
	@Autowired
	private IProductFullReductionService productFullReductionService;
	
	@RequiresPermissions("system:productFullReduction:view")
	@GetMapping()
	public String productFullReduction()
	{
	    return prefix + "/productFullReduction";
	}
	
	/**
	 * 查询产品满减(只针对同商品)列表
	 */
	@RequiresPermissions("system:productFullReduction:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductFullReduction productFullReduction)
	{
		startPage();
        List<ProductFullReduction> list = productFullReductionService.selectProductFullReductionList(productFullReduction);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出产品满减(只针对同商品)列表
	 */
	@RequiresPermissions("system:productFullReduction:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductFullReduction productFullReduction)
    {
    	List<ProductFullReduction> list = productFullReductionService.selectProductFullReductionList(productFullReduction);
        ExcelUtil<ProductFullReduction> util = new ExcelUtil<ProductFullReduction>(ProductFullReduction.class);
        return util.exportExcel(list, "productFullReduction");
    }
	
	/**
	 * 新增产品满减(只针对同商品)
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存产品满减(只针对同商品)
	 */
	@RequiresPermissions("system:productFullReduction:add")
	@Log(title = "产品满减(只针对同商品)", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProductFullReduction productFullReduction)
	{		
		return toAjax(productFullReductionService.insertProductFullReduction(productFullReduction));
	}

	/**
	 * 修改产品满减(只针对同商品)
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ProductFullReduction productFullReduction = productFullReductionService.selectProductFullReductionById(id);
		mmap.put("productFullReduction", productFullReduction);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存产品满减(只针对同商品)
	 */
	@RequiresPermissions("system:productFullReduction:edit")
	@Log(title = "产品满减(只针对同商品)", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProductFullReduction productFullReduction)
	{		
		return toAjax(productFullReductionService.updateProductFullReduction(productFullReduction));
	}
	
	/**
	 * 删除产品满减(只针对同商品)
	 */
	@RequiresPermissions("system:productFullReduction:remove")
	@Log(title = "产品满减(只针对同商品)", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productFullReductionService.deleteProductFullReductionByIds(ids));
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 20:30
	 * @Description
	 * 添加商品满减信息
	 */
	@RequiresPermissions("system:productFullReduction:insetFullReduction")
	@Log(title = "添加商品满减信息", businessType = BusinessType.DELETE)
	@PostMapping( "/insetFullReduction")
	@ResponseBody
	public  AjaxResult insetFullReduction(ProductFullReduction productFullReduction){
		return toAjax(productFullReductionService.insertProductFullReduction(productFullReduction));
	}
	
}
