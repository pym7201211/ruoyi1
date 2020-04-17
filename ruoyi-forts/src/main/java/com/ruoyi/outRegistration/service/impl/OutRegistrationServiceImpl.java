package com.ruoyi.outRegistration.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.outRegistration.domain.OutRegistration;
import com.ruoyi.outRegistration.mapper.OutRegistrationMapper;
import com.ruoyi.outRegistration.service.OutRegistrationService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.urgencyforts.until.UrgencyUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.util.ArrayList;
import java.util.List;

/**
 * 外包人员外出请假登记Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-03
 */
@Service
public class OutRegistrationServiceImpl implements OutRegistrationService
{

    private static final String link_launchApp = "launchApp://lingpaiapply$$#/jjbgApproval";

    @Autowired
    private OutRegistrationMapper outRegistrationMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;


    /**
     * 查询外包人员外出请假登记
     *
     * @param id 外包人员外出请假登记ID
     * @return 外包人员外出请假登记
     */
    @Override
    public OutRegistration selectOutRegistrationById(Long id)
    {
        return outRegistrationMapper.selectOutRegistrationById(id);
    }

    /**
     * 查询外包人员外出请假登记列表
     *
     * @param operatorId 外包人员外出请假登记
     * @return 外包人员外出请假登记
     */
    @Override
    public List<OutRegistration> selectOutRegistrationList(String operatorId)
    {
        return outRegistrationMapper.selectOutRegistrationList(operatorId);
    }

    /**
     * 后台查询外包人员外出请假登记列表
     *
     * @param outRegistration 外包人员外出请假登记
     * @return 外包人员外出请假登记
     */
    @Override
    public List<OutRegistration> selectRegistrationList(OutRegistration outRegistration)
    {
        return outRegistrationMapper.selectRegistrationList(outRegistration);
    }

    /**
     * 新增外包人员外出请假登记
     *
     * @param
     * @return 结果
     */
    @Override
    public JSONObject insertOutRegistration(String json) throws Exception {
        try {
            JSONObject jsonClient = UrgencyUntil.clientJsonParams(json);
            if (!"0".equals(jsonClient.getString("code"))){
                return jsonClient;
            }
            OutRegistration outRegistration = UrgencyUntil.registrationDemos(jsonClient);
            int insertOutRegistration = outRegistrationMapper.insertOutRegistration(outRegistration);
            if (insertOutRegistration > 0) {
                return UrgencyUntil.resultStatus("0", "添加外包人员外出登记成功");
            }
            return UrgencyUntil.resultStatus("1","添加外包人员外出请假登记失败");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 后台新增外包人员外出请假登记
     *
     * @param
     * @return 结果
     */
    @Override
    public int insertRegistration(OutRegistration outRegistration) {
        return outRegistrationMapper.insertRegistration(outRegistration);
    }

    /**
     * 修改外包人员外出请假登记
     *
     * @param outRegistration 外包人员外出请假登记
     * @return 结果
     */
    @Override
    public int updateOutRegistration(OutRegistration outRegistration)
    {
        return outRegistrationMapper.updateOutRegistration(outRegistration);
    }

    /**
     * 查询出发地
     *
     * @param
     * @return 结果
     */
    @Override
    public JSONObject getOfDeparture() throws Exception {
        try {
            List<SysDictData> departure = dictDataMapper.selectDictDataByType("DEPARTURE_SITE");
            List<String> list = new ArrayList<>();
            if (null != departure) {
                for (SysDictData sys : departure) {
                    list.add(sys.getDictLabel());
                }
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",list);
            return jsonObject;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 查询目的地
     *
     * @param
     * @return 结果
     */
    @Override
    public JSONObject getDestination() throws Exception {
        try {
            List<SysDictData> destination = dictDataMapper.selectDictDataByType("DESTINATION");
            List<String> list = new ArrayList<>();
            if (null != destination) {
                for (SysDictData sys : destination) {
                    list.add(sys.getDictLabel());
                }
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",list);
            return jsonObject;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 查询外出事由
     *
     * @param
     * @return 结果
     */
    @Override
    public JSONObject getCause() throws Exception {
        try {
            List<SysDictData> cause = dictDataMapper.selectDictDataByType("CAUSE");
            List<String> list = new ArrayList<>();
            if (null != cause) {
                for (SysDictData sys : cause) {
                    list.add(sys.getDictLabel());
                }
            }
            JSONObject jsonObject = UrgencyUntil.resultStatus("0", "查询成功");
            jsonObject.put("list",list);
            return jsonObject;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 删除外包人员外出请假登记对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOutRegistrationByIds(String ids)
    {
        return outRegistrationMapper.deleteOutRegistrationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外包人员外出请假登记信息
     *
     * @param id 外包人员外出请假登记ID
     * @return 结果
     */
    @Override
    public int deleteOutRegistrationById(Long id)
    {
        return outRegistrationMapper.deleteOutRegistrationById(id);
    }
}
