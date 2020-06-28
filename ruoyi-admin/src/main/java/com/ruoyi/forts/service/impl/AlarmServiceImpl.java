package com.ruoyi.forts.service.impl;

import com.ruoyi.forts.mapper.AlarmMapper;
import com.ruoyi.forts.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Map<String,Object> getIPList(String ip) {
        Map<String, Object> map = alarmMapper.getIPList(ip);
        String iplist = (String) map.get("IPLIST") == null ? "" : (String) map.get("IPLIST");
        TreeSet<String> hset = new TreeSet<String>(Arrays.asList(iplist.split(",")));
        map.put("IPLIST",hset.toString());
        return alarmMapper.getIPList(ip);
    }
}
