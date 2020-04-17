package com.ruoyi.urgencyforts.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyforts.mapper.UrgencyImageSystemMapper;
import com.ruoyi.urgencyforts.domain.UrgencyImageSystem;
import com.ruoyi.urgencyforts.service.IUrgencyImageSystemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 调用影像系统Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-02-26
 */
@Service
public class UrgencyImageSystemServiceImpl implements IUrgencyImageSystemService 
{
    @Autowired
    private UrgencyImageSystemMapper urgencyImageSystemMapper;

    /**
     * 查询调用影像系统
     * 
     * @param id 调用影像系统ID
     * @return 调用影像系统
     */
    @Override
    public UrgencyImageSystem selectUrgencyImageSystemById(Long id)
    {
        return urgencyImageSystemMapper.selectUrgencyImageSystemById(id);
    }

    /**
     * 查询调用影像系统列表
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 调用影像系统
     */
    @Override
    public List<UrgencyImageSystem> selectUrgencyImageSystemList(UrgencyImageSystem urgencyImageSystem)
    {
        return urgencyImageSystemMapper.selectUrgencyImageSystemList(urgencyImageSystem);
    }

    /**
     * 新增调用影像系统
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 结果
     */
    @Override
    public int insertUrgencyImageSystem(UrgencyImageSystem urgencyImageSystem)
    {
        return urgencyImageSystemMapper.insertUrgencyImageSystem(urgencyImageSystem);
    }

    /**
     * 修改调用影像系统
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 结果
     */
    @Override
    public int updateUrgencyImageSystem(UrgencyImageSystem urgencyImageSystem)
    {
        return urgencyImageSystemMapper.updateUrgencyImageSystem(urgencyImageSystem);
    }

    /**
     * 删除调用影像系统对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyImageSystemByIds(String ids)
    {
        return urgencyImageSystemMapper.deleteUrgencyImageSystemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除调用影像系统信息
     * 
     * @param id 调用影像系统ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyImageSystemById(Long id)
    {
        return urgencyImageSystemMapper.deleteUrgencyImageSystemById(id);
    }
}
