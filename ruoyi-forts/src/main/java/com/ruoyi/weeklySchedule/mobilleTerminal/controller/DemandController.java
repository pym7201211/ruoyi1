package com.ruoyi.weeklySchedule.mobilleTerminal.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyDemandScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyDemandScheduelService;
import com.ruoyi.weeklySchedule.mobilleTerminal.service.DemandService;
import com.ruoyi.weeklySchedule.until.WeeklyScheduleUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api("需求周进度")
@RestController
@RequestMapping("/DemandController")
public class DemandController {

    protected final static Logger log = LoggerFactory.getLogger(DemandController.class);

    @Autowired
    private DemandService demandService;

    @Autowired
    private IWeeklyDemandScheduelService iWeeklyDemandScheduelService;

    @Autowired
    private ISysDictDataService iSysDictDataService;


    @ApiOperation("获取主办团队")
    @PostMapping("/getHostTeam")
    @ResponseBody
    public ModelMap getHostTeam(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = demandService.selectHostTeam(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List list = (List) jsonObject.get("list");
            String access = jsonObject.getString("access");
            List<String> host_team_id = (List<String>)jsonObject.get("host_team_id");
            modelMap.put("list",list);
            modelMap.put("assess",access);
            modelMap.put("host_team_id",host_team_id);
        }catch (Exception e){
            log.error("查询获取主办团队接口异常 ： ",e);
        }
        log.info("getHostTeam : "+modelMap);
        return modelMap;
    }

    @ApiOperation("获取需求周进度")
    @PostMapping("/getDemandInfo")
    @ResponseBody
    public ModelMap getDemandInfo(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = demandService.selectDemandInfo(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List<HashMap<String,Object>> list = (List<HashMap<String, Object>>) jsonObject.get("list");
            List lists = WeeklyScheduleUntil.transList(list);
            List<HashMap<String,Object>> listes = (List<HashMap<String, Object>>) jsonObject.get("lists");
            List listess = WeeklyScheduleUntil.transList(listes);
            modelMap.put("list",lists);
            modelMap.put("lists",listess);
        }catch (Exception e){
            log.error("查询获取需求周进度接口异常 ： ",e);
        }
        log.info("getDemandInfo : "+modelMap);
        return modelMap;
    }

    @ApiOperation("添加需求周进度")
    @PostMapping("/insertDemandInfo")
    @ResponseBody
    public ModelMap insertDemandInfo(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return WeeklyScheduleUntil.resultModelMap(jsonClient);
            }
            WeeklyDemandScheduel weeklyDemandScheduel = WeeklyScheduleUntil.demandScheduel(jsonClient);
            iWeeklyDemandScheduelService.insertWeeklyDemandScheduel(weeklyDemandScheduel);
        }catch (Exception e){
            log.error("添加需求周进度接口异常 ： ",e);
        }
        log.info("insertDemandInfo : "+modelMap);
        return WeeklyScheduleUntil.resultModelMap("0","添加成功");
    }

    @ApiOperation("获取树状图数据")
    @GetMapping("/getDendrogramData")
    @ResponseBody
    public ModelMap getDendrogramData(){
        ModelMap modelMap = null;
        try {
            /*JSONObject jsonObject = demandService.selectDataByDemandDept();
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List list1 = (List) jsonObject.get("list1");
            List list2 = (List) jsonObject.get("list2");
            modelMap.put("echartDepData",list1);
            modelMap.put("echartTimeData",list2);*/
            JSONObject jsonObject = demandService.selectDataByDemandDept();
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List list = (List) jsonObject.get("list");
            modelMap.put("echartsDep",list);
        }catch (Exception e){
            log.error("获取树状图数据接口异常 ： ",e);
        }
        log.info("getDendrogramData : "+modelMap);
        return modelMap;
    }

    @ApiOperation("判断是否有权限查看图形")
    @PostMapping("/checkAccess")
    @ResponseBody
    public ModelMap checkAccess(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = demandService.checkAccess(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            String checkAccess = jsonObject.getString("checkAccess");
            modelMap.put("checkAccess",checkAccess);
        }catch (Exception e){
            log.error("判断是否有权限查看图形接口异常 ： ",e);
        }
        log.info("checkAccess : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询需求阶段")
    @GetMapping("/selectDemandCurrent")
    @ResponseBody
    public ModelMap selectDemandCurrent(){
        ModelMap modelMap = new ModelMap();
        try {
            List<SysDictData> weekly_schedule_demand = iSysDictDataService.selectDictDataByType("weekly_Schedule_demand");
            List<String> dickeyAndValue = WeeklyScheduleUntil.getDickeyAndValue(weekly_schedule_demand);
            modelMap.put("dickeyAndValue",dickeyAndValue);
            modelMap.put("code","0");
        }catch (Exception e){
            log.error("查询需求阶段接口异常 ： ",e);
        }
        log.info("selectDemandCurrent : "+modelMap);
        return modelMap;
    }

    @ApiOperation("根据流水号删除记录")
    @PostMapping("/deleteDemandBySerialNo")
    @ResponseBody
    public ModelMap deleteDemandBySerialNo(@RequestBody String json){
        ModelMap modelMap = new ModelMap();
        try {
            JSONObject jsonObject = demandService.deleteDemandBySerialNo(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
        }catch (Exception e){
            log.error("根据流水号删除记录接口异常 ： ",e);
        }
        log.info("deleteDemandBySerialNo : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询部门简称")
    @GetMapping("/selectDemandDeptName")
    @ResponseBody
    public ModelMap selectDemandDeptName(){
        ModelMap modelMap = new ModelMap();
        try {
            List<SysDictData> weekly_deptName = iSysDictDataService.selectDictDataByType("weekly_deptName");
            List<String> deptName = WeeklyScheduleUntil.getDickeyAndValue(weekly_deptName);
            modelMap.put("deptName",deptName);
            modelMap.put("code","0");
        }catch (Exception e){
            log.error("查询部门简称接口异常 ： ",e);
        }
        log.info("selectDemandDeptName : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询主办团队")
    @GetMapping("/selectDemandTeam")
    @ResponseBody
    public ModelMap selectDemandTeam(){
        ModelMap modelMap = new ModelMap();
        try {
            JSONObject jsonObject = demandService.getHostTeam();
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List list = (List) jsonObject.get("list");
            modelMap.put("code","0");
            modelMap.put("list",list);
        }catch (Exception e){
            log.error("查询主办团队接口异常 ： ",e);
        }
        log.info("selectDemandTeam : "+modelMap);
        return modelMap;
    }

    public static void main(String[] args){
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.get(Calendar.DAY_OF_WEEK);*/
        JSONObject json = new JSONObject();
        json.put("aa",null);
        System.out.println("=====>>>"+json);
    }




}
