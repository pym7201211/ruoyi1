package com.ruoyi.forts.service;

public interface AlarmService {
    Integer getTotalTokenApplyByIp(String ip);

    Integer getTotalChangeRecordByIp(String ip);
}
