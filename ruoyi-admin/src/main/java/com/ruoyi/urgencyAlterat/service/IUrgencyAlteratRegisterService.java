package com.ruoyi.urgencyAlterat.service;

import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratRegister;
import java.util.List;

/**
 * 紧急变更登记Service接口
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public interface IUrgencyAlteratRegisterService 
{
    /**
     * 查询紧急变更登记
     * 
     * @param id 紧急变更登记ID
     * @return 紧急变更登记
     */
    public UrgencyAlteratRegister selectUrgencyAlteratRegisterById(Long id);

    /**
     * 查询紧急变更登记列表
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 紧急变更登记集合
     */
    public List<UrgencyAlteratRegister> selectUrgencyAlteratRegisterList(UrgencyAlteratRegister urgencyAlteratRegister);

    /**
     * 新增紧急变更登记
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 结果
     */
    public int insertUrgencyAlteratRegister(UrgencyAlteratRegister urgencyAlteratRegister);

    /**
     * 修改紧急变更登记
     * 
     * @param urgencyAlteratRegister 紧急变更登记
     * @return 结果
     */
    public int updateUrgencyAlteratRegister(UrgencyAlteratRegister urgencyAlteratRegister);

    /**
     * 批量删除紧急变更登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrgencyAlteratRegisterByIds(String ids);

    /**
     * 删除紧急变更登记信息
     * 
     * @param id 紧急变更登记ID
     * @return 结果
     */
    public int deleteUrgencyAlteratRegisterById(Long id);
}
