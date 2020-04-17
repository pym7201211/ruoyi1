package com.ruoyi.ruoyiforts.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批流程对象 token_approval_process
 * 
 * @author mengdehu
 * @date 2019-12-22
 */
public class TokenApprovalProcesses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 领导id */
    @Excel(name = "领导id")
    private String leaderId;

    /** 领导名称 */
    @Excel(name = "领导名称")
    private String leaderName;

    /** 员工id */
    @Excel(name = "员工id")
    private String employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 审批内容 */
    @Excel(name = "审批内容")
    private String applyContent;

    /** 流水号 */
    @Excel(name = "流水号")
    private String seno;

    /** 审批状态 0-不同意 1-同意 2-审批中 3-未审批 */
    @Excel(name = "审批状态 0-不同意 1-同意 2-审批中 3-未审批")
    private String approvalStatus;

    /** 按钮类型 0-认领 1-转交 2-移除 */
    @Excel(name = "按钮类型 0-认领 1-转交 2-移除")
    private String buttonType;

    /** 转交id */
    @Excel(name = "转交id")
    private String transferId;

    /** 转交人 */
    @Excel(name = "转交人")
    private String transferName;

    /** 系统id */
    @Excel(name = "系统id")
    private String systemId;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLeaderId(String leaderId) 
    {
        this.leaderId = leaderId;
    }

    public String getLeaderId() 
    {
        return leaderId;
    }
    public void setLeaderName(String leaderName) 
    {
        this.leaderName = leaderName;
    }

    public String getLeaderName() 
    {
        return leaderName;
    }
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setApplyContent(String applyContent) 
    {
        this.applyContent = applyContent;
    }

    public String getApplyContent() 
    {
        return applyContent;
    }
    public void setSeno(String seno) 
    {
        this.seno = seno;
    }

    public String getSeno() 
    {
        return seno;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setButtonType(String buttonType) 
    {
        this.buttonType = buttonType;
    }

    public String getButtonType() 
    {
        return buttonType;
    }
    public void setTransferId(String transferId) 
    {
        this.transferId = transferId;
    }

    public String getTransferId() 
    {
        return transferId;
    }
    public void setTransferName(String transferName) 
    {
        this.transferName = transferName;
    }

    public String getTransferName() 
    {
        return transferName;
    }
    public void setSystemId(String systemId) 
    {
        this.systemId = systemId;
    }

    public String getSystemId() 
    {
        return systemId;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("leaderId", getLeaderId())
            .append("leaderName", getLeaderName())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("applyContent", getApplyContent())
            .append("seno", getSeno())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("approvalStatus", getApprovalStatus())
            .append("buttonType", getButtonType())
            .append("transferId", getTransferId())
            .append("transferName", getTransferName())
            .append("systemId", getSystemId())
            .append("systemName", getSystemName())
            .toString();
    }
}
