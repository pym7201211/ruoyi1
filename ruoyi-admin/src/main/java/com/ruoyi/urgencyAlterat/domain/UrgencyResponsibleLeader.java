package com.ruoyi.urgencyAlterat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分管领导对象 urgency_responsible_leader
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public class UrgencyResponsibleLeader extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_urgency_responsible_leader.nextval */
    private Long id;

    /** 分管id */
    @Excel(name = "分管id")
    private String leaderId;

    /** 分管姓名 */
    @Excel(name = "分管姓名")
    private String leaderName;

    /** 部门id */
    @Excel(name = "部门id")
    private String deptId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("id", getId())
            .append("leaderId", getLeaderId())
            .append("leaderName", getLeaderName())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .toString();
    }
}
