package com.ruoyi.urgencyAlterat.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyAlterat.mapper.UrgencyResponsibleLeaderMapper;
import com.ruoyi.urgencyAlterat.domain.UrgencyResponsibleLeader;
import com.ruoyi.urgencyAlterat.service.IUrgencyResponsibleLeaderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分管领导Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Service
public class UrgencyResponsibleLeaderServiceImpl implements IUrgencyResponsibleLeaderService 
{
    @Autowired
    private UrgencyResponsibleLeaderMapper urgencyResponsibleLeaderMapper;

    /**
     * 查询分管领导
     * 
     * @param id 分管领导ID
     * @return 分管领导
     */
    @Override
    public UrgencyResponsibleLeader selectUrgencyResponsibleLeaderById(Long id)
    {
        return urgencyResponsibleLeaderMapper.selectUrgencyResponsibleLeaderById(id);
    }

    /**
     * 查询分管领导列表
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 分管领导
     */
    @Override
    public List<UrgencyResponsibleLeader> selectUrgencyResponsibleLeaderList(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        return urgencyResponsibleLeaderMapper.selectUrgencyResponsibleLeaderList(urgencyResponsibleLeader);
    }

    /**
     * 新增分管领导
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 结果
     */
    @Override
    public int insertUrgencyResponsibleLeader(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        urgencyResponsibleLeader.setCreateTime(DateUtils.getNowDate());
        return urgencyResponsibleLeaderMapper.insertUrgencyResponsibleLeader(urgencyResponsibleLeader);
    }

    /**
     * 修改分管领导
     * 
     * @param urgencyResponsibleLeader 分管领导
     * @return 结果
     */
    @Override
    public int updateUrgencyResponsibleLeader(UrgencyResponsibleLeader urgencyResponsibleLeader)
    {
        urgencyResponsibleLeader.setUpdateTime(DateUtils.getNowDate());
        return urgencyResponsibleLeaderMapper.updateUrgencyResponsibleLeader(urgencyResponsibleLeader);
    }

    /**
     * 删除分管领导对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyResponsibleLeaderByIds(String ids)
    {
        return urgencyResponsibleLeaderMapper.deleteUrgencyResponsibleLeaderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分管领导信息
     * 
     * @param id 分管领导ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyResponsibleLeaderById(Long id)
    {
        return urgencyResponsibleLeaderMapper.deleteUrgencyResponsibleLeaderById(id);
    }
}
