package com.ruoyi.urgencyAlterat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 紧急变更登记对象 urgency_alterat_register
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public class UrgencyAlteratRegister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_urgency_alterat_register.nextval */
    private Long id;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 操作人id */
    @Excel(name = "操作人id")
    private String operatorId;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 复核人id */
    @Excel(name = "复核人id")
    private String reviewerId;

    /** 复核人 */
    @Excel(name = "复核人")
    private String reviewer;

    /** 序列 */
    @Excel(name = "序列")
    private String orderNum;

    /** 变更日期 */
    @Excel(name = "变更日期")
    private String urgencyDate;

    /** 实施人 */
    @Excel(name = "实施人")
    private String executor;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 变更功能点描述 */
    @Excel(name = "变更功能点描述")
    private String urgencyFunDescribe;

    /** 相关系统配合说明 */
    @Excel(name = "相关系统配合说明")
    private String cooperateItems;

    /** 是否代码已审核 */
    @Excel(name = "是否代码已审核")
    private String codeAudit;

    /** 是否完成测试 */
    @Excel(name = "是否完成测试")
    private String finishTheTest;

    /** 是否完成压力测试 */
    @Excel(name = "是否完成压力测试")
    private String pressureTest;

    /** 是否业务投产申请 */
    @Excel(name = "是否业务投产申请")
    private String businessOperation;

    /** 是否操作手册更新 */
    @Excel(name = "是否操作手册更新")
    private String handbookUpdate;

    /** 风险点描述 */
    @Excel(name = "风险点描述")
    private String riskDescribe;

    /** 是否制定应急回退 */
    @Excel(name = "是否制定应急回退")
    private String sendBackScheme;

    /** 变更发起的业务部门 */
    @Excel(name = "变更发起的业务部门")
    private String urgencySponsorDept;

    /** 是否涉及互联网系统变更 */
    @Excel(name = "是否涉及互联网系统变更")
    private String internetUrgency;

    /** 安全团队确认 */
    @Excel(name = "安全团队确认")
    private String securityTeam;

    /** 是否涉及数据变更 */
    @Excel(name = "是否涉及数据变更")
    private String dataUrgency;

    /** 大数据管理团队确认 */
    @Excel(name = "大数据管理团队确认")
    private String bigDataTeam;

    /** 涉及系统 */
    @Excel(name = "涉及系统")
    private String involveSystem;

    /** 更步骤文字说明 */
    @Excel(name = "更步骤文字说明")
    private String involveSystemIllustrate;

    /** 0：未认证 */
    @Excel(name = "0：未认证")
    private String status;

    /** 订单流水号 */
    @Excel(name = "订单流水号")
    private String orderNo;

    /** 团队主管签字 */
    @Excel(name = "团队主管签字")
    private String teamCharge;

    /** 分管领导签字 */
    @Excel(name = "分管领导签字")
    private String teamBranched;

    /** 主管变更领导签字 */
    @Excel(name = "主管变更领导签字")
    private String chargeLeader;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String manageStatus;

    /** 当前任务 */
    @Excel(name = "当前任务")
    private String currentTask;

    /** 实施人id */
    @Excel(name = "实施人id")
    private String executorId;

    /** 分管id */
    @Excel(name = "分管id")
    private String teamBranchedId;

    /** 主管id */
    @Excel(name = "主管id")
    private String chargeLeaderId;

    /** 团队主管签字 */
    @Excel(name = "团队主管签字")
    private String teamChargeStatus;

    /** 分管签字状态 */
    @Excel(name = "分管签字状态")
    private String teamBranchedStatus;

    /** 变更主管签字 */
    @Excel(name = "变更主管签字")
    private String chargeLeaderStatus;

    /** 团队主管id */
    @Excel(name = "团队主管id")
    private String teamChargeId;

    /** 安全团队id */
    @Excel(name = "安全团队id")
    private String securityTeamId;

    /** 大数据团队id */
    @Excel(name = "大数据团队id")
    private String bigDataTeamId;

    /** 复核人确认状态 */
    @Excel(name = "复核人确认状态")
    private String reviewerStatus;

    @Excel(name = "所属团队")
    private String scienceChargeTeam;

    public String getScienceChargeTeam() {
        return scienceChargeTeam;
    }

    public void setScienceChargeTeam(String scienceChargeTeam) {
        this.scienceChargeTeam = scienceChargeTeam;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setOperatorId(String operatorId) 
    {
        this.operatorId = operatorId;
    }

    public String getOperatorId() 
    {
        return operatorId;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setReviewerId(String reviewerId) 
    {
        this.reviewerId = reviewerId;
    }

    public String getReviewerId() 
    {
        return reviewerId;
    }
    public void setReviewer(String reviewer) 
    {
        this.reviewer = reviewer;
    }

    public String getReviewer() 
    {
        return reviewer;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setUrgencyDate(String urgencyDate) 
    {
        this.urgencyDate = urgencyDate;
    }

    public String getUrgencyDate() 
    {
        return urgencyDate;
    }
    public void setExecutor(String executor) 
    {
        this.executor = executor;
    }

    public String getExecutor() 
    {
        return executor;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setUrgencyFunDescribe(String urgencyFunDescribe) 
    {
        this.urgencyFunDescribe = urgencyFunDescribe;
    }

    public String getUrgencyFunDescribe() 
    {
        return urgencyFunDescribe;
    }
    public void setCooperateItems(String cooperateItems) 
    {
        this.cooperateItems = cooperateItems;
    }

    public String getCooperateItems() 
    {
        return cooperateItems;
    }
    public void setCodeAudit(String codeAudit) 
    {
        this.codeAudit = codeAudit;
    }

    public String getCodeAudit() 
    {
        return codeAudit;
    }
    public void setFinishTheTest(String finishTheTest) 
    {
        this.finishTheTest = finishTheTest;
    }

    public String getFinishTheTest() 
    {
        return finishTheTest;
    }
    public void setPressureTest(String pressureTest) 
    {
        this.pressureTest = pressureTest;
    }

    public String getPressureTest() 
    {
        return pressureTest;
    }
    public void setBusinessOperation(String businessOperation) 
    {
        this.businessOperation = businessOperation;
    }

    public String getBusinessOperation() 
    {
        return businessOperation;
    }
    public void setHandbookUpdate(String handbookUpdate) 
    {
        this.handbookUpdate = handbookUpdate;
    }

    public String getHandbookUpdate() 
    {
        return handbookUpdate;
    }
    public void setRiskDescribe(String riskDescribe) 
    {
        this.riskDescribe = riskDescribe;
    }

    public String getRiskDescribe() 
    {
        return riskDescribe;
    }
    public void setSendBackScheme(String sendBackScheme) 
    {
        this.sendBackScheme = sendBackScheme;
    }

    public String getSendBackScheme() 
    {
        return sendBackScheme;
    }
    public void setUrgencySponsorDept(String urgencySponsorDept) 
    {
        this.urgencySponsorDept = urgencySponsorDept;
    }

    public String getUrgencySponsorDept() 
    {
        return urgencySponsorDept;
    }
    public void setInternetUrgency(String internetUrgency) 
    {
        this.internetUrgency = internetUrgency;
    }

    public String getInternetUrgency() 
    {
        return internetUrgency;
    }
    public void setSecurityTeam(String securityTeam) 
    {
        this.securityTeam = securityTeam;
    }

    public String getSecurityTeam() 
    {
        return securityTeam;
    }
    public void setDataUrgency(String dataUrgency) 
    {
        this.dataUrgency = dataUrgency;
    }

    public String getDataUrgency() 
    {
        return dataUrgency;
    }
    public void setBigDataTeam(String bigDataTeam) 
    {
        this.bigDataTeam = bigDataTeam;
    }

    public String getBigDataTeam() 
    {
        return bigDataTeam;
    }
    public void setInvolveSystem(String involveSystem) 
    {
        this.involveSystem = involveSystem;
    }

    public String getInvolveSystem() 
    {
        return involveSystem;
    }
    public void setInvolveSystemIllustrate(String involveSystemIllustrate) 
    {
        this.involveSystemIllustrate = involveSystemIllustrate;
    }

    public String getInvolveSystemIllustrate() 
    {
        return involveSystemIllustrate;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setTeamCharge(String teamCharge) 
    {
        this.teamCharge = teamCharge;
    }

    public String getTeamCharge() 
    {
        return teamCharge;
    }
    public void setTeamBranched(String teamBranched) 
    {
        this.teamBranched = teamBranched;
    }

    public String getTeamBranched() 
    {
        return teamBranched;
    }
    public void setChargeLeader(String chargeLeader) 
    {
        this.chargeLeader = chargeLeader;
    }

    public String getChargeLeader() 
    {
        return chargeLeader;
    }
    public void setManageStatus(String manageStatus) 
    {
        this.manageStatus = manageStatus;
    }

    public String getManageStatus() 
    {
        return manageStatus;
    }
    public void setCurrentTask(String currentTask) 
    {
        this.currentTask = currentTask;
    }

    public String getCurrentTask() 
    {
        return currentTask;
    }
    public void setExecutorId(String executorId) 
    {
        this.executorId = executorId;
    }

    public String getExecutorId() 
    {
        return executorId;
    }
    public void setTeamBranchedId(String teamBranchedId) 
    {
        this.teamBranchedId = teamBranchedId;
    }

    public String getTeamBranchedId() 
    {
        return teamBranchedId;
    }
    public void setChargeLeaderId(String chargeLeaderId) 
    {
        this.chargeLeaderId = chargeLeaderId;
    }

    public String getChargeLeaderId() 
    {
        return chargeLeaderId;
    }
    public void setTeamChargeStatus(String teamChargeStatus) 
    {
        this.teamChargeStatus = teamChargeStatus;
    }

    public String getTeamChargeStatus() 
    {
        return teamChargeStatus;
    }
    public void setTeamBranchedStatus(String teamBranchedStatus) 
    {
        this.teamBranchedStatus = teamBranchedStatus;
    }

    public String getTeamBranchedStatus() 
    {
        return teamBranchedStatus;
    }
    public void setChargeLeaderStatus(String chargeLeaderStatus) 
    {
        this.chargeLeaderStatus = chargeLeaderStatus;
    }

    public String getChargeLeaderStatus() 
    {
        return chargeLeaderStatus;
    }
    public void setTeamChargeId(String teamChargeId) 
    {
        this.teamChargeId = teamChargeId;
    }

    public String getTeamChargeId() 
    {
        return teamChargeId;
    }
    public void setSecurityTeamId(String securityTeamId) 
    {
        this.securityTeamId = securityTeamId;
    }

    public String getSecurityTeamId() 
    {
        return securityTeamId;
    }
    public void setBigDataTeamId(String bigDataTeamId) 
    {
        this.bigDataTeamId = bigDataTeamId;
    }

    public String getBigDataTeamId() 
    {
        return bigDataTeamId;
    }
    public void setReviewerStatus(String reviewerStatus) 
    {
        this.reviewerStatus = reviewerStatus;
    }

    public String getReviewerStatus() 
    {
        return reviewerStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("systemName", getSystemName())
            .append("operatorId", getOperatorId())
            .append("operator", getOperator())
            .append("reviewerId", getReviewerId())
            .append("reviewer", getReviewer())
            .append("orderNum", getOrderNum())
            .append("urgencyDate", getUrgencyDate())
            .append("executor", getExecutor())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("urgencyFunDescribe", getUrgencyFunDescribe())
            .append("cooperateItems", getCooperateItems())
            .append("codeAudit", getCodeAudit())
            .append("finishTheTest", getFinishTheTest())
            .append("pressureTest", getPressureTest())
            .append("businessOperation", getBusinessOperation())
            .append("handbookUpdate", getHandbookUpdate())
            .append("riskDescribe", getRiskDescribe())
            .append("sendBackScheme", getSendBackScheme())
            .append("urgencySponsorDept", getUrgencySponsorDept())
            .append("internetUrgency", getInternetUrgency())
            .append("securityTeam", getSecurityTeam())
            .append("dataUrgency", getDataUrgency())
            .append("bigDataTeam", getBigDataTeam())
            .append("involveSystem", getInvolveSystem())
            .append("involveSystemIllustrate", getInvolveSystemIllustrate())
            .append("status", getStatus())
            .append("orderNo", getOrderNo())
            .append("teamCharge", getTeamCharge())
            .append("teamBranched", getTeamBranched())
            .append("chargeLeader", getChargeLeader())
            .append("manageStatus", getManageStatus())
            .append("currentTask", getCurrentTask())
            .append("executorId", getExecutorId())
            .append("teamBranchedId", getTeamBranchedId())
            .append("chargeLeaderId", getChargeLeaderId())
            .append("teamChargeStatus", getTeamChargeStatus())
            .append("teamBranchedStatus", getTeamBranchedStatus())
            .append("chargeLeaderStatus", getChargeLeaderStatus())
            .append("teamChargeId", getTeamChargeId())
            .append("securityTeamId", getSecurityTeamId())
            .append("bigDataTeamId", getBigDataTeamId())
            .append("reviewerStatus", getReviewerStatus())
            .toString();
    }
}
