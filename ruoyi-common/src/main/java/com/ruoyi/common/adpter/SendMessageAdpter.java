package com.ruoyi.common.adpter;

import com.ruoyi.common.demoservice.*;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@Component
public class SendMessageAdpter {
    public static void main(String[] args) {
        GROUPSNDRequest gpr = new GROUPSNDRequest();
        gpr.setSENDCONTENT("测试000001");
        gpr.setSENDNO("01010314");
        SendMessageAdpter.sendmessage(gpr);
    }

    protected final static Logger log = LoggerFactory.getLogger(SendMessageAdpter.class);

    public static TASCTLMsgSendResponse sendmessage(GROUPSNDRequest groupsndRequest){

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String data = df.format(new Date());
        long time = new Date().getTime();
        String times = String.valueOf(time);
        RequestBase rb = new RequestBase();

        final String traceid = times; //rb.getSEQNO();
        System.out.println("流水号："+times);
        TASCTLMsgSendRequest sendRequest = new TASCTLMsgSendRequest();

        sendRequest.setSEQNO(traceid);
        sendRequest.setSERVICEID("msg01");
        sendRequest.setSERVERID("8069");        //服务方系统号
        sendRequest.setCHANNELID("8249");  //雨燕平台的
        sendRequest.setBANKCODE("999999");
        sendRequest.setUSERID("999999");
        sendRequest.setAUTHID("admin");

        sendRequest.setTRANDATE(data);
        sendRequest.setTRANTIME("160000");


        sendRequest.setRESOLVETYPE("");
        sendRequest.setECIFCUSTNO("");
        sendRequest.setEXTSYSTEMID("");
        sendRequest.setPARTYNAME("");
        sendRequest.setCERTTYPE("");
        sendRequest.setCERTNO("");
        sendRequest.setEXTARRID("");
        sendRequest.setEXTARRTYPE("");
        //msp分配的产品编号
        sendRequest.setPRDID("50340");
        sendRequest.setRESERVE1("");
        sendRequest.setRESERVE2("");
        sendRequest.setRESERVE3("");
        sendRequest.setRESERVE4("");
        sendRequest.setRESERVE5("");
        sendRequest.setRESERVE6("");
        sendRequest.setRESERVE7("");
        sendRequest.setRESERVE8("");
        sendRequest.setRESERVE9("");
        sendRequest.setRESERVE10("");

        groupsndRequest.setCHLID("8");
        groupsndRequest.setGROUPNO("1");
        groupsndRequest.setSIGNARRID("");
        groupsndRequest.setSIGNTYPE("");
//        +groupsndRequest.getSENDNO()
        groupsndRequest.setSENDNO(groupsndRequest.getSENDNO());
        //groupsndRequest.setSENDTAG("掌上运维");
        groupsndRequest.setSENDTAG(groupsndRequest.getSENDTAG());
        groupsndRequest.setSENDCONTENT(groupsndRequest.getSENDCONTENT());
        groupsndRequest.setCONTENT1("");
        groupsndRequest.setCONTENT2("");
        if (StringUtils.isNotBlank(groupsndRequest.getCONTENT3())){
            groupsndRequest.setCONTENT3(groupsndRequest.getCONTENT3()+"?serialNo="+traceid);
        }else{
            groupsndRequest.setCONTENT3("");
        }
        groupsndRequest.setCONTENT4("");
        groupsndRequest.setCONTENT5("");
        groupsndRequest.setMSGEXPFLAG("2");
        groupsndRequest.setSENDBEGINTIME("");
        groupsndRequest.setSENDENDTIME("");
        groupsndRequest.setRESERVE1("");
        groupsndRequest.setRESERVE2("");
        groupsndRequest.setRESERVE3("");
        groupsndRequest.setRESERVE4("");
        groupsndRequest.setRESERVE5("");
        groupsndRequest.setRESERVE6("");
        groupsndRequest.setRESERVE7("");
        groupsndRequest.setRESERVE8("");
        groupsndRequest.setRESERVE9("");
        groupsndRequest.setRESERVE10("");


        GROUPSNDLISTRequest groupsndlistRequest = new GROUPSNDLISTRequest();
        List<GROUPSNDRequest> list = groupsndlistRequest.getGROUPSND();
        list.add(groupsndRequest);

        sendRequest.setGROUPSNDLIST(groupsndlistRequest);
//        System.out.println("request="+sendRequest);
        log.info("request="+sendRequest);
        //TASCTLMsgSendResponse包含所有信息（头加内容）
        ECIFMSGTASCTLMsgSendSOAPQSService emss = new ECIFMSGTASCTLMsgSendSOAPQSService();
        ECIFMSGTASCTLMsgSendService service = emss.getECIFMSGTASCTLMsgSendSOAPQSPort();
        TASCTLMsgSendResponse response=null;
        try {
            log.info("请求发送中");
//            System.out.println("qingqiufasongzhong");
          response = service.tasCTLMsgSend(sendRequest);
//            System.out.println("qingqiufasongzhongchenggong");
          log.info("请求发送成功");
        }catch (Exception exception){
//            System.out.println("exception="+exception.getMessage());
            log.info("exception+" +exception.getMessage());
        }
//        System.out.println("wwww"+groupsndRequest.getSENDCONTENT());
        log.info("www:"+groupsndRequest.getSENDCONTENT());
        log.info("getERRORCODE =======>>>"+response.getERRORCODE());
        log.info("getERRORMSG ========>>>"+response.getERRORMSG());
        log.info("getRETCODE : "+response.getRETCODE());
        log.info("getRETMSG  : "+response.getRETMSG());
        log.info("getTRANSTATUS :"+response.getTRANSTATUS());
        return response;

    }
}
