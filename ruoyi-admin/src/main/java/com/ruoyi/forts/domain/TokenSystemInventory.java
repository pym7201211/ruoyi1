package com.ruoyi.forts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.*;

/**
 * 江苏银行信息系统标准化清单（2019年四季度）对象 token_system_inventory
 * 
 * @author mengdehu
 * @date 2019-11-21
 */
public class TokenSystemInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键seq_token_system_inventory.nextval */
    private Long id;

    private String ip;

    private List<Map<String,Object>> ipList = new ArrayList<>();

    public List<Map<String,Object>> getIpList() {
        return ipList;
    }

    public void setIpList(List<Map<String,Object>> ipList) {
        this.ipList = new ArrayList<>();
        this.ipList = ipList;
    }

    /** 等级分类 */
    @Excel(name = "等级分类")
    private String gradeClassify;

    /** 类型(前台、中台、数据、人工智能、内部管理、其他) */
    @Excel(name = "类型(前台、中台、数据、人工智能、内部管理、其他)")
    private String type;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 系统简称 */
    @Excel(name = "系统简称")
    private String systemAbbreviation;

    /** 业务主管部门 */
    @Excel(name = "业务主管部门")
    private String businessChargeDepartment;

    /** 科技主管团队 */
    @Excel(name = "科技主管团队")
    private String scienceChargeTeam;

    /** 应用维护 */
    @Excel(name = "应用维护")
    private String useMaintainStaff;

    /** 服务时间 */
    @Excel(name = "服务时间")
    private String serviceDate;

    /** 投产日期 */
    @Excel(name = "投产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionDate;

    /** 维护人员Id */
    @Excel(name = "维护人员Id")
    private String maintainUserId;

    /** 部门id */
    //@Excel(name = "部门id")
    private String departmentId;

    /** 系统id */
    @Excel(name = "系统id")
    private String systemId;

    /** 主管id */
    @Excel(name = "主管id")
    private String leaderId;

    /** 主管姓名 */
    @Excel(name = "主管姓名")

    private String leaderName;

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    /**
     * biaozhunhuaqingdang
     */
    /**应用维护的人数截取存入数组*/
    private String[]useMaintainStaffs;

    /**应用维护的人员ID截取存入数组*/
    private String[]maintainUserIds;

    /**记录查询信息属于哪个主管团队的下标*/
    private int num;

    public String[] getUseMaintainStaffs() {
        return useMaintainStaffs;
    }

    public void setUseMaintainStaffs(String[] useMaintainStaffs) {
        this.useMaintainStaffs = useMaintainStaffs;
    }

    public String[] getMaintainUserIds() {
        return maintainUserIds;
    }

    public void setMaintainUserIds(String[] maintainUserIds) {
        this.maintainUserIds = maintainUserIds;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TokenSystemInventory() {
    }

    public TokenSystemInventory
            (Long id, String gradeClassify, String type, String systemName,
             String systemAbbreviation, String businessChargeDepartment,
             String scienceChargeTeam, String useMaintainStaff,
             String serviceDate, Date productionDate, String maintainUserId,
             String systemId,String leaderId,String leaderName) {
        this.id = id;
        this.gradeClassify = gradeClassify;
        this.type = type;
        this.systemName = systemName;
        this.systemAbbreviation = systemAbbreviation;
        this.businessChargeDepartment = businessChargeDepartment;
        this.scienceChargeTeam = scienceChargeTeam;
        this.useMaintainStaff = useMaintainStaff;
        this.serviceDate = serviceDate;
        this.productionDate = productionDate;
        this.maintainUserId = maintainUserId;
        this.systemId = systemId;
        this.leaderId = leaderId;
        this.leaderName = leaderName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGradeClassify(String gradeClassify)
    {
        this.gradeClassify = gradeClassify;
    }

    public String getGradeClassify()
    {
        return gradeClassify;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setSystemName(String systemName)
    {
        this.systemName = systemName;
    }

    public String getSystemName()
    {
        return systemName;
    }
    public void setSystemAbbreviation(String systemAbbreviation)
    {
        this.systemAbbreviation = systemAbbreviation;
    }

    public String getSystemAbbreviation()
    {
        return systemAbbreviation;
    }
    public void setBusinessChargeDepartment(String businessChargeDepartment)
    {
        this.businessChargeDepartment = businessChargeDepartment;
    }

    public String getBusinessChargeDepartment()
    {
        return businessChargeDepartment;
    }
    public void setScienceChargeTeam(String scienceChargeTeam)
    {
        this.scienceChargeTeam = scienceChargeTeam;
    }

    public String getScienceChargeTeam()
    {
        return scienceChargeTeam;
    }
    public void setUseMaintainStaff(String useMaintainStaff)
    {
        this.useMaintainStaff = useMaintainStaff;
    }

    public String getUseMaintainStaff()
    {
        return useMaintainStaff;
    }
    public void setServiceDate(String serviceDate)
    {
        this.serviceDate = serviceDate;
    }

    public String getServiceDate()
    {
        return serviceDate;
    }
    public void setProductionDate(Date productionDate)
    {
        this.productionDate = productionDate;
    }

    public Date getProductionDate()
    {
        return productionDate;
    }
    public void setMaintainUserId(String maintainUserId)
    {
        this.maintainUserId = maintainUserId;
    }

    public String getMaintainUserId()
    {
        return maintainUserId;
    }
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }
    public void setSystemId(String systemId)
    {
        this.systemId = systemId;
    }

    public String getSystemId()
    {
        return systemId;
    }

    @Override
    public String toString() {
        return "TokenSystemInventory{" +
                "id=" + id +
                ", gradeClassify='" + gradeClassify + '\'' +
                ", type='" + type + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemAbbreviation='" + systemAbbreviation + '\'' +
                ", businessChargeDepartment='" + businessChargeDepartment + '\'' +
                ", scienceChargeTeam='" + scienceChargeTeam + '\'' +
                ", useMaintainStaff='" + useMaintainStaff + '\'' +
                ", serviceDate='" + serviceDate + '\'' +
                ", productionDate=" + productionDate +
                ", maintainUserId='" + maintainUserId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", systemId='" + systemId + '\'' +
                ", leaderId='" + leaderId + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", useMaintainStaffs=" + Arrays.toString(useMaintainStaffs) +
                ", maintainUserIds=" + Arrays.toString(maintainUserIds) +
                ", num=" + num +
                '}';
    }
}
