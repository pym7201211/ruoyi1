package com.ruoyi.ruoyiforts.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.ruoyiforts.domain.TokenApprovalProcesses;
import com.ruoyi.ruoyiforts.mapper.FortDetailedListMapper;
import com.ruoyi.ruoyiforts.service.FortDetailedListService;
import com.ruoyi.ruoyiforts.until.FortDetailedListUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FortDetailedListServiceImpl implements FortDetailedListService {

    private static final Logger log = LoggerFactory.getLogger(FortDetailedListServiceImpl.class);

    private static final String link_launchApp = "launchApp://lingpaiapply$$#/bossApproval";


    @Autowired
    private FortDetailedListMapper fortDetailedListMapper;


    @Override
    public boolean selectButton(String json) throws Exception{
        try{
            if (null == json || "".equals(json)){
                throw new IllegalArgumentException("selectButton json is null");
            }
            log.info("selectButton json : "+json);
            JSONObject jsonObject = JSON.parseObject(json);
            if (null != jsonObject && jsonObject.containsKey("note1")){
                JSONObject note = (JSONObject) jsonObject.get("note1");
                String systemName = note.getString("systemName");
                String userId = note.getString("userId");
                return fortDetailedListMapper.selectButton(systemName,userId) > 0;
            }
        }catch (Exception e){
            throw new Exception("查询按钮接口异常:",e);
        }
        return false;
    }

    /**
     * 认领、解除并发送消息
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public boolean sendMessageClaim(String json,String buttonType) throws Exception{
        try{
            if (null == json || "".equals(json)){
                throw new IllegalArgumentException("sendMessageClaim json is null");
            }
            JSONObject jsonObject = JSON.parseObject(json);
            log.info("sendMessageClaim json : "+json);
            if (null != json && jsonObject.containsKey("note")){
                JSONObject note = (JSONObject) jsonObject.get("note");
                log.info("sendMessageClaim note : "+note);
                String userId = note.getString("userId");
                String systemId = note.getString("systemId");
                String systemName = note.getString("systemName");
                String userName = note.getString("userName");
                String transferId = "";
                String transferName = "";
                if (note.containsKey("transferId") && note.containsKey("transferName")){
                    transferId = note.getString("transferId");
                    transferName = note.getString("transferName");
                }
                Map<String, String> hashMap = fortDetailedListMapper.selectInfo(systemName);
                log.info("sendMessageClaim hashMap : "+hashMap);
                List<String> nos = new ArrayList<>();
                if (null != hashMap && hashMap.size() > 0){
                    String leaderId = hashMap.get("LEADER_ID");
                    if (leaderId.indexOf(",") != -1){
                        String[] leaderIds = leaderId.split(",");
                        for (String leader:leaderIds) {
                            nos.add(leader);
                        }
                    }else{
                        nos.add(leaderId);
                    }
                    //nos.add(hashMap.get("LEADER_ID"));
                    //"http://172.20.10.3:8081/bossApproval?userid="
                    Map<String, String> map = FortDetailedListUntil.sendInfo(buttonType,
                            userName, systemName, transferName);
                    String contents = map.get("contents");
                    String content = map.get("content");
                    String tag = map.get("tag");
                    String link=link_launchApp+"?userid="+userId+"?systemName="+systemName+
                            "?content="+contents+",是否同意:";
                    //Map<String,String> send = FortDetailedListUntil.sendMessage(nos, content, tag,link);
                    Map<String, String> send = FortDetailedListUntil.esbSendMessage(nos, content, tag, link);
                    if (null != send && send.containsKey("transtatus") && send.containsKey("seqNo")){
                        String seqNo = send.get("seqNo");
                        if ("COMPLETE".equals(send.get("transtatus"))){
                            TokenApprovalProcesses tokenApprovalProcesses = FortDetailedListUntil.setDemo
                                    (hashMap.get("LEADER_ID"),
                                    hashMap.get("LEADER_NAME"),userId,userName,
                                    contents,seqNo,"2",buttonType,transferId,transferName,
                                    systemId,systemName);
                            return fortDetailedListMapper.insertTokenApprovalProcess(tokenApprovalProcesses) > 0;
                        }
                    }
                }
            }
        }catch (Exception e){
            throw new Exception("认领、解除并发送消息impl接口异常: ",e);
        }
        return false;
    }

    @Override
    public HashMap<String, String> selectApporvalStaus(String json) throws Exception {
        if (null == json || "".equals(json)){
            throw new IllegalArgumentException("sendMessageClaim json is null");
        }
        JSONObject jsonObject = JSON.parseObject(json);
        log.info("selectApporvalStaus json1 : "+json);
        if (null != json && jsonObject.containsKey("note1")){
            JSONObject note = (JSONObject) jsonObject.get("note1");
            log.info("selectApporvalStaus note1 : "+note);
            String userId = note.getString("userId");
            String systemName = note.getString("systemName");
            return fortDetailedListMapper.selectApporvalStaus(userId,systemName);
        }
        return null;
    }

    /**
     * 审批页面
     * @param json
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,String> approvalProcess(String json) throws Exception {
        String code = "1";
        String msg = "审批失败!";
        Map<String,String> processMap = new HashMap<>();
        List<String> nos = new ArrayList<>();
        String buttonName = "";
        if (null == json || "".equals(json)){
            throw new IllegalArgumentException("sendMessageClaim json is null");
        }
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            if (null != json && jsonObject.containsKey("note")){
                JSONObject note = (JSONObject) jsonObject.get("note");
                String seNo = note.getString("seNo");
                String userId = note.getString("userId");
                String systemName = note.getString("systemName");
                String approvalStatus = "1".equals(note.getString("approvalStatus")) ? "同意" : "拒绝";  //审批是否同意
                HashMap<String, String> hashMap = fortDetailedListMapper.selectApprovalInfo(seNo);
                String employee_id = hashMap.get("EMPLOYEE_ID");
                String employeeName = hashMap.get("EMPLOYEE_NAME");
                nos.add(employee_id);
                log.info("approvalProcess hashMap : "+hashMap);
                if (null != hashMap && hashMap.size() > 0){
                    if (StringUtils.isBlank(hashMap.get("BUTTON_TYPE"))){
                        throw new IllegalArgumentException("BUTTON_TYPE查询出的为空");
                    }
                    if ("0".equals(hashMap.get("BUTTON_TYPE"))){                     //认领
                        if ("1".equals(note.getString("approvalStatus"))){      //审批同意
                            int i = fortDetailedListMapper.updateInventoryUser(employeeName,userId,systemName); //更新标准化清单表
                            if (i <= 0){
                                processMap.put("code","1");
                                processMap.put("msg","更新标准化清单表失败!");
                                return processMap;
                            }
                            processMap.put("userId",userId);
                        }
                        buttonName = "认领";
                    }
                    if ("1".equals(hashMap.get("BUTTON_TYPE"))){                    //转交
                        if ("1".equals(note.getString("approvalStatus"))) {      //审批同意
                            HashMap<String, String> map = fortDetailedListMapper.selectApprovalInfo(seNo);
                            String oldUserId = map.get("EMPLOYEE_ID");
                            String oldUser = map.get("EMPLOYEE_NAME");
                            String newUserId = map.get("TRANSFER_ID");
                            String newUser = map.get("TRANSFER_NAME");
                            String systemName1 = map.get("SYSTEM_NAME");
                            log.info("approvalProcess hashMap : "+map);
                            int i = fortDetailedListMapper.transferSystemName(oldUser, newUser,
                                    oldUserId, newUserId,systemName1);
                            log.info("izj ======>>>"+i);
                            if (i <= 0){
                                processMap.put("code","1");
                                processMap.put("msg","更新标准化清单表失败!");
                                return processMap;
                            }
                        }
                        buttonName = "转交";
                    }
                    if ("2".equals(hashMap.get("BUTTON_TYPE"))){                    //解除
                        if ("1".equals(note.getString("approvalStatus"))) {      //审批同意
                            Map<String,String> map = fortDetailedListMapper.selectInventoryUser(systemName);
                            if (StringUtils.isBlank(map.get("MAINTAIN_USER_ID"))){
                                throw new IllegalArgumentException("查询用户id无数据");
                            }
                            log.info("userId : =====>>>"+map.get("MAINTAIN_USER_ID"));
                            Map<String, String> idAndUser =
                                    FortDetailedListUntil.getIdAndUser(map.get("MAINTAIN_USER_ID"),
                                            map.get("USE_MAINTAIN_STAFF"),note, employeeName);
                            int i1 = fortDetailedListMapper.updateInventoryUserId(idAndUser.get("maintainUserId"),
                                    idAndUser.get("useMaintainStaff"),systemName);
                            log.info("i1 ==========>>>"+i1);
                            if (i1 <= 0){
                                processMap.put("code","1");
                                processMap.put("msg","更新标准化清单表失败!");
                                return processMap;
                            }
                        }
                        buttonName = "解除";
                    }
                    int approvalStatus1 = fortDetailedListMapper.updateApprovalStatus(note.getString("approvalStatus"), seNo);
                    log.info("approvalStatus ===========>>>"+approvalStatus1);
                    if (approvalStatus1 > 0){
                        /*FortDetailedListUntil.sendMessage(nos,
                                "您申请"+buttonName+hashMap.get("SYSTEM_NAME")+"管理权限已"+approvalStatus+",审批人 : "
                                        +hashMap.get("LEADER_NAME"),"认领审批回复",null);*/
                        String content = "您申请"+buttonName+hashMap.get("SYSTEM_NAME")+"管理权限已"+approvalStatus+",审批人 : "
                                +hashMap.get("LEADER_NAME");
                        FortDetailedListUntil.esbSendMessage(nos,content,"审批回复",null);
                        code = "0";
                        msg = "执行成功!";
                    }
                }
            }
        }catch (Exception e){
            throw new Exception("审批页面接口异常: ",e);
        }
        processMap.put("code",code);
        processMap.put("msg",msg);
        return processMap;
    }

    @Override
    public String selectIsApproval(String json) {
        String seNo = "";
        if (null == json || "".equals(json)){
            throw new IllegalArgumentException("sendMessageCareof json is null");
        }
        JSONObject jsonObject = JSON.parseObject(json);
        if (null != json && jsonObject.containsKey("note")) {
            JSONObject note = (JSONObject) jsonObject.get("note");
            seNo = note.getString("seNo");
        }
        String str = fortDetailedListMapper.selectIsApproval(seNo);
        //return ("1".equals(str)||"0".equals(str)) ? true : false;
        return str;
    }

    @Override
    public List<HashMap<String, String>> getIdAndName(String systemName) {
        return fortDetailedListMapper.getIdAndName(systemName);
    }


}

