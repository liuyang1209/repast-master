package com.aaa.repast.admin.project.system.advertise.controller;

import java.util.List;

import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.advertise.domain.AdvertiseAndPositionVo;
import com.aaa.repast.admin.project.system.advertisePosition.domain.AdvertisePosition;
import com.aaa.repast.admin.project.system.advertisePosition.service.IAdvertisePositionService;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import com.aaa.repast.admin.project.system.shopInformation.service.IShopInformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.advertise.domain.Advertise;
import com.aaa.repast.admin.project.system.advertise.service.IAdvertiseService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 广告位 信息操作处理
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/advertise")
public class AdvertiseController extends BaseController {
    private String prefix = "system/advertise";

    @Autowired
    private IAdvertiseService advertiseService;

    @Autowired
    private IAdvertisePositionService advertisePositionService;

    @Autowired
    private IShopInformationService shopInformationService;

    @RequiresPermissions("system:advertise:view")
    @GetMapping()
    public String advertise() {
        return prefix + "/advertise";
    }

    /**
     * 查询广告位列表
     */
    @RequiresPermissions("system:advertise:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AdvertiseAndPositionVo advertiseAndPositionVo) {
        startPage();
        List<AdvertiseAndPositionVo> list = advertiseService.selectAdvertiseList(advertiseAndPositionVo);
        return getDataTable(list);
    }


    /**
     * 导出广告位列表
     */
    @RequiresPermissions("system:advertise:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AdvertiseAndPositionVo advertiseAndPositionVo) {
        List<AdvertiseAndPositionVo> list = advertiseService.selectAdvertiseList(advertiseAndPositionVo);
        ExcelUtil<AdvertiseAndPositionVo> util = new ExcelUtil<AdvertiseAndPositionVo>(AdvertiseAndPositionVo.class);
        return util.exportExcel(list, "advertise");
    }

    /**
     * 新增广告位
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存广告位
     */
    @RequiresPermissions("system:advertise:add")
    @Log(title = "广告位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MultipartFile file, Advertise advertise) {
        int i = advertiseService.insertAdvertise(file,advertise);
        return toAjax(i);
    }

    /**
     * 修改广告位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        AdvertiseAndPositionVo advertise = advertiseService.selectAdvertiseById(id);
        mmap.put("advertise", advertise);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告位
     */
    @RequiresPermissions("system:advertise:edit")
    @Log(title = "广告位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MultipartFile file,Advertise advertise) {
        int i = advertiseService.updateAdvertise(file, advertise);
        return toAjax(i);
    }

    /**
     * 删除广告位
     */
    @RequiresPermissions("system:advertise:remove")
    @Log(title = "广告位", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(advertiseService.deleteAdvertiseByIds(ids));
    }

/*	@RequiresPermissions("system:advertise:positionName")
	@PostMapping("/positionName")
	@ResponseBody
    public TableDataInfo selectAdvertiesPosition(){
		AdvertisePosition advertisePosition = new AdvertisePosition();
		return getDataTable(advertisePositionService.selectAdvertisePositionList(advertisePosition));
	}*/

    /**
     * 位置名称
     */
    @PostMapping("/position")
    @ResponseBody
    public TableDataInfo selectAdvertisePositionName() {
        List<AdvertisePosition> advertisePositions = advertisePositionService.selectAdvertisePositionName();
        return getDataTable(advertisePositions);
    }

    /**
     * 店铺名称
     */
    @PostMapping("/shop")
    @ResponseBody
    public TableDataInfo selectShopInformationName() {
        List<ShopInformation> shopInformations = shopInformationService.selectShopInformationName();
        return getDataTable(shopInformations);
    }
    /**
     *  修改上下线状态
     * @param id
     * @param status
     * @return
     */
    @RequiresPermissions("system:productCategory:status")
    @Log(title = "广告上下线状态", businessType = BusinessType.DELETE)
    @PostMapping("/status")
    @ResponseBody
    public AjaxResult showStatus(Long id,Integer status){
        int i = advertiseService.status(id, status);
        return toAjax(i);
    }

}
