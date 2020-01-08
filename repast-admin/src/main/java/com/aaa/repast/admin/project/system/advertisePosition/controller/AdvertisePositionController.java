package com.aaa.repast.admin.project.system.advertisePosition.controller;

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

import com.aaa.repast.admin.project.system.advertisePosition.domain.AdvertisePosition;
import com.aaa.repast.admin.project.system.advertisePosition.service.IAdvertisePositionService;

/**
 * 广告位位置 信息操作处理
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/advertisePosition")
public class AdvertisePositionController extends BaseController
{
    private String prefix = "system/advertisePosition";
	
	@Autowired
	private IAdvertisePositionService advertisePositionService;
	
	@RequiresPermissions("system:advertisePosition:view")
	@GetMapping()
	public String advertisePosition()
	{
	    return prefix + "/advertisePosition";
	}
	
	/**
	 * 查询广告位位置列表
	 */
	@RequiresPermissions("system:advertisePosition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AdvertisePosition advertisePosition)
	{
		startPage();
        List<AdvertisePosition> list = advertisePositionService.selectAdvertisePositionList(advertisePosition);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出广告位位置列表
	 */
	@RequiresPermissions("system:advertisePosition:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AdvertisePosition advertisePosition)
    {
    	List<AdvertisePosition> list = advertisePositionService.selectAdvertisePositionList(advertisePosition);
        ExcelUtil<AdvertisePosition> util = new ExcelUtil<AdvertisePosition>(AdvertisePosition.class);
        return util.exportExcel(list, "advertisePosition");
    }
	
	/**
	 * 新增广告位位置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告位位置
	 */
	@RequiresPermissions("system:advertisePosition:add")
	@Log(title = "广告位位置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AdvertisePosition advertisePosition)
	{		
		return toAjax(advertisePositionService.insertAdvertisePosition(advertisePosition));
	}

	/**
	 * 修改广告位位置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AdvertisePosition advertisePosition = advertisePositionService.selectAdvertisePositionById(id);
		mmap.put("advertisePosition", advertisePosition);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告位位置
	 */
	@RequiresPermissions("system:advertisePosition:edit")
	@Log(title = "广告位位置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AdvertisePosition advertisePosition)
	{		
		return toAjax(advertisePositionService.updateAdvertisePosition(advertisePosition));
	}
	
	/**
	 * 删除广告位位置
	 */
	@RequiresPermissions("system:advertisePosition:remove")
	@Log(title = "广告位位置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(advertisePositionService.deleteAdvertisePositionByIds(ids));
	}
	
}
