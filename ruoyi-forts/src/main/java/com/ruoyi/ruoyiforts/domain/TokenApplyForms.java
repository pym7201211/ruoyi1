package com.ruoyi.ruoyiforts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 令牌登记申请对象 token_apply_form
 * 
 * @author mengdehu
 * @date 2019-11-22
 */
public class TokenApplyForms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id */
    @Excel(name = "员工id")
    private String employeeId;

    /** 申请日期 */
    @Excel(name = "申请日期")
    private String applyDate;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 申请环境 */
    @Excel(name = "申请环境")
    private String applyEnvironment;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 是否开启远程 0-不开启 1-开启 */
    @Excel(name = "是否开启远程 0-不开启 1-开启")
    private String openDistinct;

    /** 开启说明 */
    @Excel(name = "开启说明")
    private String openInstructions;

    /** 有效时长 */
    @Excel(name = "有效时长")
    private String validDate;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String applyStatus;

    /** 开启时间 */
    @Excel(name = "开启时间")
    private String openDate;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endDate;

    /** 导入数据方式 */
    @Excel(name = "导入数据方式")
    private String addway;

    /** 开启事由 */
    @Excel(name = "开启事由")
    private String openIncident;

    /** 常用语id */
    @Excel(name = "常用语id")
    private String openIncidentId;

    /** 申请次数 */
    @Excel(name = "申请次数")
    private String applycount;

    /** 关联vpn表id */
    @Excel(name = "关联vpn表id")
    private String uniquenesscode;

    /** 发送消息流水号 */
    @Excel(name = "发送消息流水号")
    private String seqno;

    /** 选择其它系统 */
    @Excel(name = "选择其它系统")
    private String otherSystem;

    /** 审批状态 0-不同意 1-同意  2-审批中 3-未审批 */
    @Excel(name = "审批状态")
    private String approvalStatus;

    /** 预留字段1 */
    //@Excel(name = "预留字段1")
    private String reserved1;

    /** 预留字段2 */
    //@Excel(name = "预留字段2")
    private String reserved2;

    /** 预留字段3 */
    //@Excel(name = "预留字段3")
    private String reserved3;

    /** 主键SEQ_TOKEN_APPLY_FROM.NEXTVAL */
    private Long tokenId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getApplyEnvironment() {
        return applyEnvironment;
    }

    public void setApplyEnvironment(String applyEnvironment) {
        this.applyEnvironment = applyEnvironment;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getOpenDistinct() {
        return openDistinct;
    }

    public void setOpenDistinct(String openDistinct) {
        this.openDistinct = openDistinct;
    }

    public String getOpenInstructions() {
        return openInstructions;
    }

    public void setOpenInstructions(String openInstructions) {
        this.openInstructions = openInstructions;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddway() {
        return addway;
    }

    public void setAddway(String addway) {
        this.addway = addway;
    }

    public String getOpenIncident() {
        return openIncident;
    }

    public void setOpenIncident(String openIncident) {
        this.openIncident = openIncident;
    }

    public String getOpenIncidentId() {
        return openIncidentId;
    }

    public void setOpenIncidentId(String openIncidentId) {
        this.openIncidentId = openIncidentId;
    }

    public String getApplycount() {
        return applycount;
    }

    public void setApplycount(String applycount) {
        this.applycount = applycount;
    }

    public String getUniquenesscode() {
        return uniquenesscode;
    }

    public void setUniquenesscode(String uniquenesscode) {
        this.uniquenesscode = uniquenesscode;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    public String getOtherSystem() {
        return otherSystem;
    }

    public void setOtherSystem(String otherSystem) {
        this.otherSystem = otherSystem;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public String getReserved3() {
        return reserved3;
    }

    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3;
    }

    @Override
    public String toString() {
        return "TokenApplyForms{" +
                "employeeId='" + employeeId + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", proposer='" + proposer + '\'' +
                ", applyEnvironment='" + applyEnvironment + '\'' +
                ", systemName='" + systemName + '\'' +
                ", openDistinct='" + openDistinct + '\'' +
                ", openInstructions='" + openInstructions + '\'' +
                ", validDate='" + validDate + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", addway='" + addway + '\'' +
                ", openIncident='" + openIncident + '\'' +
                ", openIncidentId='" + openIncidentId + '\'' +
                ", applycount='" + applycount + '\'' +
                ", uniquenesscode='" + uniquenesscode + '\'' +
                ", seqno='" + seqno + '\'' +
                ", otherSystem='" + otherSystem + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                ", reserved3='" + reserved3 + '\'' +
                ", tokenId=" + tokenId +
                '}';
    }
}
