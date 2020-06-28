package com.ruoyi.cloudDesktop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 云桌面账号对象 vd_cloud_account
 *
 * @author ruoyi
 * @date 2020-06-03
 */
public class VdCloudAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账号 */
    private String account;

    /** 项目组 */
    @Excel(name = "项目组")
    private String team;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String company;

    /** 使用人 */
    @Excel(name = "使用人")
    private String userName;

    /** 认领时间 */
    @Excel(name = "认领时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 使用人 */
    @Excel(name = "认领人id")
    private String claimantId;

    /** 使用人 */
    @Excel(name = "认领人名称")
    private String claimantName;

    /** 使用人 */
    @Excel(name = "账号集合")
    private String accountList;

    @Override
    public String toString() {
        return "VdCloudAccount{" +
                "account='" + account + '\'' +
                ", team='" + team + '\'' +
                ", company='" + company + '\'' +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                ", claimantId='" + claimantId + '\'' +
                ", claimantName='" + claimantName + '\'' +
                ", accountList='" + accountList + '\'' +
                '}';
    }

    public String getAccountList() {
        return accountList;
    }

    public void setAccountList(String accountList) {
        this.accountList = accountList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(String claimantId) {
        this.claimantId = claimantId;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }
}
