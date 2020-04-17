package com.ruoyi.weeklySchedule.mobilleTerminal.service;

import com.alibaba.fastjson.JSONObject;

public interface DemandService {

    public JSONObject selectHostTeam (String json) throws Exception;

    public JSONObject selectDemandInfo (String json) throws Exception;

    public JSONObject selectDataByDemandDept() throws Exception;

    public JSONObject checkAccess(String json) throws Exception;

    public JSONObject deleteDemandBySerialNo(String json) throws Exception;

    public JSONObject getHostTeam() throws Exception;
}
