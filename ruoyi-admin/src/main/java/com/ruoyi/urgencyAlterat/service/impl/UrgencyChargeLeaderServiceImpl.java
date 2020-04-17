package com.ruoyi.urgencyAlterat.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyAlterat.mapper.UrgencyChargeLeaderMapper;
import com.ruoyi.urgencyAlterat.domain.UrgencyChargeLeader;
import com.ruoyi.urgencyAlterat.service.IUrgencyChargeLeaderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 主管变更领导Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Service
public class UrgencyChargeLeaderServiceImpl implements IUrgencyChargeLeaderService 
{
    @Autowired
    private UrgencyChargeLeaderMapper urgencyChargeLeaderMapper;

    /**
     * 查询主管变更领导
     * 
     * @param id 主管变更领导ID
     * @return 主管变更领导
     */
    @Override
    public UrgencyChargeLeader selectUrgencyChargeLeaderById(Long id)
    {
        return urgencyChargeLeaderMapper.selectUrgencyChargeLeaderById(id);
    }

    /**
     * 查询主管变更领导列表
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 主管变更领导
     */
    @Override
    public List<UrgencyChargeLeader> selectUrgencyChargeLeaderList(UrgencyChargeLeader urgencyChargeLeader)
    {
        return urgencyChargeLeaderMapper.selectUrgencyChargeLeaderList(urgencyChargeLeader);
    }

    /**
     * 新增主管变更领导
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 结果
     */
    @Override
    public int insertUrgencyChargeLeader(UrgencyChargeLeader urgencyChargeLeader)
    {
        urgencyChargeLeader.setCreateTime(DateUtils.getNowDate());
        return urgencyChargeLeaderMapper.insertUrgencyChargeLeader(urgencyChargeLeader);
    }

    /**
     * 修改主管变更领导
     * 
     * @param urgencyChargeLeader 主管变更领导
     * @return 结果
     */
    @Override
    public int updateUrgencyChargeLeader(UrgencyChargeLeader urgencyChargeLeader)
    {
        urgencyChargeLeader.setUpdateTime(DateUtils.getNowDate());
        return urgencyChargeLeaderMapper.updateUrgencyChargeLeader(urgencyChargeLeader);
    }

    /**
     * 删除主管变更领导对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyChargeLeaderByIds(String ids)
    {
        return urgencyChargeLeaderMapper.deleteUrgencyChargeLeaderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除主管变更领导信息
     * 
     * @param id 主管变更领导ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyChargeLeaderById(Long id)
    {
        return urgencyChargeLeaderMapper.deleteUrgencyChargeLeaderById(id);
    }
}
