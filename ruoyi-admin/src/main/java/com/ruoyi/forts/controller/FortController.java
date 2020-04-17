package com.ruoyi.forts.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.adpter.SendMessageAdpter;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.demoservice.GROUPSNDRequest;
import com.ruoyi.common.demoservice.TASCTLMsgSendResponse;
import com.ruoyi.common.httpClient.HttpClientUtils;
import com.ruoyi.common.httpClient.HttpHeader;
import com.ruoyi.common.httpClient.HttpUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtils;
import com.ruoyi.common.utils.poi.ReadWps;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.domain.TokenSystemInventorySo;
import com.ruoyi.forts.service.ITokenSystemInventoryService;
import com.ruoyi.ruoyiforts.domain.TokenApplyForms;
import com.ruoyi.ruoyiforts.service.FortService;
import com.ruoyi.ruoyiforts.until.FortDetailedListUntil;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import com.ruoyi.wsdl.esbService.PushMessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 令牌登记
 * @author mengdehu
 * @since  2019-11-11
 */

@Api("令牌登记")
@RestController
@RequestMapping("/FortController")
public class FortController extends BaseController {
    protected final static Logger log = LoggerFactory.getLogger(FortController.class);

    private static final String link_launchApp = "launchApp://lingpaiapply$$#/lingApproval";
    private static final String link_launchApp_approval = "launchApp://lingpaiapply$$#/AccordingDetails";

    @Autowired
    private FortService fortService;

    @Autowired
    private ISysDictDataService iSysDictDataService;

    @Autowired
    private ExcelUtils excelUtils;

    @Autowired
    private ITokenSystemInventoryService tokenSystemInventoryService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 令牌申请首页查询
     * @param //model
     * @param //pageNum
     * @param //pageSize
     * @return
     */
    @ApiOperation("令牌申请首页查询")
    @PostMapping("/ApplyFortIndex")
    @ResponseBody
    public ModelMap ApplyFortIndex(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String employeeId = "";
        List<HashMap<String, String>> list = new ArrayList<>();
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")){
                JSONObject note = (JSONObject) jsonObject.get("note");
                pageNum = note.getString("pageNum");
                pageSize = note.getString("pageSize");
                employeeId = note.getString("employeeId");
                if(StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)){
                    String orderBy = SqlUtil.escapeOrderBySql("");
                    PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                    List<HashMap<String, String>> hashMaps = fortService.selectApplyAndResult(employeeId);
                    if (null != hashMaps){
                        for (HashMap<String,String> map:hashMaps) {
                            list.add(transformUpperCase(map));
                        }
                    }
                    code = "0";
                    msg = "查询成功";
                    model.put("hashMaps",list);
                }else{
                    msg = "分页条数或页数未传";
                }
            }
        }catch (Exception e){
            log.error("令牌申请首页查询接口异常：" ,e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("model : "+model);
        return model;
    }



    /**
     * 令牌申请接口
     *
     * @return
     */
    @ApiOperation("令牌申请接口")
    @PostMapping("/LoggingApplyFort")
    @ResponseBody
    public ModelMap LoggingApplyFort(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm");
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")){
                log.info("LoggingApplyFort json : "+json);
                JSONObject note = (JSONObject) jsonObject.get("note");
                String employeeId = note.getString("employeeId");
                String proposer = note.getString("proposer");
                //String applyDate = note.getString("applyDate");
                String applyDate = sdf.format(new Date());
                String openIncident = note.getString("openIncident");
                String applyEnvironment = note.getString("applyEnvironment");
                String systemName = note.getString("systemName");
                String openDate = note.getString("openDate");
                String validDate = note.getString("validDate");
                String endDate = note.getString("endDate");
                String openDistinct = note.getString("openDistinct");
                String openInstructions = note.getString("openInstructions");
                String openIncidentId = note.getString("openIncidentId");
                String otherSystem = note.getString("otherSystem");
                //String applyCount = note.getString("applyCount");
                String applyCount = "0";
                openIncident = iSysDictDataService.selectDictLabel("token_openIncident",openIncident);
                String distinct = "";
                if("1".equals(openDistinct)){
                    String dictLabel = iSysDictDataService.selectDictLabel("token_openDistinct",
                            openDistinct);
                    distinct = "(开启"+dictLabel+"申请)";
                }
                //long longDateTime = (sdf.parse(endDate).getTime()-sdf.parse(openDate).getTime())/(60*60*1000);
                String tag = proposer+"自助开启令牌权限";
                String content = "开启时间:"+sd.format(sdf.parse(openDate))+" "+"\n"+
                        "结束时间:"+sd.format(sdf.parse(endDate))+" "+"\n"+
                        "系统名称:"+systemName+" "+"\n"+"开启事由:"+openIncident;
                Map<String,String> message = sendsMessage(employeeId,distinct+tag,content);
                if(null != message && message.containsKey("code")){
                    if ("0".equals(message.get("code"))){
                        TokenApplyForms tokenApplyForms = setDomain( employeeId, applyDate,  proposer,
                                applyEnvironment, systemName,openDistinct,  openInstructions,  validDate,
                                null,openDate, endDate, openIncident,  openIncidentId,
                                applyCount,null,null,
                                otherSystem,message.get("seNo"),"2");
                        boolean bl = fortService.insertTokenApplyForm(tokenApplyForms);
                        if (bl){
                            //if("1".equals(message.get("flag"))){
                                /*JSONObject js = new JSONObject();
                                JSONObject notes = new JSONObject();
                                js.put("seNo",message.get("seNo"));
                                js.put("approvalName","1");
                                js.put("approvalStatus","1");
                                js.put("approvalId","001");
                                notes.put("note",js);
                                ModelMap model1 = TokenApplyApprovals(notes.toString());
                                if (null != model1 && model1.containsKey("code")){
                                    code = "0";
                                    msg = "查询成功";
                                }*/
                            //}
                            code = "0";
                            msg = "查询成功";
                        }
                    }else{
                        msg = message.get("msg");
                    }
                }else{
                    msg = message.get("msg");
                }
            }
        }catch (Exception e){
            log.error("令牌申请接口异常：",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("LoggingApplyFort : "+model);
        return model;
    }

    public ModelMap TokenApplyApprovals(String json){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String userName = "";
        String uniquenessCode = "";
        String applyStatus = "";
        try{
            log.info("TokenApplyApproval json : "+json);
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                String seno = note.getString("seNo");
                String approvalName = note.getString("approvalName");
                String approvalStatus = note.getString("approvalStatus");
                String approvalId = note.getString("approvalId");
                HashMap map = fortService.selectApprovalInfo(seno);
                if (null == map || map.size() == 0){
                    model.put("code",code);
                    model.put("msg","流水号查询令牌申请表无数据");
                    log.info("TokenApplyApproval : "+model);
                    return model;
                }
                String employeeId = (String) map.get("EMPLOYEE_ID");
                String applyEnvironment = (String) map.get("APPLY_ENVIRONMENT");
                String openDate = sdf.format((Date)map.get("OPEN_DATE"));
                String endDate = sdf.format((Date)map.get("END_DATE"));
                String openDistinct = (String) map.get("OPEN_DISTINCT");
                String applyDate = sdf.format((Date)map.get("APPLY_DATE"));
                String proposer = (String) map.get("PROPOSER");
                if ("1".equals(approvalStatus)){
                    JSONObject httpJson = null;
                    log.info("newAndOldSwitch : "+newAndOldSwitch());
                    if (newAndOldSwitch()){
                        httpJson = httpOpenDistinct(employeeId,"",applyEnvironment,openDate,endDate);
                    }else {
                        httpJson = httpOpenDistinct(employeeId,openDate,endDate);
                    }
                    if(null != httpJson && httpJson.containsKey("code")){
                        if("2000".equals(httpJson.getString("code"))){
                            applyStatus = "堡垒机成功";
                            if("1".equals(openDistinct)){
                                Map<String, String> maps = openDistinctExcel(employeeId);
                                if(null != maps && maps.size() > 0){
                                    userName = maps.get("userName");
                                    uniquenessCode = maps.get("uniquenessCode");
                                }
                            }
                        }else{
                            //applyStatus = "堡垒机失败";
                            model.put("code","1");
                            model.put("msg",httpJson.getString("msg"));
                            return model;
                        }
                    }else{
                        model.put("code","1");
                        model.put("msg","调用保垒机失败");
                        return model;
                    }
                }
                int i = fortService.updateApprovalInfo(approvalStatus, uniquenessCode, userName,
                        approvalName, applyStatus, seno);
                if (i > 0){
                    code = "0";
                    msg = "申请成功";
                    /*Map<String,String> map1 = sendsEmployeeAndLeaderMessage(employeeId, approvalName,
                            applyDate, approvalStatus, approvalId, proposer);
                    if (null != map1 && map1.containsKey("code")){
                        if ("0".equals(map1.get("code"))){
                            code = "0";
                            msg = "申请成功";
                        }
                    }*/
                }
            }
        }catch (Exception e){
            log.error("令牌申请审批接口异常:",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("TokenApplyApproval : "+model);
        return model;
    }

    @ApiOperation("令牌申请查询状态")
    @PostMapping("/TokenApplyStatus")
    @ResponseBody
    public ModelMap TokenApplyStatus(@RequestBody String json){
        ModelMap model = new ModelMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        String code = "1";
        String msg = "查询失败";
        try{
            log.info("TokenApplyStatus json : "+json);
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                String seno = note.getString("seNo");
                //String approvalName = note.getString("approvalName");
                HashMap map = fortService.selectApprovalInfo(seno);
                if (null == map || map.size() == 0){
                    model.put("code",code);
                    model.put("msg","流水号查询令牌申请表无数据");
                    log.info("TokenApplyApproval : "+model);
                    return model;
                }
                String contents = "开启时间:"+sdf.format((Date) map.get("OPEN_DATE"))+" "+"\n"+
                        "结束时间:"+sdf.format((Date)map.get("END_DATE"))+" "+"\n"+
                        "系统名称:"+((String) map.get("SYSTEM_NAME"))+" "+"\n"+
                        "开启事由:"+((String)map.get("OPEN_INCIDENT"));
                if (StringUtils.isBlank((String)map.get("APPROVAL_STATUS"))){
                    model.put("approvalStatus","2");
                    String proposer = (String)map.get("PROPOSER");
                    String applyDate = sdf.format((Date)map.get("APPLY_DATE"));
                    String content = proposer+"于"+applyDate+"自助申请开通令牌，"+contents+" ,是否同意：";
                    model.put("content",content);
                }else {
                    if ("0".equals((String)map.get("APPROVAL_STATUS"))){
                        model.put("approvalStatus","0");
                        model.put("content","该令牌已审批为:不通过,审批人: "+map.get("RESERVED1"));
                    }else
                    if ("1".equals((String)map.get("APPROVAL_STATUS"))){
                        model.put("approvalStatus","1");
                        model.put("content","该令牌已审批为:通过,审批人: "+map.get("RESERVED1"));
                    }else
                    if ("2".equals((String)map.get("APPROVAL_STATUS"))){
                        model.put("approvalStatus","2");
                        String proposer = (String)map.get("PROPOSER");
                        String applyDate = sdf.format((Date)map.get("APPLY_DATE"));
                        String content = proposer+"于"+applyDate+"申请开通令牌，"+contents+" ,是否同意：";
                        model.put("content",content);
                    }else{
                        model.put("code",code);
                        model.put("msg","查询审批状态错误");
                        log.info("TokenApplyApproval : "+model);
                        return model;
                    }
                }
                code = "0";
                msg = "查询成功";
            }
        }catch (Exception e){
            log.error("令牌申请审批接口异常:",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("TokenApplyApproval : "+model);
        return model;
    }


    /**
     * 令牌申请审批接口
     * @param json
     * @return
     */
    @ApiOperation("令牌申请审批接口")
    @PostMapping("/TokenApplyApproval")
    @ResponseBody
    public ModelMap TokenApplyApproval(@RequestBody String json){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String userName = "";
        String uniquenessCode = "";
        String applyStatus = "";
        try{
            log.info("TokenApplyApproval json : "+json);
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                String seno = note.getString("seNo");
                String approvalName = note.getString("approvalName");
                String approvalStatus = note.getString("approvalStatus");
                String approvalId = note.getString("approvalId");
                HashMap map = fortService.selectApprovalInfo(seno);
                if (null == map || map.size() == 0){
                    model.put("code",code);
                    model.put("msg","流水号查询令牌申请表无数据");
                    log.info("TokenApplyApproval : "+model);
                    return model;
                }
                String employeeId = (String) map.get("EMPLOYEE_ID");
                String applyEnvironment = (String) map.get("APPLY_ENVIRONMENT");
                String openDate = sdf.format((Date)map.get("OPEN_DATE"));
                String endDate = sdf.format((Date)map.get("END_DATE"));
                String openDistinct = (String) map.get("OPEN_DISTINCT");
                String applyDate = sdf.format((Date)map.get("APPLY_DATE"));
                String proposer = (String) map.get("PROPOSER");
                if ("1".equals(approvalStatus)){
                    JSONObject httpJson = null;
                    log.info("newAndOldSwitch : "+newAndOldSwitch());
                    if (newAndOldSwitch()){
                        httpJson = httpOpenDistinct(employeeId,"",applyEnvironment,openDate,endDate);
                    }else {
                        httpJson = httpOpenDistinct(employeeId,openDate,endDate);
                    }
                    if(null != httpJson && httpJson.containsKey("code")){
                        if("2000".equals(httpJson.getString("code"))){
                            applyStatus = "堡垒机成功";
                            if("1".equals(openDistinct)){
                                Map<String, String> maps = openDistinctExcel(employeeId);
                                if(null != maps && maps.size() > 0){
                                    userName = maps.get("userName");
                                    uniquenessCode = maps.get("uniquenessCode");
                                }
                            }
                        }else{
                            //applyStatus = "堡垒机失败";
                            model.put("code","1");
                            model.put("msg",httpJson.getString("msg"));
                            return model;
                        }
                    }else{
                        model.put("code","1");
                        model.put("msg","调用保垒机失败");
                        return model;
                    }
                }
                int i = fortService.updateApprovalInfo(approvalStatus, uniquenessCode, userName,
                        approvalName, applyStatus, seno);
                if (i > 0){
                    Map<String,String> map1 = sendsEmployeeAndLeaderMessage(employeeId, approvalName,
                            applyDate, approvalStatus, approvalId, proposer);
                    if (null != map1 && map1.containsKey("code")){
                        if ("0".equals(map1.get("code"))){
                            code = "0";
                            msg = "申请成功";
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("令牌申请审批接口异常:",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("TokenApplyApproval : "+model);
        return model;
    }

    /**
     * 审批后查询发送信息
     * @param employeeId
     * @param approvalName
     * @param applyDate
     * @param approvalStatus
     * @param approvalId
     * @param proposer
     * @return
     * @throws Exception
     */
    public Map<String,String> sendsEmployeeAndLeaderMessage(String employeeId,String approvalName,
                                             String applyDate,String approvalStatus,
                                             String approvalId,String proposer)throws Exception{
        Map map = new HashMap<>();
        List<String> nos = new ArrayList<>();
        try{
            String status = "1".equals(approvalStatus) ? "通过" : "拒绝";
            String tag = "令牌申请审批回复";
            String content = "您于"+applyDate+"申请开通令牌已"+status+",审批人 : "+approvalName;
//            String sendStatus = sendApprovalMessage(employeeId, tag, content);
            String sendStatus = esbSendApprovalMessage(employeeId, tag, content);
            if ("COMPLETE".equals(sendStatus)){
                try{
                    String ldUserId = "";
                    if (StringUtils.isNotEmpty(employeeId)){
                        employeeId = employeeId.replaceFirst("0","");
                    }
                    List<HashMap<String, String>> twoOrgInfomation = fortService.getTwoOrgInfomation(employeeId);
                    log.info("sendsEmployeeAndLeaderMessage twoOrgInfomation : "+twoOrgInfomation);
                    if (null == twoOrgInfomation || twoOrgInfomation.size() == 0){
                        return map;
                    }
                    for (HashMap<String, String> hashMap:twoOrgInfomation) {
                        ldUserId = hashMap.get("USER_ID");
                        if (StringUtils.isNotBlank(ldUserId)){
                            ldUserId = ldUserId.startsWith("0") ? ldUserId : "0"+ldUserId;
                            if (ldUserId.equals(approvalId)){
                                continue;
                            }
                        }
                        nos.add(ldUserId);
                        log.info("sendmessage ldUserId : "+ldUserId);
                    }
                    if (null == nos || nos.size() == 0){
                        map.put("code","0");
                        return map;
                    }
                    //将数组转为字符串并用“,”分隔
                    String newnos = String.join(",", nos.toArray(new String[nos.size()]));
                    String leaderContent = proposer+"于"+applyDate+"申请开通令牌已审批"+status+",审批人 : "+approvalName;
                    //String sendLeaderStatus = sendApprovalMessage(newnos, "令牌申请审批", leaderContent);
                    String sendLeaderStatus = esbSendApprovalMessage(newnos,"令牌申请审批",leaderContent);
                    if ("COMPLETE".equals(sendLeaderStatus)){
                        map.put("code","0");
                    }
                }catch (Exception e){
                    throw new Exception("查询发送领导信息接口异常: ",e);
                }
            }
        }catch (Exception e){
            throw new Exception("查询审批后发送消息接口异常: ",e);
        }
        return map;
    }

    /**
     *
     * @param employeeId
     * @param tag
     * @param content
     * @return
     * @throws Exception
     */
    public static String sendApprovalMessage(String employeeId,String tag,String content) throws Exception {
        String sendStatus = "";
        try{
            GROUPSNDRequest groupsndRequest = new GROUPSNDRequest();
            groupsndRequest.setSENDCONTENT(content);
            groupsndRequest.setSENDTAG(tag);
            groupsndRequest.setSENDNO(employeeId);
            TASCTLMsgSendResponse sendmessage =
                    SendMessageAdpter.sendmessage(groupsndRequest);
            sendStatus = sendmessage.getTRANSTATUS();
        }catch (Exception e){
            throw new Exception("审批后发送消息审批后发送消息接口异常:",e);
        }
        return sendStatus;
    }

    public static String esbSendApprovalMessage(String employeeId,String tag,String content) throws Exception {
        String sendStatus = "";
        List<String> nos = new ArrayList<>();
        nos.add(employeeId);
        try{
            PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag, null);
            sendStatus = pushMessageResponse.getTRANSTATUS();
        }catch (Exception e){
            throw new Exception("审批后发送消息审批后发送消息接口异常:",e);
        }
        return sendStatus;
    }

    public Map<String,String> paramMaps() throws Exception {
        try{
            List<SysDictData> token_name_password = iSysDictDataService.selectDictDataByType("token_name_password");
            Map<String,String> map = new HashMap<>();
            if (null != token_name_password){
                for (SysDictData dict : token_name_password) {
                    map.put("username",dict.getDictLabel());
                    map.put("password",dict.getDictValue());
                }
            }
            return map;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String beforeTime(String openTime) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(openTime));
            cal.add(Calendar.MINUTE,-2);
            return sdf.format(cal.getTime());
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * HTTPclient调用第三方堡垒机接口
     * @return
     * @throws Exception
     */
    public JSONObject httpOpenDistinct(String userName,String openDate,String endDate) throws Exception{
        JSONObject json = new JSONObject();
        try {
            log.info("httpClient : "+openDate+" "+endDate);
            String urlPost = configService.selectConfigByKey("token_fort_urlPost");
            String urlGet = configService.selectConfigByKey("token_fort_urlGet");
            String urlPut = configService.selectConfigByKey("token_fort_urlPut");
            String hostname = configService.selectConfigByKey("token_fort_hostname");
            log.info(urlPost +" "+urlGet+" "+urlPut);
            String resultPost = HttpUtil.doPost1(urlPost, HttpHeader.headerMap(""), paramMaps(), "UTF-8", false);
            log.info("resultPost =======>>> "+resultPost);
            JSONObject jsonObject = JSON.parseObject(resultPost);
            String st_auth_token = jsonObject.getString("ST_AUTH_TOKEN");
            log.info("ST_AUTH_TOKEN =======>>> "+st_auth_token);

            Map<String,String> map = new HashMap<>();
            map.put("loginName",userName);
            String resultGet = HttpUtil.doGet(urlGet, HttpClientUtils.headerMap(st_auth_token), map, "UTF-8", false);
            log.info("resultGet ========>> "+resultGet);
            JSONObject jsonGet = JSON.parseObject(resultGet);
            String content = jsonGet.getString("content");
            JSONArray objects = JSONObject.parseArray(content);
            String id = objects.getJSONObject(0).getString("id");
            log.info("id ================>>>"+id);

            Map<String,String> mapPut = new HashMap<>();
            mapPut.put("validFrom",beforeTime(openDate));
            mapPut.put("validTo",endDate);
            String resultPut = HttpClientUtils.doPut(hostname, urlPut+"/"+id, HttpClientUtils.headerMap(st_auth_token), mapPut);
            log.info("resultPut ========>>> "+resultPut);
            if ("204".equals(resultPut)){
                json.put("code","2000");
                json.put("msg","调用堡垒机成功");
            }else{
                json.put("code","1");
                json.put("msg","调用堡垒机失败");
            }
        }catch (Exception e){
            throw new Exception("HTTPclient调用第三方堡垒机接口异常:",e);
        }
        log.info("httpOpenDistinct : "+json);
        return json;
    }

    /**
     * HTTPclient调用第三方堡垒机接口
     * @return
     * @throws Exception
     */
    public JSONObject httpOpenDistinct(String userName,String password,String applyEnvironment,String openDate,String endDate) throws Exception{
        JSONObject json = new JSONObject();
        try {
            /*String prxUrl = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", "prxUrl");*/
            log.info("httpClient : "+openDate+" "+endDate);
            String apply_Environment_name = iSysDictDataService.selectDictLabel
                    ("token_applyEnvironment",applyEnvironment);
            String sufUrl = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", "sufUrl");
            String identity = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", applyEnvironment+"_identity");
            String token = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", applyEnvironment+"_token");
            Map<String,String> map = new HashMap<>();
            //map.put("login",userName);
            /*map.put("valid_date1",sdf.format(sdf1.parse(openDate)));
            map.put("valid_date2",sdf.format(sdf1.parse(endDate)));*/
            map.put("valid_date1",openDate);
            map.put("valid_date2",endDate);
            log.info("HTTPclient调用第三方堡垒机接口上送:"+map);
            log.info("HTTPclient调用第三方堡垒机接口url : "+apply_Environment_name+sufUrl+userName);
            Map headerMap = HttpHeader.headerMap(identity, token);
            log.info("headerMap : "+headerMap);
            log.info("identity : "+identity+" token : "+token);
            String str = HttpUtil.doPost(apply_Environment_name+sufUrl+userName+"/",headerMap,map,"UTF-8",false);
            JSONObject jsonObject = JSONObject.parseObject(str);
            if ("2000".equals(jsonObject.getString("code"))){
                json.put("code","2000");
                json.put("msg",jsonObject.getString("msg"));
                json.put("data",jsonObject.getString("date"));
            }else{
                json.put("code",jsonObject.getString("code"));
                json.put("msg",jsonObject.getString("msg"));
            }
        }catch (Exception e){
            throw new Exception("HTTPclient调用第三方堡垒机接口异常:",e);
        }
        log.info("httpOpenDistinct : "+json);
        return json;
    }

    /**
     * 反显数据
     *
     * @return
     */
    @ApiOperation("反显数据接口")
    @PostMapping("/InvertValue")
    @ResponseBody
    public ModelMap InvertValue(){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try {

            List<SysDictData> applyEnvironment =
                    iSysDictDataService.selectDictDataByType("token_applyEnvironment");    //申请环境
            List<SysDictData> openIncident =
                    iSysDictDataService.selectDictDataByType("token_openIncident");        //开启事由
            List<SysDictData> validDate =
                    iSysDictDataService.selectDictDataByType("token_validDate");           //有效时长
            if(null != applyEnvironment && applyEnvironment.size() > 0 &&
                    null != openIncident && openIncident.size() > 0 && null != validDate && validDate.size() > 0){
                model.put("applyEnvironment",getDickeyAndValue(applyEnvironment));
                model.put("openIncident",getDickeyAndValue(openIncident));
                model.put("validDate",getDickeyAndValue(validDate));
                code = "0";
                msg = "查询成功";
            }
        }catch (Exception e){
            log.error("反显数据",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("InvertValue : "+model);
        return model;
    }


    @ApiOperation("测试堡垒机")
    @PostMapping("/TestOpenDistinct")
    @ResponseBody
    public ModelMap TestOpenDistinct(
            @RequestParam(required = false , defaultValue = "") String url,
            @RequestParam(required = false , defaultValue = "") String openDate,
            @RequestParam(required = false , defaultValue = "") String endDate,
            @RequestParam(required = false , defaultValue = "") String identity,
            @RequestParam(required = false , defaultValue = "") String token
    ){
        JSONObject json = new JSONObject();
        ModelMap model = new ModelMap();
        try {
            Map<String,String> map = new HashMap<>();
            /*map.put("validFrom",openDate);
            map.put("validTo",endDate);*/
            map.put("username",openDate);
            map.put("password",endDate);
            log.info("HTTPclient调用第三方堡垒机接口上送:"+map);
            Map headerMap = HttpHeader.headerMap(identity, token);
            log.info("headerMap : "+headerMap);
            log.info("identity : "+identity+" token : "+token);
            String str = HttpUtil.doPost(url,headerMap,map,"UTF-8",false);
            JSONObject jsonObject = JSONObject.parseObject(str);
            if ("2000".equals(jsonObject.getString("code"))){
                json.put("code","2000");
                json.put("msg",jsonObject.getString("msg"));
                json.put("data",jsonObject.getString("date"));
            }else{
                json.put("code",jsonObject.getString("code"));
                json.put("msg",jsonObject.getString("msg"));
            }
        }catch (Exception e){
            log.error("HTTPclient调用第三方堡垒机接口异常:",e);
        }
        log.info("httpOpenDistinct : "+json);
        return model;
    }

    /**
     * 获取系统名称
     * @param json
     * @return
     */
    @ApiOperation("获取系统名称")
    @PostMapping("/getSystemName")
    @ResponseBody
    public ModelMap getSystemName(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                List<String> list = new ArrayList<>();
                List<HashMap<String, String>> likeSystem =
                        fortService.getLikeSystem(note.getString("userId"), note.getString("systemName"));
                if (null != likeSystem && likeSystem.size() != 0){
                    for (HashMap<String,String> map:likeSystem) {
                        list.add(map.get("SYSTEM_NAME"));
                    }
                    model.put("list",list);
                }/*else{
                    List<HashMap<String, String>> allDepartment = fortService.getAllDepartment();
                    model.put("allDepartment",allDepartment);
                }*/
                code = "0";
                msg = "1";
            }
        }catch (Exception e){
            log.error("获取系统名称",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("model : "+model);
        return model;
    }

    @ApiOperation("全部系统名称")
    @PostMapping("/allSystemName")
    @ResponseBody
    public ModelMap allSystemName(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject note = (JSONObject) jsonObject.get("note");
                String userId = note.getString("userId");
                String systemName = note.getString("systemName");
                List<String> list = new ArrayList<>();
                List<HashMap<String, String>> allSystemNames = fortService.getAllSystemName(systemName);
                if (null != allSystemNames && allSystemNames.size() != 0){
                    for (HashMap<String,String> map:allSystemNames) {
                        list.add(map.get("SYSTEM_NAME"));
                    }
                    code = "0";
                    msg = "查询成功";
                    model.put("list",list);
                    boolean bl = fortService.selectSearchSystem(userId);
                    String isExist = bl == true ? "true" : "false";
                    model.put("isExist",isExist);
                }
            }
            //model.put("allSystemName",allSystemNames);
        }catch (Exception e){
            log.error("获取全部系统名称接口异常:",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("allSystemName : "+model);
        return model;
    }



    /**
     * 开启事由常用语
     * @param json
     * @return
     */
    @ApiOperation("开启事由常用语")
    @PostMapping("/OpenInstruction")
    @ResponseBody
    public ModelMap OpenInstructions(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")){
                JSONObject note = (JSONObject) jsonObject.get("note");
                String singId = note.getString("singId");
                if (StringUtils.isNotBlank(singId)){
                    List<HashMap<String, String>> commonLanguage = fortService.getCommonLanguage(singId);//开启说明
                    model.put("openInstructions",commonLanguage);
                }else{
                    model.put("openInstructions",null);
                }
                code = "0";
                msg = "查询成功";
            }

        }catch (Exception e){
            log.error("开启事由常用语接口异常：",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("model : "+model);
        return model;
    }

    public static List<HashMap<String,String>> getDickeyAndValue(List<SysDictData> list){
        List<HashMap<String,String>> lists = new ArrayList<HashMap<String,String>>();
        if (null != list && list.size() > 0){
            for(int i = 0;i <list.size();i++){
                HashMap<String,String> map = new HashMap<>();
                map.put(list.get(i).getDictLabel(),list.get(i).getDictValue());
                lists.add(map);
            }
        }
        return lists;
    }

    /**
     * 发送推送
     * @param userId
     * @param content
     * @return
     * @throws Exception
     */
    public Map sendsMessage(String userId,String tag,String content) throws Exception{
        String transtatus = "";
        String seNo = "";
        Map<String,String> map = new HashMap<>();
        List<String> nos = new ArrayList<>();
        try{
            //获取上级领导信息
            if (StringUtils.isNotEmpty(userId)){
                userId = userId.replaceFirst("0","");
            }
            log.info("userId ====>>> "+userId);
            boolean leaderSend = fortService.isLeaderSend(userId);
            if (leaderSend){
                /*long time = new Date().getTime();
                String times = String.valueOf(time);*/
                String seqNo = EsbSendMessage.getSeqNo();
                map.put("seNo",seqNo);
                map.put("flag","1");
                map.put("code","0");
                map.put("msg","查询成功");
                return map;
            }
            List<HashMap<String, String>> twoOrgInfomation = fortService.getTwoOrgInfomation(userId);
            if(null == twoOrgInfomation || twoOrgInfomation.size() == 0){
                map.put("code","1");
                map.put("msg","查询无发送消息领导号");
                return map;
            }
            log.info("sendsMessage twoOrgInfomation : "+twoOrgInfomation);
            for (HashMap<String, String> hashMap:twoOrgInfomation) {
                String ldUserId = hashMap.get("USER_ID");
                if (StringUtils.isNotBlank(ldUserId)){
                    ldUserId = ldUserId.startsWith("0") ? ldUserId : "0"+ldUserId;
                }
                nos.add(ldUserId);
                log.info("sendmessage ldUserId : "+ldUserId);
            }
            /*PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag,
                    link_launchApp_approval);*/
            PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag,
                    link_launchApp+"?content="+tag+",是否同意:");
            transtatus = pushMessageResponse.getTRANSTATUS();
            String errormsg = pushMessageResponse.getERRORMSG();
            seNo = pushMessageResponse.getSEQNO();
            map.put("code","0");
            map.put("transtatus",transtatus);
            map.put("seNo",seNo);
            log.info("transtatus : "+transtatus+"  "+"errormsg : "+errormsg);
            log.info("sendmessage   :  "+pushMessageResponse.toString());
        }catch (Exception e){
            throw new Exception("令牌申请发送推送接口异常:",e);
        }
        return map;
    }



    /**
     * 添加申请实体类
     * @param proposer
     * @param applyDate
     * @param openIncident
     * @param applyEnvironment
     * @param systemName
     * @param openDate
     * @param validDate
     * @param endDate
     * @param openDistinct
     * @param openInstructions
     * @return
     * @throws Exception
     */
    public static TokenApplyForms setDomain
    (String employeeId,String applyDate, String proposer, String applyEnvironment,String systemName,
    String openDistinct, String openInstructions, String validDate,String applyStatus,
    String openDate,String endDate,String openIncident, String openIncidentId,String applyCount,
    String uniquenessCode,String userName,String otherSystem,String seno,String approvalStatus) throws Exception {
        TokenApplyForms ta = new TokenApplyForms();
        try {
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");

            ta.setEmployeeId(employeeId);
            ta.setApplyDate(applyDate);
            ta.setProposer(proposer);
            ta.setApplyEnvironment(applyEnvironment);
            ta.setSystemName(systemName);
            ta.setOpenDistinct(openDistinct);
            ta.setOpenInstructions(openInstructions);
            ta.setValidDate(validDate);
            ta.setApplyStatus(applyStatus);
            ta.setOpenDate(openDate);
            ta.setEndDate(endDate);
            ta.setAddway("app");
            ta.setOpenIncident(openIncident);
            ta.setOpenIncidentId(openIncidentId);
            ta.setApplycount(applyCount);
            ta.setUniquenesscode(uniquenessCode);
            ta.setRemark(userName);
            ta.setOtherSystem(otherSystem);
            ta.setSeqno(seno);
            ta.setApprovalStatus(approvalStatus);
        }catch (Exception e){
            throw new Exception(e);
        }
        return ta;
    }

    /**
     * 开启远程读取Excel文件
     * @return
     * @throws Exception
     */
    public Map<String,String> openDistinctExcel(String employeeId) throws Exception {
        Map<String,String> map = new HashMap<>();
        try {
            String uniqueness = uniquenessCode(employeeId);
            String url = iSysDictDataService.selectDictLabel("token_distinctExcel", "url");

            String params[] = {"userName","password",};
            String userName = "";
            String password = "";
            //BigDecimal useNum = BigDecimal.ZERO;

            //List<Map<String, String>> maps = ReadWps.ReaderWps(url, params,1);
            List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
            List<List<String>> list = excelUtils.read(url);
            if (list != null) {
                for (int i = 1; i < list.size(); i++) {
                    Map<String, String> map1 = new LinkedHashMap<String, String>();
                    List<String> cellList = list.get(i);
                    for (int j = 0; j < cellList.size(); j++) {
                        map1.put(params[j],cellList.get(j));
                    }
                    maps.add(map1);
                    log.info("=====>>>"+map1);
                }
            }
            if(null != maps && maps.size() != 0){
                /*String maxCount = fortService.selectMaxCount();
                if(StringUtils.isNotBlank(maxCount)){
                    if (maps.size() == Integer.parseInt(maxCount)){
                        //useNum = BigDecimal.ZERO;
                        maxCount = "0";
                    }
                }*/

                int random = (int)(Math.random()*30)+1;

                for (int i = 0; i < maps.size(); i++) {
                    userName = maps.get(i).get("userName");
                    password = maps.get(i).get("password");
                    if(i == random){
                        break;
                    }/*if(i == Integer.parseInt(maxCount)){
                        break;
                    }*/
                }
                map.put("userName",userName);
                map.put("password",password);
                map.put("uniquenessCode",uniqueness);
                /*int count = 1;
                if(StringUtils.isNotBlank(maxCount)){
                    count = Integer.parseInt(maxCount) + 1;
                }*/
                log.info("openDistinctExcel openDistinctExcel : "+employeeId);
                boolean bl = fortService.addVpnInfo(userName, password, "0",
                            new BigDecimal(String.valueOf(random)),employeeId,uniqueness);
                if(bl){
                    List<String> nos = new ArrayList<>();
                    nos.add(employeeId);
                    FortDetailedListUntil.esbSendMessage(nos, "用户名 : "+userName+" "+"密码 : "+password,
                            "远程用户名和密码",null);
                    /*FortDetailedListUntil.sendMessage(nos,
                            "用户名 : "+userName+" "+"密码 : "+password,null,null);*/
                    /*GROUPSNDRequest groupsndRequest = new GROUPSNDRequest();
                    groupsndRequest.setSENDCONTENT("用户名 : "+userName+" "+"密码 : "+password);
                    groupsndRequest.setSENDNO(employeeId);
                    TASCTLMsgSendResponse sendmessage =
                            SendMessageAdpter.sendmessage(groupsndRequest);
                    map.put("sendStatus",sendmessage.getTRANSTATUS());*/
                }
            }
        }catch (Exception e){
            throw new Exception("开启远程读取Excel文件接口异常:",e);
        }
        log.info("openDistinctExcel : "+map);
        return map;
    }

    /**
     * 唯一编码
     */
    public static String uniquenessCode(String id)
    {
        return UUID.randomUUID().toString() +"_"+id;
    }


    public HashMap<String, String> transformUpperCase(HashMap<String, String> orgMap) throws Exception{
        HashMap<String, String> resultMap = new HashMap<>();

        if (orgMap == null || orgMap.isEmpty()) {
            return resultMap;
        }

        Set<String> keySet = orgMap.keySet();
        for (String key : keySet) {
            String newKey = key.toLowerCase();
            if("open_distinct".equals(newKey)){
                String dictLabel = iSysDictDataService.selectDictLabel
                        ("token_openDistinct", orgMap.get(key));
                resultMap.put(newKey, dictLabel);
                continue;
            }
            if ("approval_status".equals(newKey)){
                String dictLabel = iSysDictDataService.selectDictLabel
                        ("token_approval_status", orgMap.get(key));
                resultMap.put(newKey,dictLabel);
                continue;
            }
            //newKey = newKey.replace("_", "");
            resultMap.put(newKey, orgMap.get(key));
        }

        return resultMap;
    }



    /**
     * biaozhunhuaqingdang
     * @param args
     * @throws Exception
     */


    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度） 科技主管团队分组详情
     */
    //@RequiresPermissions("forts:inventory:list")
    @GetMapping("/seletescienceChargeTeam")
    @ResponseBody
    @ApiOperation("查询科技主管团队分组信息")
    public TableDataInfo seletescienceChargeTeam() {
        List<String> list = tokenSystemInventoryService.seletescienceChargeTeam();
        List<String> lists = new ArrayList<>();
        for (String str : list){
            if (str.indexOf(",") != -1){
                lists.add(romoveDist(str,","));
            }else if (str.indexOf("、") != -1){
                lists.add(romoveDist(str,"、"));
            }else{
                lists.add(str);
            }
        }
        return getDataTable(lists);
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度） 科技主管团队分组的系统详情
     */
    //@RequiresPermissions("forts:inventory:list")
    @PostMapping("/seletesystemName")
    @ResponseBody
    @ApiOperation("根据系统名称查询系统详情")
    //public TableDataInfo seletesystemName(String systemName) {
    public TableDataInfo seletesystemName(@RequestBody com.ruoyi.common.json.JSONObject param) {
        com.ruoyi.common.json.JSONObject note = param.getObj("note");
        String systemName = note.getStr("systemName");
        TokenSystemInventory tokenSystemInventory = new TokenSystemInventory();
        List<TokenSystemInventory> list = new ArrayList<>();
        if (systemName != null && !systemName.equals("")) {
            tokenSystemInventory.setSystemName(systemName);
            //list = tokenSystemInventoryService.selectTokenSystemInventoryList(tokenSystemInventory);
            list = tokenSystemInventoryService.selectNameInventoryList(tokenSystemInventory);
            changes(list);
        }
        return getDataTable(list);
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度） 科技主管团队分组的人员详情
     */
    //@RequiresPermissions("forts:inventory:list")
    @PostMapping("/seletsperson")
    @ResponseBody
    @ApiOperation("跟据人员信息查看详情")
    // public TableDataInfo seletsposon(String maintainUserId) {
    public TableDataInfo seletsperson(@RequestBody com.ruoyi.common.json.JSONObject param) {
        com.ruoyi.common.json.JSONObject note = param.getObj("note");
        String maintainUserId = note.getStr("maintainUserId");
        TokenSystemInventory tokenSystemInventory = new TokenSystemInventory();
        List<TokenSystemInventory> list = new ArrayList<>();
        //Set<TokenSystemInventory> lists = new HashSet<>(list);
        if (maintainUserId != null && !("").equals(maintainUserId)) {
            tokenSystemInventory.setMaintainUserId(maintainUserId);
            list = tokenSystemInventoryService.selectTokenSystemInventoryList(tokenSystemInventory);
            changes(list);
        }
        return getDataTable(list);
    }

    public void changes(List<TokenSystemInventory> list) {
        if (list.size() != 0) {
            for (TokenSystemInventory t : list) {
                String useMaintainStaff = t.getUseMaintainStaff();
                useMaintainStaff = romoveDist(useMaintainStaff,"、");
                if (useMaintainStaff != null && !("").equals(useMaintainStaff)) {
                    String[] split = useMaintainStaff.split("、");
                    t.setUseMaintainStaffs(split);
                }
                String maintainUserId = t.getMaintainUserId();
                maintainUserId = romoveDist(maintainUserId,",");
                if (maintainUserId != null && !("").equals(maintainUserId)) {
                    String[] maintainUserIds = maintainUserId.split(",");
                    String[] useMaintainStaffs = t.getUseMaintainStaffs();
                    for (int i = 0; i < maintainUserIds.length; i++) {
                        String aa = maintainUserIds[i];
                        String ss = aa.replaceFirst("0", "");
                        String phone = fortService.selectPhone(ss);
                        String str = useMaintainStaffs[i] + "," + maintainUserIds[i]+","+phone;
                        //log.info("=============>>>"+str);
                        useMaintainStaffs[i] = str;
                    }
                    t.setUseMaintainStaffs(useMaintainStaffs);
                }
            }
        }
    }

    public void change(List<TokenSystemInventory> list) {
        if (list.size() != 0) {
            for (TokenSystemInventory t : list) {
                String useMaintainStaff = t.getUseMaintainStaff();
                useMaintainStaff = romoveDist(useMaintainStaff,"、");
                if (useMaintainStaff != null && !("").equals(useMaintainStaff)) {
                    String[] split = useMaintainStaff.split("、");
                    t.setUseMaintainStaffs(split);
                }
                String maintainUserId = t.getMaintainUserId();
                maintainUserId = romoveDist(maintainUserId,",");
                if (maintainUserId != null && !("").equals(maintainUserId)) {
                    String[] maintainUserIds = maintainUserId.split(",");
                    String[] useMaintainStaffs = t.getUseMaintainStaffs();
                    for (int i = 0; i < maintainUserIds.length; i++) {
                        String str = useMaintainStaffs[i] + "," + maintainUserIds[i];
                        useMaintainStaffs[i] = str;
                    }
                    t.setUseMaintainStaffs(useMaintainStaffs);
                }
            }
        }
    }

    @GetMapping("/seletegradeClassify")
    @ResponseBody
    @ApiOperation("查询等级分类分组信息")
    public TableDataInfo seletegradeClassify() {
        List<String> list = tokenSystemInventoryService.seletegradeClassify();
        return getDataTable(list);
    }

    @GetMapping("/seletetype")
    @ResponseBody
    @ApiOperation("查询类型信息")
    public TableDataInfo seletetype() {
        List<String> list = tokenSystemInventoryService.seletetype();
        List<String> list1 = new ArrayList<>();
        if (list.contains("前台")){
            list1.add("前台");
        }
        if (list.contains("中台")){
            list1.add("中台");
        }
        if (list.contains("后台")){
            list1.add("后台");
        }
       for(String str:list){
           if (!list1.contains(str) && !("其他").equals(str)){
                list1.add(str);
           }
       }
        if (list.contains("其他")){
            list1.add("其他");
        }
        return getDataTable(list1);
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度） 科技主管团队分组的人员详情
     */
    //@RequiresPermissions("forts:inventory:list")
    @PostMapping("/seletescienceCharge")
    @ResponseBody
    @ApiOperation("跟据科技主管团队分组和(人员或系统)搜索详情")
    //public TableDataInfo seletescienceCharge(String scienceChargeTeam,String msg) {
    public TableDataInfo seletescienceCharge(@RequestBody com.ruoyi.common.json.JSONObject param) {
        com.ruoyi.common.json.JSONObject note = param.getObj("note");
        String scienceChargeTeam = note.getStr("scienceChargeTeam");
        String msg = note.getStr("msg");
        int num = 0;//记录查询出得信息属于哪个团队
        TokenSystemInventory tokenSystemInventory = new TokenSystemInventory();
        tokenSystemInventory.setScienceChargeTeam(scienceChargeTeam);
        tokenSystemInventory.setUseMaintainStaff(msg);
        tokenSystemInventory.setSystemName(msg);
        tokenSystemInventory.setSystemAbbreviation(msg);
        List<TokenSystemInventory> list = new ArrayList<>();
        if (!((scienceChargeTeam == null | ("").equals(scienceChargeTeam)) && (msg == null | ("").equals(msg)))) {
            list = tokenSystemInventoryService.seletescienceChargeTeamorperson(tokenSystemInventory);
            if (list.size() != 0) {
                List<String> team = tokenSystemInventoryService.seletescienceChargeTeam();
                TokenSystemInventory tokenSystemInventory1 = list.get(0);
                for (int i = 0; i < team.size(); i++) {
                    if (team.get(i).equals(tokenSystemInventory1.getScienceChargeTeam())) {
                        num = i;
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    TokenSystemInventory t = list.get(i);
                    String systemName = (i + 1) + "." + t.getSystemName();
                    t.setSystemName(systemName);
                    t.setNum(num);
                }
                changes(list);
            }
        }
        return getDataTable(list);
    }

    @PostMapping("/seleteClassTybe")
    @ResponseBody
    @ApiOperation("根据等级分类和类型模糊查询和人信息查询")
    //public TableDataInfo seleteClassTybe(String gradeClassify,String type,String maintainUserId){
    public TableDataInfo seleteClassTybe(@RequestBody com.ruoyi.common.json.JSONObject param) {
        com.ruoyi.common.json.JSONObject note = param.getObj("note");
        String gradeClassifys = note.getStr("gradeClassifys");
        String types = note.getStr("types");
        String maintainUserId=note.getStr("maintainUserId");
        List<String>gradeClassifys1=new ArrayList<>();
        List<String>types1=new ArrayList<>();
        if (gradeClassifys!=null&&!("").equals(gradeClassifys)){
            String[] split = gradeClassifys.split(",");
            gradeClassifys1=Arrays.asList(split);
        }
        if (types!=null&&!("").equals(types)){
            String[] split = types.split(",");
            types1=Arrays.asList(split);
        }
        TokenSystemInventorySo tokenSystemInventorySo=new TokenSystemInventorySo(gradeClassifys1,types1,maintainUserId);
        List<TokenSystemInventory> list = tokenSystemInventoryService.selectTokenSystemInventoryLi(tokenSystemInventorySo);
        for (int i = 0; i < list.size(); i++) {
            TokenSystemInventory t = list.get(i);
            String systemName = (i + 1) + "." + t.getSystemName();
            t.setSystemName(systemName);
        }
        changes(list);
        return getDataTable(list);
    }

    @ApiOperation("根据团队搜索人员")
    @PostMapping("/SertchEmployeeByStaff")
    @ResponseBody
    public ModelMap SertchEmployeeByStaff(@RequestBody String json) {
        ModelMap model = new ModelMap();
        List<String> list = new ArrayList<>();
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
            String chargeStaff = note.getString("chargeStaff");
            List<HashMap> infoByStaff = fortService.getInfoByStaff(chargeStaff);
            if (null != infoByStaff && infoByStaff.size() > 0){
                for (HashMap<String,String> map:infoByStaff) {
                    String userId = map.get("MAINTAIN_USER_ID");
                    String userName = map.get("USE_MAINTAIN_STAFF");
                    String ss = userId.replaceFirst("0", "");
                    String phone = fortService.selectPhone(ss);
                    String listAll = userName+","+userId+","+phone;
                    list.add(listAll);
                }
            }
            model.put("code","0");
            model.put("infoByStaff",list);
        }catch (Exception e){
            log.error("根据团队搜索人员接口异常:",e);
        }
        return model;
    }

    @PostMapping("/selectApplyInfo")
    @ResponseBody
    @ApiOperation("查询审批令牌数据")
    public ModelMap selectApplyInfo(@RequestBody String json) {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询审批令牌数据失败";
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
//            String userId = note.getString("userId");
            String seqNo = note.getString("seqNo");
            HashMap<String, String> map = fortService.selectInfoBySeqno(seqNo);
            code = "0";
            model.put("list",map);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("msg",msg);
        }
        model.put("code",code);
        log.info("selectApplyInfo model : "+model);
        return model;
    }

    @PostMapping("/sendMsg")
    @ResponseBody
    @ApiOperation("测试发送消息")
    public static void sendMsg(String idno, String msg,String link) {
        try {
            JSONObject map = new JSONObject();
            map.put("huang","黄");
            map.put("yi","黄1");
            map.put("chao","黄2");
            String aa = "http://172.20.10.3:8081#/bossApproval";
            sendsMessages(idno,"测试","呵呵",link_launchApp+"?map="+map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendsMessages(String userId, String tag, String content,String link) throws Exception {
        String transtatus = "";
        List<String> nos = new ArrayList<>();
        try {
            //获取上级领导信息
            if (StringUtils.isNotEmpty(userId)) {
                userId = userId.replaceFirst("0", "");
            }
            log.info("userId ====>>> " + userId);
            String ldUserId = "01010314";
            for (int i =0;i<2;i++){
                if (i == 0){
                    nos.add("01010314");
                }else{
                    nos.add("01010245");
                }
            }
            /*List<HashMap<String, String>> twoOrgInfomation = fortService.getTwoOrgInfomation(userId);
            for (HashMap<String, String> hashMap : twoOrgInfomation) {
                String ldUserId = hashMap.get("USER_ID");
                if (StringUtils.isNotBlank(ldUserId)) {
                    ldUserId = ldUserId.startsWith("0") ? ldUserId : "0" + ldUserId;
                }*/
                //nos.add(ldUserId);
                log.info("sendmessage ldUserId : " + ldUserId);
           // }
            /*//将数组转为字符串并用“,”分隔
            String newnos = String.join(",", nos.toArray(new String[nos.size()]));
            GROUPSNDRequest groupsndRequest = new GROUPSNDRequest();
            groupsndRequest.setSENDCONTENT(content);    //内容
            groupsndRequest.setSENDTAG(tag);//标题
            groupsndRequest.setSENDNO(newnos);
            groupsndRequest.setCONTENT3(link);
            log.info("sendmessage : content : " + content);
            log.info("sendmessage : tag : " + tag);
            log.info("sendmessage : link : =================>"+link);
            TASCTLMsgSendResponse sendmessage =
                    SendMessageAdpter.sendmessage(groupsndRequest);*/
            PushMessageResponse sendmessage = EsbSendMessage.esbSendMessage(nos, "哈哈", "呵呵", "测试",
                    link);
            transtatus = sendmessage.getTRANSTATUS();
            String errormsg = sendmessage.getERRORMSG();
            log.info("transtatus : ===========>>>"+transtatus);
            log.info("sendmessage   :  " + sendmessage.toString()+
                    "errormsg : "+errormsg);
        } catch (Exception e) {
            throw new Exception();
        }
        return transtatus;
    }

    private static String romoveDist(String str,String reg){
        String[] strs=str.split(reg);
        Set<String> set=new LinkedHashSet<>();
        for(int i=0;i<strs.length;i++){
            set.add(strs[i]);
        }
        StringBuffer sb=new StringBuffer();
        Iterator it=set.iterator();
        while(it.hasNext()){
            sb.append(it.next());
            sb.append(reg);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public boolean newAndOldSwitch() throws Exception {
        boolean bl = false;
        try{
            String token_date_switch = configService.selectConfigByKey("token_date_switch");
            log.info("token_date_switch : "+token_date_switch);
            if (StringUtils.isBlank(token_date_switch)){
                return bl;
            }
            if ("off".equals(token_date_switch)){
                return true;
            }
            String startDate = iSysDictDataService.selectDictLabel("token_newAndOld_date", "start_newToken_date");
            log.info("startDate : "+startDate);
            String endDate = iSysDictDataService.selectDictLabel("token_newAndOld_date", "end_newToken_date");
            log.info("endDate : "+endDate);
            if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
                return bl;
            }
            log.info("compTime(startDate,endDate) : "+compTime(startDate,endDate));
            return true == compTime(startDate,endDate) ? false : true;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static boolean compTime(String startDate,String endDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Calendar date = Calendar.getInstance();
            date.setTime(sdf.parse(sdf.format(new Date())));

            Calendar begin = Calendar.getInstance();
            begin.setTime(sdf.parse(startDate));

            Calendar end = Calendar.getInstance();
            end.setTime(sdf.parse(endDate));
            if (date.after(begin) && date.before(end)){
                return true;
            }
            return false;
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse("20200417 10:00:00"));
        cal.add(Calendar.MINUTE,-2);
        System.out.println("========>>>"+sdf.format(cal.getTime()));
    }


}
