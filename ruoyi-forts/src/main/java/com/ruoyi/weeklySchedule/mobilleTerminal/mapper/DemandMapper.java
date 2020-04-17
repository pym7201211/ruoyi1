package com.ruoyi.weeklySchedule.mobilleTerminal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {

    public List<HashMap<String,String>> selectHostTeam(@Param("hostTeamId") String hostTeamId);

    public List<HashMap<String,Object>> selectDemandInfo(@Param("hostTeam") String hostTeam);

    public String selectManagerId(@Param("userId") String userId);

    public List<String> selectTwoDeptId(@Param("userId") String userId);

    public List<HashMap> selectDataByDemandDept();

    public List<HashMap> selectDataByMonth();

    public List<HashMap> selectDendrogramData();

    public List<HashMap<String,Object>> selectDemandInfoFinish(@Param("hostTeam") String hostTeam);

    public String getManagerId(@Param("userName") String userName);

    public int deleteDemandBySerialNo(@Param("serialNo") String serialNo);

    public String getHostTeamId(@Param("hostTeam") String hostTeam);

}
