package com.ruoyi.forts.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 令牌登记申请对象 token_apply_form
 *
 * @author mengdehu
 * @date 2019-12-02
 */
public class TokenApplyFormDemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 关联vpn表id */
    //@Excel(name = "关联vpn表id")
    private String uniquenesscode;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 申请日期 */
    @Excel(name = "申请日期")
    private String applyDate;

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
    //@Excel(name = "导入数据方式")
    private String addway;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endDate;

    /** 开启时间 */
    @Excel(name = "开启时间")
    private String openDate;

    /** 申请状态 */
    //@Excel(name = "申请状态")
    private String applyStatus;

    /** 有效时长 */
    //@Excel(name = "有效时长")
    private String validDate;

    /** 开启说明 */
    @Excel(name = "开启说明")
    private String openInstructions;

    /** 是否开启远程 0-不开启 1-开启 */
    @Excel(name = "是否开启远程 0-不开启 1-开启")
    private String openDistinct;

    /** 申请环境 */
    @Excel(name = "申请环境 0-办公环境,1-生产环境")
    private String applyEnvironment;

    public TokenApplyFormDemo() {
    }

    public TokenApplyFormDemo(Long tokenId,String employeeId, String applyDate, String proposer,
                              String applyEnvironment, String systemName, String openDistinct,
                              String openInstructions,
                              String openDate, String endDate, String openIncident, String openIncidentId) {
        this.employeeId = employeeId;
        this.applyDate = applyDate;
        this.proposer = proposer;
        this.applyEnvironment = applyEnvironment;
        this.systemName = systemName;
        this.openDistinct = openDistinct;
        this.openInstructions = openInstructions;
        this.openDate = openDate;
        this.endDate = endDate;
        this.openIncident = openIncident;
        this.openIncidentId = openIncidentId;
        this.tokenId = tokenId;
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

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
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

    @Override
    public String toString() {
        return "TokenApplyFormDemo{" +
                "systemName='" + systemName + '\'' +
                ", uniquenesscode='" + uniquenesscode + '\'' +
                ", proposer='" + proposer + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", tokenId=" + tokenId +
                ", applycount='" + applycount + '\'' +
                ", openIncidentId='" + openIncidentId + '\'' +
                ", openIncident='" + openIncident + '\'' +
                ", addway='" + addway + '\'' +
                ", endDate='" + endDate + '\'' +
                ", openDate='" + openDate + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", validDate='" + validDate + '\'' +
                ", openInstructions='" + openInstructions + '\'' +
                ", openDistinct='" + openDistinct + '\'' +
                ", applyEnvironment='" + applyEnvironment + '\'' +
                '}';
    }
}
