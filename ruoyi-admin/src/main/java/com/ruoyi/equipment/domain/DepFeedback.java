package com.ruoyi.equipment.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class DepFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备名称 */
    @Excel(name = "意见填写人")
    private String userId;

    /** 设备名称 */
    @Excel(name = "意见填写人")
    private String userName;

    /** 设备名称 */
    @Excel(name = "填写人部门")
    private String twoDep;

    /** 设备名称 */
    @Excel(name = "意见")
    private String opinion;

    /** 设备名称 */
    @Excel(name = "意见填写时间")
    private String opinionTime;

    /** 设备名称 */
    @Excel(name = "意见反馈人")
    private String personId;

    /** 设备名称 */
    @Excel(name = "意见反馈人")
    private String personName;

    /** 设备名称 */
    @Excel(name = "意见反馈")
    private String feedback;

    /** 设备名称 */
    @Excel(name = "反馈时间")
    private String feedbackTime;

    /** 设备名称 */
    @Excel(name = "编号")
    private String seqNo;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTwoDep() {
        return twoDep;
    }

    public void setTwoDep(String twoDep) {
        this.twoDep = twoDep;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(String opinionTime) {
        this.opinionTime = opinionTime;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "DepFeedback{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", twoDep='" + twoDep + '\'' +
                ", opinion='" + opinion + '\'' +
                ", opinionTime='" + opinionTime + '\'' +
                ", personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", feedback='" + feedback + '\'' +
                ", feedbackTime='" + feedbackTime + '\'' +
                ", seqNo='" + seqNo + '\'' +
                '}';
    }
}
