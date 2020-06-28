package com.ruoyi.forts.until;


import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.forts.domain.TokenAutoPushDemo;
import com.ruoyi.forts.mapper.TokenAutoPushDemoMapper;
import com.ruoyi.forts.service.ITokenApplyFormService;
import com.ruoyi.ruoyiforts.until.FortDetailedListUntil;
import com.ruoyi.urgencyforts.until.CurrentTask;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component("tokenAutoPush")
public class TokenAutoPush {
    protected final static Logger log = LoggerFactory.getLogger(CurrentTask.class);
    private static final String link_launchApp_token = "launchApp://lingpaiapply$$#/lpTokenAutoPush";

    @Autowired
    private ITokenApplyFormService tokenApplyFormService;

    public static void tokenAutoPushtTask(){
        log.info("令牌数据自动推送。。。");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try{
            TokenAutoPushDemo tokenAutoPushDemo = new TokenAutoPushDemo();
            tokenAutoPushDemo.setIsSend("0");//is_send的值为0，为未推送
            TokenAutoPushDemoMapper tokenAutoPushDemoMapper = SpringUtils.getBean("tokenAutoPushDemoMapper");
            List<TokenAutoPushDemo> tokenAutoPushList = tokenAutoPushDemoMapper.selectTokenAutoList(tokenAutoPushDemo);
            if(tokenAutoPushList.size() != 0){//是否有未推送的
                HashMap<String,String> directorIdSeqNo = new HashMap<>();//主管为key  seqno为值
                HashMap<String,ArrayList<String>> directorUser = new HashMap<>();//主管为key，list放员工

                String seqno = "";
                for (TokenAutoPushDemo autoPushDemo : tokenAutoPushList) {
                    boolean result = directorIdSeqNo.containsKey(autoPushDemo.getDirectorId());
                    boolean upResult = true;
                    if(result){
                        //将员工名称加入对面主管下面,名称会重复，推送时进行去重
                        directorUser.get(autoPushDemo.getDirectorId()).add(autoPushDemo.getUserName());
                        upResult = tokenAutoPushDemoMapper.updateTokenAutoList(directorIdSeqNo.get(autoPushDemo.getDirectorId()),autoPushDemo.getIdentity(), autoPushDemo.getTime());
                    }else{
                        //如果没有包含用户部门的key，添加进去，seqNo
                        seqno = EsbSendMessage.getSeqNo();
                        directorIdSeqNo.put(autoPushDemo.getDirectorId(),seqno);
                        //这个是为了确认同一个部门的同事，一个部门的同事只发一次主管
                        ArrayList<String> directorUserList = new  ArrayList<String>();
                        directorUserList.add(autoPushDemo.getUserName());
                        directorUser.put(autoPushDemo.getDirectorId(),directorUserList);
                        upResult = tokenAutoPushDemoMapper.updateTokenAutoList(seqno,autoPushDemo.getIdentity(), autoPushDemo.getTime());
                    }
                    if(!upResult){
                        log.info("自动推送令牌数据发生错误。。。");
                        return;
                    }
                }
                ArrayList<String> directorList = new  ArrayList<String>();
                if(!directorUser.isEmpty()){
                    for(String key:directorUser.keySet()){
                        String directorName = directorUser.get(key).toString();
                        if(directorList.size() == 0){
                            directorList.add(key);
                        }else{
                            directorList.set(0,key);
                        }
                        FortDetailedListUntil.esbSendMessage(directorList,
                                directorUser.get(key).stream().distinct().collect(Collectors.toList()).toString()+"使用令牌进行操作",//list集合去重
                                "令牌操作记录通知",link_launchApp_token+"?seqNo="+directorIdSeqNo.get(key));
                    }
                }

            }else{
                log.info("没有需要自动推送的令牌数据。。。");
            }
        }catch (Exception e){
            log.error(": ",e);
        }
    }





}
