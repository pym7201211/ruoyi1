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
import com.ruoyi.urgencyforts.domain.UrgencyTask;
import com.ruoyi.urgencyforts.service.IUrgencyTaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 紧急变更线程Controller
 * 
 * @author mengdehu
 * @date 2020-03-21
 */
@Controller
@RequestMapping("/urgencyforts/task")
public class UrgencyTaskController extends BaseController
{
    private String prefix = "urgencyforts/task";

    @Autowired
    private IUrgencyTaskService urgencyTaskService;

    @RequiresPermissions("urgencyforts:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询紧急变更线程列表
     */
    @RequiresPermissions("urgencyforts:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyTask urgencyTask)
    {
        startPage();
        List<UrgencyTask> list = urgencyTaskService.selectUrgencyTaskList(urgencyTask);
        return getDataTable(list);
    }

    /**
     * 导出紧急变更线程列表
     */
    @RequiresPermissions("urgencyforts:task:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyTask urgencyTask)
    {
        List<UrgencyTask> list = urgencyTaskService.selectUrgencyTaskList(urgencyTask);
        ExcelUtil<UrgencyTask> util = new ExcelUtil<UrgencyTask>(UrgencyTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 新增紧急变更线程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存紧急变更线程
     */
    @RequiresPermissions("urgencyforts:task:add")
    @Log(title = "紧急变更线程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyTask urgencyTask)
    {
        return toAjax(urgencyTaskService.insertUrgencyTask(urgencyTask));
    }

    /**
     * 修改紧急变更线程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyTask urgencyTask = urgencyTaskService.selectUrgencyTaskById(id);
        mmap.put("urgencyTask", urgencyTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存紧急变更线程
     */
    @RequiresPermissions("urgencyforts:task:edit")
    @Log(title = "紧急变更线程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyTask urgencyTask)
    {
        return toAjax(urgencyTaskService.updateUrgencyTask(urgencyTask));
    }

    /**
     * 删除紧急变更线程
     */
    @RequiresPermissions("urgencyforts:task:remove")
    @Log(title = "紧急变更线程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyTaskService.deleteUrgencyTaskByIds(ids));
    }
}
