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
import org.springframework.web.multipart.MultipartFile;

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

	//添加的代码
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 20:40
	 * @Description
	 * 新增保存产品分类
	 */
	@RequiresPermissions("system:productCategory:adds")
	@Log(title = "产品分类", businessType = BusinessType.INSERT)
	@PostMapping("/adds")
	@ResponseBody
	public AjaxResult addSaves(ProductCategory productCategory, MultipartFile file) {
		Boolean b = productCategoryService.addProductCategory(productCategory, file);
		if(b){
			return success();
		}
		return error();
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 14:46
	 * @Description
	 *  根据一级类目的id 查询二级类目的商品信息
	 */

	@RequiresPermissions("system:productCategory:selectTwo")
	@Log(title = "产品分类", businessType = BusinessType.INSERT)
	@PostMapping("/selectTwo")
	@ResponseBody
	public TableDataInfo selectTow(Long id) {
		List<ProductCategory> list = productCategoryService.selectTow(id);
		return getDataTable(list);
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 18:52
	 * @Description
	 *  修改二级类目信息
	 */
	@RequiresPermissions("system:productCategory:addTwo")
	@PostMapping("/addTwo")
	@ResponseBody
	public AjaxResult addTwo(ProductCategory productCategory, MultipartFile file) {
		Boolean b = productCategoryService.twoInfo(productCategory, file);
		if(b){
			return success();
		}
		return error();
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 18:52
	 * @Description
	 *  删除
	 */
	@RequiresPermissions("system:productCategory:delTwo")
	@PostMapping("/delTwo")
	@ResponseBody
	public AjaxResult delTwo(Long id) {
		Boolean b = productCategoryService.delTwoStatus(id);
		if(b){
			return success();
		}
		return error();
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/4 01:18
	 * @Description
	 * 添加二类目信息
	 */
	@RequiresPermissions("system:productCategory:twoProinfo")
	@PostMapping("/twoProinfo")
	@ResponseBody
	public AjaxResult twoProinfo(ProductCategory productCategory,MultipartFile file) {
		Boolean b = productCategoryService.twoProinfo(productCategory,file);
		if(b){
			return success();
		}
		return error();

	}
}
