package com.ruoyi.urgencyAlterat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主管变更领导对象 urgency_charge_leader
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public class UrgencyChargeLeader extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主管变更id */
    @Excel(name = "主管变更id")
    private String leaderId;

    /** 主管变更姓名 */
    @Excel(name = "主管变更姓名")
    private String leaderName;

    /** 部门id */
    @Excel(name = "部门id")
    private String deptId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 主键seq_urgency_charge_leader.nextval */
    private Long id;

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
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("leaderId", getLeaderId())
            .append("leaderName", getLeaderName())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("id", getId())
            .toString();
    }
}
