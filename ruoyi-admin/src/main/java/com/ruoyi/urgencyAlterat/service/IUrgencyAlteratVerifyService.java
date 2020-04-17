package com.ruoyi.urgencyAlterat.service;

import com.ruoyi.urgencyAlterat.domain.UrgencyAlteratVerify;
import java.util.List;

/**
 * 变更时点验证Service接口
 * 
 * @author mengdehu
 * @date 2020-02-14
 */
public interface IUrgencyAlteratVerifyService 
{
    /**
     * 查询变更时点验证
     * 
     * @param id 变更时点验证ID
     * @return 变更时点验证
     */
    public UrgencyAlteratVerify selectUrgencyAlteratVerifyById(Long id);

    /**
     * 查询变更时点验证列表
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 变更时点验证集合
     */
    public List<UrgencyAlteratVerify> selectUrgencyAlteratVerifyList(UrgencyAlteratVerify urgencyAlteratVerify);

    /**
     * 新增变更时点验证
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 结果
     */
    public int insertUrgencyAlteratVerify(UrgencyAlteratVerify urgencyAlteratVerify);

    /**
     * 修改变更时点验证
     * 
     * @param urgencyAlteratVerify 变更时点验证
     * @return 结果
     */
    public int updateUrgencyAlteratVerify(UrgencyAlteratVerify urgencyAlteratVerify);

    /**
     * 批量删除变更时点验证
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrgencyAlteratVerifyByIds(String ids);

    /**
     * 删除变更时点验证信息
     * 
     * @param id 变更时点验证ID
     * @return 结果
     */
    public int deleteUrgencyAlteratVerifyById(Long id);
}
