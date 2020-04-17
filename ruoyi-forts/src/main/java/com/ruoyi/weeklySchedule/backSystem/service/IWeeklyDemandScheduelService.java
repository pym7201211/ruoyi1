package com.ruoyi.weeklySchedule.backSystem.service;

import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyDemandScheduel;
import java.util.List;

/**
 * 需求周进度Service接口
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
public interface IWeeklyDemandScheduelService 
{
    /**
     * 查询需求周进度
     * 
     * @param id 需求周进度ID
     * @return 需求周进度
     */
    public WeeklyDemandScheduel selectWeeklyDemandScheduelById(Long id);

    /**
     * 查询需求周进度列表
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 需求周进度集合
     */
    public List<WeeklyDemandScheduel> selectWeeklyDemandScheduelList(WeeklyDemandScheduel weeklyDemandScheduel);

    public List<WeeklyDemandScheduel> selectWeeklyDemandScheduelListNew(WeeklyDemandScheduel weeklyDemandScheduel);
    /**
     * 新增需求周进度
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 结果
     */
    public int insertWeeklyDemandScheduel(WeeklyDemandScheduel weeklyDemandScheduel);

    /**
     * 修改需求周进度
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 结果
     */
    public int updateWeeklyDemandScheduel(WeeklyDemandScheduel weeklyDemandScheduel);

    /**
     * 批量删除需求周进度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeeklyDemandScheduelByIds(String ids);

    /**
     * 删除需求周进度信息
     * 
     * @param id 需求周进度ID
     * @return 结果
     */
    public int deleteWeeklyDemandScheduelById(Long id);
}
