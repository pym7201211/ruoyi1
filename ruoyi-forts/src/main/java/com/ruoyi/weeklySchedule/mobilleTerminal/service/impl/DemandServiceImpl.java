package com.ruoyi.weeklySchedule.mobilleTerminal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.weeklySchedule.mobilleTerminal.mapper.AccessMapper;
import com.ruoyi.weeklySchedule.mobilleTerminal.mapper.DemandMapper;
import com.ruoyi.weeklySchedule.mobilleTerminal.service.DemandService;
import com.ruoyi.weeklySchedule.until.WeeklyScheduleUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemandServiceImpl implements DemandService {
    protected final static Logger log = LoggerFactory.getLogger(DemandServiceImpl.class);

    @Autowired
    private DemandMapper demandMapper;

    @Autowired
    private AccessMapper accessMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Override
    public JSONObject selectHostTeam(String json) throws Exception {
        try{
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String access = "";
            String hostTeamId = "";
            String userId = jsonClient.getString("userId");
            JSONObject jsonObject1 = selectAccess(userId);
            if ("allManager".equals(jsonObject1.getString("position"))){
                hostTeamId = "";
                access = "3";   //全部权限
            }else {
                hostTeamId = jsonObject1.getString("hostTeamId");
                if ("teamLead".equals(jsonObject1.getString("position"))){
                    hostTeamId = "";
                    access = "2";
                }else if ("designee".equals(jsonObject1.getString("position"))){
                    access = "2"; //修改本团队
                }else if ("manager".equals(jsonObject1.getString("position"))){
                    access = "1";   //修改自己
                }else if ("employee".equals(jsonObject1.getString("position"))){
                    access = "0";
                }
                String dayOfWeek = WeeklyScheduleUntil.getDayOfWeek();
                String weekly_day_week = dictDataMapper.selectDictLabel("weekly_day_week", dayOfWeek);
                access = StringUtils.isNotBlank(weekly_day_week) ? "0" : access;
                log.info("access =========>>>"+access);
            }
            List<HashMap<String, String>> hashMaps = demandMapper.selectHostTeam(hostTeamId);
            List<String> twoDeptId = demandMapper.selectTwoDeptId(userId);
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMaps);
            jsonObject.put("access",access);
            jsonObject.put("host_team_id",twoDeptId);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject selectDemandInfo(String json) throws Exception {
        try{
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String hostTeam = jsonClient.getString("hostTeam");
            List<HashMap<String, Object>> hashMaps = demandMapper.selectDemandInfo(hostTeam);
            List<HashMap<String, Object>> hashMapes = demandMapper.selectDemandInfoFinish(hostTeam);
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMaps);
            jsonObject.put("lists",hashMapes);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject selectDataByDemandDept() throws Exception {
        List list = new ArrayList<>();
        try{
            /*List<HashMap> hashMaps = demandMapper.selectDataByDemandDept();
            if (null == hashMaps || hashMaps.size() == 0){
                return null;
            }
            List<HashMap> maps = demandMapper.selectDataByMonth();
            if (null == maps || maps.size() == 0){
                return null;
            }
            List list1 = selectDendrogramData(hashMaps,"1");
            List list2 = selectDendrogramData(maps,"2");
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "查询成功");
            jsonObject.put("list1",list1);
            jsonObject.put("list2",list2);*/
            List<HashMap> hashMaps = demandMapper.selectDendrogramData();
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",hashMaps);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject checkAccess(String json) throws Exception {
        try{
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String userId = jsonClient.getString("userId");
            HashMap<String, String> map = accessMapper.selectAccessInfo(userId);
            String checkAccess = null != map && map.size()>0 ? "true" : "false";
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "查询成功");
            jsonObject.put("checkAccess",checkAccess);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject deleteDemandBySerialNo(String json) throws Exception {
        try{
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            String serialNo = jsonClient.getString("serialNo");
            int i = demandMapper.deleteDemandBySerialNo(serialNo);
            return i > 0 ? WeeklyScheduleUntil.resultStatus("0","删除成功") : WeeklyScheduleUntil.resultStatus("1","删除失败");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public JSONObject getHostTeam() throws Exception {
        try{
            List<HashMap<String, String>> hashMaps = demandMapper.selectHostTeam("");
            JSONObject jsonObject = WeeklyScheduleUntil.resultStatus("0", "成功");
            jsonObject.put("list",hashMaps);
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public List selectDendrogramData (List<HashMap> hashMaps,String flag)throws Exception{
        List list = new ArrayList<>();
        try{
            String key = "1".equals(flag) ? "department" : "month";
            for (Map map: hashMaps) {
                Map<String,String> maps = new HashMap<>();
                Object name = (Object) map.get("NAME");
                Object num = (Object)map.get("NUM");
                Object name1 = (Object)map.get("NAME1");
                Object num_demand = (Object) map.get("NUM_DEMAND");
                if (null != name && null != name1){
                    maps.put(key,String.valueOf(name));
                }else{
                    String department = null != name ? String.valueOf(name) : String.valueOf(name1);
                    maps.put(key,department);
                }
                String strNum = null != num ? String.valueOf(num) : "0";
                String strNumDemand = null != num_demand ? String.valueOf(num_demand) : "0";
                maps.put("proportion",strNum);
                maps.put("value",strNumDemand);
                list.add(maps);
            }
            return list;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public JSONObject selectAccess(String userId) throws Exception{
        JSONObject jsonObject = new JSONObject();
        try{
            HashMap<String, String> map = accessMapper.selectAccessInfo(userId);
            if (null == map || map.size() == 0){                                //员工或需求经理
                String hostTeamId = demandMapper.selectManagerId(userId);
                if (StringUtils.isBlank(hostTeamId)){                        //员工
                    List<String> twoDeptId = demandMapper.selectTwoDeptId(userId);
                    jsonObject.put("position","employee");
                    jsonObject.put("hostTeamId",twoDeptId);
                    return jsonObject;
                }   //经理
                jsonObject.put("position","manager");
                jsonObject.put("hostTeamId",hostTeamId);
                return jsonObject;
            }
            //架构 总经理 团队主管 指定人员
            String team_id = map.get("TEAM_ID");
            String access_level = map.get("ACCESS_LEVEL");
            if ("1".equals(access_level)){      //指定人员或团队主管
                jsonObject.put("position","designee");
                jsonObject.put("hostTeamId",team_id);
                return jsonObject;
            }
            if ("2".equals(access_level)){      //团队主管
                jsonObject.put("position","teamLead");
                jsonObject.put("hostTeamId",team_id);
                return jsonObject;
            }
            //jsonObject.put("accessLevel","3");
            jsonObject.put("position","allManager");
            jsonObject.put("hostTeamId","allAccess");
            return jsonObject;
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
