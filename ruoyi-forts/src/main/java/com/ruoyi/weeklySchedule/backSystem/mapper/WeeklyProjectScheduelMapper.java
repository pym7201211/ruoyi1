package com.ruoyi.weeklySchedule.backSystem.mapper;

import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyProjectScheduel;
import java.util.List;

/**
 * 项目周进度Mapper接口
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
public interface WeeklyProjectScheduelMapper 
{
    /**
     * 查询项目周进度
     * 
     * @param id 项目周进度ID
     * @return 项目周进度
     */
    public WeeklyProjectScheduel selectWeeklyProjectScheduelById(Long id);

    /**
     * 查询项目周进度列表
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 项目周进度集合
     */
    public List<WeeklyProjectScheduel> selectWeeklyProjectScheduelList(WeeklyProjectScheduel weeklyProjectScheduel);

    public List<WeeklyProjectScheduel> selectWeeklyProjectScheduelListNew(WeeklyProjectScheduel weeklyProjectScheduel);

    /**
     * 新增项目周进度
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 结果
     */
    public int insertWeeklyProjectScheduel(WeeklyProjectScheduel weeklyProjectScheduel);

    /**
     * 修改项目周进度
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 结果
     */
    public int updateWeeklyProjectScheduel(WeeklyProjectScheduel weeklyProjectScheduel);

    /**
     * 删除项目周进度
     * 
     * @param id 项目周进度ID
     * @return 结果
     */
    public int deleteWeeklyProjectScheduelById(Long id);

    /**
     * 批量删除项目周进度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeeklyProjectScheduelByIds(String[] ids);
}
