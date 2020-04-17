package com.ruoyi.ruoyiforts.service;

import com.ruoyi.ruoyiforts.domain.TokenApplyForms;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.ui.ModelMap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 令牌登记service层
 */
public interface FortService {

    /**
     * 首页列表查询和详情
     * @return
     */
    public List<HashMap<String,String>> selectApplyAndResult(String employeeId);

    /**
     * 新增令牌登记申请
     *
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    public boolean insertTokenApplyForm(TokenApplyForms tokenApplyForm);

    /**
     * 获取常用语
     * @param singId
     * @return
     */
    public List<HashMap<String,String>> getCommonLanguage(String singId);

    /**
     * 获取上级领导信息
     * @param userId
     * @return
     */
    public List<HashMap<String,String>> getTwoOrgInfomation(String userId);

    /**
     * 系统名称模糊查询
     * @param userId
     * @param systemName
     * @return
     */
    public List<HashMap<String,String>> getLikeSystem(String userId,String systemName);

    /**
     * 远程vpn密码表
     * @param userName
     * @return
     */
    public HashMap<String,Object> vpnInformation(String userName);

    public boolean addVpnInfo(String userName,String password,String accountStatus,BigDecimal useNum,
                              String employeeId,String uniqueness);


    public boolean updateVpnInfo(String userName,String password,String accountStatus,BigDecimal useNum,BigDecimal id);

    /**
     * 查询全表的部门
     * @return
     */
    public List<HashMap<String,String>> getAllSystemName(String systemName);

    /**
     * 查询账户和密码的次数
     * @return
     */
    public String selectMaxCount();

    public HashMap selectApprovalInfo(String seNo);

    public int updateApprovalInfo(String approvalStatus, String uniquenessCode,
                                  String remark, String approvalName,
                                  String applyStatus, String seNo);

    public boolean selectSearchSystem(String userId);

    public boolean isLeaderSend(String leaderId);

    public String selectPhone(String userId);

    public List<HashMap> getInfoByStaff(String chargeTeam);

    public HashMap<String,String> selectInfoBySeqno (String seqNo);


    public ModelMap getSystemInfo(String list) throws Exception;

    public ModelMap getEmployeeNo(String systemId) throws Exception;


}
