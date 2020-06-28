package com.ruoyi.equipment.mapper;

import com.ruoyi.equipment.domain.DepFeedback;
import com.ruoyi.equipment.domain.DepNumberCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 设备数量Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public interface DepNumberCategoryMapper 
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
    public List<DepNumberCategory> selectDepNumberCategoryListHis(@Param("id") String id);


    /**
     * 查询用户部门
     *
     * @param user_id 用户id
     * @return 用户部门
     */
    public Map<String,Object> selectUserDep(String user_id);

    /**
     * 新增设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int insertDepNumberCategory(DepNumberCategory depNumberCategory);

    /**
     * 新增设备数量历史
     *
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int insertDepNumberCategoryHis(DepNumberCategory depNumberCategory);

    /**
     * 查询设备类别
     *
     * @return 结果
     */
    public List<DepNumberCategory> selectCategory();

    /**
     * 修改设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int updateDepNumberCategory(DepNumberCategory depNumberCategory);

    /**
     * 删除设备数量
     * 
     * @param identity 设备数量ID
     * @return 结果
     */
    public int deleteDepNumberCategoryById(String identity);

    /**
     * 批量删除设备数量
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepNumberCategoryByIds(String id);

    /**
     * 查询下一个编号
     *
     * @return 结果
     */
    public Map<String,Object> selectNextId(String id);

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
     * 查询用户是否拥有特殊权限
     *
     * @param user_id 用户id
     * @return 用户权限
     */
    public Map<String,Object> selectUserSpecial(String user_id);

    /**
     * 查询反馈意见历史
     *
     * @param twoDep 意见
     * @return 结果
     */
    public List<DepFeedback> selectFeedback(@Param("twoDep") String twoDep,@Param("seqNo") String seqNo);
}
