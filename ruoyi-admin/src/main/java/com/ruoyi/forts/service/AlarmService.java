package com.ruoyi.forts.service;

import java.util.List;
import java.util.Map;

public interface AlarmService {
    Integer getTotalTokenApplyByIp(String ip);

    Integer getTotalChangeRecordByIp(String ip);

    Map<String,Object> getIPList(String ip);
}
