package com.ruoyi.weeklySchedule.mobilleTerminal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AccessMapper {

    public HashMap<String,String> selectAccessInfo (@Param("userId") String userId);

}
