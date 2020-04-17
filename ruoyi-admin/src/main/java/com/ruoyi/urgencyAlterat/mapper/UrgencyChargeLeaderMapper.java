package com.ruoyi.urgencyAlterat.mapper;

import com.ruoyi.urgencyAlterat.domain.UrgencyChargeLeader;
import java.util.List;

/**
 * 主管变更领导Mapper接口
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public interface UrgencyChargeLeaderMapper 
{
    /**
     * 查询主管变更领导
     * 
     * @param id 主管变更领导ID
     * @return 主管变更领导
     */
    public UrgencyChargeLeader selectUrgencyChargeLeaderById(Long id);

    /**
     * 查询主管变更领导列表
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 主管变更领导集合
     */
    public List<UrgencyChargeLeader> selectUrgencyChargeLeaderList(UrgencyChargeLeader urgencyChargeLeader);

    /**
     * 新增主管变更领导
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 结果
     */
    public int insertUrgencyChargeLeader(UrgencyChargeLeader urgencyChargeLeader);

    /**
     * 修改主管变更领导
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 结果
     */
    public int updateUrgencyChargeLeader(UrgencyChargeLeader urgencyChargeLeader);

    /**
     * 删除主管变更领导
     * 
     * @param id 主管变更领导ID
     * @return 结果
     */
    public int deleteUrgencyChargeLeaderById(Long id);

    /**
     * 批量删除主管变更领导
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrgencyChargeLeaderByIds(String[] ids);
}
