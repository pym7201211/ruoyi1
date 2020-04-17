package com.ruoyi.outRegistration.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.outRegistration.domain.OutRegistration;
import com.ruoyi.outRegistration.service.OutRegistrationService;
import com.ruoyi.urgencyforts.controller.UrgencyController;
import com.ruoyi.urgencyforts.until.UrgencyUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 外包人员外出请假登记Controller
 * 
 * @author ruoyi
 * @date 2020-04-03
 */
@Api("外包人员外出登记")
@Controller
@RequestMapping("/system/registration")
public class OutRegistrationController extends BaseController
{
    private String prefix = "system/registration";

    protected final static Logger log = LoggerFactory.getLogger(OutRegistrationController.class);

    @Autowired
    private OutRegistrationService outRegistrationService;

    @RequiresPermissions("system:registration:view")
    @GetMapping()
    public String registration()
    {
        return prefix + "/registration";
    }

    /**
     * 查询外包人员外出请假登记列表
     */
    @ApiOperation("查询外包人员外出请假登记列表")
    @RequiresPermissions("system:registration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OutRegistration outRegistration)
    {
        startPage();
        List<OutRegistration> list = outRegistrationService.selectRegistrationList(outRegistration);
        return getDataTable(list);
    }

    /**
     * 导出外包人员外出请假登记列表
     */
    @ApiOperation("导出外包人员外出请假登记列表")
    @RequiresPermissions("system:registration:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OutRegistration outRegistration)
    {
        List<OutRegistration> list = outRegistrationService.selectRegistrationList(outRegistration);
        ExcelUtil<OutRegistration> util = new ExcelUtil<OutRegistration>(OutRegistration.class);
        return util.exportExcel(list, "registration");
    }

    /**
     * 查询出发地
     */
    @ApiOperation("查询出发地")
    @Log(title = "查询出发地", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:registration:depa")
    @PostMapping("/depa")
    @ResponseBody
    public ModelMap selectOfDeparture() throws Exception {
        ModelMap modelMap = null;
        try {
            JSONObject ofDeparture = outRegistrationService.getOfDeparture();
            modelMap = UrgencyUntil.resultModelMap(ofDeparture);
            if ("0".equals(modelMap.get("code"))){
                List list = (List) ofDeparture.get("list");
                modelMap.put("list",list);
            }
        } catch (Exception e) {
            log.error("查询出发地接口异常：",e);
        }
        log.info("ofDeparture：" + modelMap);
        return modelMap;
    }

    /**
     * 查询目的地
     */
    @ApiOperation("查询目的地")
    @Log(title = "查询目的地", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:registration:dest")
    @PostMapping("/dest")
    @ResponseBody
    public ModelMap selectDestination() throws Exception {
        ModelMap modelMap = null;
        try {
            JSONObject destination = outRegistrationService.getDestination();
            modelMap = UrgencyUntil.resultModelMap(destination);
            if ("0".equals(modelMap.get("code"))){
                List list = (List) destination.get("list");
                modelMap.put("list",list);
            }
        } catch (Exception e) {
            log.error("查询目的地接口异常：",e);
        }
        log.info("destination：" + modelMap);
        return modelMap;
    }

    /**
     * 查询外出事由
     */
    @ApiOperation("查询外出事由")
    @Log(title = "查询事由", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:registration:cause")
    @PostMapping("/cause")
    @ResponseBody
    public ModelMap selectCause() throws Exception {
        ModelMap modelMap = null;
        try {
            JSONObject destination = outRegistrationService.getCause();
            modelMap = UrgencyUntil.resultModelMap(destination);
            if ("0".equals(modelMap.get("code"))){
                List list = (List) destination.get("list");
                modelMap.put("list",list);
            }
        } catch (Exception e) {
            log.error("查询外出事由接口异常：",e);
        }
        log.info("destination：" + modelMap);
        return modelMap;
    }

    /**
     * 新增外包人员外出请假登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存外包人员外出请假登记
     */
    @ApiOperation("新增保存外包人员外出请假登记")
    @RequiresPermissions("system:registration:add")
    @Log(title = "外包人员外出请假登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OutRegistration outRegistration) {
        return toAjax(outRegistrationService.insertRegistration(outRegistration));
    }

    /**
     * 修改外包人员外出请假登记
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OutRegistration outRegistration = outRegistrationService.selectOutRegistrationById(id);
        mmap.put("outRegistration", outRegistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存外包人员外出请假登记
     */
    @ApiOperation("修改保存外包人员外出请假登记")
    @RequiresPermissions("system:registration:edit")
    @Log(title = "外包人员外出请假登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OutRegistration outRegistration)
    {
        return toAjax(outRegistrationService.updateOutRegistration(outRegistration));
    }

    /**
     * 删除外包人员外出请假登记
     */
    @ApiOperation("删除外包人员外出请假登记")
    @RequiresPermissions("system:registration:remove")
    @Log(title = "外包人员外出请假登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(outRegistrationService.deleteOutRegistrationByIds(ids));
    }
}
