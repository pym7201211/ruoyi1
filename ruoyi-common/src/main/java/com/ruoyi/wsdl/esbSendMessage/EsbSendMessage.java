package com.ruoyi.wsdl.esbSendMessage;

import com.ruoyi.wsdl.esbService.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsbSendMessage {
    private static final Logger log = LoggerFactory.getLogger(EsbSendMessage.class);
    private static int seq = 0;


    public static PushMessageResponse esbSendMessage(
            List<String> userIdList,String itemKey,String itemValue,String title,String appUrl)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        String seqNo = getSeqNo();
        log.info("发送esbSendMessage 流水号 ： "+seqNo);
        PushMessageRequest.DIRECTTOUSERLIST direct = new PushMessageRequest.DIRECTTOUSERLIST();
        List<USER> listUse = direct.getUSER();
        for (String str:userIdList) {
            USER user = new USER();
            user.setUSERID(str);
            listUse.add(user);
        }

        PushMessageRequest pushMessageRequest = new PushMessageRequest();
        pushMessageRequest.setSEQNO(seqNo);
        pushMessageRequest.setSERVICEID("MXMOP0101");
        pushMessageRequest.setCHANNELID("8249");
        pushMessageRequest.setSERVERID("8174");
        pushMessageRequest.setBANKCODE("999999");
        pushMessageRequest.setUSERID("999999");
        pushMessageRequest.setAUTHID("admin");
        pushMessageRequest.setTRANDATE(sdf.format(new Date()));
        pushMessageRequest.setTRANTIME(sd.format(new Date()));

        ExtHeadList extHeadList = new ExtHeadList();
        extHeadList.setBUSINESSID("50340");
        pushMessageRequest.setEXTHEAD(extHeadList);

        pushMessageRequest.setDIRECTTOUSERLIST(direct);

        ITEM item = new ITEM();
        item.setITEMKEY(itemKey);
        item.setITEMVALUE(itemValue);
        PushMessageRequest.ITEMLIST itemList = new PushMessageRequest.ITEMLIST();
        List<ITEM> iteml = itemList.getITEM();
        iteml.add(item);
        pushMessageRequest.setITEMLIST(itemList);

        pushMessageRequest.setTITLE(title);
        pushMessageRequest.setAPPURL(appUrl+"?serialNo="+seqNo);
        //pushMessageRequest.setAPPURL("launchApp://lingpaiapply$$#/lingApproval?userid=01010314?systemName=哈");
        //pushMessageRequest.setPUSHTIME(simpleDateFormat.format(new Date()));
        pushMessageRequest.setPUSHTIME(null);

        PushMessageServiceSoapBindingQSService pushsbq = new PushMessageServiceSoapBindingQSService();
        PushMessageService pushMessageServiceSoapBindingQSPort = pushsbq.getPushMessageServiceSoapBindingQSPort();
        PushMessageResponse pushMessageResponse = pushMessageServiceSoapBindingQSPort.pushMessage(pushMessageRequest);
        log.info("seqno ===========>>> "+pushMessageResponse.getSEQNO());
        log.info("transtatus ===========>>> "+pushMessageResponse.getTRANSTATUS());
        log.info("retmsg ===========>>> "+pushMessageResponse.getRETMSG());
        return pushMessageResponse;
    }


    public static String getSeqNo(){
        synchronized (log){
           seq = seq < 999 ? ++seq : 0;
        }
        DecimalFormat df = new DecimalFormat("000");
        return String.valueOf(System.currentTimeMillis())+df.format(seq);
    }

    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("01010314");
        list.add("01010245");
        PushMessageResponse pushMessageResponse = esbSendMessage(list,
                "测试","测试的值","测试标题",
                "launchApp://lingpaiapply$$#/lingApproval?userid=01010314?systemName=哈");
        System.out.println("========>>>"+pushMessageResponse.getTRANSTATUS()+
        "======>>>"+pushMessageResponse.getERRORMSG());
    }

}
