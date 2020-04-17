package com.ruoyi.weeklySchedule.backSystem.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.weeklySchedule.backSystem.mapper.WeeklyDemandScheduelMapper;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyDemandScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyDemandScheduelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 需求周进度Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
@Service
public class WeeklyDemandScheduelServiceImpl implements IWeeklyDemandScheduelService 
{
    @Autowired
    private WeeklyDemandScheduelMapper weeklyDemandScheduelMapper;

    /**
     * 查询需求周进度
     * 
     * @param id 需求周进度ID
     * @return 需求周进度
     */
    @Override
    public WeeklyDemandScheduel selectWeeklyDemandScheduelById(Long id)
    {
        return weeklyDemandScheduelMapper.selectWeeklyDemandScheduelById(id);
    }

    /**
     * 查询需求周进度列表
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 需求周进度
     */
    @Override
    public List<WeeklyDemandScheduel> selectWeeklyDemandScheduelList(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        return weeklyDemandScheduelMapper.selectWeeklyDemandScheduelList(weeklyDemandScheduel);
    }

    @Override
    public List<WeeklyDemandScheduel> selectWeeklyDemandScheduelListNew(WeeklyDemandScheduel weeklyDemandScheduel) {
        return weeklyDemandScheduelMapper.selectWeeklyDemandScheduelListNew(weeklyDemandScheduel);
    }

    /**
     * 新增需求周进度
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 结果
     */
    @Override
    public int insertWeeklyDemandScheduel(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        if (null == weeklyDemandScheduel.getCreateTime()){
            weeklyDemandScheduel.setCreateTime(DateUtils.getNowDate());
        }
        if ("已完成".equals(weeklyDemandScheduel.getCurrentGeneration())){
            weeklyDemandScheduel.setUpdateTime(DateUtils.getNowDate());
        }
        return weeklyDemandScheduelMapper.insertWeeklyDemandScheduel(weeklyDemandScheduel);
    }

    /**
     * 修改需求周进度
     * 
     * @param weeklyDemandScheduel 需求周进度
     * @return 结果
     */
    @Override
    public int updateWeeklyDemandScheduel(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        weeklyDemandScheduel.setUpdateTime(DateUtils.getNowDate());
        return weeklyDemandScheduelMapper.updateWeeklyDemandScheduel(weeklyDemandScheduel);
    }

    /**
     * 删除需求周进度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyDemandScheduelByIds(String ids)
    {
        return weeklyDemandScheduelMapper.deleteWeeklyDemandScheduelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除需求周进度信息
     * 
     * @param id 需求周进度ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyDemandScheduelById(Long id)
    {
        return weeklyDemandScheduelMapper.deleteWeeklyDemandScheduelById(id);
    }
}
