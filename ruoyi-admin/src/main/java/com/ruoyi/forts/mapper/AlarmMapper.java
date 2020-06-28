package com.ruoyi.forts.mapper;

import java.util.List;
import java.util.Map;

public interface AlarmMapper {

    Integer getTotalTokenApplyByIp(String ip);

    Integer getTotalChangeRecordByIp(String ip);

    Map<String,Object> getIPList(String ip);
}
