package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.DepFeedback;
import com.ruoyi.equipment.domain.DepNumberCategory;
import java.util.List;
import java.util.Map;

/**
 * 设备数量Service接口
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public interface IDepNumberCategoryService 
{
    /**
     * 查询设备数量
     * 
     * @param identity 设备数量ID
     * @return 设备数量
     */
    public DepNumberCategory selectDepNumberCategoryById(String identity);

    /**
     * 查询设备数量列表
     * 
     * @param depNumberCategory 设备数量
     * @return 设备数量集合
     */
    public List<DepNumberCategory> selectDepNumberCategoryList(DepNumberCategory depNumberCategory);

    /**
     * 查询设备数量历史列表
     *
     * @param id 设备数量
     * @return 设备数量集合
     */
    public List<DepNumberCategory> selectDepNumberCategoryListHis(String id);


    /**
     * 查询用户部门
     *
     * @param user_id 用户id
     * @return 用户部门
     */
    public Map<String,Object> selectUserDep(String user_id);

    /**
     * 查询用户是否拥有特殊权限
     *
     * @param user_id 用户id
     * @return 用户权限
     */
    public Map<String,Object> selectUserSpecial(String user_id);

    /**
     * 新增设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int insertDepNumberCategory(DepNumberCategory depNumberCategory);

    /**
     * 查询设备类别
     *
     * @return 结果
     */
    public List<DepNumberCategory> selectCategory();

    /**
     * 查询下一个编号
     *
     * @return 结果
     */
    public Map<String,Object> selectNextId(String id);

    /**
     * 修改设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int updateDepNumberCategory(DepNumberCategory depNumberCategory);

    /**
     * 批量删除设备数量
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepNumberCategoryByIds(DepNumberCategory depNumberCategory,String ids);

    /**
     * 删除设备数量信息
     * 
     * @param identity 设备数量ID
     * @return 结果
     */
    public int deleteDepNumberCategoryById(String identity);

    /**
     * 保存反馈意见
     *
     * @param depFeedback 意见
     * @return 结果
     */
    public int insertDepFeedback(DepFeedback depFeedback);

    /**
     * 修改反馈意见
     *
     * @param depFeedback 意见
     * @return 结果
     */
    public int updateDepFeedback(DepFeedback depFeedback);

    /**
     * 查询反馈意见历史
     *
     * @param twoDep 意见
     * @return 结果
     */
    public List<DepFeedback> selectFeedback(String twoDep,String seqNo);
}
