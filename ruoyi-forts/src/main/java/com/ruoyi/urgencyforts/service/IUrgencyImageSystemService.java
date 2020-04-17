package com.ruoyi.urgencyforts.service;

import com.ruoyi.urgencyforts.domain.UrgencyImageSystem;
import java.util.List;

/**
 * 调用影像系统Service接口
 * 
 * @author mengdehu
 * @date 2020-02-26
 */
public interface IUrgencyImageSystemService 
{
    /**
     * 查询调用影像系统
     * 
     * @param id 调用影像系统ID
     * @return 调用影像系统
     */
    public UrgencyImageSystem selectUrgencyImageSystemById(Long id);

    /**
     * 查询调用影像系统列表
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 调用影像系统集合
     */
    public List<UrgencyImageSystem> selectUrgencyImageSystemList(UrgencyImageSystem urgencyImageSystem);

    /**
     * 新增调用影像系统
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 结果
     */
    public int insertUrgencyImageSystem(UrgencyImageSystem urgencyImageSystem);

    /**
     * 修改调用影像系统
     * 
     * @param urgencyImageSystem 调用影像系统
     * @return 结果
     */
    public int updateUrgencyImageSystem(UrgencyImageSystem urgencyImageSystem);

    /**
     * 批量删除调用影像系统
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrgencyImageSystemByIds(String ids);

    /**
     * 删除调用影像系统信息
     * 
     * @param id 调用影像系统ID
     * @return 结果
     */
    public int deleteUrgencyImageSystemById(Long id);
}
