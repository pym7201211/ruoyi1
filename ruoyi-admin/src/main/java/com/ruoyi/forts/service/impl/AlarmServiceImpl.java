package com.ruoyi.forts.service.impl;

import com.ruoyi.forts.mapper.AlarmMapper;
import com.ruoyi.forts.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmMapper alarmMapper;

    @Override
    public Integer getTotalTokenApplyByIp(String ip) {
        return alarmMapper.getTotalTokenApplyByIp(ip);
    }

    @Override
    public Integer getTotalChangeRecordByIp(String ip) {
        return alarmMapper.getTotalChangeRecordByIp(ip);
    }
}
