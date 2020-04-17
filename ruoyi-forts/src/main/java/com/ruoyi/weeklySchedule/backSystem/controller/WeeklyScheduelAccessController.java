package com.ruoyi.weeklySchedule.backSystem.controller;

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
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyScheduelAccess;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyScheduelAccessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目需求权限Controller
 * 
 * @author mengdehu
 * @date 2020-03-12
 */
@Controller
@RequestMapping("/access/access")
public class WeeklyScheduelAccessController extends BaseController
{
    private String prefix = "access/access";

    @Autowired
    private IWeeklyScheduelAccessService weeklyScheduelAccessService;

    @RequiresPermissions("access:access:view")
    @GetMapping()
    public String access()
    {
        return prefix + "/access";
    }

    /**
     * 查询项目需求权限列表
     */
    @RequiresPermissions("access:access:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        startPage();
        List<WeeklyScheduelAccess> list = weeklyScheduelAccessService.selectWeeklyScheduelAccessList(weeklyScheduelAccess);
        return getDataTable(list);
    }

    /**
     * 导出项目需求权限列表
     */
    @RequiresPermissions("access:access:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        List<WeeklyScheduelAccess> list = weeklyScheduelAccessService.selectWeeklyScheduelAccessList(weeklyScheduelAccess);
        ExcelUtil<WeeklyScheduelAccess> util = new ExcelUtil<WeeklyScheduelAccess>(WeeklyScheduelAccess.class);
        return util.exportExcel(list, "access");
    }

    /**
     * 新增项目需求权限
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目需求权限
     */
    @RequiresPermissions("access:access:add")
    @Log(title = "项目需求权限", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        return toAjax(weeklyScheduelAccessService.insertWeeklyScheduelAccess(weeklyScheduelAccess));
    }

    /**
     * 修改项目需求权限
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WeeklyScheduelAccess weeklyScheduelAccess = weeklyScheduelAccessService.selectWeeklyScheduelAccessById(id);
        mmap.put("weeklyScheduelAccess", weeklyScheduelAccess);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目需求权限
     */
    @RequiresPermissions("access:access:edit")
    @Log(title = "项目需求权限", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        return toAjax(weeklyScheduelAccessService.updateWeeklyScheduelAccess(weeklyScheduelAccess));
    }

    /**
     * 删除项目需求权限
     */
    @RequiresPermissions("access:access:remove")
    @Log(title = "项目需求权限", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(weeklyScheduelAccessService.deleteWeeklyScheduelAccessByIds(ids));
    }
}
