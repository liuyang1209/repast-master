package com.aaa.repast.admin.project.system.brand.controller;

import java.util.List;
import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.brand.vo.BrandManagementVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.brand.domain.Brand;
import com.aaa.repast.admin.project.system.brand.service.IBrandService;

/**
 * 品牌 信息操作处理
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/brand")
public class BrandController extends BaseController
{
    private String prefix = "system/brand";
	
	@Autowired
	private IBrandService brandService;
	
	@RequiresPermissions("system:brand:view")
	@GetMapping()
	public String brand()
	{
	    return prefix + "/brand";
	}
	
	/**
	 * 查询品牌列表
	 * @RequiresPermissions：用来验证权限的注解
	 */
//	@RequiresPermissions("system:brand:list")
//	@PostMapping("/list")
//	@ResponseBody
//	public TableDataInfo list(Brand brand)
//	{
//		startPage();
//        List<Brand> list = brandService.selectBrandList(brand);
//		return getDataTable(list);
//	}
	
	
	/**
	 * 导出品牌列表
	 */
	@RequiresPermissions("system:brand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Brand brand)
    {
    	List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        return util.exportExcel(list, "brand");
    }
	
	/**
	 * 新增品牌
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存品牌
	 */
	@RequiresPermissions("system:brand:add")
	@Log(title = "品牌", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Brand brand)
	{		
		return toAjax(brandService.insertBrand(brand));
	}

	/**
	 * 修改品牌
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Brand brand = brandService.selectBrandById(id);
		mmap.put("brand", brand);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存品牌
	 */
	@RequiresPermissions("system:brand:edit")
	@Log(title = "品牌", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Brand brand)
	{		
		return toAjax(brandService.updateBrand(brand));
	}
	
	/**
	 * 删除品牌
	 */
	@RequiresPermissions("system:brand:remove")
	@Log(title = "品牌", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(brandService.deleteBrandByIds(ids));
	}


	/**
	  *liyong
	 */

	@RequiresPermissions("system:brand:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo selectBrandAll(BrandManagementVo brandManagementVo){

		startPage();
		List<BrandManagementVo> brandManagementVosList = brandService.selectBrandAll(brandManagementVo);
		return getDataTable(brandManagementVosList);

	}
	
}
