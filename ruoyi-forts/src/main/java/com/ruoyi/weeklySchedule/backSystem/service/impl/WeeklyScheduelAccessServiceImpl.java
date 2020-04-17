package com.ruoyi.weeklySchedule.backSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.weeklySchedule.backSystem.mapper.WeeklyScheduelAccessMapper;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyScheduelAccess;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyScheduelAccessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目需求权限Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-03-12
 */
@Service
public class WeeklyScheduelAccessServiceImpl implements IWeeklyScheduelAccessService 
{
    @Autowired
    private WeeklyScheduelAccessMapper weeklyScheduelAccessMapper;

    /**
     * 查询项目需求权限
     * 
     * @param id 项目需求权限ID
     * @return 项目需求权限
     */
    @Override
    public WeeklyScheduelAccess selectWeeklyScheduelAccessById(Long id)
    {
        return weeklyScheduelAccessMapper.selectWeeklyScheduelAccessById(id);
    }

    /**
     * 查询项目需求权限列表
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 项目需求权限
     */
    @Override
    public List<WeeklyScheduelAccess> selectWeeklyScheduelAccessList(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        return weeklyScheduelAccessMapper.selectWeeklyScheduelAccessList(weeklyScheduelAccess);
    }

    /**
     * 新增项目需求权限
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 结果
     */
    @Override
    public int insertWeeklyScheduelAccess(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        return weeklyScheduelAccessMapper.insertWeeklyScheduelAccess(weeklyScheduelAccess);
    }

    /**
     * 修改项目需求权限
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 结果
     */
    @Override
    public int updateWeeklyScheduelAccess(WeeklyScheduelAccess weeklyScheduelAccess)
    {
        return weeklyScheduelAccessMapper.updateWeeklyScheduelAccess(weeklyScheduelAccess);
    }

    /**
     * 删除项目需求权限对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyScheduelAccessByIds(String ids)
    {
        return weeklyScheduelAccessMapper.deleteWeeklyScheduelAccessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目需求权限信息
     * 
     * @param id 项目需求权限ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyScheduelAccessById(Long id)
    {
        return weeklyScheduelAccessMapper.deleteWeeklyScheduelAccessById(id);
    }
}
