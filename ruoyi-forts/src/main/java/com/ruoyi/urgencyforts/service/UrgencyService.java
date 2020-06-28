package com.ruoyi.urgencyforts.service;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;

public interface UrgencyService {

    /**
     * 查询系统名称和模糊查询
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject  getSystemName(String json) throws Exception;

    /**
     * 查询实施人
     * @return
     */
    public JSONObject getUserInfo() throws Exception;

    /**
     * 查询复核人
     * @return
     */
    public JSONObject getReviewerInfo(String json) throws Exception;

    /**
     * 查询发起的部门
     * @return
     * @throws Exception
     */
    public JSONObject getBusinessChargeDept() throws Exception;

    /**
     * 查询团队领导
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject teamLeaderInfomation(String json) throws Exception;

    /**
     * 查询分管信息
     * @param json
     * @return
     */
    public JSONObject responsibleChargeInfo(String json) throws Exception;

    /**
     * 添加紧急变更数据
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject insertUrgencyAlteratRegister(String json) throws Exception;

    /**
     * 查询审批页面数据
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject getApprovalData(String json) throws Exception;

    /**
     * 审批更改状态
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject updateSignStatus(String json) throws Exception;

    /**
     * 判断分管和主管是否已审批
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject getBranchChargeStatus(String json) throws Exception;

    /**
     * 查询紧急变更历史
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject selectUrgencyHistory(String json) throws Exception;

    /**
     * 查询联合告警紧急变更历史
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject selectUrgencyIPHistory(String json) throws Exception;

    /**
     * 查询验证接口信息
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject getVerifyData(String json) throws Exception;

    /**
     * 更新验证表
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject updateUrgencyAlteratVerify(String json) throws Exception;

    /**
     * 查询变更进度
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject selectUrgencyProcessSpeed(String json) throws Exception;

    /**
     * 查询部门号
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject selectTwoDeptOrg(String json) throws Exception;

    /**
     * 调用影像系统
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject imagessystem(String json) throws Exception;

    /**
     * 查看附件
     * @param json
     * @return
     * @throws Exception
     */
    public JSONObject viewPicture(String json) throws Exception;

    public JSONObject noApprovalData() throws Exception;

}
