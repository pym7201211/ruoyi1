package com.ruoyi.forts.service;

import com.ruoyi.forts.domain.TokenApplyForm;
import com.ruoyi.forts.domain.TokenApplyFormDemo;

import java.util.List;

/**
 * 令牌登记申请Service接口
 * 
 * @author mengdehu
 * @date 2019-11-22
 */
public interface ITokenApplyFormService 
{
    /**
     * 查询令牌登记申请
     * 
     * @param tokenId 令牌登记申请ID
     * @return 令牌登记申请
     */
    public TokenApplyForm selectTokenApplyFormById(Long tokenId);

    /**
     * 查询令牌登记申请列表
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 令牌登记申请集合
     */
    public List<TokenApplyForm> selectTokenApplyFormList(TokenApplyForm tokenApplyForm);

    /**
     * 新增令牌登记申请
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    public int insertTokenApplyForm(TokenApplyForm tokenApplyForm);

    /**
     * 新增令牌登记申请
     *
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */ public int insertTokenApplyFormDemo(TokenApplyFormDemo tokenApplyForm);

    /**
     * 修改令牌登记申请
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    public int updateTokenApplyForm(TokenApplyForm tokenApplyForm);

    /**
     * 批量删除令牌登记申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenApplyFormByIds(String ids);

    /**
     * 删除令牌登记申请信息
     * 
     * @param tokenId 令牌登记申请ID
     * @return 结果
     */
    public int deleteTokenApplyFormById(Long tokenId);
}
