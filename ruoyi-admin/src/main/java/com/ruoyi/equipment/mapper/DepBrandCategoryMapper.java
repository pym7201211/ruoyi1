package com.ruoyi.equipment.mapper;

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
public interface DepBrandCategoryMapper
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
    public List<DepNumberCategory> selectDepBrandCategoryListHis(@Param("id") String id);


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
    public int insertDepBrandCategory(DepNumberCategory depNumberCategory);

    /**
     * 新增设备数量历史
     *
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    public int insertDepBrandCategoryHis(DepNumberCategory depNumberCategory);

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
     * 删除设备数量
     * 
     * @param identity 设备数量ID
     * @return 结果
     */
    public int deleteDepBrandCategoryById(String identity);

    /**
     * 批量删除设备数量
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepBrandCategoryByIds(String id);

    /**
     * 查询下一个编号
     *
     * @return 结果
     */
    public Map<String,Object> selectNextId(String id);

    /**
     * 查询全新和利旧的总数
     * @param identity
     * @return
     */
    public Map<String,Object> selectCategoryNum(@Param("identity") String identity,@Param("twoDep") String twoDep);

    /**
     * 查询部门
     * @param id
     * @return
     */
    public Map<String,Object> selectCategoryDep(String id);

    /**
     * 数据更新到设备表中
     * @param identity
     * @param newSum
     * @param oldSum
     * @return
     */
    public int updateCategoryTable(@Param("identity") String identity,@Param("newSum") String newSum,@Param("oldSum") String oldSum,@Param("twoDep") String twoDep);
}
