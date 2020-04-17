package com.ruoyi.urgencyforts.until;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.urgencyforts.domain.UrgencyTask;
import com.ruoyi.urgencyforts.mapper.UrgencyTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component("currentTask")
public class CurrentTask {
    protected final static Logger log = LoggerFactory.getLogger(CurrentTask.class);

    public static void urgencyCurrentTask(){
        log.info("紧急变更线程扫描开始........");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try{
            UrgencyTask urgencyTask1 = new UrgencyTask();
            urgencyTask1.setStatus("0");
            UrgencyTaskMapper urgencyTaskMapper = SpringUtils.getBean("urgencyTaskMapper");
            List<UrgencyTask> list = urgencyTaskMapper.selectUrgencyTaskList(urgencyTask1);
            if (null != list && list.size() > 0){
                for (UrgencyTask urgencyTask : list){
                    Long id = urgencyTask.getId();
                    String employeeId = urgencyTask.getEmployeeId();
                    String applyEnvironment = urgencyTask.getApplyEnvironment();
                    String openDate = urgencyTask.getOpenDate();
                    String endDate = urgencyTask.getEndDate();
                    String tag = urgencyTask.getSendTag();
                    String content = urgencyTask.getSendContent();
                    String applyDate = sdf.format(urgencyTask.getCreateTime());
                    String orderNo = urgencyTask.getSeqNo();
                    if (UrgencyUntil.belongDate(sdf.parse(openDate))){
                        JSONObject jsonObject = null;
                        if (UrgencyUntil.newAndOldSwitch()){
                            jsonObject = UrgencyUntil.requireOpenDistinct(employeeId, applyEnvironment, openDate, endDate, tag, content, applyDate, orderNo);
                        }else {
                            jsonObject = UrgencyUntil.requireOpenDistinct1(employeeId,openDate,endDate,tag,content,applyDate,orderNo);
                        }
                        log.info("紧急变更开通堡垒机线程 : "+jsonObject);
                        UrgencyTask urgencyTask2 = new UrgencyTask();
                        urgencyTask2.setId(id);
                        urgencyTask2.setStatus("1");
                        urgencyTaskMapper.updateUrgencyTask(urgencyTask2);
                    }
                }
            }
        }catch (Exception e){
            log.error("紧急变更开通堡垒机线程异常: ",e);
        }
    }





}
