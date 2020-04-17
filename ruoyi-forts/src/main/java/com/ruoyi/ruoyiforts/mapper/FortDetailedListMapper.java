package com.ruoyi.ruoyiforts.mapper;

import com.ruoyi.ruoyiforts.domain.TokenApprovalProcesses;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface FortDetailedListMapper {

    public int selectButton(@Param("systemName") String systemName, @Param("userId") String userId);

    public HashMap<String,String> selectInfo(@Param("systemName") String systemName);

    public HashMap<String,String> selectApporvalStaus(@Param("userId")String userId, @Param("systemName") String systemName);

    public HashMap<String,String> selectApprovalInfo(String seNo);

    public int updateInventoryUser(@Param("employeeName") String employeeName,@Param("userId") String userId,
                                   @Param("systemName") String systemName);

    public int updateApprovalStatus(@Param("approvalStatus") String approvalStatus, @Param("seNo") String seNo);

    public HashMap<String,String> selectInventoryUser(String systemName);

    public int updateInventoryUserId(@Param("maintainUserId") String maintainUserId,
                                     @Param("useMaintainStaff") String useMaintainStaff,
                                     @Param("systemName") String systemName);

    public String selectIsApproval(String seNo);

    public List<HashMap<String,String>> getIdAndName(String systemName);

    public int transferSystemName(@Param("oldUser") String oldUser,@Param("newUser") String newUser,
                                  @Param("oldUserId") String oldUserId,@Param("newUserId")String newUserId,
                                  @Param("systemName") String systemName);

    public HashMap<String,String> selectTeam(@Param("systemName") String systemName,
                                             @Param("userId") String userId);

    /**
     * 查询审批流程
     *
     * @param id 审批流程ID
     * @return 审批流程
     */
    public TokenApprovalProcesses selectTokenApprovalProcessById(Long id);

    /**
     * 查询审批流程列表
     *
     * @param tokenApprovalProcess 审批流程
     * @return 审批流程集合
     */
    public List<TokenApprovalProcesses> selectTokenApprovalProcessList(TokenApprovalProcesses tokenApprovalProcess);

    /**
     * 新增审批流程
     *
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    public int insertTokenApprovalProcess(TokenApprovalProcesses tokenApprovalProcess);

    /**
     * 修改审批流程
     *
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    public int updateTokenApprovalProcess(TokenApprovalProcesses tokenApprovalProcess);

    /**
     * 删除审批流程
     *
     * @param id 审批流程ID
     * @return 结果
     */
    public int deleteTokenApprovalProcessById(Long id);


}
