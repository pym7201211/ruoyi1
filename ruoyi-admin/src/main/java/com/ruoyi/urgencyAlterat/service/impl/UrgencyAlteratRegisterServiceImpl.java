package com.ruoyi.urgencyAlterat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.urgencyAlterat.mapper.UrgencyAlteratRegisterMapper;
import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratRegister;
import com.ruoyi.urgencyAlterat.service.IUrgencyAlteratRegisterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 紧急变更登记Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
@Service
public class UrgencyAlteratRegisterServiceImpl implements IUrgencyAlteratRegisterService 
{
    @Autowired
    private UrgencyAlteratRegisterMapper urgencyAlteratRegisterMapper;

    /**
     * 查询紧急变更登记
     * 
     * @param id 紧急变更登记ID
     * @return 紧急变更登记
     */
    @Override
    public UrgencyAlteratRegister selectUrgencyAlteratRegisterById(Long id)
    {
        return urgencyAlteratRegisterMapper.selectUrgencyAlteratRegisterById(id);
    }

    /**
     * 查询紧急变更登记列表
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 紧急变更登记
     */
    @Override
    public List<UrgencyAlteratRegister> selectUrgencyAlteratRegisterList(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        return urgencyAlteratRegisterMapper.selectUrgencyAlteratRegisterList(urgencyAlteratRegister);
    }

    /**
     * 新增紧急变更登记
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 结果
     */
    @Override
    public int insertUrgencyAlteratRegister(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        return urgencyAlteratRegisterMapper.insertUrgencyAlteratRegister(urgencyAlteratRegister);
    }

    /**
     * 修改紧急变更登记
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 结果
     */
    @Override
    public int updateUrgencyAlteratRegister(UrgencyAlteratRegister urgencyAlteratRegister)
    {
        return urgencyAlteratRegisterMapper.updateUrgencyAlteratRegister(urgencyAlteratRegister);
    }

    /**
     * 删除紧急变更登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyAlteratRegisterByIds(String ids)
    {
        return urgencyAlteratRegisterMapper.deleteUrgencyAlteratRegisterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除紧急变更登记信息
     * 
     * @param id 紧急变更登记ID
     * @return 结果
     */
    @Override
    public int deleteUrgencyAlteratRegisterById(Long id)
    {
        return urgencyAlteratRegisterMapper.deleteUrgencyAlteratRegisterById(id);
    }
}
