package com.ruoyi.weeklySchedule.backSystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目周进度对象 weekly_project_scheduel
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
public class WeeklyProjectScheduel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 主办团队 */
    @Excel(name = "主办团队")
    private String hostTeam;

    /** 主办团队id */
    @Excel(name = "主办团队id")
    private String hostTeamId;

    /** 项目经理 */
    @Excel(name = "项目经理")
    private String projectManager;

    /** 项目经理id */
    @Excel(name = "项目经理id")
    private String projectManagerId;

    /** 需求部门 */
    @Excel(name = "需求部门")
    private String demandDept;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 计划投产时间 */
    @Excel(name = "计划投产时间")
    private String plannedProductionTime;

    /** 当前阶段 */
    @Excel(name = "当前阶段")
    private String currentGeneration;

    /** 阶段完成 */
    @Excel(name = "阶段完成")
    private String finishedPhase;

    /** 本周完成内容 */
    @Excel(name = "本周完成内容")
    private String finishThisWeek;

    /** 风险与困难 */
    @Excel(name = "风险与困难")
    private String risksDifficulties;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 流水号 */
    @Excel(name = "流水号")
    private String serialNo;

    /** 需求部门全称 */
    @Excel(name = "需求部门全称")
    private String demandDeptFullName;

    public String getDemandDeptFullName() {
        return demandDeptFullName;
    }

    public void setDemandDeptFullName(String demandDeptFullName) {
        this.demandDeptFullName = demandDeptFullName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setHostTeam(String hostTeam) 
    {
        this.hostTeam = hostTeam;
    }

    public String getHostTeam() 
    {
        return hostTeam;
    }
    public void setHostTeamId(String hostTeamId) 
    {
        this.hostTeamId = hostTeamId;
    }

    public String getHostTeamId() 
    {
        return hostTeamId;
    }
    public void setProjectManager(String projectManager) 
    {
        this.projectManager = projectManager;
    }

    public String getProjectManager() 
    {
        return projectManager;
    }
    public void setProjectManagerId(String projectManagerId) 
    {
        this.projectManagerId = projectManagerId;
    }

    public String getProjectManagerId() 
    {
        return projectManagerId;
    }
    public void setDemandDept(String demandDept) 
    {
        this.demandDept = demandDept;
    }

    public String getDemandDept() 
    {
        return demandDept;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setPlannedProductionTime(String plannedProductionTime) 
    {
        this.plannedProductionTime = plannedProductionTime;
    }

    public String getPlannedProductionTime() 
    {
        return plannedProductionTime;
    }
    public void setCurrentGeneration(String currentGeneration) 
    {
        this.currentGeneration = currentGeneration;
    }

    public String getCurrentGeneration() 
    {
        return currentGeneration;
    }
    public void setFinishedPhase(String finishedPhase) 
    {
        this.finishedPhase = finishedPhase;
    }

    public String getFinishedPhase() 
    {
        return finishedPhase;
    }
    public void setFinishThisWeek(String finishThisWeek) 
    {
        this.finishThisWeek = finishThisWeek;
    }

    public String getFinishThisWeek() 
    {
        return finishThisWeek;
    }
    public void setRisksDifficulties(String risksDifficulties) 
    {
        this.risksDifficulties = risksDifficulties;
    }

    public String getRisksDifficulties() 
    {
        return risksDifficulties;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setSerialNo(String serialNo) 
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo() 
    {
        return serialNo;
    }

    public WeeklyProjectScheduel() {
    }

    public WeeklyProjectScheduel(
            String projectName, String hostTeam, String hostTeamId, String projectManager,
            String projectManagerId, String demandDept, String startTime, String plannedProductionTime,
            String currentGeneration, String finishedPhase, String finishThisWeek, String risksDifficulties,
            String remarks, String serialNo,String demandDeptFullName) {
        this.projectName = projectName;
        this.hostTeam = hostTeam;
        this.hostTeamId = hostTeamId;
        this.projectManager = projectManager;
        this.projectManagerId = projectManagerId;
        this.demandDept = demandDept;
        this.startTime = startTime;
        this.plannedProductionTime = plannedProductionTime;
        this.currentGeneration = currentGeneration;
        this.finishedPhase = finishedPhase;
        this.finishThisWeek = finishThisWeek;
        this.risksDifficulties = risksDifficulties;
        this.remarks = remarks;
        this.serialNo = serialNo;
        this.demandDeptFullName = demandDeptFullName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("risksDifficulties", getRisksDifficulties())
                .append("finishThisWeek", getFinishThisWeek())
                .append("finishedPhase", getFinishedPhase())
                .append("currentGeneration", getCurrentGeneration())
                .append("plannedProductionTime", getPlannedProductionTime())
                .append("startTime", getStartTime())
                .append("demandDept", getDemandDept())
                .append("projectManagerId", getProjectManagerId())
                .append("projectManager", getProjectManager())
                .append("hostTeamId", getHostTeamId())
                .append("hostTeam", getHostTeam())
                .append("projectName", getProjectName())
                .append("id", getId())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .append("remarks", getRemarks())
                .append("serialNo", getSerialNo())
                .append("demandDeptFullName", getDemandDeptFullName())
                .toString();
    }
}
