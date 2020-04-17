package com.ruoyi.weeklySchedule.mobilleTerminal.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyProjectScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyDemandScheduelService;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyProjectScheduelService;
import com.ruoyi.weeklySchedule.mobilleTerminal.service.DemandService;
import com.ruoyi.weeklySchedule.mobilleTerminal.service.ProjectService;
import com.ruoyi.weeklySchedule.until.WeeklyScheduleUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api("项目周进度")
@RestController
@RequestMapping("/ProjectController")
public class ProjectController {

    protected final static Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IWeeklyProjectScheduelService iWeeklyProjectScheduelService;

    @Autowired
    private ISysDictDataService iSysDictDataService;

    @ApiOperation("获取主办团队")
    @PostMapping("/getHostTeam")
    @ResponseBody
    public ModelMap getHostTeam(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = projectService.selectHostTeam(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            String access = jsonObject.getString("access");
            List<String> host_team_id = (List<String>)jsonObject.get("host_team_id");
            List list = (List) jsonObject.get("list");
            modelMap.put("list",list);
            modelMap.put("assess",access);
            modelMap.put("host_team_id",host_team_id);
        }catch (Exception e){
            log.error("查询获取主办团队接口异常 ： ",e);
        }
        log.info("getHostTeam : "+modelMap);
        return modelMap;
    }

    @ApiOperation("获取项目周进度")
    @PostMapping("/getDemandInfo")
    @ResponseBody
    public ModelMap getDemandInfo(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonObject = projectService.selectDemandInfo(json);
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

    @ApiOperation("添加项目周进度")
    @PostMapping("/insertProjectInfo")
    @ResponseBody
    public ModelMap insertProjectInfo(@RequestBody String json){
        ModelMap modelMap = null;
        try {
            JSONObject jsonClient = WeeklyScheduleUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return WeeklyScheduleUntil.resultModelMap(jsonClient);
            }
            WeeklyProjectScheduel weeklyProjectScheduel = WeeklyScheduleUntil.projectScheduel(jsonClient);
            iWeeklyProjectScheduelService.insertWeeklyProjectScheduel(weeklyProjectScheduel);
        }catch (Exception e){
            log.error("添加项目周进度接口异常 ： ",e);
        }
        log.info("insertProjectInfo : "+modelMap);
        return WeeklyScheduleUntil.resultModelMap("0","添加成功");
    }

    @ApiOperation("查询项目阶段")
    @GetMapping("/selectProjectCurrent")
    @ResponseBody
    public ModelMap selectDemandCurrent(){
        ModelMap modelMap = new ModelMap();
        try {
            List<SysDictData> weekly_schedule_demand = iSysDictDataService.selectDictDataByType("weekly_Schedule_project");
            List<String> dickeyAndValue = WeeklyScheduleUntil.getDickeyAndValue(weekly_schedule_demand);
            modelMap.put("dickeyAndValue",dickeyAndValue);
            modelMap.put("code","0");
        }catch (Exception e){
            log.error("查询项目阶段接口异常 ： ",e);
        }
        log.info("selectProjectCurrent : "+modelMap);
        return modelMap;
    }

    @ApiOperation("根据流水号删除记录")
    @PostMapping("/deleteProjectBySerialNo")
    @ResponseBody
    public ModelMap deleteProjectBySerialNo(@RequestBody String json){
        ModelMap modelMap = new ModelMap();
        try {
            JSONObject jsonObject = projectService.deleteProjectBySerialNo(json);
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
        }catch (Exception e){
            log.error("根据流水号删除记录接口异常 ： ",e);
        }
        log.info("deleteProjectBySerialNo : "+modelMap);
        return modelMap;
    }

    @ApiOperation("查询主办团队")
    @GetMapping("/selectProjectTeam")
    @ResponseBody
    public ModelMap selectDemandTeam(){
        ModelMap modelMap = new ModelMap();
        try {
            JSONObject jsonObject = projectService.getHostTeam();
            modelMap = WeeklyScheduleUntil.resultModelMap(jsonObject);
            List list = (List) jsonObject.get("list");
            modelMap.put("code","0");
            modelMap.put("list",list);
        }catch (Exception e){
            log.error("查询主办团队接口异常 ： ",e);
        }
        log.info("selectProjectTeam : "+modelMap);
        return modelMap;
    }

}
