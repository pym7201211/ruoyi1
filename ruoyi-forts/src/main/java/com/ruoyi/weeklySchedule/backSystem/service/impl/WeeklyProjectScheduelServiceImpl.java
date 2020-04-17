package com.ruoyi.weeklySchedule.backSystem.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.weeklySchedule.backSystem.mapper.WeeklyProjectScheduelMapper;
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyProjectScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyProjectScheduelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目周进度Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
@Service
public class WeeklyProjectScheduelServiceImpl implements IWeeklyProjectScheduelService 
{
    @Autowired
    private WeeklyProjectScheduelMapper weeklyProjectScheduelMapper;

    /**
     * 查询项目周进度
     * 
     * @param id 项目周进度ID
     * @return 项目周进度
     */
    @Override
    public WeeklyProjectScheduel selectWeeklyProjectScheduelById(Long id)
    {
        return weeklyProjectScheduelMapper.selectWeeklyProjectScheduelById(id);
    }

    /**
     * 查询项目周进度列表
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 项目周进度
     */
    @Override
    public List<WeeklyProjectScheduel> selectWeeklyProjectScheduelList(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        return weeklyProjectScheduelMapper.selectWeeklyProjectScheduelList(weeklyProjectScheduel);
    }

    @Override
    public List<WeeklyProjectScheduel> selectWeeklyProjectScheduelListNew(WeeklyProjectScheduel weeklyProjectScheduel) {
        return weeklyProjectScheduelMapper.selectWeeklyProjectScheduelListNew(weeklyProjectScheduel);
    }

    /**
     * 新增项目周进度
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 结果
     */
    @Override
    public int insertWeeklyProjectScheduel(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        if (null == weeklyProjectScheduel.getCreateTime()){
            weeklyProjectScheduel.setCreateTime(DateUtils.getNowDate());
        }
        if ("项目完成".equals(weeklyProjectScheduel.getCurrentGeneration())){
            weeklyProjectScheduel.setUpdateTime(DateUtils.getNowDate());
        }
        return weeklyProjectScheduelMapper.insertWeeklyProjectScheduel(weeklyProjectScheduel);
    }

    /**
     * 修改项目周进度
     * 
     * @param weeklyProjectScheduel 项目周进度
     * @return 结果
     */
    @Override
    public int updateWeeklyProjectScheduel(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        weeklyProjectScheduel.setUpdateTime(DateUtils.getNowDate());
        return weeklyProjectScheduelMapper.updateWeeklyProjectScheduel(weeklyProjectScheduel);
    }

    /**
     * 删除项目周进度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyProjectScheduelByIds(String ids)
    {
        return weeklyProjectScheduelMapper.deleteWeeklyProjectScheduelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目周进度信息
     * 
     * @param id 项目周进度ID
     * @return 结果
     */
    @Override
    public int deleteWeeklyProjectScheduelById(Long id)
    {
        return weeklyProjectScheduelMapper.deleteWeeklyProjectScheduelById(id);
    }
}
