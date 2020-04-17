package com.ruoyi.urgencyforts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyforts.mapper.UrgencyTaskMapper;
import com.ruoyi.urgencyforts.domain.UrgencyTask;
import com.ruoyi.urgencyforts.service.IUrgencyTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 紧急变更线程Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-03-21
 */
@Service
public class UrgencyTaskServiceImpl implements IUrgencyTaskService 
{
    @Autowired
    private UrgencyTaskMapper urgencyTaskMapper;

    /**
     * 查询紧急变更线程
     * 
     * @param id 紧急变更线程ID
     * @return 紧急变更线程
     */
    @Override
    public UrgencyTask selectUrgencyTaskById(Long id)
    {
        return urgencyTaskMapper.selectUrgencyTaskById(id);
    }

    /**
     * 查询紧急变更线程列表
     * 
     * @param urgencyTask 紧急变更线程
     * @return 紧急变更线程
     */
    @Override
    public List<UrgencyTask> selectUrgencyTaskList(UrgencyTask urgencyTask)
    {
        return urgencyTaskMapper.selectUrgencyTaskList(urgencyTask);
    }

    /**
     * 新增紧急变更线程
     * 
     * @param urgencyTask 紧急变更线程
     * @return 结果
     */
    @Override
    public int insertUrgencyTask(UrgencyTask urgencyTask)
    {
        urgencyTask.setCreateTime(DateUtils.getNowDate());
        return urgencyTaskMapper.insertUrgencyTask(urgencyTask);
    }

    /**
     * 修改紧急变更线程
     * 
     * @param urgencyTask 紧急变更线程
     * @return 结果
     */
    @Override
    public int updateUrgencyTask(UrgencyTask urgencyTask)
    {
        urgencyTask.setUpdateTime(DateUtils.getNowDate());
        return urgencyTaskMapper.updateUrgencyTask(urgencyTask);
    }

    /**
     * 删除紧急变更线程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyTaskByIds(String ids)
    {
        return urgencyTaskMapper.deleteUrgencyTaskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除紧急变更线程信息
     * 
     * @param id 紧急变更线程ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyTaskById(Long id)
    {
        return urgencyTaskMapper.deleteUrgencyTaskById(id);
    }
}
