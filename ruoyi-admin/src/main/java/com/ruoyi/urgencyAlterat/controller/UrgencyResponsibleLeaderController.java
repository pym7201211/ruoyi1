package com.ruoyi.urgencyAlterat.controller;

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
import com.ruoyi.urgencyAlterat.domain.UrgencyResponsibleLeader;
import com.ruoyi.urgencyAlterat.service.IUrgencyResponsibleLeaderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分管领导Controller
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/urgencyAlterat/fleader")
public class UrgencyResponsibleLeaderController extends BaseController
{
    private String prefix = "urgencyAlterat/fleader";

    @Autowired
    private IUrgencyResponsibleLeaderService urgencyResponsibleLeaderService;

    @RequiresPermissions("urgencyAlterat:fleader:view")
    @GetMapping()
    public String fleader()
    {
        return prefix + "/fleader";
    }

    /**
     * 查询分管领导列表
     */
    @RequiresPermissions("urgencyAlterat:fleader:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        startPage();
        List<UrgencyResponsibleLeader> list = urgencyResponsibleLeaderService.selectUrgencyResponsibleLeaderList(urgencyResponsibleLeader);
        return getDataTable(list);
    }

    /**
     * 导出分管领导列表
     */
    @RequiresPermissions("urgencyAlterat:fleader:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        List<UrgencyResponsibleLeader> list = urgencyResponsibleLeaderService.selectUrgencyResponsibleLeaderList(urgencyResponsibleLeader);
        ExcelUtil<UrgencyResponsibleLeader> util = new ExcelUtil<UrgencyResponsibleLeader>(UrgencyResponsibleLeader.class);
        return util.exportExcel(list, "fleader");
    }

    /**
     * 新增分管领导
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分管领导
     */
    @RequiresPermissions("urgencyAlterat:fleader:add")
    @Log(title = "分管领导", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        return toAjax(urgencyResponsibleLeaderService.insertUrgencyResponsibleLeader(urgencyResponsibleLeader));
    }

    /**
     * 修改分管领导
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyResponsibleLeader urgencyResponsibleLeader = urgencyResponsibleLeaderService.selectUrgencyResponsibleLeaderById(id);
        mmap.put("urgencyResponsibleLeader", urgencyResponsibleLeader);
        return prefix + "/edit";
    }

    /**
     * 修改保存分管领导
     */
    @RequiresPermissions("urgencyAlterat:fleader:edit")
    @Log(title = "分管领导", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        return toAjax(urgencyResponsibleLeaderService.updateUrgencyResponsibleLeader(urgencyResponsibleLeader));
    }

    /**
     * 删除分管领导
     */
    @RequiresPermissions("urgencyAlterat:fleader:remove")
    @Log(title = "分管领导", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyResponsibleLeaderService.deleteUrgencyResponsibleLeaderByIds(ids));
    }
}
