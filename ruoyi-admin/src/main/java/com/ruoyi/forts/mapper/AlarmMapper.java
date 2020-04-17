package com.ruoyi.forts.mapper;

public interface AlarmMapper {

    Integer getTotalTokenApplyByIp(String ip);

    Integer getTotalChangeRecordByIp(String ip);
}
