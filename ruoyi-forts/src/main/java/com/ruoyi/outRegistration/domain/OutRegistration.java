package com.ruoyi.outRegistration.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外包人员外出请假登记对象 out_registration
 * 
 * @author ruoyi
 * @date 2020-04-03
 */
public class OutRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出发地 */
    @Excel(name = "出发地")
    private String departureSite;

    /** 所属行方项目经理 */
    @Excel(name = "所属行方项目经理")
    private String projectManager;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyName;

    /** 外包人员姓名 */
    @Excel(name = "外包人员姓名")
    private String staffName;

    /** 主键 */
    private Long id;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 时长 */
    @Excel(name = "时长")
    private String burningTime;

    /** 外出结束时间 */
    @Excel(name = "外出结束时间")
    private String endTime;

    /** 外出开始时间 */
    @Excel(name = "外出开始时间")
    private String startTime;

    /** 外出事由 */
    @Excel(name = "外出事由")
    private String cause;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

    /** 其他出发地 */
    @Excel(name = "其他出发地")
    private String otherDeparture;

    /** 其他目的地 */
    @Excel(name = "其他目的地")
    private String otherDestination;

    /** 其他外出事由 */
    @Excel(name = "其他外出事由")
    private String otherCause;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private String operatorId;

    public OutRegistration() {
    }

    public OutRegistration(String departureSite, String projectManager, String companyName, String staffName, String destination, String burningTime, String endTime, String startTime, String cause, String remark, String otherDeparture, String otherDestination, String otherCause, String operatorId) {
        this.departureSite = departureSite;
        this.projectManager = projectManager;
        this.companyName = companyName;
        this.staffName = staffName;
        this.destination = destination;
        this.burningTime = burningTime;
        this.endTime = endTime;
        this.startTime = startTime;
        this.cause = cause;
        this.remark = remark;
        this.otherDeparture = otherDeparture;
        this.otherDestination = otherDestination;
        this.otherCause = otherCause;
        this.operatorId = operatorId;
    }

    public void setDepartureSite(String departureSite)
    {
        this.departureSite = departureSite;
    }

    public String getDepartureSite() 
    {
        return departureSite;
    }
    public void setProjectManager(String projectManager) 
    {
        this.projectManager = projectManager;
    }

    public String getProjectManager() 
    {
        return projectManager;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setStaffName(String staffName) 
    {
        this.staffName = staffName;
    }

    public String getStaffName() 
    {
        return staffName;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setBurningTime(String burningTime) 
    {
        this.burningTime = burningTime;
    }

    public String getBurningTime() 
    {
        return burningTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOtherDeparture() {
        return otherDeparture;
    }

    public void setOtherDeparture(String otherDeparture) {
        this.otherDeparture = otherDeparture;
    }

    public String getOtherDestination() {
        return otherDestination;
    }

    public void setOtherDestination(String otherDestination) {
        this.otherDestination = otherDestination;
    }

    public String getOtherCause() {
        return otherCause;
    }

    public void setOtherCause(String otherCause) {
        this.otherCause = otherCause;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return "OutRegistration{" +
                "departureSite='" + departureSite + '\'' +
                ", projectManager='" + projectManager + '\'' +
                ", companyName='" + companyName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", destination='" + destination + '\'' +
                ", burningTime='" + burningTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", cause='" + cause + '\'' +
                ", remark='" + remark + '\'' +
                ", otherDeparture='" + otherDeparture + '\'' +
                ", otherDestination='" + otherDestination + '\'' +
                ", otherCause='" + otherCause + '\'' +
                ", operatorId='" + operatorId + '\'' +
                '}';
    }
}
