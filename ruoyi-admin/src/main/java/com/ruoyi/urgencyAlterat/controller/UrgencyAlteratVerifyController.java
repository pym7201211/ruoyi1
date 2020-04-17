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
import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratVerify;
import com.ruoyi.urgencyAlterat.service.IUrgencyAlteratVerifyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 变更时点验证Controller
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/urgencyAlterat/verify")
public class UrgencyAlteratVerifyController extends BaseController
{
    private String prefix = "urgencyAlterat/verify";

    @Autowired
    private IUrgencyAlteratVerifyService urgencyAlteratVerifyService;

    @RequiresPermissions("urgencyAlterat:verify:view")
    @GetMapping()
    public String verify()
    {
        return prefix + "/verify";
    }

    /**
     * 查询变更时点验证列表
     */
    @RequiresPermissions("urgencyAlterat:verify:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        startPage();
        List<UrgencyAlteratVerify> list = urgencyAlteratVerifyService.selectUrgencyAlteratVerifyList(urgencyAlteratVerify);
        return getDataTable(list);
    }

    /**
     * 导出变更时点验证列表
     */
    @RequiresPermissions("urgencyAlterat:verify:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        List<UrgencyAlteratVerify> list = urgencyAlteratVerifyService.selectUrgencyAlteratVerifyList(urgencyAlteratVerify);
        ExcelUtil<UrgencyAlteratVerify> util = new ExcelUtil<UrgencyAlteratVerify>(UrgencyAlteratVerify.class);
        return util.exportExcel(list, "verify");
    }

    /**
     * 新增变更时点验证
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存变更时点验证
     */
    @RequiresPermissions("urgencyAlterat:verify:add")
    @Log(title = "变更时点验证", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        return toAjax(urgencyAlteratVerifyService.insertUrgencyAlteratVerify(urgencyAlteratVerify));
    }

    /**
     * 修改变更时点验证
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyAlteratVerify urgencyAlteratVerify = urgencyAlteratVerifyService.selectUrgencyAlteratVerifyById(id);
        mmap.put("urgencyAlteratVerify", urgencyAlteratVerify);
        return prefix + "/edit";
    }

    /**
     * 修改保存变更时点验证
     */
    @RequiresPermissions("urgencyAlterat:verify:edit")
    @Log(title = "变更时点验证", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        return toAjax(urgencyAlteratVerifyService.updateUrgencyAlteratVerify(urgencyAlteratVerify));
    }

    /**
     * 删除变更时点验证
     */
    @RequiresPermissions("urgencyAlterat:verify:remove")
    @Log(title = "变更时点验证", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyAlteratVerifyService.deleteUrgencyAlteratVerifyByIds(ids));
    }
}
