package com.ruoyi.equipment.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.cloudDesktop.controller.VdCloudAccountController;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.equipment.domain.DepFeedback;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import com.ruoyi.wsdl.esbSendMessage.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.equipment.domain.DepNumberCategory;
import com.ruoyi.equipment.service.IDepNumberCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备数量Controller
 * 
 * @author ruoyi
 * @date 2020-06-01
 */


@Api("设备数据")
@RestController
@RequestMapping("/DepNumberCategoryController")
public class DepNumberCategoryController extends BaseController
{

    @Autowired
    private IDepNumberCategoryService depNumberCategoryService;
    protected final static Logger log = LoggerFactory.getLogger(DepNumberCategoryController.class);


    /**
     * 查询设备数量列表
     */
    @ApiOperation("设备数据查询")
    @PostMapping("/Category")
    @ResponseBody
    public ModelMap list(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String user_id = "";
        String id = "";
        List<DepNumberCategory> list = new ArrayList<>();
        try{
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        user_id = note.getString("user_id");
        id = note.getString("id");
        pageNum = note.getString("pageNum");
        pageSize = note.getString("pageSize");
        if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql("");
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
            DepNumberCategory depNumberCategory = new DepNumberCategory();
            if(!user_id.equals("")){
                Map<String, Object> depMap = depNumberCategoryService.selectUserDep(user_id);
                if(!depMap.get("ORG_CODE").toString().equals("1000100")){
                    depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
                }
            }else{
                depNumberCategory.setId(id);
            }
            List<DepNumberCategory> epNumberCategoryds = depNumberCategoryService.selectDepNumberCategoryList(depNumberCategory);
            if (null != epNumberCategoryds){
                for (DepNumberCategory map:epNumberCategoryds) {
                    list.add(map);
                }
            }
            code = "0";
            msg = "查询成功";
            model.put("hashMaps", list);
        }else {
            msg = "分页条数或页数未传";
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
     * 查询设备数量列表
     */
    @ApiOperation("设备数据查询")
    @PostMapping("/CategoryHis")
    @ResponseBody
    public ModelMap listHis(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String id = "";
        List<DepNumberCategory> list = new ArrayList<>();
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
            id = note.getString("id");
            pageNum = note.getString("pageNum");
            pageSize = note.getString("pageSize");
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                String orderBy = SqlUtil.escapeOrderBySql("");
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                List<DepNumberCategory> depNumberCategorys = depNumberCategoryService.selectDepNumberCategoryListHis(id);
                if (null != depNumberCategorys){
                    for (DepNumberCategory map:depNumberCategorys) {
                        list.add(map);
                    }
                }
                code = "0";
                msg = "查询成功";
                model.put("hashMaps", list);
            }else {
                msg = "分页条数或页数未传";
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
     * 新增保存设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.INSERT)
    @PostMapping("/Add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String userId = note.getString("user_id");
        String identity = note.getString("identity");
        String inUse = note.getString("inUse");
        String newBrand = note.getString("newBrand");
        String oldBrand = note.getString("oldBrand");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        //获取下一个id
        Map<String, Object> mapId = new HashMap<>();
        mapId = depNumberCategoryService.selectNextId(format);
        if(!mapId.get("ID").toString().equals(" ")){
            depNumberCategory.setId(mapId.get("ID").toString());
        }else{
            depNumberCategory.setId(format+"0001");
        }
        depNumberCategory.setUserId(userId);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setInUse(inUse);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setStatus("新增");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        AjaxResult ajaxResult = toAjax(depNumberCategoryService.insertDepNumberCategory(depNumberCategory));
        /*if(!"0".equals(ajaxResult.get("code"))){
            return ajaxResult;
        }else{
            ajaxResult.put("msg","数据添加失败");
            return ajaxResult;
        }*/
        return ajaxResult;
    }

    @PostMapping("/CategoryList")
    @ResponseBody
    public TableDataInfo selectCategory(DepNumberCategory depNumberCategory)
    {
        startPage();
        return getDataTable(depNumberCategoryService.selectCategory());
    }

    /**
     * 修改保存设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.UPDATE)
    @PostMapping("/Edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String identity = note.getString("identity");
        String id = note.getString("id");
        String inUse = note.getString("inUse");
        String user_id = note.getString("user_id");
        String newBrand = note.getString("newBrand");
        String oldBrand = note.getString("oldBrand");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        depNumberCategory.setId(id);
        depNumberCategory.setInUse(inUse);
        depNumberCategory.setUserId(user_id);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setStatus("修改");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        return toAjax(depNumberCategoryService.updateDepNumberCategory(depNumberCategory));
    }

    /**
     * 删除设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.DELETE)
    @PostMapping( "/Remove")
    @ResponseBody
    public AjaxResult remove(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String identity = note.getString("identity");
        String id = note.getString("id");
        String inUse = note.getString("inUse");
        String user_id = note.getString("userId");
        String newBrand = note.getString("newBrand");
        String oldBrand = note.getString("oldBrand");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        depNumberCategory.setId(id);
        depNumberCategory.setInUse(inUse);
        depNumberCategory.setUserId(user_id);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setStatus("删除");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        return toAjax(depNumberCategoryService.deleteDepNumberCategoryByIds(depNumberCategory,id));
    }

    /**
     * 查询人员是否分行
     */
    @PostMapping( "/IsBranch")
    @ResponseBody
    public ModelMap isBranch(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String user_id = note.getString("user_id");
        Map<String, Object> userMap = new HashMap<>();
        userMap = depNumberCategoryService.selectUserSpecial(user_id);
        ModelMap model = new ModelMap();
        if(!userMap.get("USER_LEVEL").toString().equals(" ")){
            model.put("code", "2");
            model.put("msg", "总行拥有特殊权限的人员");
            return model;
        }
        Map<String, Object> map = depNumberCategoryService.selectUserDep(user_id);
        if("1000100".equals(map.get("ORG_CODE"))){
            model.put("code", "0");
            model.put("msg", "总行人员");
        }else{
            model.put("code", "1");
            model.put("msg", "分行人员");
        }
        return model;
    }

    /**
     * 填写意见
     */
    @PostMapping("/Opinion")
    @ResponseBody
    public AjaxResult fillInComments(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String user_id = note.getString("user_id");
        String opinion = note.getString("opinion");
        String seqNo = EsbSendMessage.getSeqNo();
        Map<String, Object> map = depNumberCategoryService.selectUserDep(user_id);
        String two_dept_org = map.get("TWO_DEPT_ORG").toString();
        DepFeedback depFeedback = new DepFeedback();
        depFeedback.setUserId(user_id);
        depFeedback.setOpinion(opinion);
        depFeedback.setTwoDep(two_dept_org);
        depFeedback.setSeqNo(seqNo);
        int i = depNumberCategoryService.insertDepFeedback(depFeedback);
        return toAjax(i);
    }

    /**
     * 填写反馈
     */
    @PostMapping("/feedback")
    @ResponseBody
    public AjaxResult fillInFeedback(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String user_id = note.getString("user_id");
        String personId = note.getString("personId");
        String seqNo = note.getString("seqNo");
        String feedback = note.getString("feedback");
        DepFeedback depFeedback = new DepFeedback();
        depFeedback.setPersonId(personId);
        depFeedback.setUserId(user_id);
        depFeedback.setFeedback(feedback);
        depFeedback.setSeqNo(seqNo);
        //System.out.println("AAAAAAAAAAA:"+depFeedback.toString());
        int i = depNumberCategoryService.updateDepFeedback(depFeedback);
        return toAjax(i);
    }
    /**
     * 查询意见反馈历史
     */
    @ApiOperation("意见反馈")
    @PostMapping("/SelectFeedback")
    @ResponseBody
    public ModelMap selectFeedback(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String user_id = "";
        String seqNo = "";
        List<DepFeedback> list = new ArrayList<>();
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
            user_id = note.getString("user_id");
            pageNum = note.getString("pageNum");
            pageSize = note.getString("pageSize");
            seqNo = note.getString("seqNo");
            Map<String, Object> depMap = depNumberCategoryService.selectUserDep(user_id);
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                String orderBy = SqlUtil.escapeOrderBySql("");
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                List<DepFeedback> depFeedbacks = new ArrayList<>();
                if(!depMap.get("ORG_CODE").toString().equals("1000100")){
                    String twoDep = depMap.get("TWO_DEPT_ORG").toString();
                    depFeedbacks = depNumberCategoryService.selectFeedback(twoDep,seqNo);
                }else{
                    depFeedbacks = depNumberCategoryService.selectFeedback("",seqNo);
                }
                if (null != depFeedbacks){
                    for (DepFeedback map:depFeedbacks) {
                        list.add(map);
                    }
                }
                code = "0";
                msg = "查询成功";
                model.put("hashMaps", list);
            }else {
                msg = "分页条数或页数未传";
            }
        }catch(Exception e){
            log.error("外出查询接口异常：", e);
        }
        model.put("code", code);
        model.put("msg", msg);
        log.info("model : " + model);
        return model;
    }


}
