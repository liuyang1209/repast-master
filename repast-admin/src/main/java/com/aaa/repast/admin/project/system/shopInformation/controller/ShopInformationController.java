package com.aaa.repast.admin.project.system.shopInformation.controller;

import java.util.List;

import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import com.aaa.repast.admin.project.system.shopInformation.service.IShopInformationService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 店铺的基本 信息操作处理
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/shopInformation")
public class ShopInformationController extends BaseController {
    private String prefix = "system/shopInformation";

    @Autowired
    private IShopInformationService shopInformationService;

    @RequiresPermissions("system:shopInformation:view")
    @GetMapping()
    public String shopInformation() {
        return prefix + "/shopInformation";
    }

    /**
     * 查询店铺的基本列表
     */
    @RequiresPermissions("system:shopInformation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShopInformation shopInformation) {
        startPage();
        List<ShopInformation> list = shopInformationService.selectShopInformationList(shopInformation);
        return getDataTable(list);
    }


    /**
     * 导出店铺的基本列表
     */
    @RequiresPermissions("system:shopInformation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopInformation shopInformation) {
        List<ShopInformation> list = shopInformationService.selectShopInformationList(shopInformation);
        ExcelUtil<ShopInformation> util = new ExcelUtil<ShopInformation>(ShopInformation.class);
        return util.exportExcel(list, "shopInformation");
    }

    /**
     * 新增店铺的基本
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存店铺的基本
     */
    @RequiresPermissions("system:shopInformation:add")
    @Log(title = "店铺的基本", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MultipartFile[] files, ShopInformation shopInformation) {
		int i = shopInformationService.insertShopInformation(files, shopInformation);
		return toAjax(i);
    }

    /**
     * 修改店铺的基本
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ShopInformation shopInformation = shopInformationService.selectShopInformationById(id);
        mmap.put("shopInformation", shopInformation);
        return prefix + "/edit";
    }

    /**
     * 修改保存店铺的基本
     */
    @RequiresPermissions("system:shopInformation:edit")
    @Log(title = "店铺的基本", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MultipartFile[] files, ShopInformation shopInformation) {
        return toAjax(shopInformationService.updateShopInformation(files, shopInformation));
    }

    /**
     * 删除店铺的基本
     */
    @RequiresPermissions("system:shopInformation:remove")
    @Log(title = "店铺的基本", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shopInformationService.deleteShopInformationByIds(ids));
    }

    @PostMapping("/closed")
    @ResponseBody
    public AjaxResult closed(Long id , Integer closed) {
        return toAjax(shopInformationService.updateClosed(id,closed));
    }
}
