package com.ruoyi.weeklySchedule.until;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyDemandScheduel;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyProjectScheduel;
import com.ruoyi.weeklySchedule.mobilleTerminal.mapper.DemandMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeeklyScheduleUntil {
    protected final static Logger log = LoggerFactory.getLogger(WeeklyScheduleUntil.class);

    private static int seq = 0;


    /**
     * 获取返回接口状态信息
     * @param code
     * @param msg
     * @return
     */
    public static JSONObject resultStatus(String code, String msg){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        return json;
    }

    public static ModelMap resultModelMap(JSONObject jsonObject){
        ModelMap modelMap =  new ModelMap();
        if (null != jsonObject && jsonObject.containsKey("code")){
            String code = jsonObject.getString("code");
            String msg = jsonObject.getString("msg");
            modelMap.put("code",code);
            modelMap.put("msg",msg);
        }
        return modelMap;
    }

    public static ModelMap resultModelMap(String code,String msg){
        ModelMap modelMap =  new ModelMap();
        modelMap.put("code",code);
        modelMap.put("msg",msg);
        return modelMap;
    }

    /**
     * 校验客户端传入的参数
     * @param json
     * @return
     * @throws Exception
     */
    public static JSONObject clientJsonParams(String json) throws Exception {
        if (null == json || "".equals(json)){
            throw new IllegalArgumentException("json is null");
        }
        try{
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")) {
                JSONObject jsonNote = (JSONObject) jsonObject.get("note");
                jsonNote.put("code","0");
                return jsonNote;
            }else {
                return resultStatus("1","客户端传入json错误");
            }
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static List transList(List<HashMap<String,Object>> list) throws Exception{
        List lists = new ArrayList();
        try{
            for (HashMap<String,Object> map: list) {
                HashMap<String, Object> map1 = transformUpperCase(map);
                lists.add(map1);
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return lists;
    }

    /**
     * 将大写改小写
     * @param orgMap
     * @return
     * @throws Exception
     */
    public static HashMap<String, Object> transformUpperCase(HashMap<String, Object> orgMap) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        try{
            if (orgMap == null || orgMap.isEmpty()) {
                return resultMap;
            }

            Set<String> keySet = orgMap.keySet();
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                //newKey = newKey.replace("_", "");
                resultMap.put(newKey, orgMap.get(key));
            }
        }catch (Exception e){
            throw new Exception(e);
        }
        return resultMap;
    }

    public static String getSeqNo(){
        synchronized (log){
            seq = seq < 999 ? ++seq : 0;
        }
        DecimalFormat df = new DecimalFormat("000");
        return String.valueOf(System.currentTimeMillis())+df.format(seq);
    }

    public static WeeklyDemandScheduel demandScheduel(JSONObject jsonObject) throws Exception{
        log.info("WeeklyDemandScheduel jsonObject : "+jsonObject);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            if (null == jsonObject || jsonObject.isEmpty()){
                return null;
            }
            String demand_name = jsonObject.getString("demand_name");
            String host_team = jsonObject.getString("host_team");
            String host_team_id = jsonObject.getString("host_team_id");
            if (StringUtils.isBlank(host_team_id)){
                DemandMapper demandMapper = SpringUtils.getBean("demandMapper");
                host_team_id = demandMapper.getHostTeamId(host_team);
            }
            String host_manager = jsonObject.getString("host_manager");
            String host_manager_id = jsonObject.getString("host_manager_id");
            String demand_dept = jsonObject.getString("demand_dept");
            if (StringUtils.isNotBlank(demand_dept)){
                String[] split = demand_dept.split(",");
                demand_dept = split[0];
            }
            String demand_dept_id = jsonObject.getString("demand_dept_id");
            String processing_time = jsonObject.getString("processing_time");
            String planned_production_time = jsonObject.getString("planned_production_time");
            String plan_rd_completion_time = jsonObject.getString("plan_rd_completion_time");
            String current_generation = jsonObject.getString("current_generation");
            String finished_phase = jsonObject.getString("finished_phase");
            String finish_this_week = jsonObject.getString("finish_this_week");
            String risks_difficulties = jsonObject.getString("risks_difficulties");
            String remarks = jsonObject.getString("remarks");
            String serial_no = jsonObject.getString("serial_no");
            serial_no = StringUtils.isBlank(serial_no) ? getSeqNo() : serial_no;
            String demandDeptFullName = jsonObject.getString("demand_dept_full_name");
            String create_time = jsonObject.getString("create_time");
            /*if ("已完成".equals(current_generation)){
                create_time = sdf.format(new Date());
            }*/
            String hostManagerId = "";
            if(StringUtils.isNotBlank(host_manager)){
                if (host_manager.indexOf(",") != -1){
                    String[] split = host_manager.split(",");
                    hostManagerId = getHostManagerId(split);
                }else if (host_manager.indexOf("、") != -1){
                    String[] split = host_manager.split("、");
                    hostManagerId = getHostManagerId(split);
                }else {
                    hostManagerId = getHostManagerId(host_manager);
                }
            }

            WeeklyDemandScheduel weeklyDemandScheduel = new WeeklyDemandScheduel(
                    demand_name, host_team, host_team_id, host_manager, hostManagerId,
                    demand_dept, demand_dept_id, processing_time, planned_production_time,
                    plan_rd_completion_time, current_generation, finished_phase, finish_this_week,
                    risks_difficulties, remarks,demandDeptFullName);

            weeklyDemandScheduel.setSerialNo(serial_no);
            weeklyDemandScheduel.setCreateTime(sdf.parse(create_time));
            return weeklyDemandScheduel;
        }catch (Exception e){
            throw new Exception(e);
        }

    }

    public static String getHostManagerId(String[] str) throws Exception{
        String managerIds = "";
        try{
            DemandMapper demandMapper = SpringUtils.getBean("demandMapper");
            for (String name : str){
                String managerId = demandMapper.getManagerId(name);
                managerIds = managerIds+managerId+",";
            }
            return managerIds.substring(0,managerIds.length() - 1);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static String getHostManagerId(String str) throws Exception{
        String managerId = "";
        try{
            DemandMapper demandMapper = SpringUtils.getBean("demandMapper");
            managerId = demandMapper.getManagerId(str);
            return managerId;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static WeeklyProjectScheduel projectScheduel(JSONObject jsonObject) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("WeeklyProjectScheduel jsonObject : "+jsonObject);
        try{
            if (null == jsonObject || jsonObject.isEmpty()){
                return null;
            }
            String project_name = jsonObject.getString("project_name");
            String host_team = jsonObject.getString("host_team");
            String host_team_id = jsonObject.getString("host_team_id");
            if (StringUtils.isBlank(host_team_id)){
                DemandMapper demandMapper = SpringUtils.getBean("demandMapper");
                host_team_id = demandMapper.getHostTeamId(host_team);
            }
            String project_manager = jsonObject.getString("project_manager");
//            String project_manager_id = jsonObject.getString("project_manager_id");
            String demand_dept = jsonObject.getString("demand_dept");
            if (StringUtils.isNotBlank(demand_dept)){
                String[] split = demand_dept.split(",");
                demand_dept = split[0];
            }
            String start_time = jsonObject.getString("start_time");
            String planned_production_time = jsonObject.getString("planned_production_time");
            String current_generation = jsonObject.getString("current_generation");
            String finished_phase = jsonObject.getString("finished_phase");
            String finish_this_week = jsonObject.getString("finish_this_week");
            String risks_difficulties = jsonObject.getString("risks_difficulties");
            String remarks = jsonObject.getString("remarks");
            String serial_no = jsonObject.getString("serial_no");
            serial_no = StringUtils.isBlank(serial_no) ? getSeqNo() : serial_no;
            String demandDeptFullName = jsonObject.getString("demand_dept_full_name");
            String create_time = jsonObject.getString("create_time");
            /*if ("项目完成".equals(current_generation)){
                create_time = sdf.format(new Date());
            }*/
            String project_manager_id = "";
            if(StringUtils.isNotBlank(project_manager)){
                if (project_manager.indexOf(",") != -1){
                    String[] split = project_manager.split(",");
                    project_manager_id = getHostManagerId(split);
                }else if (project_manager.indexOf("、") != -1){
                    String[] split = project_manager.split("、");
                    project_manager_id = getHostManagerId(split);
                }else {
                    project_manager_id = getHostManagerId(project_manager);
                }
            }
            WeeklyProjectScheduel weeklyProjectScheduel = new WeeklyProjectScheduel(
                    project_name,  host_team,  host_team_id,  project_manager,
                    project_manager_id,  demand_dept,  start_time,  planned_production_time,
                    current_generation,  finished_phase,  finish_this_week,  risks_difficulties,
                    remarks, serial_no,demandDeptFullName
            );
            weeklyProjectScheduel.setCreateTime(sdf.parse(create_time));
            return weeklyProjectScheduel;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static List<String> getDickeyAndValue(List<SysDictData> list){
        List<String> lists = new ArrayList<String>();
        if (null != list && list.size() > 0){
            for(int i = 0;i <list.size();i++){
                String value = list.get(i).getDictValue();
                lists.add(value);
            }
        }
        return lists;
    }

    public static String getDayOfWeek() throws Exception{
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int i = calendar.get(Calendar.DAY_OF_WEEK);
            return String.valueOf(i);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

}
