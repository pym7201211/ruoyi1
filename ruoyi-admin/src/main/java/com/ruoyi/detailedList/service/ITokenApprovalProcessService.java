package com.ruoyi.detailedList.service;

import com.ruoyi.detailedList.domain.TokenApprovalProcess;
import java.util.List;

/**
 * 审批流程Service接口
 * 
 * @author mengdehu
 * @date 2019-12-22
 */
public interface ITokenApprovalProcessService 
{
    /**
     * 查询审批流程
     * 
     * @param id 审批流程ID
     * @return 审批流程
     */
    public TokenApprovalProcess selectTokenApprovalProcessById(Long id);

    /**
     * 查询审批流程列表
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 审批流程集合
     */
    public List<TokenApprovalProcess> selectTokenApprovalProcessList(TokenApprovalProcess tokenApprovalProcess);

    /**
     * 新增审批流程
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    public int insertTokenApprovalProcess(TokenApprovalProcess tokenApprovalProcess);

    /**
     * 修改审批流程
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    public int updateTokenApprovalProcess(TokenApprovalProcess tokenApprovalProcess);

    /**
     * 批量删除审批流程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenApprovalProcessByIds(String ids);

    /**
     * 删除审批流程信息
     * 
     * @param id 审批流程ID
     * @return 结果
     */
    public int deleteTokenApprovalProcessById(Long id);
}
