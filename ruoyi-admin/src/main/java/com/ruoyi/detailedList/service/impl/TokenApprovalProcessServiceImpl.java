package com.ruoyi.detailedList.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detailedList.mapper.TokenApprovalProcessMapper;
import com.ruoyi.detailedList.domain.TokenApprovalProcess;
import com.ruoyi.detailedList.service.ITokenApprovalProcessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 审批流程Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-12-22
 */
@Service
public class TokenApprovalProcessServiceImpl implements ITokenApprovalProcessService 
{
    @Autowired
    private TokenApprovalProcessMapper tokenApprovalProcessMapper;

    /**
     * 查询审批流程
     * 
     * @param id 审批流程ID
     * @return 审批流程
     */
    @Override
    public TokenApprovalProcess selectTokenApprovalProcessById(Long id)
    {
        return tokenApprovalProcessMapper.selectTokenApprovalProcessById(id);
    }

    /**
     * 查询审批流程列表
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 审批流程
     */
    @Override
    public List<TokenApprovalProcess> selectTokenApprovalProcessList(TokenApprovalProcess tokenApprovalProcess)
    {
        return tokenApprovalProcessMapper.selectTokenApprovalProcessList(tokenApprovalProcess);
    }

    /**
     * 新增审批流程
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    @Override
    public int insertTokenApprovalProcess(TokenApprovalProcess tokenApprovalProcess)
    {
        tokenApprovalProcess.setCreateTime(DateUtils.getNowDate());
        return tokenApprovalProcessMapper.insertTokenApprovalProcess(tokenApprovalProcess);
    }

    /**
     * 修改审批流程
     * 
     * @param tokenApprovalProcess 审批流程
     * @return 结果
     */
    @Override
    public int updateTokenApprovalProcess(TokenApprovalProcess tokenApprovalProcess)
    {
        tokenApprovalProcess.setUpdateTime(DateUtils.getNowDate());
        return tokenApprovalProcessMapper.updateTokenApprovalProcess(tokenApprovalProcess);
    }

    /**
     * 删除审批流程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenApprovalProcessByIds(String ids)
    {
        return tokenApprovalProcessMapper.deleteTokenApprovalProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审批流程信息
     * 
     * @param id 审批流程ID
     * @return 结果
     */
    @Override
    public int deleteTokenApprovalProcessById(Long id)
    {
        return tokenApprovalProcessMapper.deleteTokenApprovalProcessById(id);
    }
}
