package com.aaa.repast.admin.project.system.productAttribute.controller;

import java.util.List;
import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.productAttributeCategory.domain.ProductAttributeCategory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.productAttribute.domain.ProductAttribute;
import com.aaa.repast.admin.project.system.productAttribute.service.IProductAttributeService;

/**
 * 商品属性参数 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/system/productAttribute")
public class ProductAttributeController extends BaseController
{
    private String prefix = "system/productAttribute";
	
	@Autowired
	private IProductAttributeService productAttributeService;
	
	@RequiresPermissions("system:productAttribute:view")
	@GetMapping()
	public String productAttribute()
	{
	    return prefix + "/productAttribute";
	}
	
	/**
	 * 查询商品属性参数列表
	 */
	@RequiresPermissions("system:productAttribute:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductAttribute productAttribute)
	{
		startPage();
        List<ProductAttribute> list = productAttributeService.selectProductAttributeList(productAttribute);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品属性参数列表
	 */
	@RequiresPermissions("system:productAttribute:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductAttribute productAttribute)
    {
    	List<ProductAttribute> list = productAttributeService.selectProductAttributeList(productAttribute);
        ExcelUtil<ProductAttribute> util = new ExcelUtil<ProductAttribute>(ProductAttribute.class);
        return util.exportExcel(list, "productAttribute");
    }
	
	/**
	 * 新增商品属性参数
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品属性参数
	 */
	@RequiresPermissions("system:productAttribute:add")
	@Log(title = "商品属性参数", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProductAttribute productAttribute)
	{		
		return toAjax(productAttributeService.insertProductAttribute(productAttribute));
	}

	/**
	 * 修改商品属性参数
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ProductAttribute productAttribute = productAttributeService.selectProductAttributeById(id);
		mmap.put("productAttribute", productAttribute);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品属性参数
	 */
	@RequiresPermissions("system:productAttribute:edit")
	@Log(title = "商品属性参数", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProductAttribute productAttribute)
	{		
		return toAjax(productAttributeService.updateProductAttribute(productAttribute));
	}
	
	/**
	 * 删除商品属性参数
	 */
	@RequiresPermissions("system:productAttribute:remove")
	@Log(title = "商品属性参数", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productAttributeService.deleteProductAttributeByIds(ids));
	}


	@PostMapping("/selectName")
	@ResponseBody
	public List<ProductAttributeCategory> selectCategoryName(){
		List<ProductAttributeCategory> productAttributeCategories = productAttributeService.selectCategoryName();
		return productAttributeCategories;
	}

	@PostMapping("/updateCategory")
	@ResponseBody
	public int updateCategory(Long productAttributeCategoryId){
		int updateCategory = productAttributeService.updateCategory(productAttributeCategoryId);
		return updateCategory;
	}

	@PostMapping("/updateShuxing")
	@ResponseBody
	public int updateShuxing(Long productAttributeCategoryId){
		int updateShuxing = productAttributeService.updateCategory(productAttributeCategoryId);
		return updateShuxing;
	}
}
