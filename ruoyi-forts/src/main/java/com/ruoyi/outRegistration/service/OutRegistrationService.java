package com.ruoyi.outRegistration.service;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.outRegistration.domain.OutRegistration;

import java.util.List;

/**
 * 外包人员外出请假登记Service接口
 * 
 * @author ruoyi
 * @date 2020-04-03
 */
public interface OutRegistrationService
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
     * @param
     * @return 结果
     */
    public JSONObject insertOutRegistration(String json) throws Exception;

    /**
     * 后台新增外包人员外出登记
     *
     * @param
     * @return 结果
     */
    int insertRegistration(OutRegistration outRegistration);

    /**
     * 修改外包人员外出请假登记
     * 
     * @param outRegistration 外包人员外出请假登记
     * @return 结果
     */
    public int updateOutRegistration(OutRegistration outRegistration);

    /**
     * 查询出发地
     * @return
     * @throws Exception
     */
    public JSONObject getOfDeparture() throws Exception;

    /**
     * 查询出发地
     * @return
     * @throws Exception
     */
    public JSONObject getDestination() throws Exception;

    /**
     * 查询事由
     * @return
     * @throws Exception
     */
    public JSONObject getCause() throws Exception;

    /**
     * 批量删除外包人员外出请假登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOutRegistrationByIds(String ids);

    /**
     * 删除外包人员外出请假登记信息
     * 
     * @param id 外包人员外出请假登记ID
     * @return 结果
     */
    public int deleteOutRegistrationById(Long id);

}
