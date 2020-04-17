package com.ruoyi.urgencyforts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 调用影像系统对象 urgency_image_system
 * 
 * @author mengdehu
 * @date 2020-02-26
 */
public class UrgencyImageSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_urgency_image_system.nextval */
    private Long id;

    /** 流水号 */
    @Excel(name = "流水号")
    private String orderNo;

    /** 员工号 */
    @Excel(name = "员工号")
    private String userId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String folderName;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 影像流水号 */
    @Excel(name = "影像流水号")
    private String ecmBusCode;

    /** 发送时间 */
    @Excel(name = "发送时间")
    private String sendTime;

    /** 发送状态 */
    @Excel(name = "发送状态")
    private String sendStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setFolderName(String folderName) 
    {
        this.folderName = folderName;
    }

    public String getFolderName() 
    {
        return folderName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setEcmBusCode(String ecmBusCode) 
    {
        this.ecmBusCode = ecmBusCode;
    }

    public String getEcmBusCode() 
    {
        return ecmBusCode;
    }
    public void setSendTime(String sendTime) 
    {
        this.sendTime = sendTime;
    }

    public String getSendTime() 
    {
        return sendTime;
    }
    public void setSendStatus(String sendStatus) 
    {
        this.sendStatus = sendStatus;
    }

    public String getSendStatus() 
    {
        return sendStatus;
    }

    public UrgencyImageSystem () {};

    public UrgencyImageSystem(/*Long id,*/ String orderNo, String userId,
                              String folderName, String filePath, String ecmBusCode,
                              String sendTime, String sendStatus) {
        /*this.id = id;*/
        this.orderNo = orderNo;
        this.userId = userId;
        this.folderName = folderName;
        this.filePath = filePath;
        this.ecmBusCode = ecmBusCode;
        this.sendTime = sendTime;
        this.sendStatus = sendStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("userId", getUserId())
            .append("folderName", getFolderName())
            .append("filePath", getFilePath())
            .append("ecmBusCode", getEcmBusCode())
            .append("sendTime", getSendTime())
            .append("sendStatus", getSendStatus())
            .toString();
    }
}
