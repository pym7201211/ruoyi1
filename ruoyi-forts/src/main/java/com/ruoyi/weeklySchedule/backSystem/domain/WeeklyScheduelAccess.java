package com.ruoyi.weeklySchedule.backSystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目需求权限对象 weekly_scheduel_access
 * 
 * @author mengdehu
 * @date 2020-03-12
 */
public class WeeklyScheduelAccess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工号 */
    @Excel(name = "员工号")
    private String userId;

    /** 主键 */
    private Long id;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 团队id */
    @Excel(name = "团队id")
    private String teamId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String userName;

    /** 权限等级 */
    @Excel(name = "权限等级")
    private String accessLevel;

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setTeamId(String teamId) 
    {
        this.teamId = teamId;
    }

    public String getTeamId() 
    {
        return teamId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setAccessLevel(String accessLevel) 
    {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() 
    {
        return accessLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("id", getId())
            .append("teamName", getTeamName())
            .append("teamId", getTeamId())
            .append("userName", getUserName())
            .append("accessLevel", getAccessLevel())
            .toString();
    }
}
