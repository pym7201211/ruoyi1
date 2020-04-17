package com.ruoyi.outRegistration.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.outRegistration.domain.OutRegistration;
import com.ruoyi.outRegistration.service.OutRegistrationService;
import com.ruoyi.urgencyforts.until.UrgencyUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 外包人员外出请假登记Controller
 *
 * @author ruoyi
 * @date 2020-04-03
 */
@Api("外包人员外出登记")
@Controller
@RequestMapping("/RegistrationController")
public class RegistrationController extends BaseController
{
    protected final static Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private OutRegistrationService outRegistrationService;

    /**
     * 查询外包人员外出请假登记列表
     */
    @ApiOperation("查询外包人员外出请假登记列表")
    @PostMapping("/list")
    @ResponseBody
    public ModelMap list(@RequestBody String json) {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String operatorId = "";
        List<OutRegistration> list = new ArrayList<>();
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            if (null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                pageNum = note.getString("pageNum");
                pageSize = note.getString("pageSize");
                operatorId = note.getString("operatorId");
                if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                    String orderBy = SqlUtil.escapeOrderBySql("");
                    PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                    List<OutRegistration> hashMaps = outRegistrationService.selectOutRegistrationList(operatorId);
                    if (null != hashMaps){
                        for (OutRegistration map:hashMaps) {
                            list.add(map);
                        }
                    }
                    code = "0";
                    msg = "查询成功";
                    model.put("hashMaps", list);
                } else {
                    msg = "分页条数或页数未传";
                }
            }
        }catch(Exception e){
            log.error("外出查询接口异常：", e);
        }
        model.put("code", code);
        model.put("msg", msg);
        log.info("model : " + model);
        return model;
    }

    /**
     * 导出外包人员外出请假登记列表
     */
    @ApiOperation("导出外包人员外出请假登记列表")
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
     * 新增保存外包人员外出请假登记
     */
    @ApiOperation("新增保存外包人员外出请假登记")
    @PostMapping("/add")
    @ResponseBody
    public ModelMap addSave(@RequestBody String json) {
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = outRegistrationService.insertOutRegistration(json);
            modelMap = UrgencyUntil.resultModelMap(jsonObject);
        } catch (Exception e) {
            log.error("外出登记接口：",e);
        }
        log.info("insertUrgencyAlteratRegister : "+modelMap);
        return modelMap;
    }

    /**
     * 修改保存外包人员外出请假登记
     */
    @ApiOperation("修改保存外包人员外出请假登记")
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
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(outRegistrationService.deleteOutRegistrationByIds(ids));
    }
}
