package com.ruoyi.urgencyforts.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 变更时点验证对象 urgency_alterat_verify
 * 
 * @author mengdehu
 * @date 2020-01-09
 */
public class UrgencyAlteratVerifys extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_urgency_alterat_verify.nextval */
    private Long id;

    /** 订单流水号 */
    @Excel(name = "订单流水号")
    private String orderNum;

    /** 变更时间 */
    @Excel(name = "变更时间")
    private String changeTime;

    /** 是否停机 */
    @Excel(name = "是否停机")
    private String isHalt;

    /** 停机影响范围 */
    @Excel(name = "停机影响范围")
    private String haltRange;

    /** 停机时间 */
    @Excel(name = "停机时间")
    private String haltTime;

    /** 验证时间 */
    @Excel(name = "验证时间")
    private String verifyDate;

    /** 验证方案 */
    @Excel(name = "验证方案")
    private String verifyScheme;

    /** 信息科技部 */
    @Excel(name = "信息科技部")
    private String inforMost;

    /** 变更发起部门 */
    @Excel(name = "变更发起部门")
    private String urgencySendDept;

    /** 验证状态 */
    @Excel(name = "验证状态")
    private String verifyStatus;

    /** 停机开始时间 */
    @Excel(name = "停机开始时间")
    private String startTime;

    /** 停机结束时间 */
    @Excel(name = "停机结束时间")
    private String endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setChangeTime(String changeTime) 
    {
        this.changeTime = changeTime;
    }

    public String getChangeTime() 
    {
        return changeTime;
    }
    public void setIsHalt(String isHalt) 
    {
        this.isHalt = isHalt;
    }

    public String getIsHalt() 
    {
        return isHalt;
    }
    public void setHaltRange(String haltRange) 
    {
        this.haltRange = haltRange;
    }

    public String getHaltRange() 
    {
        return haltRange;
    }
    public void setHaltTime(String haltTime) 
    {
        this.haltTime = haltTime;
    }

    public String getHaltTime() 
    {
        return haltTime;
    }
    public void setVerifyDate(String verifyDate) 
    {
        this.verifyDate = verifyDate;
    }

    public String getVerifyDate() 
    {
        return verifyDate;
    }
    public void setVerifyScheme(String verifyScheme) 
    {
        this.verifyScheme = verifyScheme;
    }

    public String getVerifyScheme() 
    {
        return verifyScheme;
    }
    public void setInforMost(String inforMost) 
    {
        this.inforMost = inforMost;
    }

    public String getInforMost() 
    {
        return inforMost;
    }
    public void setUrgencySendDept(String urgencySendDept) 
    {
        this.urgencySendDept = urgencySendDept;
    }

    public String getUrgencySendDept() 
    {
        return urgencySendDept;
    }
    public void setVerifyStatus(String verifyStatus) 
    {
        this.verifyStatus = verifyStatus;
    }

    public String getVerifyStatus() 
    {
        return verifyStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public UrgencyAlteratVerifys(
            /*Long id,*/ String orderNum, String changeTime, String isHalt, String haltRange,
                         String haltTime, String verifyDate, String verifyScheme, String inforMost,
                         String urgencySendDept, String verifyStatus,String startTime,String endTime) {
        //this.id = id;
        this.orderNum = orderNum;
        this.changeTime = changeTime;
        this.isHalt = isHalt;
        this.haltRange = haltRange;
        this.haltTime = haltTime;
        this.verifyDate = verifyDate;
        this.verifyScheme = verifyScheme;
        this.inforMost = inforMost;
        this.urgencySendDept = urgencySendDept;
        this.verifyStatus = verifyStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNum", getOrderNum())
            .append("changeTime", getChangeTime())
            .append("isHalt", getIsHalt())
            .append("haltRange", getHaltRange())
            .append("haltTime", getHaltTime())
            .append("verifyDate", getVerifyDate())
            .append("verifyScheme", getVerifyScheme())
            .append("inforMost", getInforMost())
            .append("urgencySendDept", getUrgencySendDept())
            .append("verifyStatus", getVerifyStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("startTime",getStartTime())
            .append("endTime",getEndTime())
            .toString();
    }
}
