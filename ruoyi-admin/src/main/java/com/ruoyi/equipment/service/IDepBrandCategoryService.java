package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.DepNumberCategory;

import java.util.List;
import java.util.Map;

/**
 * 设备数量Service接口
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public interface IDepBrandCategoryService
{
    /**
     * 查询设备数量
     *
     * @param identity 设备数量ID
     * @return 设备数量
     */
    public DepNumberCategory selectDepBrandCategoryById(String identity);

    /**
     * 查询设备数量列表
     *
     * @param depNumberCategory 设备数量
     * @return 设备数量集合
     */
    public List<DepNumberCategory> selectDepBrandCategoryList(DepNumberCategory depNumberCategory);

    /**
     * 查询设备数量历史列表
     *
     * @param id 设备数量
     * @return 设备数量集合
     */
    public List<DepNumberCategory> selectDepBrandCategoryListHis(String id);
    

    /**
     * 新增设备数量
     *
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int insertDepBrandCategory(DepNumberCategory depNumberCategory);

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
    public int updateDepBrandCategory(DepNumberCategory depNumberCategory);

    /**
     * 批量删除设备数量
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepBrandCategoryByIds(DepNumberCategory depNumberCategory, String ids);

    /**
     * 删除设备数量信息
     * 
     * @param identity 设备数量ID
     * @return 结果
     */
    public int deleteDepBrandCategoryById(String identity);

    /**
     * 查询下一个编号
     *
     * @return 结果
     */
    public Map<String,Object> selectNextId(String id);
}
