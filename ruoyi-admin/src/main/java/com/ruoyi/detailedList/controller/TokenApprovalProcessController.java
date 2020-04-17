package com.ruoyi.detailedList.controller;

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
import com.ruoyi.detailedList.domain.TokenApprovalProcess;
import com.ruoyi.detailedList.service.ITokenApprovalProcessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批流程Controller
 * 
 * @author mengdehu
 * @date 2019-12-22
 */
@Controller
@RequestMapping("/detailedList/process")
public class TokenApprovalProcessController extends BaseController
{
    private String prefix = "detailedList/process";

    @Autowired
    private ITokenApprovalProcessService tokenApprovalProcessService;

    @RequiresPermissions("detailedList:process:view")
    @GetMapping()
    public String process()
    {
        return prefix + "/process";
    }

    /**
     * 查询审批流程列表
     */
    @RequiresPermissions("detailedList:process:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenApprovalProcess tokenApprovalProcess)
    {
        startPage();
        List<TokenApprovalProcess> list = tokenApprovalProcessService.selectTokenApprovalProcessList(tokenApprovalProcess);
        return getDataTable(list);
    }

    /**
     * 导出审批流程列表
     */
    @RequiresPermissions("detailedList:process:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenApprovalProcess tokenApprovalProcess)
    {
        List<TokenApprovalProcess> list = tokenApprovalProcessService.selectTokenApprovalProcessList(tokenApprovalProcess);
        ExcelUtil<TokenApprovalProcess> util = new ExcelUtil<TokenApprovalProcess>(TokenApprovalProcess.class);
        return util.exportExcel(list, "process");
    }

    /**
     * 新增审批流程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存审批流程
     */
    @RequiresPermissions("detailedList:process:add")
    @Log(title = "审批流程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenApprovalProcess tokenApprovalProcess)
    {
        return toAjax(tokenApprovalProcessService.insertTokenApprovalProcess(tokenApprovalProcess));
    }

    /**
     * 修改审批流程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TokenApprovalProcess tokenApprovalProcess = tokenApprovalProcessService.selectTokenApprovalProcessById(id);
        mmap.put("tokenApprovalProcess", tokenApprovalProcess);
        return prefix + "/edit";
    }

    /**
     * 修改保存审批流程
     */
    @RequiresPermissions("detailedList:process:edit")
    @Log(title = "审批流程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenApprovalProcess tokenApprovalProcess)
    {
        return toAjax(tokenApprovalProcessService.updateTokenApprovalProcess(tokenApprovalProcess));
    }

    /**
     * 删除审批流程
     */
    @RequiresPermissions("detailedList:process:remove")
    @Log(title = "审批流程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenApprovalProcessService.deleteTokenApprovalProcessByIds(ids));
    }
}
