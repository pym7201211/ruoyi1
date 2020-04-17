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
import com.ruoyi.urgencyAlterat.domain.UrgencyChargeLeader;
import com.ruoyi.urgencyAlterat.service.IUrgencyChargeLeaderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主管变更领导Controller
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/urgencyAlterat/leader")
public class UrgencyChargeLeaderController extends BaseController
{
    private String prefix = "urgencyAlterat/leader";

    @Autowired
    private IUrgencyChargeLeaderService urgencyChargeLeaderService;

    @RequiresPermissions("urgencyAlterat:leader:view")
    @GetMapping()
    public String leader()
    {
        return prefix + "/leader";
    }

    /**
     * 查询主管变更领导列表
     */
    @RequiresPermissions("urgencyAlterat:leader:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyChargeLeader urgencyChargeLeader)
    {
        startPage();
        List<UrgencyChargeLeader> list = urgencyChargeLeaderService.selectUrgencyChargeLeaderList(urgencyChargeLeader);
        return getDataTable(list);
    }

    /**
     * 导出主管变更领导列表
     */
    @RequiresPermissions("urgencyAlterat:leader:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyChargeLeader urgencyChargeLeader)
    {
        List<UrgencyChargeLeader> list = urgencyChargeLeaderService.selectUrgencyChargeLeaderList(urgencyChargeLeader);
        ExcelUtil<UrgencyChargeLeader> util = new ExcelUtil<UrgencyChargeLeader>(UrgencyChargeLeader.class);
        return util.exportExcel(list, "leader");
    }

    /**
     * 新增主管变更领导
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存主管变更领导
     */
    @RequiresPermissions("urgencyAlterat:leader:add")
    @Log(title = "主管变更领导", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyChargeLeader urgencyChargeLeader)
    {
        return toAjax(urgencyChargeLeaderService.insertUrgencyChargeLeader(urgencyChargeLeader));
    }

    /**
     * 修改主管变更领导
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyChargeLeader urgencyChargeLeader = urgencyChargeLeaderService.selectUrgencyChargeLeaderById(id);
        mmap.put("urgencyChargeLeader", urgencyChargeLeader);
        return prefix + "/edit";
    }

    /**
     * 修改保存主管变更领导
     */
    @RequiresPermissions("urgencyAlterat:leader:edit")
    @Log(title = "主管变更领导", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyChargeLeader urgencyChargeLeader)
    {
        return toAjax(urgencyChargeLeaderService.updateUrgencyChargeLeader(urgencyChargeLeader));
    }

    /**
     * 删除主管变更领导
     */
    @RequiresPermissions("urgencyAlterat:leader:remove")
    @Log(title = "主管变更领导", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyChargeLeaderService.deleteUrgencyChargeLeaderByIds(ids));
    }
}
