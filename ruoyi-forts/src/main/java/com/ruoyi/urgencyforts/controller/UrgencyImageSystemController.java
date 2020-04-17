package com.ruoyi.urgencyforts.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.urgencyforts.domain.UrgencyImageSystem;
import com.ruoyi.urgencyforts.service.IUrgencyImageSystemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 调用影像系统Controller
 * 
 * @author mengdehu
 * @date 2020-02-26
 */
@Controller
@RequestMapping("/urgencyforts/imgSystem")
public class UrgencyImageSystemController extends BaseController
{
    private String prefix = "urgencyforts/imgSystem";

    @Autowired
    private IUrgencyImageSystemService urgencyImageSystemService;

    @RequiresPermissions("urgencyforts:imgSystem:view")
    @GetMapping()
    public String imgSystem()
    {
        return prefix + "/imgSystem";
    }

    /**
     * 查询调用影像系统列表
     */
    @RequiresPermissions("urgencyforts:imgSystem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyImageSystem urgencyImageSystem)
    {
        startPage();
        List<UrgencyImageSystem> list = urgencyImageSystemService.selectUrgencyImageSystemList(urgencyImageSystem);
        return getDataTable(list);
    }

    /**
     * 导出调用影像系统列表
     */
    @RequiresPermissions("urgencyforts:imgSystem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyImageSystem urgencyImageSystem)
    {
        List<UrgencyImageSystem> list = urgencyImageSystemService.selectUrgencyImageSystemList(urgencyImageSystem);
        ExcelUtil<UrgencyImageSystem> util = new ExcelUtil<UrgencyImageSystem>(UrgencyImageSystem.class);
        return util.exportExcel(list, "imgSystem");
    }

    /**
     * 新增调用影像系统
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存调用影像系统
     */
    @RequiresPermissions("urgencyforts:imgSystem:add")
    @Log(title = "调用影像系统", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyImageSystem urgencyImageSystem)
    {
        return toAjax(urgencyImageSystemService.insertUrgencyImageSystem(urgencyImageSystem));
    }

    /**
     * 修改调用影像系统
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyImageSystem urgencyImageSystem = urgencyImageSystemService.selectUrgencyImageSystemById(id);
        mmap.put("urgencyImageSystem", urgencyImageSystem);
        return prefix + "/edit";
    }

    /**
     * 修改保存调用影像系统
     */
    @RequiresPermissions("urgencyforts:imgSystem:edit")
    @Log(title = "调用影像系统", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyImageSystem urgencyImageSystem)
    {
        return toAjax(urgencyImageSystemService.updateUrgencyImageSystem(urgencyImageSystem));
    }

    /**
     * 删除调用影像系统
     */
    @RequiresPermissions("urgencyforts:imgSystem:remove")
    @Log(title = "调用影像系统", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyImageSystemService.deleteUrgencyImageSystemByIds(ids));
    }
}
