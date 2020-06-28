package com.ruoyi.urgencyforts.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.git.ecss.sysobject.system.BasePageObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.ecss.ImagesAndBase64Transform;
import com.ruoyi.ecss.VisionSystem;
import com.ruoyi.ruoyiforts.until.FortDetailedListUntil;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.urgencyforts.domain.UrgencyAlteratRegisters;
import com.ruoyi.urgencyforts.domain.UrgencyAlteratVerifys;
import com.ruoyi.urgencyforts.domain.UrgencyImageSystem;
import com.ruoyi.urgencyforts.mapper.UrgencyImageSystemMapper;
import com.ruoyi.urgencyforts.mapper.UrgencyMapper;
import com.ruoyi.urgencyforts.mapper.UrgencyVerifyMapper;
import com.ruoyi.urgencyforts.service.UrgencyService;
import com.ruoyi.urgencyforts.until.UrgencyUntil;
import org.apache.shiro.crypto.hash.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UrgencyServiceImpl implements UrgencyService {

    protected final static Logger log = LoggerFactory.getLogger(UrgencyServiceImpl.class);

    private static final String link_launchApp = "launchApp://lingpaiapply$$#/jjbgApproval";
    private static int seq = 0;

    @Autowired
    private UrgencyMapper urgencyMapper;

    @Autowired
    private UrgencyVerifyMapper urgencyVerifyMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Autowired
    private UrgencyImageSystemMapper urgencyImageSystemMapper;

    /**
     * 查询系统名称和模糊查询
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getSystemName(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String userId = jsonClient.getString("userId");
            String systemName = jsonClient.getString("systemName");
            List<String> likeSystems = urgencyMapper.getLikeSystem(userId, systemName);
            if (null == likeSystems || likeSystems.size() <= 0){
                return UrgencyUntil.resultStatus("0","查询系统名称数据为空");
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",likeSystems);
            return jsonObject;
        }catch (Exception e){
            throw new Exception("查询系统名称和模糊查询接口异常： ",e);
        }
    }

    /**
     * 查询实施人
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getUserInfo() throws Exception {
        try{
            List<HashMap<String, String>> userInfo = urgencyMapper.getUserInfo(null);
            List userLists = UrgencyUntil.getUserLists(userInfo);
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            //jsonObject.put("list",userInfo);
            jsonObject.put("lists",userLists);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询复核人
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getReviewerInfo(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String userId = jsonClient.getString("userId");
            List<HashMap<String, String>> userInfo = urgencyMapper.getUserInfo(userId);
            List userLists = UrgencyUntil.getUserLists(userInfo);
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            //jsonObject.put("list",userInfo);
            jsonObject.put("lists",userLists);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询发起的部门
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getBusinessChargeDept() throws Exception {
        try{
            List<SysDictData> businessChargeDept = dictDataMapper.selectDictDataByType("urgency_allDept");
            //List<String> businessChargeDept = urgencyMapper.getBusinessChargeDept();
            List list = new ArrayList<>();
            if (null != businessChargeDept){
                for (SysDictData sys: businessChargeDept) {
                    Map<String,String> map = new HashMap<>();
                    /*map.put("allName",sys.getDictLabel());
                    map.put("deptName",sys.getDictValue());*/
                    list.add(sys.getDictLabel()+","+sys.getDictValue());
                }
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",list);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询团队主管领导信息
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject teamLeaderInfomation(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String userId = jsonClient.getString("userId");
            if (StringUtils.isBlank(userId)){
                return UrgencyUntil.resultStatus("1","客户端传入userId为空");
            }
            List<HashMap<String,String>> hashMap = urgencyMapper.teamLeaderInfomation(userId);
            if (null == hashMap || hashMap.size() <= 0){
                return UrgencyUntil.resultStatus("1","查询无团队领导数据");
            }

            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMap);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询分管和主管信息
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject responsibleChargeInfo(String json) throws Exception {
        List<HashMap<String,String>> responMap = null;
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }

            String userId = jsonClient.getString("userId");
            if (StringUtils.isBlank(userId)){
                return UrgencyUntil.resultStatus("1","客户端传入userId为空");
            }
            List<HashMap<String,String>> hashMap = urgencyMapper.teamLeaderInfomation(userId);
            if (null == hashMap || hashMap.size() <= 0){
                return UrgencyUntil.resultStatus("1","查询无团队领导数据");
            }
            HashMap<String, String> hashMap1 = hashMap.get(0);

//            String deptId = jsonClient.getString("deptId");
            String deptId = hashMap1.get("TWO_DEPT_ORG");
            String urgency_sci_tech = jsonClient.getString("urgency_sci_tech");
            if ("true".equals(urgency_sci_tech)){
                responMap = urgencyMapper.responsibleInfo(deptId);
                if (null == responMap || responMap.size() <= 0){
                    return UrgencyUntil.resultStatus("1","查询无分管领导数据");
                }
            }
            List<HashMap<String,String>> chargeMap = urgencyMapper.chargeInfo(null);
            if (null == chargeMap || chargeMap.size() <= 0){
                return UrgencyUntil.resultStatus("1","查询无变更主管管领导数据");
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMap1);
            if (null != responMap && responMap.size() > 0){
                jsonObject.put("responMap",responMap.get(0));
            }else{
                jsonObject.put("responMaps","false");
            }
            jsonObject.put("chargeMap",chargeMap.get(0));
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 添加变更表数据和发送消息并添加验证数据
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject insertUrgencyAlteratRegister(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            UrgencyAlteratRegisters urgencyAlteratRegisters = UrgencyUntil.urgencyDemos(jsonClient);
            int insertUrgency = urgencyMapper.insertUrgencyAlteratRegister(urgencyAlteratRegisters);
            if (insertUrgency > 0){
                String orderNo = urgencyAlteratRegisters.getOrderNo();
                String teamChargeId = urgencyAlteratRegisters.getTeamChargeId();
                String operator = urgencyAlteratRegisters.getOperator();
                String operatorId = urgencyAlteratRegisters.getOperatorId();

                List<String> list = new ArrayList<>();
                list.add(teamChargeId);
                //发送团队领导审批
                String position = "teamChargePos";
                if (StringUtils.isNotBlank(operatorId)){
                    operatorId = operatorId;
                }
                String affiliatedTeam = UrgencyUntil.selectAffiliatedTeam(operatorId);
                Map<String, String> map = FortDetailedListUntil.esbSendMessage(list, affiliatedTeam+operator + "申请紧急变更", "紧急变更审批",
                        link_launchApp+"?position="+position+"?orderNo="+orderNo);
                if ("COMPLETE".equals(map.get("transtatus"))){
                    UrgencyAlteratVerifys urgencyAlteratVerifys = UrgencyUntil.insertUrgencyVerify(urgencyAlteratRegisters);
                    int insertVerify = urgencyVerifyMapper.insertUrgencyAlteratVerify(urgencyAlteratVerifys);
                    JSONObject jsonObject = UrgencyUntil.resultStatus("0", "添加成功");
                    return insertVerify > 0 ? jsonObject : UrgencyUntil.resultStatus("1", "添加验证表失败");
                }
            }
            return UrgencyUntil.resultStatus("1","添加紧急变更表失败");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 获取审批页面数据
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getApprovalData(String json) throws Exception {
        String approvalStatus = "";
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String orderNo = jsonClient.getString("orderNo");
            String position = jsonClient.getString("position");
            //String userId = jsonClient.getString("userId");
            /*String teamChargeId = jsonClient.getString("teamChargeId");
            String teamBranchedId = jsonClient.getString("teamBranchedId");
            String chargeLeaderId = jsonClient.getString("chargeLeaderId");
            String securityTeamId = jsonClient.getString("securityTeamId");
            String bigDataTeamId = jsonClient.getString("bigDataTeamId");*/
            if (StringUtils.isBlank(orderNo)){
                return UrgencyUntil.resultStatus("1","客户端传入的流水号为空");
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            HashMap<String, String> approvalData = urgencyMapper.getApprovalData(orderNo);
            HashMap<String, String> hashMap = UrgencyUntil.transformUpperCase(approvalData);
            if (null != hashMap && hashMap.size() > 0){
                //String involve_system = hashMap.get("involve_system");
                String operator_id = hashMap.get("operator_id");
                if (StringUtils.isNotBlank(operator_id)){
                    List<String> team = urgencyMapper.selectAffiliatedTeam(operator_id);
                    hashMap.put("affiliatedTeam",team.get(0));
                }
                /*if (StringUtils.isNotBlank(involve_system)){
                }*/
                if ("teamChargePos".equals(position)){
                    approvalStatus = approvalData.get("TEAM_CHARGE_STATUS");
                }
                if ("teamBranchedPos".equals(position)){
                    approvalStatus = approvalData.get("TEAM_BRANCHED_STATUS");
                }
                if ("chargeLeaderPos".equals(position)){
                    approvalStatus = approvalData.get("CHARGE_LEADER_STATUS");
                }
                if ("securityTeamPos".equals(position)){
                    approvalStatus = approvalData.get("SECURITY_TEAM");
                }
                if ("bigDataTeamPos".equals(position)){
                    approvalStatus = approvalData.get("BIG_DATA_TEAM");
                }
                if ("runTeam".equals(position)){
                    approvalStatus = "";
                }
            }
            jsonObject.put("approvalStatus",approvalStatus);
            jsonObject.put("hashMap",hashMap);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 审批更改状态
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject updateSignStatus(String json) throws Exception {
        boolean flag = true;
        boolean noFlag = true;
        int iss = 0;
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            log.info("审批更改状态 impl jsonClient : "+jsonClient);
            String orderNo = jsonClient.getString("orderNo");
            String position = jsonClient.getString("position");
            String approvalStatus = jsonClient.getString("approvalStatus");
            String operatorId = jsonClient.getString("operatorId");
            String userName = jsonClient.getString("userName");
            String status = jsonClient.getString("status").trim();
            String teamChargeStatus = "";
            String teamBranchedStatus = "";
            String chargeLeaderStatus = "";
            String securityTeam = "";
            String securityTeams = "";
            String bigDataTeam = "";
            String bigDataTeams = "";
            String reviewerStatus = "";
            String teamBranchedId = jsonClient.getString("teamBranchedId");
            String chargeLeaderId = jsonClient.getString("chargeLeaderId");
            String securityTeamId = jsonClient.getString("securityTeamId");
            String bigDataTeamId = jsonClient.getString("bigDataTeamId");
            String reviewerId = jsonClient.getString("reviewerId");
            String internet_urgency = jsonClient.getString("internet_urgency");   //是否涉及互联网变更
            String data_urgency = jsonClient.getString("data_urgency");   //是否涉及数据变更

            if ("teamChargePos".equals(position)){
                teamChargeStatus = approvalStatus;
            }
            if ("teamBranchedPos".equals(position)){
                teamBranchedStatus = approvalStatus;
            }
            if ("chargeLeaderPos".equals(position)){
                chargeLeaderStatus = approvalStatus;
            }
            if ("securityTeamPos".equals(position)){
                securityTeams = approvalStatus;
            }
            if ("bigDataTeamPos".equals(position)){
                bigDataTeams = approvalStatus;
            }
            String operator = urgencyMapper.selectOperator(orderNo);
            String operatorIds = "";
            if (StringUtils.isNotBlank(operatorId)){
                operatorIds = operatorId;
            }
            String affiliatedTeam = UrgencyUntil.selectAffiliatedTeam(operatorIds);
                //若是团队主管审批
                if (StringUtils.isNotBlank(teamChargeStatus)){
                    if ("1".equals(teamChargeStatus)){
                        if ("1".equals(internet_urgency)){
                            JSONObject jsonSecurity = UrgencyUntil.sendUrgencyMessage(securityTeamId,affiliatedTeam+operator+"发起紧急变更申请",
                                    link_launchApp+"?position=securityTeamPos?orderNo="+orderNo);
                            if ("1".equals(jsonSecurity.getString("code"))){
                                return jsonSecurity;
                            }
                        }
                        if ("1".equals(data_urgency)){
                            JSONObject jsonBigData = UrgencyUntil.sendUrgencyMessage(bigDataTeamId,affiliatedTeam+operator+"发起紧急变更申请",
                                    link_launchApp+"?position=bigDataTeamPos?orderNo="+orderNo);
                            if ("1".equals(jsonBigData.getString("code"))){
                                return jsonBigData;
                            }
                        }
                    }else {
                        JSONObject jsonReviewer = UrgencyUntil.sendUrgencyMessage(operatorId, "您的紧急变更申请已拒绝 拒绝人：" + userName,
                                link_launchApp+"?position=operator?orderNo="+orderNo);
                        if ("1".equals(jsonReviewer.getString("code"))) {
                            return jsonReviewer;
                        }
                        JSONObject jsonObject = UrgencyUntil.sendReviewer(reviewerId, operator, userName, orderNo);
                        if ("1".equals(jsonObject.getString("code"))){
                            return jsonObject;
                        }
                        urgencyVerifyMapper.updateverifyStatus(orderNo);
                        noFlag = false;
                    }
                }
                //若是团队主管，安全团队，大数据管理团队
                if (StringUtils.isNotBlank(teamChargeStatus) ||
                        StringUtils.isNotBlank(securityTeams) ||
                        StringUtils.isNotBlank(bigDataTeams)){

                    if ("1".equals(approvalStatus)){
                        if ("1".equals(internet_urgency)){
                            securityTeam = "1";
                        }
                        if ("1".equals(data_urgency)){
                            bigDataTeam = "1";
                        }

                        if (StringUtils.isNotBlank(teamChargeStatus)){
                            securityTeams = "";
                            bigDataTeams = "";
                        }
                        if (StringUtils.isNotBlank(securityTeams)){
                            int i = urgencyMapper.updateSignStatus(orderNo, teamChargeStatus, teamBranchedStatus, chargeLeaderStatus,securityTeam,
                                    null,null);
                            if (i <= 0){
                                return UrgencyUntil.resultStatus("1", "添加失败");
                            }
                            flag = false;
                        }
                        if (StringUtils.isNotBlank(bigDataTeams)){
                            int i = urgencyMapper.updateSignStatus(orderNo, teamChargeStatus, teamBranchedStatus, chargeLeaderStatus,null,
                                    bigDataTeam,null);
                            if (i <= 0){
                                return UrgencyUntil.resultStatus("1", "添加失败");
                            }
                            flag = false;
                        }
                        int rewSecBigStatus = urgencyMapper.selectRewSecBigStatus(orderNo,securityTeam,bigDataTeam);
                        if (rewSecBigStatus > 0){
                            if ("true".equals(status)){
                                    JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(teamBranchedId, affiliatedTeam+operator+"发起紧急变更申请",
                                            link_launchApp+"?position=teamBranchedPos?orderNo="+orderNo);
                                    if ("1".equals(jsonBranched.getString("code"))){
                                        return jsonBranched;
                                    }
                            }else{
                                    JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(chargeLeaderId, affiliatedTeam+operator+"发起紧急变更申请",
                                            link_launchApp+"?position=chargeLeaderPos?orderNo="+orderNo);
                                    if ("1".equals(jsonBranched.getString("code"))){
                                        return jsonBranched;
                                    }
                                    urgencyMapper.updateManageStatus("1",orderNo);

                            }
                        }
                    }else{
                        if (noFlag){
                            JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(operatorId, "您的紧急变更申请已拒绝 拒绝人："+userName,
                                    link_launchApp+"?position=operator?orderNo="+orderNo);
                            if ("1".equals(jsonBranched.getString("code"))){
                                return jsonBranched;
                            }
                            JSONObject jsonObject = UrgencyUntil.sendReviewer(reviewerId, operator, userName, orderNo);
                            if ("1".equals(jsonObject.getString("code"))){
                                return jsonObject;
                            }
                        }
                        //为拒绝时更改验证状态
                        urgencyVerifyMapper.updateverifyStatus(orderNo);
                        int aa = urgencyMapper.updateSignStatus(orderNo, teamChargeStatus, teamBranchedStatus, chargeLeaderStatus,securityTeams,
                                bigDataTeams,reviewerStatus);
                        return aa > 0 ? UrgencyUntil.resultStatus("0", "添加成功") : UrgencyUntil.resultStatus("1", "添加失败");
                    }
                }
                //若是分管领导
                if (StringUtils.isNotBlank(teamBranchedStatus)){
                    if ("1".equals(teamBranchedStatus)){
                        JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(chargeLeaderId, affiliatedTeam+operator+"发起紧急变更申请",
                                link_launchApp+"?position=chargeLeaderPos?orderNo="+orderNo);
                        if ("1".equals(jsonBranched.getString("code"))){
                            return jsonBranched;
                        }
                        urgencyMapper.updateManageStatus("1",orderNo);
                    }else {
                        JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(operatorId, "您的紧急变更申请已拒绝 拒绝人：" + userName,
                                link_launchApp+"?position=operator?orderNo="+orderNo);
                        if ("1".equals(jsonBranched.getString("code"))) {
                            return jsonBranched;
                        }
                        JSONObject jsonObject = UrgencyUntil.sendReviewer(reviewerId, operator, userName, orderNo);
                        if ("1".equals(jsonObject.getString("code"))){
                            return jsonObject;
                        }
                        //为拒绝时更改验证状态
                        urgencyVerifyMapper.updateverifyStatus(orderNo);
                    }
                }
                //若是变更主管
                if (StringUtils.isNotBlank(chargeLeaderStatus)){
                    urgencyMapper.updateManageStatus("2",orderNo);
                    if ("1".equals(chargeLeaderStatus)){
                        HashMap<String, String> approvalData = urgencyMapper.getApprovalData(orderNo);
                        if (null != approvalData && approvalData.size() > 0){
                            if (StringUtils.isBlank(reviewerId)){
                                return UrgencyUntil.resultStatus("1", "查询发送消息复核人id失败");
                            }
                            String[] reviewerIds = reviewerId.split(",");
                            for (String id : reviewerIds) {
                                JSONObject jsonReviewers = UrgencyUntil.sendUrgencyMessage(id, affiliatedTeam+operator+"申请的紧急变更申请已通过 审批人：" + userName,
                                        link_launchApp+"?position=reviewers?orderNo="+orderNo);
                                if ("1".equals(jsonReviewers.getString("code"))) {
                                    return jsonReviewers;
                                }
                            }
                            String runTeam = urgencyMapper.selectRunTeam();
                            JSONObject jsonRunTeam = UrgencyUntil.sendUrgencyMessage(runTeam, affiliatedTeam+operator+"申请的紧急变更申请已通过 审批人：" + userName,
                                    link_launchApp+"?position=runTeam?orderNo="+orderNo);
                            if ("1".equals(jsonRunTeam.getString("code"))) {
                                return jsonRunTeam;
                            }
                            List<SysDictData> urgency_sendMessage = dictDataMapper.selectDictDataByType("urgency_sendMessage");
                            if (null != urgency_sendMessage && urgency_sendMessage.size() > 0){
                                for(int i = 0;i <urgency_sendMessage.size();i++){
                                    String label = urgency_sendMessage.get(i).getDictLabel();
                                    String value = urgency_sendMessage.get(i).getDictValue();
                                    JSONObject sendUrgencyMessage = UrgencyUntil.sendUrgencyMessage(value, affiliatedTeam+operator+"申请的紧急变更申请已通过 审批人：" + userName,
                                            link_launchApp+"?position=runTeam?orderNo="+orderNo);
                                    if ("1".equals(jsonRunTeam.getString("code"))) {
                                        continue;
                                    }
                                }
                            }
                            String openIncident = dictDataMapper.selectDictLabel("token_openIncident", "jjbg");
                            JSONObject jsonObject = UrgencyUntil.urgencyApplyFort(approvalData,openIncident,orderNo);
                            if ("0".equals(jsonObject.getString("code"))){
                                int i = urgencyMapper.updateSignStatus(orderNo, teamChargeStatus, teamBranchedStatus, chargeLeaderStatus,securityTeam,
                                        bigDataTeam,reviewerStatus);
                                if (i < 0){
                                    return UrgencyUntil.resultStatus("1", "添加失败");
                                }
                            }else{
                                return UrgencyUntil.resultStatus("0", jsonObject.getString("msg"));
                            }
                            return UrgencyUntil.resultStatus("0", "添加成功");
                        }
                    }else {
                        JSONObject jsonBranched = UrgencyUntil.sendUrgencyMessage(operatorId, "您的紧急变更申请已拒绝 拒绝人："+userName,
                                link_launchApp+"?position=reviewer?orderNo="+orderNo);
                        if ("1".equals(jsonBranched.getString("code"))){
                            return jsonBranched;
                        }
                        if (StringUtils.isBlank(reviewerId)){
                            return UrgencyUntil.resultStatus("1", "查询发送复核人id失败");
                        }
                        /*String[] reviewerIds = reviewerId.split(",");
                        for (String id : reviewerIds) {
                            JSONObject jsonReviewers = UrgencyUntil.sendUrgencyMessage(id, operator+"申请的紧急变更申请已拒绝 拒绝人：" + userName,
                                    link_launchApp+"?position=reviewer?orderNo="+orderNo);
                            if ("1".equals(jsonReviewers.getString("code"))) {
                                return jsonReviewers;
                            }
                        }*/
                        JSONObject jsonObject = UrgencyUntil.sendReviewer(reviewerId, operator, userName, orderNo);
                        if ("1".equals(jsonObject.getString("code"))){
                            return jsonObject;
                        }
                        //为拒绝时更改验证状态
                        urgencyVerifyMapper.updateverifyStatus(orderNo);
                    }
                }
                if (StringUtils.isNotBlank(teamChargeStatus)){
                    securityTeam = "";
                    bigDataTeam = "";
                }
                if (flag){
                    iss = urgencyMapper.updateSignStatus(orderNo, teamChargeStatus, teamBranchedStatus, chargeLeaderStatus,securityTeam,
                            bigDataTeam,reviewerStatus);
                    return iss > 0 ? UrgencyUntil.resultStatus("0", "添加成功") : UrgencyUntil.resultStatus("1", "添加失败");
                }else {
                    return UrgencyUntil.resultStatus("0", "添加成功");
                }
//            }
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询分管和主管审批状态
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getBranchChargeStatus(String json) throws Exception {
        boolean flagStatus = false;
        JSONObject jsonFlagStatus = null;
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String orderNo = jsonClient.getString("orderNo");
            HashMap<String, String> approvalData = urgencyMapper.getApprovalData(orderNo);
            if (null != approvalData && approvalData.size() > 0){
                String team_branched_status = approvalData.get("TEAM_BRANCHED_STATUS");
                String charge_leader_status = approvalData.get("CHARGE_LEADER_STATUS");
                String operator_id = approvalData.get("OPERATOR_ID");
                String executor_id = approvalData.get("EXECUTOR_ID");
                String reviewer_id = approvalData.get("REVIEWER_ID");
                if ("1".equals(team_branched_status) && "1".equals(charge_leader_status)){
                    JSONObject jsonObject = UrgencyUntil.sendApprovalUser(operator_id, executor_id, reviewer_id, "1");
                    flagStatus = true;
                    /*if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }*/
                }
                if ("2".equals(team_branched_status)){
                    JSONObject jsonObject = UrgencyUntil.sendApprovalUser(operator_id, executor_id, reviewer_id, "2");
                    /*if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }*/
                }
                if ("2".equals(charge_leader_status)){
                    JSONObject jsonObject = UrgencyUntil.sendApprovalUser(operator_id, executor_id, reviewer_id, "3");
                    /*if ("1".equals(jsonObject.getString("code"))){
                        return jsonObject;
                    }*/
                }
                if (flagStatus){
                    JSONObject jsonObject = UrgencyUntil.urgencyApplyFort(approvalData,"","");
                    if ("0".equals(jsonObject.getString("code"))){
                        jsonFlagStatus = UrgencyUntil.resultStatus("0", "添加成功");
                        jsonFlagStatus.put("flagStatus","true");
                    }else{
                        jsonFlagStatus = UrgencyUntil.resultStatus("0", jsonObject.getString("msg"));
                    }
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return jsonFlagStatus;
    }

    /**
     * 查询紧急变更历史
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject selectUrgencyHistory(String json) throws Exception {
        try{
            JSONObject jsonObject1 = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject1.get("note");

            String operatorId = note.getString("operatorId");
            String ip = "";
            if (StringUtils.isBlank(operatorId)){
                return UrgencyUntil.resultStatus("1", "operatorId为null");
            }
            List<HashMap<String, String>> hashMaps = urgencyMapper.selectUrgencyHistory(operatorId,ip);

            List<String> team = urgencyMapper.selectAffiliatedTeam(operatorId);

            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMaps);
            jsonObject.put("affiliatedTeam",team.get(0));
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询联合告警紧急变更历史
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject selectUrgencyIPHistory(String json) throws Exception {
        try{
            JSONObject jsonObject1 = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject1.get("note");
            String systemName = note.getString("service");
            if (StringUtils.isBlank(systemName)){
                return UrgencyUntil.resultStatus("1", "systemName为null");
            }
            List<HashMap<String, String>> urgencyIPList = urgencyMapper.selectUrgencyIPHistory(systemName);
            List<HashMap<String, String>> teamList = urgencyMapper.selectAffiliatedIPTeam(systemName);
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",urgencyIPList);
            jsonObject.put("affiliatedTeam",teamList);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询验证信息
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getVerifyData(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String orderNum = jsonClient.getString("orderNum");
            if (StringUtils.isBlank(orderNum)){
                return UrgencyUntil.resultStatus("1","客户端传入orderNum为空");
            }
            HashMap<String, String> verifyData = urgencyVerifyMapper.getVerifyData(orderNum);
            HashMap<String, String> hashMap = UrgencyUntil.transformUpperCase(verifyData);
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMap);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 提交验证
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject updateUrgencyAlteratVerify(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            UrgencyAlteratVerifys urgencyAlteratVerifys = UrgencyUntil.urgencyAlteratVerifys(jsonClient);
            int i = urgencyVerifyMapper.updateUrgencyAlteratVerify(urgencyAlteratVerifys);
            return i > 0 ? UrgencyUntil.resultStatus("0", "查询成功") : UrgencyUntil.resultStatus("1", "提交验证失败");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 查询紧急变更进度
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject selectUrgencyProcessSpeed(String json) throws Exception {
        JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
        if (!"0".equals(jsonClient.getString("code"))){
            return jsonClient;
        }
        String orderNo = jsonClient.getString("orderNo");
        if (StringUtils.isBlank(orderNo)){
            return UrgencyUntil.resultStatus("1","客户端传入orderNo为空");
        }
        HashMap<String, String> hashMap1 = urgencyMapper.selectUrgencyProcessSpeed(orderNo);
        HashMap<String, String> hashMap = UrgencyUntil.transformUpperCase(hashMap1);
        JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
        jsonObject.put("list",hashMap);
        return jsonObject;
    }

    /**
     * 查询部门号
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject selectTwoDeptOrg(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String userId = jsonClient.getString("userId");
            String twoDeptOrg = urgencyMapper.selectTwoDeptOrg(userId);
            if (StringUtils.isBlank(twoDeptOrg)){
                return UrgencyUntil.resultStatus("1","查询无部门号");
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("twoDeptOrg",twoDeptOrg);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 掉用影像系统
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject imagessystem(String json) throws Exception {
        String folderType = "";
        String folderName = "";
        try{
            JSONObject jsonClient = UrgencyUntil.checkClientParams(json);
            if (null != jsonClient){
                String images = jsonClient.getString("images");
                String userId = jsonClient.getString("userId");
                String fileFolder = jsonClient.getString("fileFolder");
                log.info("imagessystem jsonClient ========>>>"+userId + fileFolder);
                if (StringUtils.isBlank(images)){
                    JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
                    jsonObject.put("orderNo",UrgencyUntil.getUuid(userId));
                    return jsonObject;
                }
                String imgSysUrl = dictDataMapper.selectDictLabel("urgency_imgSys_url", "imgSysUrl");
                //String url = imgSysUrl + userId +"/" +getDate()+"/";
                String imgFilePath = ImagesAndBase64Transform.fileMkdirs(imgSysUrl);
                String allFilePath = "";
                String fileFolderes = "";
                if (StringUtils.isNotBlank(images)){
                    List<BasePageObject> pageObjects = new ArrayList<>();
                    String[] split = images.split(",");
                    for (int i = 0; i < split.length; i++) {
                        log.info("image ===========>>>"+split[i].length());
                        String namePic = getSeqNo(userId);
                        if (StringUtils.isNotBlank(fileFolder)){
                            String[] fileFolders = fileFolder.split(",");
                            String fileFolder1 = fileFolders[i];
                            log.info("fileFolder1 : "+fileFolder1);
                            folderType = StringUtils.substringAfter(fileFolder1,".");
                            folderName = StringUtils.substringBefore(fileFolder1,".");
                        }else{
                            folderType = "jpg";
                        }
                        String imgFilePaths = imgFilePath+namePic+"_"+folderName+"."+folderType;
                        log.info("imgFilePath : "+imgFilePaths);
                        boolean bl = ImagesAndBase64Transform.GenerateImage(split[i], imgFilePaths);
                        if (bl == false){
                            return UrgencyUntil.resultStatus("1", "base64转图片失败");
                        }
                        if ("".equals(folderName)){
                            folderName = namePic;
                        }
                        BasePageObject basePageObject = VisionSystem.setPageObject(imgFilePaths, folderName,folderType);
                        pageObjects.add(basePageObject);
                        allFilePath = allFilePath + imgFilePaths+",";
                        fileFolderes = fileFolderes + namePic+"_"+folderName+"."+folderType + ",";
                    }
                    JSONObject addJson = VisionSystem.add(userId, pageObjects);
                    jsonClient.put("filePath",allFilePath.substring(0,allFilePath.length()-1));
                    jsonClient.put("ecmBusCode",addJson.getString("ecmBusCode"));
                    jsonClient.put("fileFolderes",fileFolderes.substring(0,fileFolderes.length()-1));
                    if ("0".equals(addJson.getString("code"))) {
                        jsonClient.put("sendStatus","调用影像系统成功");
                    }else{
                        jsonClient.put("sendStatus","调用影像系统失败");
                    }
                    String uuid = UrgencyUntil.getUuid(userId);
                    jsonClient.put("orderNo",uuid);
                    UrgencyImageSystem urgencyImageSystem = UrgencyUntil.imageSystemDemo(jsonClient);
                    urgencyImageSystemMapper.insertUrgencyImageSystem(urgencyImageSystem);
                    if ("0".equals(addJson.getString("code"))){
                        JSONObject jsonObject = UrgencyUntil.resultStatus("0", "上传影像成功");
                        jsonObject.put("orderNo",uuid);
                        return jsonObject;
                    }else {
                        return UrgencyUntil.resultStatus("1",addJson.getString("msg"));
                    }
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return UrgencyUntil.resultStatus("0", "无影像上传");
    }

    @Override
    public JSONObject viewPicture(String json) throws Exception {
        try{
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String orderNo = jsonClient.getString("orderNo");
            String str = urgencyMapper.viewPicture(orderNo);
            String viewAnnex = StringUtils.isBlank(str) ? "false" : "true";
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",str);
            jsonObject.put("viewAnnex",viewAnnex);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject noApprovalData() throws Exception {
        try{
            JSONObject jsonObject = new JSONObject();
            List<HashMap<String,String>> list = new ArrayList<>();
            List<HashMap<String, String>> hashMaps = urgencyMapper.noApprovalData();
            for (HashMap<String,String> hashMap : hashMaps) {
                String operator_id = hashMap.get("OPERATOR_ID");
                if (StringUtils.isNotBlank(operator_id)){
                    List<String> team = urgencyMapper.selectAffiliatedTeam(operator_id);
                    hashMap.put("affiliatedTeam",team.get(0));
                }
                list.add(hashMap);
            }
            jsonObject.put("list",list);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    public static String getSeqNo(String userId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd:HHmmss");
        synchronized (log){
            seq = seq < 999 ? ++seq : 0;
        }
        DecimalFormat df = new DecimalFormat("000");
        return userId+"_"+sdf.format(new Date())+"_"+df.format(seq);
    }

    public static void main (String[] args){
        /*String seqNo = getSeqNo();
        System.out.println(seqNo);*/
        String s = StringUtils.substringBefore("", ".");
        String s1 = StringUtils.substringBefore(null, ".");
        System.out.println(s);
        System.out.println(s1);
    }

}
