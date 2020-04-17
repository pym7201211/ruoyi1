package com.ruoyi.detailedList.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 搜索系统人员对象 token_searchsystem_user
 * 
 * @author mengdehu
 * @date 2020-01-03
 */
public class TokenSearchsystemUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表主键seq_token_searchSystem_user.nextval */
    private Long id;

    /** 团队id */
    @Excel(name = "团队id")
    private String teamId;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 员工id */
    @Excel(name = "员工id")
    private String userId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String userName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeamId(String teamId) 
    {
        this.teamId = teamId;
    }

    public String getTeamId() 
    {
        return teamId;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teamId", getTeamId())
            .append("teamName", getTeamName())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
