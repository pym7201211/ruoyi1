package com.ruoyi.forts.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 令牌自动推送对象 token_apply_form
 *
 * @author mengdehu
 * @date 2020-05-06
 */
public class TokenAutoPushDemo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 登陆时间 */
    @Excel(name = "登陆时间" , width = 30, dateFormat = "yyyyMMdd HH:mm:ss")
    private String time;

    /** 账号 */
    @Excel(name = "账号")
    private String account;


    /** 命令 */
    @Excel(name = "命令")
    private String cmd;


    /** 员工id */
    @Excel(name = "员工id")
    private String identity;


    /** 主机ip */
    @Excel(name = "主机ip")
    private String detIp;

    /** 来源ip */
    @Excel(name = "来源ip")
    private String srcIp;


    /** 是否推送 */
    @Excel(name = "是否推送")
    private String isSend;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String userName;

    /** 员工部门 */
    @Excel(name = "员工部门")
    private String userdep;

    /** 主管id */
    @Excel(name = "主管id")
    private String directorId;

    /** 主管姓名 */
    @Excel(name = "主管姓名")
    private String directorName;

    /** 编号 */
    @Excel(name = "编号")
    private String seqno;

    public TokenAutoPushDemo() {
    }

    public TokenAutoPushDemo(String time, String account, String cmd, String identity, String detIp, String srcIp, String isSend, String userName, String userdep, String directorId, String directorName, String seqno) {
        this.time = time;
        this.account = account;
        this.cmd = cmd;
        this.identity = identity;
        this.detIp = detIp;
        this.srcIp = srcIp;
        this.isSend = isSend;
        this.userName = userName;
        this.userdep = userdep;
        this.directorId = directorId;
        this.directorName = directorName;
        this.seqno = seqno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDetIp() {
        return detIp;
    }

    public void setDetIp(String detIp) {
        this.detIp = detIp;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserdep() {
        return userdep;
    }

    public void setUserdep(String userdep) {
        this.userdep = userdep;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getSeqNo() {
        return seqno;
    }

    public void setSeqNo(String seqNo) {
        this.seqno = seqNo;
    }

    @Override
    public String toString() {
        return "TokenAutoPushDemo{" +
                "time='" + time + '\'' +
                ", account='" + account + '\'' +
                ", cmd='" + cmd + '\'' +
                ", identity='" + identity + '\'' +
                ", detIp='" + detIp + '\'' +
                ", srcIp='" + srcIp + '\'' +
                ", isSend='" + isSend + '\'' +
                ", userName='" + userName + '\'' +
                ", userdep='" + userdep + '\'' +
                ", directorId='" + directorId + '\'' +
                ", directorName='" + directorName + '\'' +
                ", seqNo='" + seqno + '\'' +
                '}';
    }
}
