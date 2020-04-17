package com.ruoyi.outRegistration.mapper;


import com.ruoyi.outRegistration.domain.OutRegistration;

import java.util.List;

/**
 * 外包人员外出请假登记Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-03
 */
public interface OutRegistrationMapper 
{
    /**
     * 查询外包人员外出请假登记
     * 
     * @param id 外包人员外出请假登记ID
     * @return 外包人员外出请假登记
     */
    public OutRegistration selectOutRegistrationById(Long id);

    /**
     * 查询外包人员外出请假登记列表
     * 
     * @param operatorId 外包人员外出请假登记
     * @return 外包人员外出请假登记集合
     */
    public List<OutRegistration> selectOutRegistrationList(String operatorId);

    /**
     * 后台查询外包人员外出请假登记列表
     *
     * @param outRegistration 外包人员外出请假登记
     * @return 外包人员外出请假登记集合
     */
    public List<OutRegistration> selectRegistrationList(OutRegistration outRegistration);

    /**
     * 新增外包人员外出请假登记
     * 
     * @param outRegistration 外包人员外出请假登记
     * @return 结果
     */
    public int insertOutRegistration(OutRegistration outRegistration);

    /**
     * 后台新增外包人员外出请假登记
     *
     * @param outRegistration 外包人员外出请假登记
     * @return 结果
     */
    public int insertRegistration(OutRegistration outRegistration);
    /**
     * 修改外包人员外出请假登记
     * 
     * @param outRegistration 外包人员外出请假登记
     * @return 结果
     */
    public int updateOutRegistration(OutRegistration outRegistration);

    /**
     * 删除外包人员外出请假登记
     * 
     * @param id 外包人员外出请假登记ID
     * @return 结果
     */
    public int deleteOutRegistrationById(Long id);

    /**
     * 批量删除外包人员外出请假登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOutRegistrationByIds(String[] ids);
}
