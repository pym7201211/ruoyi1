package com.ruoyi.cloudDesktop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.cloudDesktop.domain.UserDemo;
import com.ruoyi.cloudDesktop.domain.VdAccountData;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.outRegistration.controller.RegistrationController;
import com.ruoyi.outRegistration.domain.OutRegistration;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import com.ruoyi.cloudDesktop.service.IVdCloudAccountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 云桌面账号Controller
 * 
 * @author ruoyi
 * @date 2020-06-03
 */
@Controller
@RequestMapping("/CloudDesktop")
public class VdCloudAccountController extends BaseController
{

    @Autowired
    private IVdCloudAccountService vdCloudAccountService;
    protected final static Logger log = LoggerFactory.getLogger(VdCloudAccountController.class);


    /**
     * 查询云桌面账号列表
     */
    @PostMapping("/SelectAccounts")
    @ResponseBody
    public ModelMap list(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String account = "";
        List<VdCloudAccount> list = new ArrayList<>();

        try {
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
            pageNum = note.getString("pageNum");
            pageSize = note.getString("pageSize");
            account = note.getString("account");
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                VdCloudAccount vdCloudAccount = new VdCloudAccount();
                vdCloudAccount.setAccount(account);
                String orderBy = SqlUtil.escapeOrderBySql("");
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                List<VdCloudAccount> vdCloudAccounts = vdCloudAccountService.selectVdCloudAccountList(vdCloudAccount);
                if (null != vdCloudAccounts){
                    for (VdCloudAccount map:vdCloudAccounts) {
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
     * 查询云桌面账号列表
     */
    @PostMapping("/SelectAccountSearch")
    @ResponseBody
    public TableDataInfo listSearch(@RequestBody String json)
    {
        startPage();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String account = note.getString("account");
        VdCloudAccount vdCloudAccount = new VdCloudAccount();
        vdCloudAccount.setAccount(account);
        List<VdCloudAccount> vdCloudAccounts = vdCloudAccountService.selectVdCloudAccountList(vdCloudAccount);

        return getDataTable(vdCloudAccounts);
    }


    /**
     * 修改保存云桌面账号
     */
    @PostMapping("/UpdateAccount")
    @ResponseBody
    public AjaxResult editSave(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray notes = (JSONArray) jsonObject.get("note");
        int num = 0;
        for(int i = 0;i<notes.size();i++){
            JSONObject note = notes.getJSONObject(i);
            String account = note.getString("account");
            String team = note.getString("team");
            String company = note.getString("company");
            String user_name = note.getString("user_name");
            String claimant_id = note.getString("claimant_id");
            VdCloudAccount vdCloudAccount = new VdCloudAccount();
            vdCloudAccount.setAccount(account);
            vdCloudAccount.setClaimantId(claimant_id);
            vdCloudAccount.setTeam(team);
            vdCloudAccount.setCompany(company);
            vdCloudAccount.setUserName(user_name);
            num = vdCloudAccountService.updateVdCloudAccount(vdCloudAccount);
        }
        return toAjax(num);
    }

    /**
     * 查询用户所在部门人员
     */
    @PostMapping("/SelectUser")
    @ResponseBody
    public TableDataInfo selectUser(@RequestBody String json)
    {
        startPage();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String user_id = note.getString("user_id");
        List<UserDemo> userDemos = vdCloudAccountService.selectUser(user_id);
        return getDataTable(userDemos);
    }

    /**
     * 查询用户所在部门人员
     */
    @PostMapping("/SelectAllUser")
    @ResponseBody
    public TableDataInfo selectAllUser(@RequestBody String json)
    {
        startPage();
        List<UserDemo> userDemos = vdCloudAccountService.selectAllUser();
        return getDataTable(userDemos);
    }

    /**
     * 查询用户项目和账号
     */
    @PostMapping("/SelectAllTeam")
    @ResponseBody
    public TableDataInfo SelectAllTeam(@RequestBody String json)
    {
        startPage();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String user_id = note.getString("user_id");
        List<VdCloudAccount> vdCloudAccounts = vdCloudAccountService.selectAllTeam(user_id);
        return getDataTable(vdCloudAccounts);
    }

    /**
     * 查询用户项目和账号
     */
    @PostMapping("/SelectAccountData")
    @ResponseBody
    public TableDataInfo SelectAccountData(@RequestBody String json)
    {
        startPage();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String account = note.getString("account");
        String begin_time = note.getString("begin_time");
        String end_time = note.getString("end_time");
        String day = note.getString("day");
        List<Map<String, Object>> vdAccountData = vdCloudAccountService.SelectAccountData(account, begin_time, end_time, day);
        return getDataTable(vdAccountData);
    }


}
