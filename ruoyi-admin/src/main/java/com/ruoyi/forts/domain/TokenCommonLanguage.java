package com.ruoyi.forts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 令牌开启常用语对象 token_common_language
 * 
 * @author mengdehu
 * @date 2019-11-18
 */
public class TokenCommonLanguage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_token_common_language.nextval */
    private Long id;

    /** 常用语内容 */
    @Excel(name = "常用语内容")
    private String content;

    /** 事由类型 */
    @Excel(name = "事由类型")
    private String incidentType;

    /** 标记id */
    @Excel(name = "标记id")
    private String signId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIncidentType(String incidentType) 
    {
        this.incidentType = incidentType;
    }

    public String getIncidentType() 
    {
        return incidentType;
    }
    public void setSignId(String signId) 
    {
        this.signId = signId;
    }

    public String getSignId() 
    {
        return signId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("incidentType", getIncidentType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("signId", getSignId())
            .toString();
    }
}
