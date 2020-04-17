package com.ruoyi.weeklySchedule.backSystem.mapper;

import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyScheduelAccess;
import java.util.List;

/**
 * 项目需求权限Mapper接口
 * 
 * @author mengdehu
 * @date 2020-03-12
 */
public interface WeeklyScheduelAccessMapper 
{
    /**
     * 查询项目需求权限
     * 
     * @param id 项目需求权限ID
     * @return 项目需求权限
     */
    public WeeklyScheduelAccess selectWeeklyScheduelAccessById(Long id);

    /**
     * 查询项目需求权限列表
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 项目需求权限集合
     */
    public List<WeeklyScheduelAccess> selectWeeklyScheduelAccessList(WeeklyScheduelAccess weeklyScheduelAccess);

    /**
     * 新增项目需求权限
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 结果
     */
    public int insertWeeklyScheduelAccess(WeeklyScheduelAccess weeklyScheduelAccess);

    /**
     * 修改项目需求权限
     * 
     * @param weeklyScheduelAccess 项目需求权限
     * @return 结果
     */
    public int updateWeeklyScheduelAccess(WeeklyScheduelAccess weeklyScheduelAccess);

    /**
     * 删除项目需求权限
     * 
     * @param id 项目需求权限ID
     * @return 结果
     */
    public int deleteWeeklyScheduelAccessById(Long id);

    /**
     * 批量删除项目需求权限
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeeklyScheduelAccessByIds(String[] ids);
}
