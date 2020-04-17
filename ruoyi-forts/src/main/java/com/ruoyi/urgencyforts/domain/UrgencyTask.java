package com.ruoyi.urgencyforts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 紧急变更线程对象 urgency_task
 * 
 * @author mengdehu
 * @date 2020-03-21
 */
public class UrgencyTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 员工id */
    @Excel(name = "员工id")
    private String employeeId;

    /** 申请环境 */
    @Excel(name = "申请环境")
    private String applyEnvironment;

    /** 开启时间 */
    @Excel(name = "开启时间")
    private String openDate;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endDate;

    /** 发送消息内容 */
    @Excel(name = "发送消息内容")
    private String sendContent;

    /** 状态 0-未执行 1-已执行 */
    @Excel(name = "状态 0-未执行 1-已执行")
    private String status;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String taskType;

    /** 发送消息标题 */
    @Excel(name = "发送消息标题")
    private String sendTag;

    /** 流水号 */
    @Excel(name = "流水号")
    private String seqNo;

    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setApplyEnvironment(String applyEnvironment) 
    {
        this.applyEnvironment = applyEnvironment;
    }

    public String getApplyEnvironment() 
    {
        return applyEnvironment;
    }
    public void setOpenDate(String openDate) 
    {
        this.openDate = openDate;
    }

    public String getOpenDate() 
    {
        return openDate;
    }
    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }

    public String getEndDate() 
    {
        return endDate;
    }
    public void setSendContent(String sendContent) 
    {
        this.sendContent = sendContent;
    }

    public String getSendContent() 
    {
        return sendContent;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setSendTag(String sendTag) 
    {
        this.sendTag = sendTag;
    }

    public String getSendTag() 
    {
        return sendTag;
    }
    public void setSeqNo(String seqNo) 
    {
        this.seqNo = seqNo;
    }

    public String getSeqNo() 
    {
        return seqNo;
    }

    public UrgencyTask(){};

    public UrgencyTask(
            String employeeId, String applyEnvironment, String openDate, String endDate,
            String sendContent, String status, String taskType, String sendTag, String seqNo, Date createTime) {
        this.employeeId = employeeId;
        this.applyEnvironment = applyEnvironment;
        this.openDate = openDate;
        this.endDate = endDate;
        this.sendContent = sendContent;
        this.status = status;
        this.taskType = taskType;
        this.sendTag = sendTag;
        this.seqNo = seqNo;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("applyEnvironment", getApplyEnvironment())
            .append("openDate", getOpenDate())
            .append("endDate", getEndDate())
            .append("sendContent", getSendContent())
            .append("status", getStatus())
            .append("taskType", getTaskType())
            .append("createTime", getCreateTime())
            .append("sendTag", getSendTag())
            .append("seqNo", getSeqNo())
            .toString();
    }
}
