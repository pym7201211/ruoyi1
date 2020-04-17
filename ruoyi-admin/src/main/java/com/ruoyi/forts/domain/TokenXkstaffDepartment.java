package com.ruoyi.forts.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信科部员工对象 token_xkstaff_department
 * 
 * @author mengdehu
 * @date 2019-12-02
 */
public class TokenXkstaffDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门主键seq_token_xkstaff_department.nextval */
    private Long deptId;

    /** extend10 */
    @Excel(name = "extend10")
    private String extend10;

    /** 用户号 */
    @Excel(name = "用户号")
    private String userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private String userType;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 所属机构 */
    @Excel(name = "所属机构")
    private String orgCode;

    /** 一级部门 */
    @Excel(name = "一级部门")
    private String oneDeptOrg;

    /** 二级部门 */
    @Excel(name = "二级部门")
    private String twoDeptOrg;

    /** 岗位代码 */
    @Excel(name = "岗位代码")
    private String positionCode;

    /** 拼音名称 */
    @Excel(name = "拼音名称")
    private String pinyinName;

    /** 任职资格 */
    @Excel(name = "任职资格")
    private String qualification;

    /** 逻辑删除机构标志 */
    @Excel(name = "逻辑删除机构标志")
    private String dFlag;

    /** 维护人 */
    @Excel(name = "维护人")
    private String maintainOr;

    /** 维护时间 */
    @Excel(name = "维护时间")
    private String maintainDate;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 职务 */
    @Excel(name = "职务")
    private String duty;

    /** line_dept */
    @Excel(name = "line_dept")
    private String lineDept;

    /** 离退休标志 */
    @Excel(name = "离退休标志")
    private String rFlag;

    /** 人员状态 */
    @Excel(name = "人员状态")
    private String extend1;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String extend2;

    /** 第一学历 */
    @Excel(name = "第一学历")
    private String extend3;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String extend4;

    /** 最高学位 */
    @Excel(name = "最高学位")
    private String extend5;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String extend6;

    /** extend7 */
    @Excel(name = "extend7")
    private String extend7;

    /** extend8 */
    @Excel(name = "extend8")
    private String extend8;

    /** extend9 */
    @Excel(name = "extend9")
    private String extend9;

    /** id */
    private String id;

    public TokenXkstaffDepartment() {
    }

    public TokenXkstaffDepartment(Long deptId, String id, String userId, String userName, String sex, String userType, String idCard, String orgCode, String oneDeptOrg, String twoDeptOrg, String positionCode, String pinyinName, String qualification, String dFlag, String maintainOr, String maintainDate, String phone, String duty, String lineDept, String rFlag, String extend1, String extend2, String extend3, String extend4, String extend5, String extend6, String extend7, String extend8, String extend9, String extend10) {
        this.deptId = deptId;
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.userType = userType;
        this.idCard = idCard;
        this.orgCode = orgCode;
        this.oneDeptOrg = oneDeptOrg;
        this.twoDeptOrg = twoDeptOrg;
        this.positionCode = positionCode;
        this.pinyinName = pinyinName;
        this.qualification = qualification;
        this.dFlag = dFlag;
        this.maintainOr = maintainOr;
        this.maintainDate = maintainDate;
        this.phone = phone;
        this.duty = duty;
        this.lineDept = lineDept;
        this.rFlag = rFlag;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.extend3 = extend3;
        this.extend4 = extend4;
        this.extend5 = extend5;
        this.extend6 = extend6;
        this.extend7 = extend7;
        this.extend8 = extend8;
        this.extend9 = extend9;
        this.extend10 = extend10;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setExtend10(String extend10) 
    {
        this.extend10 = extend10;
    }

    public String getExtend10() 
    {
        return extend10;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setUserType(String userType) 
    {
        this.userType = userType;
    }

    public String getUserType() 
    {
        return userType;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setOrgCode(String orgCode) 
    {
        this.orgCode = orgCode;
    }

    public String getOrgCode() 
    {
        return orgCode;
    }
    public void setOneDeptOrg(String oneDeptOrg) 
    {
        this.oneDeptOrg = oneDeptOrg;
    }

    public String getOneDeptOrg() 
    {
        return oneDeptOrg;
    }
    public void setTwoDeptOrg(String twoDeptOrg) 
    {
        this.twoDeptOrg = twoDeptOrg;
    }

    public String getTwoDeptOrg() 
    {
        return twoDeptOrg;
    }
    public void setPositionCode(String positionCode) 
    {
        this.positionCode = positionCode;
    }

    public String getPositionCode() 
    {
        return positionCode;
    }
    public void setPinyinName(String pinyinName) 
    {
        this.pinyinName = pinyinName;
    }

    public String getPinyinName() 
    {
        return pinyinName;
    }
    public void setQualification(String qualification) 
    {
        this.qualification = qualification;
    }

    public String getQualification() 
    {
        return qualification;
    }
    public void setDFlag(String dFlag) 
    {
        this.dFlag = dFlag;
    }

    public String getDFlag() 
    {
        return dFlag;
    }
    public void setMaintainOr(String maintainOr) 
    {
        this.maintainOr = maintainOr;
    }

    public String getMaintainOr() 
    {
        return maintainOr;
    }
    public void setMaintainDate(String maintainDate)
    {
        this.maintainDate = maintainDate;
    }

    public String getMaintainDate()
    {
        return maintainDate;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDuty(String duty) 
    {
        this.duty = duty;
    }

    public String getDuty() 
    {
        return duty;
    }
    public void setLineDept(String lineDept) 
    {
        this.lineDept = lineDept;
    }

    public String getLineDept() 
    {
        return lineDept;
    }
    public void setRFlag(String rFlag) 
    {
        this.rFlag = rFlag;
    }

    public String getRFlag() 
    {
        return rFlag;
    }
    public void setExtend1(String extend1) 
    {
        this.extend1 = extend1;
    }

    public String getExtend1() 
    {
        return extend1;
    }
    public void setExtend2(String extend2) 
    {
        this.extend2 = extend2;
    }

    public String getExtend2() 
    {
        return extend2;
    }
    public void setExtend3(String extend3) 
    {
        this.extend3 = extend3;
    }

    public String getExtend3() 
    {
        return extend3;
    }
    public void setExtend4(String extend4) 
    {
        this.extend4 = extend4;
    }

    public String getExtend4() 
    {
        return extend4;
    }
    public void setExtend5(String extend5) 
    {
        this.extend5 = extend5;
    }

    public String getExtend5() 
    {
        return extend5;
    }
    public void setExtend6(String extend6) 
    {
        this.extend6 = extend6;
    }

    public String getExtend6() 
    {
        return extend6;
    }
    public void setExtend7(String extend7) 
    {
        this.extend7 = extend7;
    }

    public String getExtend7() 
    {
        return extend7;
    }
    public void setExtend8(String extend8) 
    {
        this.extend8 = extend8;
    }

    public String getExtend8() 
    {
        return extend8;
    }
    public void setExtend9(String extend9) 
    {
        this.extend9 = extend9;
    }

    public String getExtend9() 
    {
        return extend9;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("extend10", getExtend10())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("sex", getSex())
            .append("userType", getUserType())
            .append("idCard", getIdCard())
            .append("orgCode", getOrgCode())
            .append("oneDeptOrg", getOneDeptOrg())
            .append("twoDeptOrg", getTwoDeptOrg())
            .append("positionCode", getPositionCode())
            .append("pinyinName", getPinyinName())
            .append("qualification", getQualification())
            .append("dFlag", getDFlag())
            .append("maintainOr", getMaintainOr())
            .append("maintainDate", getMaintainDate())
            .append("phone", getPhone())
            .append("duty", getDuty())
            .append("lineDept", getLineDept())
            .append("rFlag", getRFlag())
            .append("extend1", getExtend1())
            .append("extend2", getExtend2())
            .append("extend3", getExtend3())
            .append("extend4", getExtend4())
            .append("extend5", getExtend5())
            .append("extend6", getExtend6())
            .append("extend7", getExtend7())
            .append("extend8", getExtend8())
            .append("extend9", getExtend9())
            .append("id", getId())
            .toString();
    }
}
