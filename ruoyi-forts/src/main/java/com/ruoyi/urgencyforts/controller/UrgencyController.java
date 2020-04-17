package com.ruoyi.urgencyforts.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.urgencyforts.service.UrgencyService;
import com.ruoyi.urgencyforts.until.UrgencyUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    @Api("紧急变更")
    @RestController
    @RequestMapping("/UrgencyController")
    public class UrgencyController extends BaseController {

    protected final static Logger log = LoggerFactory.getLogger(UrgencyController.class);

    @Autowired
    private UrgencyService urgencyService;

    @Autowired
    private ISysDictDataService iSysDictDataService;

    /**
     * 查询系统名称和模糊查询
     * @param json
     * @return
     */
    @ApiOperation("获取系统名称")
    @PostMapping("/getSystemName")
    @ResponseBody
    public ModelMap getSystemName(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject systemName = urgencyService.getSystemName(json);
            modelMap = UrgencyUntil.resultModelMap(systemName);
            if ("0".equals((String) modelMap.get("code"))){
                List systemNameList = (List) systemName.get("list");
                //String systemNameList = systemName.getString("list");
                modelMap.put("list",systemNameList);
            }
        }catch (Exception e){
            log.error("查询系统名称和模糊查询接口异常 ： ",e);
        }
        log.info("getSystemName : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询实施人")
    @GetMapping("/getUserInfo")
    @ResponseBody
    public ModelMap getUserInfo(){
        ModelMap modelMap = null;
        try{
            JSONObject userInfo = urgencyService.getUserInfo();
            modelMap = UrgencyUntil.resultModelMap(userInfo);
            if ("0".equals((String) modelMap.get("code"))){
                //List<HashMap<String,String>> list = (List<HashMap<String,String>>)userInfo.get("list");
                //List userInfos = UrgencyUntil.getUserInfos(list);
                List lists = (List)userInfo.get("lists");
                //modelMap.put("list",userInfos);
                modelMap.put("lists",lists);
            }
        }catch (Exception e){
            log.error("查询复核人和实施人接口异常：",e);
        }
        log.info("getUserInfo : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询复核人")
    @PostMapping("/getReviewerInfo")
    @ResponseBody
    public ModelMap getReviewerInfo(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject userInfo = urgencyService.getReviewerInfo(json);
            modelMap = UrgencyUntil.resultModelMap(userInfo);
            if ("0".equals((String) modelMap.get("code"))){
                List lists = (List)userInfo.get("lists");
                modelMap.put("lists",lists);
            }
        }catch (Exception e){
            log.error("查询复核人和实施人接口异常：",e);
        }
        log.info("getUserInfo : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询发起的部门")
    @GetMapping("/businessChargeDept")
    @ResponseBody
    public ModelMap businessChargeDept(){
        ModelMap modelMap = null;
        try{
            JSONObject businessChargeDept = urgencyService.getBusinessChargeDept();
            modelMap = UrgencyUntil.resultModelMap(businessChargeDept);
            if ("0".equals((String) modelMap.get("code"))){
                List list = (List)businessChargeDept.get("list");
                modelMap.put("list",list);
            }
        }catch (Exception e){
            log.error("查询发起的部门接口异常：",e);
        }
        log.info("businessChargeDept : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询签字领导")
    @PostMapping("/signLeader")
    @ResponseBody
    public ModelMap signLeader(@RequestBody String json){
        ModelMap modelMap = null;
        try{
//            JSONObject teamLeader = urgencyService.teamLeaderInfomation(json);
            JSONObject responsibleCharge = urgencyService.responsibleChargeInfo(json);
            /*modelMap = UrgencyUntil.resultModelMap(teamLeader);
            if ("0".equals((String) modelMap.get("code"))){
                List<HashMap<String,String>> list = (List<HashMap<String,String>>)teamLeader.get("list");
                modelMap.put("list",list);
            }*/
            modelMap = UrgencyUntil.resultModelMap(responsibleCharge);
            if ("0".equals((String) modelMap.get("code"))){
                HashMap<String,String> list = (HashMap<String,String>)responsibleCharge.get("list");
                modelMap.put("list",list);
                String responMap = responsibleCharge.getString("responMaps");
                HashMap<String,String> responMaplist = null;
                if (!"false".equals(responMap)){
                    responMaplist =
                            (HashMap<String,String>)responsibleCharge.get("responMap");
                }
                HashMap<String,String> chargeMaplist =
                        (HashMap<String,String>)responsibleCharge.get("chargeMap");
                modelMap.put("responMaplist",responMaplist);
                modelMap.put("chargeMaplist",chargeMaplist);
            }else {
                log.info("model : "+modelMap);
                return modelMap;
            }
        }catch (Exception e){
            log.error("查询签字领导接口异常：",e);
        }
        log.info("signLeader : "+modelMap);
        return modelMap;
    }

    @ApiOperation("添加紧急变更数据")
    @PostMapping("/insertUrgencyAlteratRegister")
    @ResponseBody
    public ModelMap insertUrgencyAlteratRegister(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject jsonObject = urgencyService.insertUrgencyAlteratRegister(json);
            modelMap = UrgencyUntil.resultModelMap(jsonObject);
        }catch (Exception e){
            log.error("添加紧急变更数据接口异常：",e);
        }
        log.info("insertUrgencyAlteratRegister : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询审批页面数据")
    @PostMapping("/approvalData")
    @ResponseBody
    public ModelMap approvalData(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject approvalData = urgencyService.getApprovalData(json);
            modelMap = UrgencyUntil.resultModelMap(approvalData);
            if ("0".equals((String) modelMap.get("code"))){
                Map<String,String> map = (HashMap<String,String>)approvalData.get("hashMap");
                String approvalStatus = approvalData.getString("approvalStatus");
               /* JSONObject isTeamCharge = (JSONObject)approvalData.get("isTeamCharge");
                JSONObject isTeamBranched = (JSONObject)approvalData.get("isTeamBranched");
                JSONObject isChargeLeader = (JSONObject)approvalData.get("isChargeLeader");
                JSONObject isSecurityTeamId = (JSONObject)approvalData.get("isSecurityTeamId");
                JSONObject isBigDataTeamId = (JSONObject)approvalData.get("isBigDataTeamId");*/
                modelMap.put("list",map);
                    modelMap.put("approvalStatus",approvalStatus);
                /*modelMap.put("isTeamCharge",isTeamCharge);
                modelMap.put("isTeamBranched",isTeamBranched);
                modelMap.put("isChargeLeader",isChargeLeader);
                modelMap.put("isSecurityTeamId",isSecurityTeamId);
                modelMap.put("isBigDataTeamId",isBigDataTeamId);*/
            }
        }catch (Exception e){
            log.error("查询审批页面数据接口异常：",e);
        }
        log.info("approvalData : "+modelMap);
        return modelMap;
    }

    @ApiOperation("审批更改状态接")
    @PostMapping("/approvalUpdateStatus")
    @ResponseBody
    public ModelMap approvalUpdateStatus(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject jsonObject = urgencyService.updateSignStatus(json);
            modelMap = UrgencyUntil.resultModelMap(jsonObject);
        }catch (Exception e){
            log.error("审批更改状态接口异常：",e);
        }
        log.info("approvalUpdateStatus : "+modelMap);
        return modelMap;
    }

        @ApiOperation("查询紧急变更历史")
        @PostMapping("/selectUrgencyHistory")
        @ResponseBody
        public ModelMap selectUrgencyHistory(@RequestBody String json){
            ModelMap modelMap = null;
            try{
                JSONObject jsonObject = urgencyService.selectUrgencyHistory(json);
                modelMap = UrgencyUntil.resultModelMap(jsonObject);
                if ("0".equals((String) modelMap.get("code"))){
                    modelMap.put("list",(List<HashMap<String,String>>)jsonObject.get("list"));
                    modelMap.put("affiliatedTeam",(String)jsonObject.get("affiliatedTeam"));
                }
            }catch (Exception e){
                log.error("审批更改状态接口异常：",e);
            }
            log.info("selectUrgencyHistory : "+modelMap);
            return modelMap;
        }

        @ApiOperation("查询验证信息")
        @PostMapping("/getVerifyData")
        @ResponseBody
        public ModelMap getVerifyData(@RequestBody String json){
            ModelMap modelMap = null;
            try{
                JSONObject jsonObject = urgencyService.getVerifyData(json);
                modelMap = UrgencyUntil.resultModelMap(jsonObject);
                if ("0".equals((String) modelMap.get("code"))){
                    modelMap.put("list",(HashMap<String,String>)jsonObject.get("list"));
                }
            }catch (Exception e){
                log.error("查询验证信息接口异常：",e);
            }
            log.info("getVerifyData : "+modelMap);
            return modelMap;
        }

        @ApiOperation("提交验证")
        @PostMapping("/updateUrgencyAlteratVerify")
        @ResponseBody
        public ModelMap updateUrgencyAlteratVerify(@RequestBody String json){
            ModelMap modelMap = null;
            try{
                JSONObject jsonObject = urgencyService.updateUrgencyAlteratVerify(json);
                modelMap = UrgencyUntil.resultModelMap(jsonObject);
            }catch (Exception e){
                log.error("提交验证接口异常：",e);
            }
            log.info("updateUrgencyAlteratVerify : "+modelMap);
            return modelMap;
        }

        @ApiOperation("查询变更进度")
        @PostMapping("/selectUrgencyProcessSpeed")
        @ResponseBody
        public ModelMap selectUrgencyProcessSpeed(@RequestBody String json){
            ModelMap modelMap = null;
            try{
                JSONObject jsonObject = urgencyService.selectUrgencyProcessSpeed(json);
                modelMap = UrgencyUntil.resultModelMap(jsonObject);
                if ("0".equals((String) modelMap.get("code"))){
                    modelMap.put("list",(HashMap<String,String>)jsonObject.get("list"));
                }
            }catch (Exception e){
                log.error("查询变更进度接口异常：",e);
            }
            log.info("selectUrgencyProcessSpeed : "+modelMap);
            return modelMap;
        }

        @ApiOperation("判断是否显示分管签字")
        @PostMapping("/selectTwoDeptOrg")
        @ResponseBody
        public ModelMap selectTwoDeptOrg(@RequestBody String json){
            ModelMap modelMap = null;
            try{
                JSONObject jsonObject = urgencyService.selectTwoDeptOrg(json);
                modelMap = UrgencyUntil.resultModelMap(jsonObject);
                if ("0".equals((String) modelMap.get("code"))){
                    String twoDeptOrg = jsonObject.getString("twoDeptOrg");
                    String urgency_sci_tech = iSysDictDataService.selectDictLabel("urgency_sci_tech", twoDeptOrg);
                    String sci_tech = StringUtils.isNotBlank(urgency_sci_tech) ? "false" : "true";  //为true时显示分管签字
                    modelMap.put("urgency_sci_tech",sci_tech);
                }
            }catch (Exception e){
                log.error("判断是否显示分管签字接口异常：",e);
            }
            log.info("selectTwoDeptOrg : "+modelMap);
            return modelMap;
        }

    @ApiOperation("调用影像接口")
    @PostMapping("/imagesSystem")
    @ResponseBody
    public ModelMap imagesSystem(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject imagessystem = urgencyService.imagessystem(json);
            modelMap = UrgencyUntil.resultModelMap(imagessystem);
            modelMap.put("orderNo",imagessystem.getString("orderNo"));
        }catch (Exception e){
            log.error("调用影像接口异常：",e);
        }
        log.info("imagesSystem : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查看附件")
    @PostMapping("/viewPicture")
    @ResponseBody
    public ModelMap viewPicture(@RequestBody String json){
        ModelMap modelMap = null;
        try{
            JSONObject viewPicture = urgencyService.viewPicture(json);
            modelMap = UrgencyUntil.resultModelMap(viewPicture);
            modelMap.put("viewAnnex",viewPicture.getString("viewAnnex"));
            modelMap.put("list",viewPicture.getString("list"));
        }catch (Exception e){
            log.error("调用影像接口异常：",e);
        }
        log.info("viewPicture : "+modelMap);
        return modelMap;
    }

    @ApiOperation("紧急变更补发功能")
    @PostMapping("/reissueMessage")
    @ResponseBody
    public ModelMap reissueMessage(
            @RequestParam(required = false , defaultValue = "" ) String id,			//渠道类型 Android iOS
            @RequestParam(required = false , defaultValue = "" ) String content,			//地区编号
            @RequestParam(required = false , defaultValue = "" ) String url
    ){
        ModelMap modelMap = new ModelMap();
        try{
            /*String id = request.getParameter("id");
            String content = request.getParameter("content");
            String url = request.getParameter("url");*/
            JSONObject jsonObject = UrgencyUntil.sendUrgencyMessage(id, content, url);
            if ("0".equals(jsonObject.getString("code"))){
                modelMap.put("code","0");
                modelMap.put("msg","发送成功");
            }
        }catch (Exception e){
            log.error("调用影像接口异常：",e);
        }
        log.info("reissueMessage : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询未审批的消息")
    @GetMapping("/noApprovalData")
    @ResponseBody
    public ModelMap noApprovalData(){
        ModelMap modelMap = new ModelMap();
        try{
            JSONObject jsonObject = urgencyService.noApprovalData();
            modelMap.put("code","0");
            modelMap.put("list",jsonObject);
        }catch (Exception e){
            log.error("查询未审批的消息接口异常：",e);
        }
        log.info("noApprovalData : "+modelMap);
        return modelMap;
    }

        public static void main(String[] args){
            /*List<String> list = new ArrayList<>();
            String[] strings = new String[list.size()];
            list.toArray(strings);
            System.out.println(list);*/
                /*String source = "[\"小明\",\"aaacew\",\"小慧\"]";
                System.out.println(source);
                Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+)");
                List<String> list = new ArrayList<>();
                Matcher matcher = pattern.matcher(source);
                while (matcher.find()) {
                    list.add(matcher.group());
                }
                System.out.println(list.size());
                System.out.println(list);*/
           /* String str = "[\"小明\",\"aaacew\",\"小慧\"]";
            char ss[] = str.toCharArray(); //利用toCharArray方法转换
            String s = String.valueOf(ss);
            String replace = s.replace("[", "").replace("]", "");
            List<String> pathList = Arrays.asList(replace);
            for (String strs : pathList){
                System.out.println(strs);
            }*/
        }


    }
