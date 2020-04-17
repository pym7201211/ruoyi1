package com.ruoyi.ruoyiforts.until;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.adpter.SendMessageAdpter;
import com.ruoyi.common.demoservice.GROUPSNDRequest;
import com.ruoyi.common.demoservice.TASCTLMsgSendResponse;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.ruoyiforts.domain.TokenApprovalProcesses;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import com.ruoyi.wsdl.esbService.PushMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortDetailedListUntil {
    private static final Logger log = LoggerFactory.getLogger(FortDetailedListUntil.class);


    /**
     * 发送消息公共类
     * @param nos
     * @param content
     * @param tag
     * @throws Exception
     */
    public static Map<String,String> sendMessage(List<String> nos, String content, String tag,String link) throws Exception{
        String transtatus = "";
        String seqNO = "";
        Map<String,String> map = new HashMap<>();
        try{
            //将数组转为字符串并用“,”分隔
            String newnos = String.join(",", nos.toArray(new String[nos.size()]));

            GROUPSNDRequest groupsndRequest = new GROUPSNDRequest();
            groupsndRequest.setSENDCONTENT(content);    //内容
            groupsndRequest.setSENDTAG(tag);             //标题
            groupsndRequest.setSENDNO(newnos);
            groupsndRequest.setCONTENT3(link);
            log.info("sendmessage : content : "+content);
            log.info("sendmessage : tag : "+tag);
            TASCTLMsgSendResponse sendmessage =
                    SendMessageAdpter.sendmessage(groupsndRequest);
            transtatus = sendmessage.getTRANSTATUS();
            seqNO = sendmessage.getSEQNO();
            map.put("transtatus",transtatus);
            map.put("seqNo",seqNO);
            log.info("sendmessage  transtatus :  "+transtatus+" seqNO : "+seqNO);
        }catch (Exception e){
            throw new Exception("发送消息公共类接口异常 : ",e);
        }
        return map;
    }

    public static Map<String,String> esbSendMessage(List<String> nos, String content, String tag,String link) throws Exception{
        String transtatus = "";
        String seqNO = "";
        Map<String,String> map = new HashMap<>();
        try{
            log.info("==========>>>"+nos);
            PushMessageResponse pushMessageResponse = EsbSendMessage.esbSendMessage(nos, tag, content, tag, link);
            transtatus = pushMessageResponse.getTRANSTATUS();
            String retmsg = pushMessageResponse.getRETMSG();
            seqNO = pushMessageResponse.getSEQNO();
            map.put("transtatus",transtatus);
            map.put("seqNo",seqNO);
            log.info("sendmessage  transtatus :  "+transtatus+" seqNO : "+seqNO+" msg : "+retmsg);
        }catch (Exception e){
            throw new Exception("发送消息公共类接口异常 : ",e);
        }
        return map;
    }

    /**
     *
     * @param buttonType
     * @param userName
     * @param systemName
     * @param transferNames
     * @return
     * @throws Exception
     */
    public static Map<String,String> sendInfo(String buttonType,String userName,
                                              String systemName,String transferNames) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分");
        Map<String,String> map = new HashMap<>();
        try{
            String content = "";
            String tag = "";
            String contents = "";
            if ("0".equals(buttonType)){
                tag = "信息系统维护认领申请";
                content = userName+"申请认领维护"+systemName+"管理权限";
                contents = userName+"于"+sdf.format(new Date())+"申请认领"+systemName+"管理权限";
            }
            if ("1".equals(buttonType)){
                tag = "信息系统转交申请";
                content = userName+"申请转交"+systemName+"管理权限";
                contents = userName+"于"+sdf.format(new Date())+"申请转交"+systemName+"管理权限,"+
                        "转交人："+transferNames;
            }
            if ("2".equals(buttonType)){
                tag = "信息系统解除申请";
                content = userName+"申请解除"+systemName+"管理权限";
                contents = userName+"于"+sdf.format(new Date())+"申请解除"+systemName+"管理权限";
            }
            map.put("content",content);
            map.put("tag",tag);
            map.put("contents",contents);
        }catch (Exception e){
            throw new Exception("发送消息信息发送消息信息接口异常：",e);
        }
        return map;
    }

    /**
     * 拼接用户名和id
     * @param maintainUserIds
     * @param useMaintainStaffs
     * @param note
     * @param employeeName
     * @return
     * @throws Exception
     */
    public static Map<String,String> getIdAndUser(String maintainUserIds,String useMaintainStaffs,
                                                  JSONObject note,String employeeName)throws Exception{
        Map<String,String> map = new HashMap<>();
        String maintainUserId = "";
        String useMaintainStaff = "";
        log.info("getIdAndUser  "+"maintainUserIds : "+maintainUserIds+"useMaintainStaffs : "+useMaintainStaffs+
        "userId : "+note.getString("userId")+"employeeName : "+employeeName);
        try{
            if (maintainUserIds.indexOf(",") != -1){
                String[] split = maintainUserIds.split(",");
                for (String sysName : split) {
                    if (note.getString("userId").equals(sysName)){
                        continue;
                    }
                    maintainUserId = maintainUserId+sysName+",";
                }
                map.put("maintainUserId",getdeleteCharAt(maintainUserId,","));
            }
            if (useMaintainStaffs.indexOf("、") != -1){
                String[] str = useMaintainStaffs.split("、");
                for (String staff : str){
                    if (employeeName.equals(staff)){
                        continue;
                    }
                    useMaintainStaff = useMaintainStaff+staff+"、";
                }
                map.put("useMaintainStaff",getdeleteCharAt(useMaintainStaff,"、"));
            }
        }catch (Exception e){
            throw new Exception("拼接用户名和id方法异常:",e);
        }
        log.info("getIdAndUser map : "+map);
        return map;
    }

    /**
     * 去掉末尾逗号
     * @param params
     * @return
     * @throws Exception
     */
    public static String getdeleteCharAt(String params,String symbol)throws Exception{
        try{
            if (params.endsWith(symbol)){
                StringBuffer stb = new StringBuffer(params);
                stb = stb.deleteCharAt(stb.length() -1);
                params = stb.toString();
            }
        }catch (Exception e){
            throw new Exception("去掉末尾逗号方法异常:",e);
        }
        return params;
    }

    public static TokenApprovalProcesses setDemo(String leaderId, String leaderName, String employeeId,
                                                 String employeeName, String applyContent, String seno, String approvalStatus, String buttonType,
                                                 String transferId, String transferName, String systemId, String systemName){
        TokenApprovalProcesses tokenApprovalProcesses = new TokenApprovalProcesses();
        tokenApprovalProcesses.setLeaderId(leaderId);
        tokenApprovalProcesses.setLeaderName(leaderName);
        tokenApprovalProcesses.setEmployeeId(employeeId);
        tokenApprovalProcesses.setEmployeeName(employeeName);
        tokenApprovalProcesses.setApplyContent(applyContent);
        tokenApprovalProcesses.setSeno(seno);
        tokenApprovalProcesses.setCreateTime(DateUtils.getNowDate());
        tokenApprovalProcesses.setUpdateTime(DateUtils.getNowDate());
        tokenApprovalProcesses.setApprovalStatus(approvalStatus);
        tokenApprovalProcesses.setButtonType(buttonType);
        tokenApprovalProcesses.setTransferId(transferId);
        tokenApprovalProcesses.setTransferName(transferName);
        tokenApprovalProcesses.setSystemId(systemId);
        tokenApprovalProcesses.setSystemName(systemName);
        return tokenApprovalProcesses;
    }


}
