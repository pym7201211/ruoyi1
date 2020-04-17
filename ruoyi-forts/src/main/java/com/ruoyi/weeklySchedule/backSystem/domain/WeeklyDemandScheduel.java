package com.ruoyi.weeklySchedule.backSystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 需求周进度对象 weekly_demand_scheduel
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
public class WeeklyDemandScheduel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求名称 */
    @Excel(name = "需求名称")
    private String demandName;

    /** 主办团队 */
    @Excel(name = "主办团队")
    private String hostTeam;

    /** 主办团队id */
    @Excel(name = "主办团队id")
    private String hostTeamId;

    /** 主办经理 */
    @Excel(name = "主办经理")
    private String hostManager;

    /** 主办经理id */
    @Excel(name = "主办经理id")
    private String hostManagerId;

    /** 需求部门 */
    @Excel(name = "需求部门")
    private String demandDept;

    /** 需求部门id */
    @Excel(name = "需求部门id")
    private String demandDeptId;

    /** 受理时间 */
    @Excel(name = "受理时间")
    private String processingTime;

    /** 计划投产时间 */
    @Excel(name = "计划投产时间")
    private String plannedProductionTime;

    /** 计划研发完成时间 */
    @Excel(name = "计划研发完成时间")
    private String planRdCompletionTime;

    /** 当前阶段 */
    @Excel(name = "当前阶段")
    private String currentGeneration;

    /** 研发完成度 */
    @Excel(name = "研发完成度")
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
    public void setDemandName(String demandName) 
    {
        this.demandName = demandName;
    }

    public String getDemandName() 
    {
        return demandName;
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
    public void setHostManager(String hostManager) 
    {
        this.hostManager = hostManager;
    }

    public String getHostManager() 
    {
        return hostManager;
    }
    public void setHostManagerId(String hostManagerId) 
    {
        this.hostManagerId = hostManagerId;
    }

    public String getHostManagerId() 
    {
        return hostManagerId;
    }
    public void setDemandDept(String demandDept) 
    {
        this.demandDept = demandDept;
    }

    public String getDemandDept() 
    {
        return demandDept;
    }
    public void setDemandDeptId(String demandDeptId) 
    {
        this.demandDeptId = demandDeptId;
    }

    public String getDemandDeptId() 
    {
        return demandDeptId;
    }
    public void setProcessingTime(String processingTime) 
    {
        this.processingTime = processingTime;
    }

    public String getProcessingTime() 
    {
        return processingTime;
    }
    public void setPlannedProductionTime(String plannedProductionTime) 
    {
        this.plannedProductionTime = plannedProductionTime;
    }

    public String getPlannedProductionTime() 
    {
        return plannedProductionTime;
    }
    public void setPlanRdCompletionTime(String planRdCompletionTime) 
    {
        this.planRdCompletionTime = planRdCompletionTime;
    }

    public String getPlanRdCompletionTime() 
    {
        return planRdCompletionTime;
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

    public WeeklyDemandScheduel() {
    }

    public WeeklyDemandScheduel
            (String demandName, String hostTeam, String hostTeamId, String hostManager, String hostManagerId,
             String demandDept, String demandDeptId, String processingTime, String plannedProductionTime,
             String planRdCompletionTime, String currentGeneration, String finishedPhase, String finishThisWeek,
             String risksDifficulties, String remarks,String demandDeptFullName) {
        this.demandName = demandName;
        this.hostTeam = hostTeam;
        this.hostTeamId = hostTeamId;
        this.hostManager = hostManager;
        this.hostManagerId = hostManagerId;
        this.demandDept = demandDept;
        this.demandDeptId = demandDeptId;
        this.processingTime = processingTime;
        this.plannedProductionTime = plannedProductionTime;
        this.planRdCompletionTime = planRdCompletionTime;
        this.currentGeneration = currentGeneration;
        this.finishedPhase = finishedPhase;
        this.finishThisWeek = finishThisWeek;
        this.risksDifficulties = risksDifficulties;
        this.remarks = remarks;
        this.demandDeptFullName = demandDeptFullName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("finishedPhase", getFinishedPhase())
                .append("remarks", getRemarks())
                .append("planRdCompletionTime", getPlanRdCompletionTime())
                .append("plannedProductionTime", getPlannedProductionTime())
                .append("processingTime", getProcessingTime())
                .append("demandDeptId", getDemandDeptId())
                .append("demandDept", getDemandDept())
                .append("hostManagerId", getHostManagerId())
                .append("hostManager", getHostManager())
                .append("hostTeamId", getHostTeamId())
                .append("hostTeam", getHostTeam())
                .append("demandName", getDemandName())
                .append("id", getId())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .append("demandDeptFullName", getDemandDeptFullName())
                .append("serialNo", getSerialNo())
                .append("finishThisWeek", getFinishThisWeek())
                .append("risksDifficulties", getRisksDifficulties())
                .append("currentGeneration", getCurrentGeneration())
                .toString();
    }
}
