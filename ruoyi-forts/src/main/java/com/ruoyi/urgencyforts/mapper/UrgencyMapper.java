package com.ruoyi.urgencyforts.mapper;

import com.ruoyi.urgencyforts.domain.UrgencyAlteratRegisters;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.List;

public interface UrgencyMapper {

    /**
     * 系统名称模糊查询
     * @param userId
     * @param systemName
     * @return
     */
    public List<String> getLikeSystem(@Param("userId") String userId, @Param("systemName") String systemName);

    /**
     * 查询复核人和实时人
     * @param
     * @return
     */
    public List<HashMap<String,String>> getUserInfo(@Param("userId") String userId);

    /**
     * 发起的业务部门
     * @return
     */
    public List<String> getBusinessChargeDept();

    /**
     * 查询团队领导
     * @param userId
     * @return
     */
    public List<HashMap<String,String>> teamLeaderInfomation(@Param("userId") String userId);

    /**
     * 查询分管信息
     * @param dept_id
     * @return
     */
    public List<HashMap<String,String>> responsibleInfo(@Param("dept_id") String dept_id);

    /**
     * 查询主管信息
     * @param dept_id
     * @return
     */
    public List<HashMap<String,String>> chargeInfo(@Param("dept_id") String dept_id);

    /**
     * 添加紧急变更数据
     * @param urgencyAlteratRegisters
     * @return
     */
    public int insertUrgencyAlteratRegister(UrgencyAlteratRegisters urgencyAlteratRegisters);

    /**
     * 根据操作人查询最大序列号
     * @param operatorId
     * @return
     */
    public String getMaxOrderNum(@Param("operatorId") String operatorId);

    /**
     * 查询审批页面数据
     * @param orderNo
     * @return
     */
    public HashMap<String,String> getApprovalData(@Param("orderNo") String orderNo);

    /**
     * 审批更改状态
     * @param orderNo
     * @return
     */
    public int updateSignStatus(@Param("orderNo") String orderNo,@Param("teamChargeStatus") String teamChargeStatus,
                                @Param("teamBranchedStatus") String teamBranchedStatus,
                                @Param("chargeLeaderStatus") String chargeLeaderStatus,
                                @Param("securityTeam") String securityTeam,
                                @Param("bigDataTeam") String bigDataTeam,
                                @Param("reviewerStatus") String reviewerStatus);

    /**
     * 获取安全团队和大数据团队主管id
     * @param twoDeptOrg
     * @return
     */
    public String getSecurityBigDataId(@Param("twoDeptOrg") String twoDeptOrg);

    /**
     * 查询紧急变更历史
     * @param operatorId
     * @return
     */
    public List<HashMap<String,String>> selectUrgencyHistory(@Param("operatorId") String operatorId);

    /**
     * 查询变更进度
     * @param orderNo
     * @return
     */
    public HashMap<String,String> selectUrgencyProcessSpeed(@Param("orderNo") String orderNo);

    /**
     * 查询部门号
     * @param userId
     * @return
     */
    public String selectTwoDeptOrg(@Param("userId") String userId);

    /**
     * 查询安全，大数据，复核人审批状态
     * @param orderNo
     * @return
     */
    public int selectRewSecBigStatus(@Param("orderNo") String orderNo,
                                     /*@Param("reviewerStatus") String reviewerStatus,*/
                                     @Param("securityTeam") String securityTeam,
                                     @Param("bigDataTeam") String bigDataTeam);

    public String selectSecurityTeam(@Param("orderNo") String orderNo);

    public String selectBigDataTeam(@Param("orderNo") String orderNo);

    public String selectOperator(@Param("orderNo") String orderNo);

    public String selectRunTeam();

    public String viewPicture(@Param("orderNo") String orderNo);

    public List<String> selectAffiliatedTeam(@Param("userId") String userId);

    public int updateManageStatus(@Param("manageStatus") String manageStatus,
                                  @Param("orderNo") String orderNo);

    public List<HashMap<String,String>> noApprovalData();
}
