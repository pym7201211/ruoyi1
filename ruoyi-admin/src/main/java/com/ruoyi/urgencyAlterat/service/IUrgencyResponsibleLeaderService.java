package com.ruoyi.urgencyAlterat.service;

import com.ruoyi.urgencyAlterat.domain.UrgencyResponsibleLeader;
import java.util.List;

/**
 * 分管领导Service接口
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public interface IUrgencyResponsibleLeaderService 
{
    /**
     * 查询分管领导
     * 
     * @param id 分管领导ID
     * @return 分管领导
     */
    public UrgencyResponsibleLeader selectUrgencyResponsibleLeaderById(Long id);

    /**
     * 查询分管领导列表
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 分管领导集合
     */
    public List<UrgencyResponsibleLeader> selectUrgencyResponsibleLeaderList(UrgencyResponsibleLeader urgencyResponsibleLeader);

    /**
     * 新增分管领导
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 结果
     */
    public int insertUrgencyResponsibleLeader(UrgencyResponsibleLeader urgencyResponsibleLeader);

    /**
     * 修改分管领导
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 结果
     */
    public int updateUrgencyResponsibleLeader(UrgencyResponsibleLeader urgencyResponsibleLeader);

    /**
     * 批量删除分管领导
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrgencyResponsibleLeaderByIds(String ids);

    /**
     * 删除分管领导信息
     * 
     * @param id 分管领导ID
     * @return 结果
     */
    public int deleteUrgencyResponsibleLeaderById(Long id);
}
