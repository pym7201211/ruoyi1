package com.ruoyi.urgencyAlterat.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyAlterat.mapper.UrgencyAlteratVerifyMapper;
import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratVerify;
import com.ruoyi.urgencyAlterat.service.IUrgencyAlteratVerifyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 变更时点验证Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Service
public class UrgencyAlteratVerifyServiceImpl implements IUrgencyAlteratVerifyService 
{
    @Autowired
    private UrgencyAlteratVerifyMapper urgencyAlteratVerifyMapper;

    /**
     * 查询变更时点验证
     * 
     * @param id 变更时点验证ID
     * @return 变更时点验证
     */
    @Override
    public UrgencyAlteratVerify selectUrgencyAlteratVerifyById(Long id)
    {
        return urgencyAlteratVerifyMapper.selectUrgencyAlteratVerifyById(id);
    }

    /**
     * 查询变更时点验证列表
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 变更时点验证
     */
    @Override
    public List<UrgencyAlteratVerify> selectUrgencyAlteratVerifyList(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        return urgencyAlteratVerifyMapper.selectUrgencyAlteratVerifyList(urgencyAlteratVerify);
    }

    /**
     * 新增变更时点验证
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 结果
     */
    @Override
    public int insertUrgencyAlteratVerify(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        urgencyAlteratVerify.setCreateTime(DateUtils.getNowDate());
        return urgencyAlteratVerifyMapper.insertUrgencyAlteratVerify(urgencyAlteratVerify);
    }

    /**
     * 修改变更时点验证
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 结果
     */
    @Override
    public int updateUrgencyAlteratVerify(UrgencyAlteratVerify urgencyAlteratVerify)
    {
        urgencyAlteratVerify.setUpdateTime(DateUtils.getNowDate());
        return urgencyAlteratVerifyMapper.updateUrgencyAlteratVerify(urgencyAlteratVerify);
    }

    /**
     * 删除变更时点验证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyAlteratVerifyByIds(String ids)
    {
        return urgencyAlteratVerifyMapper.deleteUrgencyAlteratVerifyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除变更时点验证信息
     * 
     * @param id 变更时点验证ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyAlteratVerifyById(Long id)
    {
        return urgencyAlteratVerifyMapper.deleteUrgencyAlteratVerifyById(id);
    }
}
