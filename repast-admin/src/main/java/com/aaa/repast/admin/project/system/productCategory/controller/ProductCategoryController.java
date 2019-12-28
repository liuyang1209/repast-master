package com.aaa.repast.admin.project.system.productCategory.controller;

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

import com.aaa.repast.admin.project.system.productCategory.domain.ProductCategory;
import com.aaa.repast.admin.project.system.productCategory.service.IProductCategoryService;

/**
 * 产品分类 信息操作处理
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/productCategory")
public class ProductCategoryController extends BaseController
{
    private String prefix = "system/productCategory";
	
	@Autowired
	private IProductCategoryService productCategoryService;
	
	@RequiresPermissions("system:productCategory:view")
	@GetMapping()
	public String productCategory()
	{
	    return prefix + "/productCategory";
	}
	
	/**
	 * 查询产品分类列表
	 */
	@RequiresPermissions("system:productCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductCategory productCategory)
	{
		startPage();
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出产品分类列表
	 */
	@RequiresPermissions("system:productCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductCategory productCategory)
    {
    	List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        ExcelUtil<ProductCategory> util = new ExcelUtil<ProductCategory>(ProductCategory.class);
        return util.exportExcel(list, "productCategory");
    }
	
	/**
	 * 新增产品分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存产品分类
	 */
	@RequiresPermissions("system:productCategory:add")
	@Log(title = "产品分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProductCategory productCategory)
	{		
		return toAjax(productCategoryService.insertProductCategory(productCategory));
	}

	/**
	 * 修改产品分类
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ProductCategory productCategory = productCategoryService.selectProductCategoryById(id);
		mmap.put("productCategory", productCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存产品分类
	 */
	@RequiresPermissions("system:productCategory:edit")
	@Log(title = "产品分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProductCategory productCategory)
	{		
		return toAjax(productCategoryService.updateProductCategory(productCategory));
	}
	
	/**
	 * 删除产品分类
	 */
	@RequiresPermissions("system:productCategory:remove")
	@Log(title = "产品分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productCategoryService.deleteProductCategoryByIds(ids));
	}
	
}
