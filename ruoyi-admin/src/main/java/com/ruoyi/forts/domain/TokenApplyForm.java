package com.ruoyi.forts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 令牌登记申请对象 token_apply_form
 *
 * @author mengdehu
 * @date 2019-12-02
 */
public class TokenApplyForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** ip */
    @Excel(name = "ip")
    private String ip;

    /** 关联vpn表id */
    //@Excel(name = "关联vpn表id")
    private String uniquenesscode;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 申请日期 */
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyyMMdd HH:mm:ss")
    private Date applyDate;

    /** 员工id */
    @Excel(name = "员工id")
    private String employeeId;

    /** 主键SEQ_TOKEN_APPLY_FROM.NEXTVAL */
    private Long tokenId;

    /** 申请次数 */
    //@Excel(name = "申请次数")
    private String applycount;

    /** 常用语id */
    @Excel(name = "常用语id")
    private String openIncidentId;

    /** 开启事由 */
    @Excel(name = "开启事由")
    private String openIncident;

    /** 导入数据方式 */
    @Excel(name = "导入数据方式")
    private String addway;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyyMMdd HH:mm:ss")
    private Date endDate;

    /** 开启时间 */
    @Excel(name = "开启时间", width = 30, dateFormat = "yyyyMMdd HH:mm:ss")
    private Date openDate;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String applyStatus;

    /** 有效时长 */
    @Excel(name = "有效时长")
    private String validDate;

    /** 开启说明 */
    @Excel(name = "开启说明")
    private String openInstructions;

    /** 是否开启远程 0-不开启 1-开启 */
    @Excel(name = "是否开启远程 0-不开启 1-开启")
    private String openDistinct;

    /** 申请环境 */
    @Excel(name = "申请环境")
    private String applyEnvironment;

    /** 发送消息流水号 */
    @Excel(name = "发送消息流水号")
    private String seqno;

    /** 选择其它系统 */
    @Excel(name = "选择其它系统")
    private String otherSystem;

    /** 审批状态 */
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

    @Excel(name = "所属团队")
    private String scienceChargeTeam;

    public TokenApplyForm() {
    }

    public TokenApplyForm(Long tokenId,String employeeId, Date applyDate, String proposer, String applyEnvironment, String systemName, String openDistinct, String openInstructions, String validDate, String applyStatus, Date openDate, Date endDate, String addway, String openIncident, String openIncidentId, String applycount) {
        this.employeeId = employeeId;
        this.applyDate = applyDate;
        this.proposer = proposer;
        this.applyEnvironment = applyEnvironment;
        this.systemName = systemName;
        this.openDistinct = openDistinct;
        this.openInstructions = openInstructions;
        this.validDate = validDate;
        this.applyStatus = applyStatus;
        this.openDate = openDate;
        this.endDate = endDate;
        this.addway = addway;
        this.openIncident = openIncident;
        this.openIncidentId = openIncidentId;
        this.applycount = applycount;
        this.tokenId = tokenId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getScienceChargeTeam() {
        return scienceChargeTeam;
    }

    public void setScienceChargeTeam(String scienceChargeTeam) {
        this.scienceChargeTeam = scienceChargeTeam;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUniquenesscode() {
        return uniquenesscode;
    }

    public void setUniquenesscode(String uniquenesscode) {
        this.uniquenesscode = uniquenesscode;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getApplycount() {
        return applycount;
    }

    public void setApplycount(String applycount) {
        this.applycount = applycount;
    }

    public String getOpenIncidentId() {
        return openIncidentId;
    }

    public void setOpenIncidentId(String openIncidentId) {
        this.openIncidentId = openIncidentId;
    }

    public String getOpenIncident() {
        return openIncident;
    }

    public void setOpenIncident(String openIncident) {
        this.openIncident = openIncident;
    }

    public String getAddway() {
        return addway;
    }

    public void setAddway(String addway) {
        this.addway = addway;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getOpenInstructions() {
        return openInstructions;
    }

    public void setOpenInstructions(String openInstructions) {
        this.openInstructions = openInstructions;
    }

    public String getOpenDistinct() {
        return openDistinct;
    }

    public void setOpenDistinct(String openDistinct) {
        this.openDistinct = openDistinct;
    }

    public String getApplyEnvironment() {
        return applyEnvironment;
    }

    public void setApplyEnvironment(String applyEnvironment) {
        this.applyEnvironment = applyEnvironment;
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
        return "TokenApplyForm{" +
                "systemName='" + systemName + '\'' +
                ", uniquenesscode='" + uniquenesscode + '\'' +
                ", proposer='" + proposer + '\'' +
                ", applyDate=" + applyDate +
                ", employeeId='" + employeeId + '\'' +
                ", tokenId=" + tokenId +
                ", applycount='" + applycount + '\'' +
                ", openIncidentId='" + openIncidentId + '\'' +
                ", openIncident='" + openIncident + '\'' +
                ", addway='" + addway + '\'' +
                ", endDate=" + endDate +
                ", openDate=" + openDate +
                ", applyStatus='" + applyStatus + '\'' +
                ", validDate='" + validDate + '\'' +
                ", openInstructions='" + openInstructions + '\'' +
                ", openDistinct='" + openDistinct + '\'' +
                ", applyEnvironment='" + applyEnvironment + '\'' +
                ", seqno='" + seqno + '\'' +
                ", otherSystem='" + otherSystem + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                ", reserved3='" + reserved3 + '\'' +
                '}';
    }
}
