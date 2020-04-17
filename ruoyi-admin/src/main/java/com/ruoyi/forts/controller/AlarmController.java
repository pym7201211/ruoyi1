package com.ruoyi.forts.controller;

import com.ruoyi.forts.service.AlarmService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api("令牌申请记录和紧急变更记录")
@RestController
@RequestMapping("/AlarmController")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/totalTokenApply/{ip}")
    @ResponseBody
    public Integer getTotalTokenApplyByIp(@PathVariable("ip") String ip){
        return alarmService.getTotalTokenApplyByIp(ip);
    }

    @RequestMapping("/totalChangeRecord/{ip}")
    @ResponseBody
    public Integer getTotalChangeRecordByIp(@PathVariable("ip") String ip){
        return alarmService.getTotalChangeRecordByIp(ip);
    }
}
