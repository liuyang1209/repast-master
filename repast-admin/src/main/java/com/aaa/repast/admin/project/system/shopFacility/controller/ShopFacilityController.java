package com.aaa.repast.admin.project.system.shopFacility.controller;

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

import com.aaa.repast.admin.project.system.shopFacility.domain.ShopFacility;
import com.aaa.repast.admin.project.system.shopFacility.service.IShopFacilityService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-06
 */
@Controller
@RequestMapping("/system/shopFacility")
public class ShopFacilityController extends BaseController
{
    private String prefix = "system/shopFacility";
	
	@Autowired
	private IShopFacilityService shopFacilityService;
	
	@RequiresPermissions("system:shopFacility:view")
	@GetMapping()
	public String shopFacility()
	{
	    return prefix + "/shopFacility";
	}
	
	/**
	 * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等列表
	 */
	@RequiresPermissions("system:shopFacility:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopFacility shopFacility)
	{
		startPage();
        List<ShopFacility> list = shopFacilityService.selectShopFacilityList(shopFacility);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等列表
	 */
	@RequiresPermissions("system:shopFacility:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopFacility shopFacility)
    {
    	List<ShopFacility> list = shopFacilityService.selectShopFacilityList(shopFacility);
        ExcelUtil<ShopFacility> util = new ExcelUtil<ShopFacility>(ShopFacility.class);
        return util.exportExcel(list, "shopFacility");
    }
	
	/**
	 * 新增店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
	 */
	@RequiresPermissions("system:shopFacility:add")
	@Log(title = "店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopFacility shopFacility)
	{
		return toAjax(shopFacilityService.insertShopFacility(shopFacility));
	}

	/**
	 * 修改店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ShopFacility shopFacility = shopFacilityService.selectShopFacilityById(id);
		mmap.put("shopFacility", shopFacility);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
	 */
	@RequiresPermissions("system:shopFacility:edit")
	@Log(title = "店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopFacility shopFacility)
	{		
		return toAjax(shopFacilityService.updateShopFacility(shopFacility));
	}
	
	/**
	 * 删除店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
	 */
	@RequiresPermissions("system:shopFacility:remove")
	@Log(title = "店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopFacilityService.deleteShopFacilityByIds(ids));
	}

	@RequiresPermissions("system:productCategory:adds")
	@Log(title = "产品分类", businessType = BusinessType.INSERT)
	@PostMapping("/adds")
	@ResponseBody
	public AjaxResult addSaves(ShopFacility shopFacility, MultipartFile file) {
		Boolean b = shopFacilityService.addProductCategory(shopFacility, file);
		if(b){
			return success();
		}
		return error();
	}
	
}
