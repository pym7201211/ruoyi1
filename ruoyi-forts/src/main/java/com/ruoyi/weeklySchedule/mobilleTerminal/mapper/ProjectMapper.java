package com.ruoyi.weeklySchedule.mobilleTerminal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    public List<HashMap<String,String>> selectHostTeam(@Param("hostTeamId") String hostTeamId);

    public List<HashMap<String,Object>> selectDemandInfo(@Param("hostTeam") String hostTeam);

    public List<HashMap<String,Object>> selectDemandInfoFinish(@Param("hostTeam") String hostTeam);

    public String selectManagerId(@Param("hostManagerId") String hostManagerId);

    public List<String> selectTwoDeptId(@Param("userId") String userId);

    public int deleteProjectBySerialNo(@Param("serialNo") String serialNo);

    public String getHostTeamId(@Param("hostTeam") String hostTeam);



}
