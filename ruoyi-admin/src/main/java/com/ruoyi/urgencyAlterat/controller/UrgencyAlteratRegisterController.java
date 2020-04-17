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
import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratRegister;
import com.ruoyi.urgencyAlterat.service.IUrgencyAlteratRegisterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 紧急变更登记Controller
 *
 * @author mengdehu
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/urgencyAlterat/register")
public class UrgencyAlteratRegisterController extends BaseController
{
    private String prefix = "urgencyAlterat/register";

    @Autowired
    private IUrgencyAlteratRegisterService urgencyAlteratRegisterService;

    @RequiresPermissions("urgencyAlterat:register:view")
    @GetMapping()
    public String register()
    {
        return prefix + "/register";
    }

    /**
     * 查询紧急变更登记列表
     */
    @RequiresPermissions("urgencyAlterat:register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        startPage();
        List<UrgencyAlteratRegister> list = urgencyAlteratRegisterService.selectUrgencyAlteratRegisterList(urgencyAlteratRegister);
        return getDataTable(list);
    }

    /**
     * 导出紧急变更登记列表
     */
    @RequiresPermissions("urgencyAlterat:register:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        List<UrgencyAlteratRegister> list = urgencyAlteratRegisterService.selectUrgencyAlteratRegisterList(urgencyAlteratRegister);
        ExcelUtil<UrgencyAlteratRegister> util = new ExcelUtil<UrgencyAlteratRegister>(UrgencyAlteratRegister.class);
        return util.exportExcel(list, "register");
    }

    /**
     * 新增紧急变更登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存紧急变更登记
     */
    @RequiresPermissions("urgencyAlterat:register:add")
    @Log(title = "紧急变更登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        return toAjax(urgencyAlteratRegisterService.insertUrgencyAlteratRegister(urgencyAlteratRegister));
    }

    /**
     * 修改紧急变更登记
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrgencyAlteratRegister urgencyAlteratRegister = urgencyAlteratRegisterService.selectUrgencyAlteratRegisterById(id);
        mmap.put("urgencyAlteratRegister", urgencyAlteratRegister);
        return prefix + "/edit";
    }

    /**
     * 修改保存紧急变更登记
     */
    @RequiresPermissions("urgencyAlterat:register:edit")
    @Log(title = "紧急变更登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        return toAjax(urgencyAlteratRegisterService.updateUrgencyAlteratRegister(urgencyAlteratRegister));
    }

    /**
     * 删除紧急变更登记
     */
    @RequiresPermissions("urgencyAlterat:register:remove")
    @Log(title = "紧急变更登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urgencyAlteratRegisterService.deleteUrgencyAlteratRegisterByIds(ids));
    }
}
