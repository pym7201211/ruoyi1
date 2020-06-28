package com.ruoyi.urgencyforts.until;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonObject;
import com.ruoyi.common.httpClient.HttpClientUtils;
import com.ruoyi.common.httpClient.HttpHeader;
import com.ruoyi.common.httpClient.HttpUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.outRegistration.domain.OutRegistration;
import com.ruoyi.ruoyiforts.domain.TokenApplyForms;
import com.ruoyi.ruoyiforts.mapper.FortMapper;
import com.ruoyi.ruoyiforts.service.FortService;
import com.ruoyi.ruoyiforts.until.FortDetailedListUntil;
import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.mapper.SysConfigMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.urgencyforts.domain.UrgencyAlteratRegisters;
import com.ruoyi.urgencyforts.domain.UrgencyAlteratVerifys;
import com.ruoyi.urgencyforts.domain.UrgencyImageSystem;
import com.ruoyi.urgencyforts.domain.UrgencyTask;
import com.ruoyi.urgencyforts.mapper.UrgencyMapper;
import com.ruoyi.urgencyforts.mapper.UrgencyTaskMapper;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import com.ruoyi.wsdl.esbService.PushMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class UrgencyUntil {
    protected final static Logger log = LoggerFactory.getLogger(UrgencyUntil.class);
    private static final String link_launchApp = "launchApp://lingpaiapply$$#/jjbgApproval";
    private static final String link_launchApp_approval = "launchApp://lingpaiapply$$#/AccordingDetails";

    /**
     * 获取返回接口状态信息
     * @param code
     * @param msg
     * @return
     */
    public static JSONObject resultStatus(String code,String msg){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        return json;
    }

    public static ModelMap resultModelMap(JSONObject jsonObject){
        ModelMap modelMap =  new ModelMap();
        if (null != jsonObject && jsonObject.containsKey("code")){
            String code = jsonObject.getString("code");
            String msg = jsonObject.getString("msg");
            modelMap.put("code",code);
            modelMap.put("msg",msg);
        }
        return modelMap;
    }

    /**
     * 校验客户端传入的参数
     * @param json
     * @return
     * @throws Exception
     */
    public static JSONObject clientJsonParams(String json) throws Exception {
        if (null == json || "".equals(json)){
            throw new IllegalArgumentException("getSystemName json is null");
        }
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject jsonNote = (JSONObject) jsonObject.get("note");
                jsonNote.put("code","0");
                return jsonNote;
            }else {
                return resultStatus("1","客户端传入json错误");
            }
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static JSONObject checkClientParams(String json) throws Exception {
        try {
            if (StringUtils.isNotBlank(json)) {
                JSONObject jsonObject = JSON.parseObject(json);
                if (null != jsonObject && jsonObject.containsKey("notes")) {
                    JSONObject jsonNote = (JSONObject) jsonObject.get("notes");
                    jsonNote.put("code", "0");
                    return jsonNote;
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return null;
    }

    /**
     * 获取姓名和id
     * @param list
     * @return
     * @throws Exception
     */
    public static List getUserInfos(List<HashMap<String,String>> list) throws Exception{
        List lists = new ArrayList();
        try{
            if (null == list || list.isEmpty()){
                return list;
            }
            for (HashMap<String,String> map:list) {
                Map<String,String> maps = new HashMap<>();
                maps.put("userId",map.get("USER_ID"));
                maps.put("userName",map.get("USER_NAME"));
                lists.add(maps);
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return lists;
    }

    public static List getUserLists(List<HashMap<String,String>> list) throws Exception{
        List lists = new ArrayList();
        try{
            if (null == list || list.isEmpty()){
                return null;
            }
            for (HashMap<String,String> map:list) {
                lists.add(map.get("USER_ID")+","+map.get("USER_NAME"));
            }
            String[] strings = new String[lists.size()];
            lists.toArray(strings);
        }catch (Exception e){
            throw new Exception(e);
        }
        return lists;
    }


    /**
     * 添加紧急变更实体类数据
     * @param jsonClient
     * @return
     */
    public static UrgencyAlteratRegisters urgencyDemos(JSONObject jsonClient) throws Exception {
        try{
            log.info("jsonClient : "+jsonClient);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String systemName = jsonClient.getString("systemName");
            String operatorId = jsonClient.getString("operatorId");
            String operator = jsonClient.getString("operator");
            String reviewerId = jsonClient.getString("reviewerId");
            if (StringUtils.isNotBlank(reviewerId)){
                reviewerId = reviewerId;
            }
            String reviewer = jsonClient.getString("reviewer");
            String orderNo = jsonClient.getString("orderNo");
            String urgencyDate = sdf.format(new Date());
            String executor = jsonClient.getString("executor");
            String startTime = jsonClient.getString("startTime");
            String endTime = jsonClient.getString("endTime");
            String urgencyFunDescribe = jsonClient.getString("urgencyFunDescribe");
            String cooperateItems = jsonClient.getString("cooperateItems");
            String codeAudit = jsonClient.getString("codeAudit");
            String finishTheTest = jsonClient.getString("finishTheTest");
            String pressureTest = jsonClient.getString("pressureTest");
            String businessOperation = jsonClient.getString("businessOperation");
            String handbookUpdate = jsonClient.getString("handbookUpdate");
            String riskDescribe = jsonClient.getString("riskDescribe");
            String sendBackScheme = jsonClient.getString("sendBackScheme");
            String urgencySponsorDept = jsonClient.getString("urgencySponsorDept");

            UrgencyMapper urgencyMapperBean =  SpringUtils.getBean("urgencyMapper");
            String internetUrgency = jsonClient.getString("internetUrgency");
            String securityTeamId = "";
            if ("1".equals(internetUrgency)){
                securityTeamId = urgencyMapperBean.getSecurityBigDataId("100011702");
                if (StringUtils.isNotBlank(securityTeamId)){
                    securityTeamId = securityTeamId;
                }
            }
            String securityTeam = jsonClient.getString("securityTeam");
            String dataUrgency = jsonClient.getString("dataUrgency");
            String bigDataTeamId = "";
            if ("1".equals(dataUrgency)){
                bigDataTeamId = urgencyMapperBean.getSecurityBigDataId("10001170901");
                if (StringUtils.isNotBlank(bigDataTeamId)){
                    bigDataTeamId = bigDataTeamId;
                }
            }
            String involveSystem = jsonClient.getString("involveSystem");
            String bigDataTeam = jsonClient.getString("bigDataTeam");
            String involveSystemIllustrate = jsonClient.getString("involveSystemIllustrate");
            String status = jsonClient.getString("status").trim();
            //String orderNo = jsonClient.getString("orderNo");
            String teamCharge = jsonClient.getString("teamCharge");
            String teamBranched = jsonClient.getString("teamBranched");
            String chargeLeader = jsonClient.getString("chargeLeader");
//            String manageStatus = jsonClient.getString("manageStatus");
            String manageStatus = "";
//            String currentTask = jsonClient.getString("currentTask");
            String currentTask = "";
            String executorId = jsonClient.getString("executorId");
            /*if (StringUtils.isNotBlank(executorId)){
                executorId = executorId.startsWith("0") ? executorId : "0"+executorId;
            }*/
            String teamBranchedId = jsonClient.getString("teamBranchedId");
            String chargeLeaderId = jsonClient.getString("chargeLeaderId");
            String teamChargeId = jsonClient.getString("teamChargeId");
            if (StringUtils.isNotBlank(teamChargeId)){
                teamChargeId = teamChargeId;
            }

            //String orderNo = getUuid(operatorId);

            UrgencyMapper urgencyMapper = SpringUtils.getBean("urgencyMapper");
            String maxOrderNum = urgencyMapper.getMaxOrderNum(operatorId);
            String orderNum = getMaxOrderNum(maxOrderNum);

            UrgencyAlteratRegisters urgencyAlteratRegisters = new UrgencyAlteratRegisters(
                    systemName,operatorId,operator,reviewerId,reviewer,orderNum,urgencyDate,executor,startTime,
                    endTime,urgencyFunDescribe,cooperateItems,codeAudit,finishTheTest,pressureTest,businessOperation,
                    handbookUpdate,riskDescribe,sendBackScheme,urgencySponsorDept,internetUrgency,securityTeam,
                    dataUrgency,bigDataTeam,involveSystem,involveSystemIllustrate,status,orderNo,teamCharge,
                    teamBranched,chargeLeader,manageStatus,currentTask,executorId,teamBranchedId,chargeLeaderId,teamChargeId,
                    securityTeamId,bigDataTeamId,null);
            return urgencyAlteratRegisters;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static UrgencyAlteratVerifys insertUrgencyVerify(UrgencyAlteratRegisters urgencyAlteratRegisters){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String orderNo = urgencyAlteratRegisters.getOrderNo();
        String startTime = urgencyAlteratRegisters.getStartTime();
        String endTime = urgencyAlteratRegisters.getEndTime();
        String changeTime = startTime+" 至 "+endTime;
        UrgencyAlteratVerifys urgencyAlteratVerifys = newUrgencyAlteratVerifys(orderNo, changeTime, null, null, null,
                simpleDateFormat.format(new Date()),null, null, null, null, startTime, endTime);
        return urgencyAlteratVerifys;
    }

    public static UrgencyAlteratVerifys urgencyAlteratVerifys(JSONObject jsonObject){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String isHalt = jsonObject.getString("isHalt");
        String haltRange = jsonObject.getString("haltRange");
        String haltTime = jsonObject.getString("haltTime");
        String verifyScheme = jsonObject.getString("verifyScheme");
        String inforMost = jsonObject.getString("inforMost");
        String urgencySendDept = jsonObject.getString("urgencySendDept");
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String orderNum = jsonObject.getString("orderNum");
        UrgencyAlteratVerifys urgencyAlteratVerifys = newUrgencyAlteratVerifys(orderNum, null, isHalt, haltRange, haltTime,
                simpleDateFormat.format(new Date()),verifyScheme, inforMost, urgencySendDept, "1", startTime, endTime);
        return urgencyAlteratVerifys;
    }

    public static UrgencyAlteratVerifys newUrgencyAlteratVerifys(String orderNum, String changeTime, String isHalt, String haltRange,
                                                                 String haltTime, String verifyDate, String verifyScheme, String inforMost,
                                                                 String urgencySendDept, String verifyStatus,String startTime,String endTime){
        UrgencyAlteratVerifys urgencyAlteratVerifys = new UrgencyAlteratVerifys(orderNum, changeTime, isHalt, haltRange,
                haltTime, verifyDate,  verifyScheme,  inforMost, urgencySendDept,  verifyStatus, startTime, endTime);
        return urgencyAlteratVerifys;
    }


    /**
     * 获取uuid
     * @param id
     * @return
     */
    public static String getUuid(String id){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return id+"_"+uuid;
    }

    /**
     * 查询最大的序列号
     * @param maxOrderNum
     * @return
     */
    public static String getMaxOrderNum(String maxOrderNum){
        if (StringUtils.isBlank(maxOrderNum)){
            return "1";
        }
        int orderNum = Integer.parseInt(maxOrderNum);
        return String.valueOf(++orderNum);
    }

    /**
     * 将大写改小写
     * @param orgMap
     * @return
     * @throws Exception
     */
    public static HashMap<String, String> transformUpperCase(HashMap<String, String> orgMap) throws Exception{
        HashMap<String, String> resultMap = new HashMap<>();
        try{
            if (orgMap == null || orgMap.isEmpty()) {
                return resultMap;
            }

            Set<String> keySet = orgMap.keySet();
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                //newKey = newKey.replace("_", "");
                resultMap.put(newKey, orgMap.get(key));
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return resultMap;
    }

    /**
     * 发送紧急变更消息
     * @param teamId
     * @param link_launchApp
     * @return
     * @throws Exception
     */
    public static JSONObject sendUrgencyMessage(String teamId,String content,String link_launchApp) throws Exception {
        log.info("发送紧急变更消息 teamId : "+teamId);
        try{
            if (StringUtils.isNotBlank(teamId)){
                List<String> list = new ArrayList<>();
                list.add(teamId);
                Map<String, String> map = FortDetailedListUntil.esbSendMessage(list, content, "紧急变更", link_launchApp);
                if ("COMPLETE".equals(map.get("transtatus"))){
                    return  UrgencyUntil.resultStatus("0", "发送消息成功");
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return  UrgencyUntil.resultStatus("1", "发送分管审批消息失败");
    }

    /**
     * 审批后发送消息
     * @param userId
     * @param content
     * @param tag
     * @return
     * @throws Exception
     */
    public static JSONObject sendApprovalNotice(String userId,String content,String tag) throws Exception {
        try{
            if (StringUtils.isNotBlank(userId)){
                List<String> list = new ArrayList<>();
                list.add(userId);
                FortDetailedListUntil.esbSendMessage(list,content,tag,null);
                return  UrgencyUntil.resultStatus("0", "发送消息成功");
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return  UrgencyUntil.resultStatus("1", "发送分管审批消息失败");
    }

    public static JSONObject sendApprovalUser(String operator_id,String executor_id,String reviewer_id,String flag) throws Exception {
        try{
            List<String> list = new ArrayList<>();
            list.add(operator_id);
            list.add(executor_id);
            list.add(reviewer_id);

            if ("1".equals(flag)){
                for (String userId:list) {
                    JSONObject jsonObject = sendApprovalNotice(userId, "您申请的紧急变更已审批同意", "紧急变更审批回复");
                    if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }
                }
            }
            if ("2".equals(flag)){
                for (String userId:list) {
                    JSONObject jsonObject = sendApprovalNotice(userId, "您申请的紧急变更已审批拒绝", "紧急变更审批回复");
                    if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }
                }
            }
            if ("3".equals(flag)){
                for (String userId:list) {
                    JSONObject jsonObject = sendApprovalNotice(userId, "您申请的紧急变更已审批拒绝", "紧急变更审批回复");
                    if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return  UrgencyUntil.resultStatus("0", "发送消息成功");
    }

    /**
     * 紧急变更令牌申请
     *
     * @return
     */
    public static JSONObject urgencyApplyFort(Map<String,String> map,String openIncident,String orderNo){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm");
        JSONObject json = new JSONObject();
        String code = "1";
        String msg = "添加紧急变更令牌申请接口失败";
        try {
            if (null == map || map.size() <= 0){
                return null;
            }
            String employeeIds = map.get("EXECUTOR_ID");
            String proposers = map.get("EXECUTOR");
            String applyDate = sdf.format(new Date());
            //String openIncident = "jjbg";
            String applyEnvironment = "生产环境";
            String systemName = map.get("SYSTEM_NAME");
            String openDate = map.get("START_TIME");
            String endDate = map.get("END_TIME");
            String openInstructions = "紧急变更";
            String content = "开启时间:"+sd.format(sdf.parse(openDate))+" "+"\n"+
                    "结束时间:"+sd.format(sdf.parse(endDate))+" "+"\n"+
                    "系统名称:"+systemName+" "+"\n"+"开启事由:"+openIncident;
            if (StringUtils.isBlank(employeeIds)){
                json.put("code",code);
                json.put("msg","查询employeeId为空");
                return json;
            }
            int index = 0;
            String[] split = employeeIds.split(",");
            String[] splits = proposers.split(",");
            for (String employeeId : split){
                String proposer = splits[index];
                String tag = proposer+"自助开启令牌权限";

                TokenApplyForms tokenApplyForms = setDomain( employeeId, applyDate,  proposer,applyEnvironment, systemName,"0",
                        openInstructions,"",null,openDate, endDate, openIncident,"",
                        "0",null,null,"0",orderNo,"1");
                FortMapper fortService =  SpringUtils.getBean("fortMapper");
                fortService.insertTokenApplyForm(tokenApplyForms);

                openDate = getOpenDate(openDate, endDate);  //判断主管审批时间是否在开启时间和结束时间之内

                UrgencyTask urgencyTask = new UrgencyTask(employeeId, applyEnvironment, openDate, endDate,
                        content, "0", "紧急变更", tag, orderNo,new Date());
                UrgencyTaskMapper urgencyTaskMapper = SpringUtils.getBean("urgencyTaskMapper");
                urgencyTaskMapper.insertUrgencyTask(urgencyTask);
                index ++;
            }
            code = "0";
            msg = "添加成功";
        }catch (Exception e){
            log.error("添加令牌申请接口异常：",e);
        }
        json.put("code",code);
        json.put("msg",msg);
        return json;
    }

    public static String getOpenDate(String openDate,String endDate) throws Exception{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            Date newDate = new Date();
            /*if (newDate.before(sdf.parse(openDate))){
                return openDate;
            }*/
            if (newDate.after(sdf.parse(openDate)) && newDate.before(sdf.parse(endDate))){
                return sdf.format(newDate);
            }
            /*if (newDate.after(sdf.parse(endDate))){
                return sdf.format(newDate);
            }*/
            return openDate;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String getFormatDate(String date)throws Exception{
        try{
            SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(sd.parse(date));
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String beforeTime(String time) throws Exception{
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(sd.parse(time));
            cal.add(Calendar.MINUTE,-5);
            return sdf.format(cal.getTime());
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static JSONObject requireOpenDistinct1(String employeeId,String openDate,String endDate,
                                                  String tag,String content,String applyDate,String orderNo) throws Exception{
        try{
            JSONObject jsonObject = httpOpenDistinct(employeeId,beforeTime(openDate), getFormatDate(endDate));
            FortMapper fortMapper = SpringUtils.getBean("fortMapper");
            if (null != jsonObject && jsonObject.size() > 0){
                if ("2000".equals(jsonObject.getString("code"))){
                    Map<String,String> map = sendMessageLeader(employeeId, tag, content);
                    if (null == map || "1".equals(map.get("code"))){
                        return resultStatus("1","发送领导消息失败");
                    }
                    Map map1 = sendMessageSuccess(employeeId, applyDate, orderNo);
                    if (null ==map1 || !map1.containsKey("code")){
                        return resultStatus("1","发送员工消息失败");
                    }
                    fortMapper.updateApprovalInfoTask("1", "", "","",
                            "堡垒机成功", map.get("seNo"), orderNo);
                    return resultStatus("0","调用堡垒机接口成功");
                }
            }
            fortMapper.updateApprovalInfo("1", "", "","","堡垒机失败", orderNo);
            return resultStatus("1","调用堡垒机接口失败");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static JSONObject requireOpenDistinct(String employeeId,String applyEnvironment,String openDate,String endDate,
                                                 String tag,String content,String applyDate,String orderNo) throws Exception{
        try{
            JSONObject jsonObject = httpOpenDistinct(employeeId,applyEnvironment,openDate,endDate);
            FortMapper fortMapper = SpringUtils.getBean("fortMapper");
            if (null != jsonObject && jsonObject.size() > 0){
                if ("2000".equals(jsonObject.getString("code"))){
                    Map<String,String> map = sendMessageLeader(employeeId, tag, content);
                    if (null == map || "1".equals(map.get("code"))){
                        return resultStatus("1","发送领导消息失败");
                    }
                    Map map1 = sendMessageSuccess(employeeId, applyDate, orderNo);
                    if (null ==map1 || !map1.containsKey("code")){
                        return resultStatus("1","发送员工消息失败");
                    }
                    fortMapper.updateApprovalInfoTask("1", "", "","",
                            "堡垒机成功", map.get("seNo"), orderNo);
                    return resultStatus("0","调用堡垒机接口成功");
                }
            }
            fortMapper.updateApprovalInfo("1", "", "","","堡垒机失败", orderNo);
            return resultStatus("1","调用堡垒机接口失败");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static Map sendMessageSuccess(String employeeId,String applyDate,String orderNo) throws Exception {
        try{
            Map<String,String> map = sendsEmployeeAndLeaderMessage(employeeId, applyDate, "1",orderNo);
            return map;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static Map<String,String> sendMessageLeader(String employeeId,String tag,String content) throws Exception {
        try{
            Map<String,String> message = sendsMessage(employeeId,tag,content);
            return message;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 发送推送
     * @param userId
     * @param content
     * @return
     * @throws Exception
     */
    public static Map sendsMessage(String userId,String tag,String content) throws Exception{
        String transtatus = "";
        String seNo = "";
        Map<String,String> map = new HashMap<>();
        List<String> nos = new ArrayList<>();
        try{
            if (StringUtils.isBlank(userId)){
                map.put("code","1");
                map.put("msg","查询无发送消息领导号");
                return map;
            }
            //FortService fortService = SpringUtils.getBean("fortService");
            FortMapper fortMapper = SpringUtils.getBean("fortMapper");
            List<HashMap<String, String>> twoOrgInfomation = fortMapper.getTwoOrgInfomation(userId);
            if(null == twoOrgInfomation || twoOrgInfomation.size() == 0){
                map.put("code","1");
                map.put("msg","查询无发送消息领导号");
                return map;
            }
            log.info("sendsMessage twoOrgInfomation : "+twoOrgInfomation);
            for (HashMap<String, String> hashMap:twoOrgInfomation) {
                String ldUserId = hashMap.get("USER_ID");
                if (StringUtils.isNotBlank(ldUserId)){
                    ldUserId = ldUserId;
                }
                nos.add(ldUserId);
                log.info("sendmessage ldUserId : "+ldUserId);
            }
            PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag,
                    link_launchApp_approval);
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
            ta.setAddway("紧急变更流程");
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

    public static Map<String,String> paramMaps() throws Exception {
        try{

            SysDictDataMapper iSysDictDataService = SpringUtils.getBean("sysDictDataMapper");
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

    public static String selectConfigByKey(String configKey)
    {
        SysConfigMapper configMapper = SpringUtils.getBean("sysConfigMapper");
        SysConfig config = new SysConfig();
        config.setConfigKey(configKey);
        SysConfig retConfig = configMapper.selectConfig(config);
        return StringUtils.isNotNull(retConfig) ? retConfig.getConfigValue() : "";
    }

    /**
     * HTTPclient调用第三方堡垒机接口
     * @return
     * @throws Exception
     */
    public static JSONObject httpOpenDistinct(String userName,String openDate,String endDate) throws Exception{
        JSONObject json = new JSONObject();
        try {
            log.info("httpClient : "+openDate+" "+endDate);
            //ISysConfigService configService = SpringUtils.getBean("iSysConfigService");
            String urlPost = selectConfigByKey("token_fort_urlPost");
            String urlGet = selectConfigByKey("token_fort_urlGet");
            String urlPut = selectConfigByKey("token_fort_urlPut");
            String hostname = selectConfigByKey("token_fort_hostname");
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
            mapPut.put("validFrom",openDate);
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
    public static JSONObject httpOpenDistinct(String userName,String applyEnvironment,String openDate,String endDate) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject json = new JSONObject();
        try {
            SysDictDataMapper iSysDictDataService = SpringUtils.getBean("sysDictDataMapper");
            //ISysDictDataService iSysDictDataService = SpringUtils.getBean("iSysDictDataService");
            String apply_Environment_name = iSysDictDataService.selectDictLabel
                    ("token_applyEnvironment",applyEnvironment);
            String sufUrl = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", "sufUrl");
            String identity = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", applyEnvironment+"_identity");
            String token = iSysDictDataService.selectDictLabel
                    ("token_baoleiji_url", applyEnvironment+"_token");
            Map<String,String> map = new HashMap<>();
            map.put("valid_date1",sd.format(sdf.parse(openDate)));
            map.put("valid_date2",sd.format(sdf.parse(endDate)));
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
     * 审批后查询发送信息
     * @param employeeId
     * @param applyDate
     * @param approvalStatus
     * @return
     * @throws Exception
     */
    public static Map<String,String> sendsEmployeeAndLeaderMessage(String employeeId,
                                                                   String applyDate,String approvalStatus,String orderNo)throws Exception{
        Map map = new HashMap<>();
        try{
            String tag = "紧急变更审批回复";
            String content = "";
            if ("1".equals(approvalStatus)){
                content = "您于"+applyDate+"申请的紧急变更申请已审批通过,令牌已按申请时间开启.";
            }else {
                content = "您于"+applyDate+"申请的紧急变更申请已审批拒绝";
            }
            String sendStatus = esbSendApprovalMessage(employeeId, tag, content, orderNo);
            if ("COMPLETE".equals(sendStatus)){
                map.put("code","0");
            }
        }catch (Exception e){
            throw new Exception("查询审批后发送消息接口异常: ",e);
        }
        return map;
    }

    public static String esbSendApprovalMessage(String employeeId,String tag,String content,String orderNo) throws Exception {
        String sendStatus = "";
        List<String> nos = new ArrayList<>();
        nos.add(employeeId);
        try{
            PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag,
                    link_launchApp+"?position=runTeam?orderNo="+orderNo);
            sendStatus = pushMessageResponse.getTRANSTATUS();
        }catch (Exception e){
            throw new Exception("审批后发送消息审批后发送消息接口异常:",e);
        }
        return sendStatus;
    }

    /**
     * 添加调用影像系统表实体类
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public static UrgencyImageSystem imageSystemDemo(JSONObject jsonObject) throws Exception{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String orderNo = jsonObject.getString("orderNo");
            String userId = jsonObject.getString("userId");
            String folderName = jsonObject.getString("fileFolderes");
            String filePath = jsonObject.getString("filePath");
            String ecmBusCode = jsonObject.getString("ecmBusCode");
            String sendTime = sdf.format(new Date());
            String sendStatus = jsonObject.getString("sendStatus");
            UrgencyImageSystem urgencyImageSystem = new UrgencyImageSystem(orderNo, userId,
                    folderName, filePath, ecmBusCode,sendTime, sendStatus);
            return urgencyImageSystem;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String selectAffiliatedTeam(String userId) throws Exception{
        try{
            UrgencyMapper urgencyMapper = SpringUtils.getBean("urgencyMapper");
            List<String> team = urgencyMapper.selectAffiliatedTeam(userId);
            if (null != team && team.size() > 0){
                return team.get(0);
            }
            return null;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 拒绝时发送消息
     * @param reviewerId
     * @param operator
     * @param userName
     * @param orderNo
     * @return
     * @throws Exception
     */
    public static JSONObject sendReviewer(String reviewerId,String operator,String userName,String orderNo)throws Exception{
        try{
            String[] reviewerIds = reviewerId.split(",");
            for (String id : reviewerIds) {
                JSONObject jsonReviewers = UrgencyUntil.sendUrgencyMessage(id, operator+"申请的紧急变更申请已拒绝 拒绝人：" + userName,
                        link_launchApp+"?position=reviewer?orderNo="+orderNo);
                if ("1".equals(jsonReviewers.getString("code"))) {
                    return jsonReviewers;
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return UrgencyUntil.resultStatus("0", "发送复核人消息成功");
    }

    public static Date beforeDate(int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE,minute);
        Date time = calendar.getTime();
        return time;
    }

    public static boolean newAndOldSwitch() throws Exception {
        boolean bl = false;
        try{
            String token_date_switch = selectConfigByKey("token_date_switch");
            if (StringUtils.isBlank(token_date_switch)){
                return bl;
            }
            if ("off".equals(token_date_switch)){
                return true;
            }
            SysDictDataMapper iSysDictDataService = SpringUtils.getBean("sysDictDataMapper");
            String startDate = iSysDictDataService.selectDictLabel("token_newAndOld_date", "start_newToken_date");
            String endDate = iSysDictDataService.selectDictLabel("token_newAndOld_date", "end_newToken_date");
            if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
                return bl;
            }
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

    public static boolean belongDate(Date time) {
        boolean bl = false;
        if (time.before(beforeDate(30)) && time.after(beforeDate(-30))){
            bl = true;
        }
        return bl;
    }

    /**
     * 添加外包人员外出登记实体类数据
     * @param jsonClient
     * @return
     */
    public static OutRegistration registrationDemos(JSONObject jsonClient) {
        log.info("jsonClient : "+jsonClient);
        String departureSite = jsonClient.getString("departureSite");
        String projectManager = jsonClient.getString("projectManager");
        String companyName = jsonClient.getString("companyName");
        String staffName = jsonClient.getString("staffName");
        String destination = jsonClient.getString("destination");
        String burningTime = jsonClient.getString("burningTime");
        String endTime = jsonClient.getString("endTime");
        String startTime = jsonClient.getString("startTime");
        String cause = jsonClient.getString("cause");
        String remark = jsonClient.getString("remark");
        String otherDeparture = jsonClient.getString("otherDeparture");
        String otherDestination = jsonClient.getString("otherDestination");
        String otherCause = jsonClient.getString("otherCause");
        String operatorId = jsonClient.getString("operatorId");
        OutRegistration outRegistration = new OutRegistration(departureSite, projectManager, companyName,
                staffName, destination, burningTime, endTime, startTime, cause, remark, otherDeparture,
                otherDestination, otherCause, operatorId);
        return outRegistration;
    }

    public static void main(String[] args) throws Exception {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(new Date());//把当前时间赋给日历
        calendar.add(Calendar.MINUTE, -20);
        Date before7days = calendar.getTime();   //得到n前的时间
        boolean b = belongDate(before7days);
        System.out.println(b);*/
        String s = beforeTime("20200202 14:25:00");
        System.out.println(s);
    }

}
